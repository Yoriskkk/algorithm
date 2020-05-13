# JVM

[TOC]

























## 一、  JVM内存结构

### 1.   运行时数据区

![image-20200513191715402](pic\image-20200513191715402.png)

#### 1.1     方法区

方法区与Java堆一样，是各个**线程共享**的内存区域，它用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。虽然Java虚拟机规范把方法区描述为堆的一个逻辑部分，但是它却有一个别名叫做Non-Heap（非堆），目的是与Java堆区分开来。

- 常量池

  运行时常量池时方法区的一部分。Class文件中除了有类的版本、字段、方法、接口等描述信息外，还有一项信息是常量池，用于存放编译期生成的各种字面量和符号引用，这部分内容将在类加载后进入方法区的运行时常量池中存放

#### 1.2     虚拟机栈

Java虚拟机栈是**线程私有**的，它的生命周期与线程相同。虚拟机栈描述的是J**ava方法执行的内存模型**：每个方法在执行的同时都会创建一个栈帧，用于存储局部变量表、操作数栈、动态链接、方法出口等信息。每一个方法从调用直至执行完成的过程，就对应着一个栈帧在虚拟机栈中入栈到出栈的过程。

#### 1.3     本地方法栈

本地方法栈与虚拟机栈锁发挥的作用是非常相似的，它们之间的区别是：

- 虚拟机栈为虚拟机执行Java方法（也就是字节码）服务
- 本地方法栈则为虚拟机使用到的Native方法服务

#### 1.4     堆

Java堆是Java虚拟机所管理的内存中最大的一块。堆是被所有**线程共享**的一块内存区域，在虚拟机启动时创建。此内存区域的**唯一目的就是存放对象实例**，几乎所有的对象实例都在这里分配内存。

Java堆可以处于物理上不连续的内存空间中，只要逻辑上是连续的即可。

![1589383222531](pic\\1589383222531.png)

- S0 ：survivor from
- S1：survivor to ，S0和S1是大小相等的两块区域，在同一时间节点上只有一块区域是有数据的
- Metaspace：Class、Package、Method、Field、字节码、常量池、符号引用等等
- CCS：压缩类空间，存放32位指针的Class
- CodeCache：JIT编译后的本地代码、JNI使用的C代码

#### 1.5     程序计数器 PC Register

JVM支持多线程同时执行，每一个线程都有自己的PC Register,线程正在执行的方法叫做当前方法，如果是java代码，PC Register里面存放的就是当前正在执行的指令的地址，如果是c语言，则为空


## 二、 JVM常用参数

- -Xms	最小堆内存
- -Xmx    最大堆内存
- -XX:NewSize    新生代大小
- -XX:MaxNewSize    新生代最大的大小
- -XX:NewRatio    new区和old区的比例
- -XX:SurvivorRatio    eden区和survivor区的比例
- -XX:MetaspaceSize    
- -XX:MaxMetaspaceSize    
- -XX:+UseCompressedClassPointers    是否启用压缩类指针，启用就会产生ccs,默认最大一个G
- -XX:CompressedClassSpaceSize    设置压缩类大小
- -XX:InitialCodeCacheSize
- -XX:ReservedCodeCacheSize

## 三、 垃圾回收算法

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




