# JVM

[TOC]

























## 一、  JVM内存结构

### 1.   运行时数据区

![image-20200513191715402](pic\image-20200513191715402.png)

#### 1.1     方法区

#### 1.2     虚拟机栈JVM Stacks

Java虚拟机栈是**线程私有**的，它的生命周期与线程相同。虚拟机栈描述的是J**ava方法执行的内存模型**：每个方法在执行的同时都会创建一个栈帧，用于存储局部变量表、操作数栈、动态链接、方法出口等信息。每一个方法从调用直至执行完成的过程，就对应着一个栈帧在虚拟机栈中入栈到出栈的过程。

#### 1.3     本地方法栈
#### 1.4     堆

Java堆是Java虚拟机所管理的内存中最大的一块。堆是被所有线程共享的一块内存区域，在虚拟机启动时创建。此内存区域的唯一目的就是存放对象实例，几乎所有的对象实例都在这里分配

#### 1.5     程序计数器 PC Register

JVM支持多线程同时执行，每一个线程都有自己的PC Register,线程正在执行的方法叫做当前方法，如果是java代码，PC Register里面存放的就是当前正在执行的指令的地址，如果是c语言，则为空

### 2.   并发编程技术应用
#### 2.1     自定义线程池实现异步落库

对于任务奖品明细进行异步落库，落库失败写本地文件，核心线程数和任务线程数，需要根据线上的实际耗时进行调整，一般来说最佳线程数=（线程等待时间与线程cpu时间之比+1）*cpu数 （这个地方多写一点论据，公式数学化一点，简单直观，给一个实际值，或者真实例子）

```java
@Data
@Component
public class QueryTaskManager {
    @Value("${com.oppo.bot.common.activity.corePoolSize:100}")
    private  int corePoolSize ;
    private static final long DEFAULT_KEEP_ALIVE_SECONDS = 10;
    @Value("${com.oppo.bot.common.activity.taskPoolSize:500}")
    private int taskPoolSize;
    private BlockingQueue<Runnable> WORK_QUEUE;
    private ThreadPoolExecutor threadPoolExecutor;

    @PostConstruct
    public void init() {
        if (taskPoolSize < corePoolSize) {
            taskPoolSize = corePoolSize;
        }
        WORK_QUEUE = new LinkedBlockingDeque(taskPoolSize);
        threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                taskPoolSize,
                DEFAULT_KEEP_ALIVE_SECONDS,
                TimeUnit.SECONDS,
                WORK_QUEUE,
                new ThreadFactoryBuilder().setNameFormat("task-pool-thread-%d").build());
    }
    @PreDestroy
    public void close() {
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }
}

private void asynInsertDB(AwardRequest awardRequest) {
        threadPool.getThreadPoolExecutor().execute(() -> {
            try {
                String currentYMD = ActTimeUtil.getCurrentYMD(new Date());
                String tableName = "mission_award_info_" + currentYMD;
                missionAwardInfoDao.insertOneMissionAwardInfoByTableName(tableName, awardRequest);
            } catch (Exception e) {
                lostFileUtil.saveExceptionMsgToLocation(awardRequest);
                log.error("insert mission award error:{}", e);
            }
        });
}
```


## 二、 编码设计

### 1.   面向对象代码设计

#### 1.1     自定义mapper继承通用mapper

所有的自定义mapper文件，继承一个通用mapper,让通用mapper继承tk.mybatis.mapper.common包中的Mapper和MySqlMapper，Mapper和MySqlMapper中封装了大量的crud的api，简化了crud操作步骤，提升开发效率

```java
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {}

public interface AwardPrizeInfoMapper extends MyMapper<AwardPrizeInfo> {}
public interface AwardPoolInfoMapper extends MyMapper<AwardPoolInfo> {}
public interface AwardLuckeyInfoMapper extends MyMapper<AwardLuckeyInfo> {}
```



### 2.   常用软件设计模式与代码重构优化

#### 2.1     使用工厂和策略模式重构超长奖品类型判断分支，提升代码扩展性

使用工厂模式解耦了对象的创建和使用，使用策略模式解耦了策略的定义、创建、使用，极大提高代码扩展性，原先的if else代码，被优化一行，通过策略factory调用getStrategy方法，直接拿到对应奖品类型的实现类。

```java
//定义一个奖品领取的策略工厂
public class RecieveAwardStrategyFactory {

    private static final Map<Integer,Strategy> strategies = new HashMap<>();

    static{
        strategies.put(AwardTypeEnum.REDPACKET_AWARD.getType(),new RecieveRedPacketStrategy());
        strategies.put(AwardTypeEnum.INTEGRAL_AWARD.getType(),new RecieveIntegralStrategy());
        strategies.put(AwardTypeEnum.KIND_AWARD.getType(),new RecieveKindAwardStrategy());
    }

    public static Strategy getStrategy(Integer type){
        if(type == null || type.isEmpty()){
            try {
                throw new IllegalAccessException("type should not be empty.");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return strategies.get(type);
    }
}    
```

