# IOC学习文档

[TOC]

## 一、  引言

### 1.   需求说明

  ioc的底层实现机制：反射

### 2.   关键问题清单

| 类别 | 问题                             | 自评结论 | 评审结论 |
| ---- | -------------------------------- | -------- | -------- |
| 存储 | 是否涉及存储变更                 | 是       |          |
|      | 存储变更是否兼容老服务           | 是       |          |
|      | 存储变更能否回滚                 | 是       |          |
| 发布 | 上下游服务间api协议是否有升级    | 是       |          |
|      | 发布过程有无顺序依赖             | 无       |          |
|      | 发布过程是否兼容                 | 是       |          |
| 兼容 | 是否兼容新老版本客户端           | 是       |          |
|      | 是否存在多品牌多终端兼容问题     | 否       |          |
|      | 是否兼容一加、realme？           | 兼容     |          |
|      | 是否兼容手表、电视、音响等终端？ | 兼容     |          |

### 3.   文档约定

| 在接口参数的描述中，使用以下术语约定 |                                |
| ------------------------------------ | ------------------------------ |
| 存在                                 | 说明                           |
| M                                    | must 必须存在                  |
| O                                    | optional 可选参数              |
| C                                    | conditional 在某些条件下必     |
| R                                    | copy from request 与请求串一致 |
| -                                    | meaningless 无意义             |

 

## 二、  总体设计

### 1.  静默push架构图

![image-20200825104234815](D:\Users\80261443\AppData\Roaming\Typora\typora-user-images\image-20200825104234815.png)


## 三、   详细设计

### 1.  管理后台接口清单

| 序号 | 服务名     | 接口描述           | 接口名               |
| ---- | ---------- | ------------------ | -------------------- |
| 1    | bot-manage | 获取静默push列表数据 | /manage/api/push/list |
| 2    | bot-manage | 编辑静默push数据 | /manage/api/push/getPushById |
| 3    | bot-manage | 保存静默push数据 | /manage/api/push/editPush |
| 4    | bot-manage | 删除静默push数据 | /manage/api/push/removePush |
| 5    | bot-manage | 复制静默push数据 | /manage/api/push/copy |

### 2.  和客户端约定透传协议

```java
{
    "showType":1,//1代表静默push
    "silentAction":"prefetch",//push行为（prefetch, httpDns, globalConfig）
    "silentJson":""//JSON格式，透传字段
}
```

### 3.   相关协议

#### 3.1   获取静默push列表数据

##### 接口path路径

```java
GET /manage/api/push/list
```

##### 请求参数

| 字段     | 类型     | 说明                  | 约定 |
| -------- | -------- | --------------------- | ---- |
| pageIndex | Long | 用户信息类            | O    |
| pageSize | Long | 分页大小 | O |
| title    | String   | 标题             | O   |
| actionType | Integer | 点击动作(null-全部,0-打开应用,1-打开应用内页,2-打开网页地址3-query上屏,4-语音播报) | O    |
| timeType | String | 用户query分出的技能id | O    |
| status | Integer | 审核状态          | O    |
| pushStatus | Integer | 状态（null-全部，0-未推送，1-已推送，2-已生效） | O    |
| operator | Integer | 更新人           | O    |
| pushTimeFlag | Integer | 推送类型          | O    |
| pushTime | Integer | 推送时间          | O    |
| silentAction | String | push行为(prefetch, httpDns, globalConfig)              | O    |
| showType | Integer | 展示样式(0=通知栏消息,1=静默push) | M |

**示例**

```json
{
  "pageIndex":1,
  "pageSize":20,
  "silentAction":"prefetch",
  "showType":1  
}
```

##### 返回参数

| 字段               | 类型         | 说明         |
| ------------------ | ------------ | ------------ |
| code | Integer | code码 |
| data | Object | 数据体 |
| desc | String | 描述 |

**示例**

```json
{
    "code": 0,
    "data": {
        "total": 331,
        "list": [
            {
                "silentAction":"silentAction",
        		"silentJson":{},//json透传字段,前端需做json格式校验
        		"isSpeed":true,
        		"speed":1000,//推送速率范围（1000~50000）条/秒
            },
            ...
        ]
    },
    "desc": "OK"
}                        
```

