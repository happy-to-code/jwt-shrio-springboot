# yida-jwt-shiro

项目基于 Spring Boot 2.1.13 ，使用JWT进行鉴权授权，shiro进行权限控制。
#### 开发环境

- JDK：8
- IDE：IntelliJ IDEA （后端）
- 依赖管理：Maven
- 数据库：MySQL 5.7.18

#### 表结构的简介
```aidl
    权限的认证和校验采用RBAC模型，总共有5张表，分别为user、user_role、role、role_permission和permission，
其中user_role和role_permission为中间表，user表和role表示一对多的关系，role表和permission表也是一对多的关系。
```
#### 项目权限验证流程
1.用户填写用户名和密码后用POST请求访问/login接口，程序返回token令牌信息，失败则直接返回身份错误信息。

2.在之后接口的API请求中需要验证身份，请求的Headers中是否添加Authorization和登录时返回的token令牌。

3.服务端进行token认证，失败身份错误信息。

4.用JWT做认证（登录），Shiro做授权。

#### 项目运行

-   下载源码
    
-   配置Java运行坏境，主要是JDK（基于1.8），maven
    
-   创建shirojwt数据库，设置编码为UTF-8，执行shiroJwt.sql文件，初始化数据
    
-   修改application.yml，更新MySQL账号和密码
    
-   IDEA运行DemoApplication，则可启动项目。或在yida-jwt-shiro目录下运行命令mvn clean package，然后在yida-jwt-shiro/target目录下运行java -jar yida-jwt-shiro-1.0-SNAPSHOT.jar命令


#### 测试
- 1、启动应用

    *访问URL获取token*
    
    ```
    POST http://localhost:8888/login
    ```
  
  *Body参数*
  
  ``` json
  {
  	"username":"admin",
  	"password":"admin"
  }
  ```
  返回值：
  
  ``` json
     {
         "code": 200,
         "msg": "Login success",
         "data": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1ODYxNTUzMzcsInVzZXJuYW1lIjoiYWRtaW4ifQ.XLjCcDCo0_Qjn-neIwfa1DfLH8xL1bYr8pSPv9zW6LU"
     }
  ```
  
![](pic/获取token.png "使用postman获取token")

- 2、使用token访问API
>
> 2.1 我们先测试下不带token访问API的情况
![](pic/未携带token访问.png "不带token访问API的情况")
> 我们可以看到直接报错了
>
>> 2.2 同样的请求携带token
![](pic/携带token访问成功.png "携带token")
>
- 3、测试权限控制之角色控制
```aidl
   先解释下一个注解:
   @RequiresRoles(value = {"admin","guest"},logical = Logical.OR)
   这个注解的作用是携带的token中的角色必须是admin、guest中的一个
   如果把logical = Logical.OR改成logical = Logical.AND，那么这个注解的作用就变成角色必须同时包含admin和guest了
    
```
>
> 3.1、我们先测试用admin登录，但要求角色是guest的情况
>
>    即注解是@RequiresRoles(value = {"guest"})这种情况，但我们给的token却是admin登录的token
![](pic/需要guest角色但却是admin的token.png "需要guest角色但却是admin的token")

>![](pic/guest权限guest的token.png "guest权限guest的token,访问成功！")

- 3、测试权限控制之权限控制
```aidl
     惯例解释下注解：
     @RequiresPermissions(logical = Logical.OR, value = {"user:view", "user:edit"})
    和@RequiresRoles类似，权限的的值放在value中，值之间的关系用Logical.OR和Logical.AND控制

    在我们的数据库中，admin有两个角色，角色名分别是：admin和guest，角色拥有的权限分别是：
    admin：[user:view，user:edit]，guest：[user:edit]
```

![](pic/权限不足的情况.png "权限不足的情况")

![](pic/有权限访问.png "有权限访问")