```java
//定义一个领奖策略接口
public interface RecieveAwardStrategy {
    int recieveAwardStrategy(ReceiveAwardRequest receiveAwardRequest);
}
```

```java
//领取红包策略实现类
public class RecieveRedPacketStrategy implements RecieveAwardStrategy{
    @Override
    public int recieveAwardStrategy(ReceiveAwardRequest receiveAwardRequest) {
   		//业务逻辑实现
        ..
    }
}
//领取积分策略实现类
public class RecieveIntegralStrategy implements RecieveAwardStrategy{
    @Override
    public int recieveAwardStrategy(ReceiveAwardRequest receiveAwardRequest) {
        ..
    }
}
//领取实物策略实现类
public class RecieveKindAwardStrategy implements RecieveAwardStrategy{
    @Override
    public int recieveAwardStrategy(ReceiveAwardRequest receiveAwardRequest) {
        ..
    }
}
...
```


### 3.   常用数据结构与算法应用

#### 3.1      使用HashMap存储奖池和奖品集信息

因为一个奖池会包含多个奖品信息，而协议会使用poolCode作为奖池标识。所以这里使用							HashMap<String, List< AwardPrizeInfo >>，key存poolCode，value存奖池对应的奖品集，在通过缓存中换取到所有奖池和奖品信息的集合时，可以通过poolCode以O(1)的时间复杂度拿到对应奖品list。
#### 3.2     抽奖算法实现（抽奖模型）

这块代码是由一名外包同学编写（修改为其他同事写的），在之前的上线过程，运营反馈中奖的概率和实际配置的中奖概率不符，很多奖品都发放不出，剩余库存过多。

首先对原来的抽奖算法代码进行分析，代码如下：

```java
public PrizeReformDTO drawAlgorithm(List<PrizeReformDTO> drawList) {
        Collections.shuffle(drawList);
        double probability = Math.random();
        PrizeReformDTO result = null;
        double preProbability = 0;
        for (PrizeReformDTO awardPrizeInfo : drawList) {
            if (Objects.isNull(awardPrizeInfo.getLuckyRate())) {
                log.info("中奖奖品:{},概率为空", awardPrizeInfo.getId());
                return null;
            }
            float prizeRate = awardPrizeInfo.getLuckyRate();
            prizeRate = prizeRate / 100;
            log.info("此奖品:{},此奖品中奖概率:{},用户随机到的中奖概率:{}", awardPrizeInfo.getName(), prizeRate, probability);
            if (probability < prizeRate) {
                result = awardPrizeInfo;
                log.info("中奖奖品信息:{}，rate:{}", result.getName(), (prizeRate + preProbability));
                return result;
            }
        }
        log.info("抽奖结果-未中奖");
        return result;
    }
```

调用我自己实现的一个概率测试方法，查看实际概率与配置概率差异结果如下：（去掉无用日志）

```java
17:55:13.525 [main] INFO TestDemo - 抽奖次数100000
17:55:13.525 [main] INFO TestDemo - prizeId:359设置的中奖概率:0.0,实际的中奖概率:0.0
17:55:13.525 [main] INFO TestDemo - prizeId:360设置的中奖概率:0.05,实际的中奖概率:0.01003
17:55:13.525 [main] INFO TestDemo - prizeId:361设置的中奖概率:0.1,实际的中奖概率:0.02269
17:55:13.525 [main] INFO TestDemo - prizeId:365设置的中奖概率:0.2,实际的中奖概率:0.05542
17:55:13.525 [main] INFO TestDemo - prizeId:369设置的中奖概率:0.25,实际的中奖概率:0.08082
17:55:13.525 [main] INFO TestDemo - prizeId:400设置的中奖概率:0.3,实际的中奖概率:0.1292
17:55:13.525 [main] INFO TestDemo - 不中奖概率0.70184
```

结果可以明显看出，实际的中奖概率是远下于配置的概率的。

该实现，大致的思路是

1.打乱待抽奖集合

2.roll一个0-1之间的概率

3.遍历待抽奖集合，判断roll出来的概率是否小于奖品设置的概率，若谷小于就中奖并且return，反之不中奖