#### 3.2   编辑静默push数据

##### 接口path路径

```java
GET /manage/api/push/getPushById
```

##### 请求参数


| 字段 | 类型    | 说明             | 约定 |
| ---- | ------- | ---------------- | ---- |
| id   | Integer | push信息的主键id | M    |

**示例**

```json
{
  "id": 1
}
```

##### 返回参数

| 字段 | 类型    | 说明   |
| ---- | ------- | ------ |
| code | Integer | code码 |
| data | Object  | 数据体 |
| desc | String  | 描述   |

**示例**

```json
{
    "code": 0,
    "data": {
        "silentAction":"silentAction",
        "silentJson":{},//json透传字段,前端需做json格式校验
        "isSpeed":true,
        "speed":1000,//推送速率范围（1000~50000）条/秒
    },
    "desc": "OK"
}
```

#### 3.3   保存静默push数据

##### 接口path路径

```java
POST /manage/api/push/editPush
```

##### 请求参数


| 字段     | 类型     | 说明           | 约定 |
| -------- | -------- | -------------- | ---- |
| pushInfo | PushInfo | 推送信息实体类 | M    |

**示例**

```json
{
    "pushInfo":{
        "silentAction":"silentAction",
        "silentJson":{},//json透传字段,前端需做json格式校验
        "isSpeed":true,
        "speed":1000,//推送速率范围（1000~50000）条/秒
    }
}
```

##### 返回参数

| 字段 | 类型    | 说明   |
| ---- | ------- | ------ |
| code | Integer | code码 |
| data | Object  | 数据体 |
| desc | String  | 描述   |

**示例**

```json
{
  "code": 0,
  "data": {
    	"silentAction":"silentAction",
        "silentJson":{},//json透传字段,前端需做json格式校验
        "isSpeed":true,
        "speed":1000,//推送速率范围（1000~50000）条/秒
  },
  "desc": "OK"
}
```

#### 3.4   删除静默push数据

##### 接口path路径

```java
GET /manage/api/push/removePush
```

##### 请求参数


| 字段 | 类型    | 说明             | 约定 |
| ---- | ------- | ---------------- | ---- |
| id   | Integer | push信息的主键id | M    |

**示例**

```json
{
  "id": 383
}
```

##### 返回参数

| 字段 | 类型    | 说明   |
| ---- | ------- | ------ |
| code | Integer | code码 |
| data | Object  | 数据体 |
| desc | String  | 描述   |

**示例**

```json
{
  "code": 0,
  "data": null,
  "desc": "OK"
}
```

#### 3.5   复制静默push数据

##### 接口path路径

```java
GET /manage/api/push/removePush
```

##### 请求参数


| 字段 | 类型    | 说明             | 约定 |
| ---- | ------- | ---------------- | ---- |
| id   | Integer | push信息的主键id | M    |

**示例**

```json
{
  "id": 383
}
```

##### 返回参数

| 字段 | 类型    | 说明   |
| ---- | ------- | ------ |
| code | Integer | code码 |
| data | Object  | 数据体 |
| desc | String  | 描述   |

**示例**

```json
{
  "code": 0,
  "data": {
    	"silentAction":"silentAction",
        "silentJson":{},//json透传字段,前端需做json格式校验
        "isSpeed":true,
        "speed":1000,//推送速率范围（1000~50000）条/秒
  },
  "desc": "OK"
}
```

#### 3.6   推送静默push数据

##### 接口path路径

```java
GET /manage/api/push/startPush
```

##### 请求参数


| 字段 | 类型    | 说明             | 约定 |
| ---- | ------- | ---------------- | ---- |
| id   | Integer | push信息的主键id | M    |

**示例**

```json
{
  "id": 383
}
```

##### 返回参数

| 字段 | 类型    | 说明   |
| ---- | ------- | ------ |
| code | Integer | code码 |
| data | Object  | 数据体 |
| desc | String  | 描述   |