这种实现的问题在于，如果中奖就return这里，因为假如说，奖品集合的size为6，中大奖概率为1/100，那么用户中大奖的概率就变成了1/100 * 1/6 = 1/600,因为用户中奖需要两个必要条件，1：roll到比0.01更小的数字；2，大奖必须排在集合的第一位。如果这个时候大奖排在第二位，而一个积分奖(高概率)排在了首位，那么就会被积分奖品给拦截掉。这就是该抽奖算法比实际设置的概率低的原因。

改变后的抽奖算法，大致的实现思路为：将奖品集合按照对应的中奖概率划分到不同的区间，然后roll一个随机数，去反查这个数字落在哪个区间，代表中了哪种奖品。代码如下：

```java
// 放大倍数
private static final int mulriple = 100000000;
public PrizeReformDTO rebuildDrawAlgorithm(List<PrizeReformDTO> drawList) {

        int lastScope = 0;
        Collections.shuffle(drawList);
        Map<Integer, int[]> prizeScopes = new HashMap<>();
        for (PrizeReformDTO prize : drawList) {
            if(prize.getLuckyRate().intValue()==0){
                //"中奖概率为0，所以不划分区间"
                continue;
            }
            int prizeId = prize.getId();
            // 划分区间
            int currentScope = (int) (lastScope + prize.getLuckyRate()*0.01*(new BigDecimal(mulriple)).intValue());
            prizeScopes.put(prizeId, new int[]{lastScope + 1, currentScope});
            lastScope = currentScope;
        }
        log.info("prize scopes:{}",JSON.toJSONString(prizeScopes));

        // 获取1-mulriple之间的一个随机数
        int luckyNumber = new Random().nextInt(mulriple);
        log.info("luckyNumber:{}",luckyNumber);
        int luckyPrizeId = 0;
        // 查找随机数所在的区间
        if ((null != prizeScopes) && !prizeScopes.isEmpty()) {
            Set<Map.Entry<Integer, int[]>> entrySets = prizeScopes.entrySet();
            for (Map.Entry<Integer, int[]> m : entrySets) {
                int key = m.getKey();
                if (luckyNumber >= m.getValue()[0] && luckyNumber <= m.getValue()[1]) {
                    luckyPrizeId = key;
                    break;
                }
            }
        }
        if(luckyPrizeId!=0){
            for (int i = 0; i < drawList.size(); i++) {
                if(drawList.get(i).getId().equals(luckyPrizeId)){
                    log.info("lottery result:[prizeId:{},prizeName:{}]",luckyPrizeId,drawList.get(i).getName());
                    return drawList.get(i);
                }
            }
        }
        log.info("lottery result：null");
        return null;
    }
```

抽奖算法重写，进行了一个实际中奖概率和奖品设置的中奖概率比对测试，结果如下

```java
17:49:43.787 [main] INFO TestDemo - 抽奖次数100000
17:49:43.787 [main] INFO TestDemo - prizeId:359设置的中奖概率:0.0,实际的中奖概率:0.0
17:49:43.787 [main] INFO TestDemo - prizeId:360设置的中奖概率:0.05,实际的中奖概率:0.05025
17:49:43.787 [main] INFO TestDemo - prizeId:361设置的中奖概率:0.1,实际的中奖概率:0.09836
17:49:43.787 [main] INFO TestDemo - prizeId:365设置的中奖概率:0.2,实际的中奖概率:0.20138
17:49:43.787 [main] INFO TestDemo - prizeId:369设置的中奖概率:0.25,实际的中奖概率:0.25218
17:49:43.787 [main] INFO TestDemo - prizeId:400设置的中奖概率:0.3,实际的中奖概率:0.2985
17:49:43.787 [main] INFO TestDemo - 不中奖概率0.09933
```

可以发现，我们调用抽奖算法10w次的情况下，实际中奖概率和配置的概率是非常接近的。

## 三、 常用框架（列一下问题点，在开头）

### 1.   基础类库应用

#### 1.1     guava限流组件RateLimiter应用（贴一个tps限流的曲线图）

并发场景下，为了防止抽奖接口被流量冲垮，使用RateLimiter组件进行qps限流，并且限流触发后，可以根据线上实际情况，进行**随机拒绝**部分用户，**概率灵活可配置**

```java
private RateLimiter rateLimiter = RateLimiter.create(2000);

public boolean checkAllLimit(DrawRequest request) {
        boolean qpsFlag = checkLimitQPS();
        if (!qpsFlag) {
            log.info("rate limiter enable.")
            if (configConfiguration.getTrafficPercent() < Math.random()) {
        		return CommonResponse.error(ResultEnum.QPS_LIMIT_FAILED.getCode(), ResultEnum.QPS_LIMIT_FAILED.getMessage());
            }    
		}
    	...
}            

public boolean checkLimitQPS() {
    return rateLimiter.acquire() != 0.0 ? false:true;
}
```
### 2.   中间件应用
#### 2.1     RocketMQ、Redis
抽奖接口上线会面临高并发场景，这个时候大量请求生成订单号会直接操作数据库，进行生成订单号（落库中奖人员信息）和增加奖品发放数量。而这些请求如果直接打到数据库，mysql很可能就会挂掉，压测有试过直接同步落库，性能较差，100的并发，只有68的tps。消息队列主要有三个作用：1.异步，2.解耦，3.削峰。我们可以使用RocketMQ,将生成订单和增加发奖数量进行异步落库，这样服务的耗时瓶颈也就消失了。

如果异步落库失败，我们需要有对应补救机制：设置重试次数，进行本地写文件保存，重试，并更新奖品记录缓存。由于**落库操作是幂等的**，所以不用担心，重试落库会造成超发。

落库操作幂等的原因是，订单号是唯一的，为了防止超发，生成订单号是通过actId+prizeId+index,actId标识活动，prizeId是award_prize_info表的主键，利用**Redis原子操作incr获得index**，比如红包奖品的库存为500，那么index只能是[1~500],而订单表示用订单号作为主键，就算同样的订单落库也只会成功一次。而**生成订单和更新库存是使用事务包裹**起来的，从而保证了订单重复落库是幂等的。防止奖品超发。

```java
//订单号生成
public String createOrderId(String actId,Integer prizeId,String poolCode) throws Exception{
        String orderKey = redisKeyService.getOrderIdIncrKey(actId,prizeId);
        Long index = redisCacheTemplate.incr(key);
    	String prizeInfoKey = redisKeyService.getPrizeReformDTOKey(poolCode,prizeId);
        PrizeReformDTO prizeReformDTO = (PrizeReformDTO)redisCacheTemplate.getex(prizeInfoKey);
        if (index > prizeReformDTO.getCount()){
            //商品无库存，直接返回null
            return null;
        }
        return actId+prizeId+index;
}
```

```java
//consumer落库，失败写文件到本地
public class MqHandler {
	...
    public void handle(AwardInfoMQMsg awardInfoMQMsg) {
        try{
            ...
            awardLuckeyService.upAwardLuckeyUserInfoByMQ(awardInfoMQMsg);
        }catch (Exception e){
            ...
            lostFileUtil.saveExceptionMsgToLocation(awardInfoMQMsg);
        }
    }
}
```

### 3.   开发框架应用

#### 2.1     Spring

使用定时注解在服务启动时预加载奖池奖品数据到redis，减少服务实际请求中对于数据库的直接操作，因为奖池奖品的数据允许5分钟的延迟，而奖品的总库存已经和产品约定好，不得修改总库存，如果在上线过程想把对应奖品下掉，通过奖品概率置为0然后新增同样的奖品，去操作。

```java
	//5min加载奖池奖品信息
    @Scheduled(fixedRate = 1 * 5 * 60 * 1000)
    public void upAwardPrizeInfoCache() {
        log.debug("load prize info");
        awardPoolInfoDao.upAwardPoolInfoMapCacheFromDB(actConfigDataPrefixName);
        awardPoolInfoDao.setAwardPrizeReformDTOListToCache(actConfigDataPrefixName);
        awardPoolInfoDao.getAwardPrizeInfoMap();
        List<Act> acts = actDao.queryActList();
        for (Act act : acts) {
			awardLuckeyInfoDao.timerTaskLatestAwardList(act.getActId(), null);
        }
    }
```

#### 2.2     Mybatis

使用mybatis逆向生成工具，一键生成mapper，mapper.xml，库表实体类（自带数据库备注，以及字段驼峰命名转换），集成tk.mybatis，极大缩短操作数据库时间（写代码的时间，给一个大致的数据，大约节约了多少时间）。

```java
@Data
@Table(name = "mission_award_info")
public class MissionAwardInfo {
    /**
     * 自增id
     */
    @Id
    private Integer id;
    
    /**
     * 订单号
     */
    @Column(name = "orderId")
    private String orderid;

    /**
     * 奖品id
     */
    @Column(name = "award_id")
    private String awardId;
	...
}    

```

```java
public interface MissionAwardInfoMapper extends MyMapper<MissionAwardInfo> {}
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.oppo.bot.activity.award.dal.mapper.MissionAwardInfoMapper" >
  <resultMap id="BaseResultMap" type="com.oppo.bot.activity.award.domain.mission.MissionAwardInfo" >
    <id column="id" jdbcType="INTEGER" property="id" />
    <result column="orderId" jdbcType="CHAR" property="orderid" />
    ...
    <result column="actName" jdbcType="VARCHAR" property="actname" />
  </resultMap>
</mapper>
```