**示例**

```json
{
  "code": 0,
  "data": null,
  "desc": "OK"
}
```

### 4.   存储设计

1. 存储结构设计。

   | 表名      | 描述       |
   | --------- | ---------- |
   | push_info | 推送信息表 |

   push_info：

   | 字段名             | 类型         | 描述                                   |
   | ------------------ | ------------ | -------------------------------------- |
   | id                 | int(11)      | 自增主键                               |
   | icon               | text         | 图标url                                |
   | style              | tinyint(1)   | 通知栏样式（0-短文本）                         |
   | show_type          | tinyint(1)   | 展示样式：0=通知栏消息，1=静默push     |
   | title              | varchar(50)  | 推送标题                               |
   | content            | varchar(255) | 透传内容（json）                       |
   | action_type        | int(2)    | 点击动作（0-打开应用，1-打开应用内页，2-打开网页地址，3-query上屏，4-语言播报） |
   | landing_type       | int(2)       | （0-打开应用内页，1-activity，2-scheme url） |
   | action_content | varchar(255) |  |
   | params             | text  | 键值（json格式存储）                   |
   | push_scope_flag    | int(2) | 推送范围标识（0-全部用户，1-registration_ID[多个逗号分隔最多五个]，2-用户条件） |
   | push_scope         | text | 推送范围            |
   | status             | smallint(1) | 流程状态（0-未审核，1-审核中，2-发布） |
   | push_time          | datetime | 推送时间            |
   | is_offline         | tinyint(1)   | 是否支持离线展示（0-否，1-定时）  |
   | expiry_time        | int(5) | 有效时长（单位：小时） |
   | is_timing          | tinyint(1) | 定时展示（0-关闭，1-开启）  |
   | channel            | varchar(50) | 通道                 |
   | pre_delete         | smallint(1) | 已废弃                               |
   | pre_modify         | smallint(1) |                                |
   | push_status        | int(2) | 状态（0-未推送，1-已推送，2-已生效）          |
   | push_cycle         | text   | 推送周期(存放 与周期相关的json数据）     |
   | is_speed           | tinyint(1) | 是否定速推送           |
   | speed              | int(12) | 定速推送（单位  条/s）（范围：1000~50000） |
   | show_start_time    | datetime | 定时展示 开始时间                      |
   | show_end_time      | datetime | 定时展示 结束时间 |
   | start_time | datetime | 暂时废弃 |
   | push_flag          | tinyint(1) |                                        |
   | fail_tag           | varchar(255) |  |
   | operator           | varchar(12) | 操作人                              |
   | create_time        | datetime | 创建时间 |
   | update_time        | datetime | 更新时间 |
   | is_delete          | tinyint(1) | 是否删除 |
   | push_way           | text | 推送通道 |
   | time_out           | int(12) | 定时清除 |
   | action_type_two    | int(1) | 点击动作（0-打开应用,1-打开应用内页,2-打开网页地址3-query上屏,4-语音播报） |
   | action_content_two | varchar(255) | 触发内容 |
   | params_two | text | 键值（json格式存储） |
   | landing_type_two | int(2) |                                        |
   | action | tinyint(1) | 是否点击button |
   | push_time_flag | tinyint(1) | 推送时间标识（0-立即，1-定时,2-周期） |
   | silent_action | varchar(50) | 目前支持三种形式(prefetch,httpDns,globalConfig)|
   | silent_json | varchar(255) | 静默push透传给客户端的字段|


## 四、   高可用设计

结合业务特点，参考以下设计内容：

1、 数据一致性设计

2、 冗余设计（主备，多活）

3、 熔断设计

4、 柔性设计

## 五、   监控告警

### 1.   静默push监控项

1.静默push请求数

2.静默push成功数

3.静默push异常数

## 六、   资源与排期

### 1.   机器和存储资源预估

### 2.   研发工作量预估

## 七、   评审记录

| 评审时间 | 评审建议 | 评审结论 |
| -------- | -------- | -------- |
|          |          |          |
|          |          |          |

 