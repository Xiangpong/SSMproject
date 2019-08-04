## 项目准备前瞻

### 技术选型
* Spring
* Spring MVC
* Mybatis
* redis 缓存
* solor 搜索服务
* EasyUI 
* UEditor
* JQuery
* Freemark 模板渲染引擎
* activMQ 消息队列
* httpClient
* MySQL
### 开发环境
* Intellij IDEA
* Maven
* Tomcat7
* JDK
* Nginx 
* Git
* postman
* sqlyog
* Windows10

### 关键内容
* 技术架构
* 工程搭建
* SSM框架整合
* Mybatis逆向工程
* 日志的添加与使用
* 拦截器
* 后端功能（系统开发，图片系统，数据等）
* 前端功能（商品浏览，下订单，购物车等）
* redis 使用及集群搭建
* solor 使用和集群搭建
* JMS 消息队列
* sso 单点登录
* restful服务
* 在Linux上部署

## 架构

**传统的集群架构 和 分布式架构 的区别**

### 单机架构
讲集群架构之前，要先提一下单机架构。例如一个简单的web项目，这个项目被部署在一个服务器上，这样的架构模式就是单机架构。显而易见：单个服务器能够处理能力是有限的，当这个项目不断添加新的业务处里，访问量不断增加时，单机往往无法负荷，最常见的就是访问某个网站时页面显示过慢（没错！同志！有时候打开一个网页打开半天其实不是你网速不行）

### 集群架构

单个服务器应付不过来，那就多来几个。将原来部署在单机的项目复制几份，分别部署在其他服务器上，构成一个“群”，一个服务器就是这个集群上的一个节点，**每个节点处理同样的业务**。当有客户访问服务器时，“负载均衡服务器”就会将客户引导向集群中负载较小的节点，以此提供给客户最好的访问体验。
我个人都集群架构解决单机架构问题的方式，称之为“暴力破解”。

* 优点：解决单个服务器业务过多访问量过大时出现安全问题
* 缺点：耦合度高；增加了运维成本；不能灵活部署。

### 分布式架构

例如一个web电商项目，其业务类型一点是多样的，“用户服务”、“商品服务”、“后台管理服务”等。分布式架构，即将一个完整的系统拆分成多个子系统（子项目），分布在不同的服务器中，这一个个服务都是一个个独立的项目，可以独立运行。服务之间又存有依赖，数据流通。

* 优点：模块独立，耦合度低；独立运维；灵活部署
* 缺点：需要额外开发模块间的数据通讯

## Git代码版本管理系统

1. 通过git可以将代码保存到服务器，防止代码丢失。例如较为出名的Github
2. 远程代码同步，使用不同机器不同地点，可以对保存在服务器上的代码进行同步修改
3. 团队合作，团队成员可以使用git对同一服务器上的同一项目进行作业
4. 误删文件不用怕
5. 记录项目版本

### git的安装

git是一个软件，安装方式和普通软件一样，去官网下载对应版本就好了。

https://git-scm.com/

### 常用git的命令

创建git仓库
> git init 

下载git仓库
> git clone 'host'      //host为项目地址

查看仓库状态
> git status

添加文件到仓库暂存区
> git add 'filename'    
> git add *    //提交全部文件

将暂存区文件提交到git仓库
> git commit 

将仓库文件提交到远端服务器的某个分支
> git push origin master  //master可以换成其他分支名

查看当前分支
> git branch

创建分支
> git branch branch_name

切换当前分支到其他分支
> git checkout another_branch

删除分支
> git branch -d branch_name

更多git命令可以阅读git使用文档。
这里推荐一个简单的git命令指南网站：http://rogerdudler.github.io/git-guide/index.zh.html

## Github

> GitHub是通过Git进行版本控制的软件源代码托管服务平台---维基百科

### Github的身份多种多样

* 代码托管服务器
* 多人协作平台
* 个人博客网址
* 个人简历

Github的使用这里就不多做介绍了，百度可以搜索到很多使用教程。

## Maven的安装与配置    

### 什么是Maven

一个项目管理工具，提供了一套完整的构建生命周期的框架，亦可以是一个整合工具。

* 可以自动完成一些工程的基础构建配置

### Maven的安装

1. 首先要配置好JDK的环境变量
2. 从官网下载
3. 配置Maven环境变量

### 修改配置文件

#### 添加阿里云镜像路径

Maven文件夹 → conf文件夹 → settings.xml
在mirrors标签之间添加：
```xml
   <mirror>
      <id>alimaven</id>
      <mirrorOf>central</mirrorOf>
      <name>aliyun.maven.mirror</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </mirror>
```

#### 配置本地仓库

Maven文件夹 → conf文件夹 → settings.xml

```xml
 <localRepository>D:/MavenRepository</localRepository>
```

### Maven的特性

#### 依赖管理
* jar包的依赖
* 工程间的依赖
* 继承
* 聚合

#### 工程类型
* war包项目
* jar包项目
* pom工程


## SSM商城模块设计

![模块设计图.png](https://i.loli.net/2019/06/21/5d0bb2a6d58c853544.png)

![模块设计图2.png](https://i.loli.net/2019/06/21/5d0bb2a70a79f26080.png)

## 用IDEA创建Maven项目

...

## SSM框架整合

spring → service

spring MVC → 表现层

Mybatis → dao 数据库

### 什么是Mybatis？

MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以使用简单的 XML 或注解来配置和映射原生类型、接口和 Java 的 POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

### 什么是druid连接池

Druid是Java语言中最好的数据库连接池。Druid能够提供强大的监控和扩展功能。

### 引入Mybatis

1. Parent模块的pom.xml中配置Mybatis依赖。

2. 在Manager模块的mapper包中的pom.xml配置一致的Mybatis依赖
图

3. 在Manager模块 → web包 → src/mian/resource → 创建mybatis文件夹并创建sqlMapConfig.xml文件 用于构建 SqlSessionFactory

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <!--<environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="org/mybatis/example/BlogMapper.xml"/>
  </mappers> -->
</configuration>
```
#### 上面为sqlMapConfig.xml文件内容，注释内容可删除，因为将通过Spring来调用

引入完成后Maven依赖情况

![配置Mybatis.png](https://i.loli.net/2019/06/21/5d0bb2a71621a69468.png)

### 引入Spring

1. 在Parent中的pom.xml中配置以下依赖：
    * spring-context
    * spring-jdbc
    * spring-aspects
    * spring-beans
    * spring-webmvc

2. 在manager模块的service包的pom.xml 配置相同依赖

3. 在manager模块 → web包 → src/mian/resource → 创建spring文件夹并创建springmvc.xml文件
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc" xsi:schemaLocation="http://www.springframework.org/schema/context
              http://www.springframework.org/schema/context/spring-context-4.2.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">
    <context:component-scan base-package="com.pong.controller">
    </context:component-scan>

    <mvc:annotation-driven></mvc:annotation-driven>

    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
</beans>
```

#### 引入完成后Maven依赖情况

![配置spring.png](https://i.loli.net/2019/06/21/5d0bb2a6d5b7b12454.png)

### 引入druid连接池

1. 在Parent中的pom.xml中配置druid依赖：

2. 在manager模块中的mapper包的pom.xml配置相同依赖

3. 在manager模块 → web包 → src/mian/resource/spring 创建以下文件：
    * applicationContext-dao.xml
    * applicationContext-trans.xml
    * applicationContext-service.xml

#### applicationContext-dao.xml

的配置信息可以在druid的中文使用文档中的druid参考配置找到：
https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98  

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:context="http://www.springframework.org/schema/context"  xsi:schemaLocation="
       http://www.springframework.org/schema/context
              http://www.springframework.org/schema/context/spring-context-4.2.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">

    <context:property-placeholder location = "classpath:properties/db.properties"/>

    <!-- 这里用导入properrties文件来给定url，username，password的值 -->

    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
        <property name="url" value="${jdbc_url}" />
        <property name="username" value="${jdbc_user}" />
        <property name="password" value="${jdbc_password}" />
        <property name="filters" value="stat" />
        <property name="maxActive" value="20" />
        <property name="initialSize" value="1" />
        <property name="maxWait" value="60000" />
        <property name="minIdle" value="1" />
        <property name="timeBetweenEvictionRunsMillis" value="60000" />
        <property name="minEvictableIdleTimeMillis" value="300000" />
        <property name="testWhileIdle" value="true" />
        <property name="testOnBorrow" value="false" />
        <property name="testOnReturn" value="false" />
        <property name="poolPreparedStatements" value="true" />
        <property name="maxOpenPreparedStatements" value="20" />
    </bean>

    <!--配置Mybatis-spring-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="configLocation" value="classpath:mybatis/sqlMapConfig.xml"/>
        <property name="dataSource" ref="dataSource" />
    </bean>

    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.pong.mapper"/>
    </bean>

</beans>
```

!!：额外在manager模块 → web包 → src/mian/resource/ 创建一个perproties文件夹并创建一个db.perproties文件

#### db.perproties
```
jdbc_url =  
jdbc_user = 
jdbc_password = 
```

#### applicationContext-service.xml
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:context="http://www.springframework.org/schema/context"  xsi:schemaLocation="
       http://www.springframework.org/schema/context
              http://www.springframework.org/schema/context/spring-context-4.2.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">

    <context:component-scan base-package="com.pong.service"></context:component-scan>


</beans>
```

#### applicationContext-trans.xml
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/context
              http://www.springframework.org/schema/context/spring-context-4.2.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">
    <bean id="transactionManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="save*" propagation="REQUIRED"/>
            <tx:method name="insert*" propagation="REQUIRED"/>
            <tx:method name="add*" propagation="REQUIRED"/>
            <tx:method name="create*" propagation="REQUIRED"/>
            <tx:method name="delete*" propagation="REQUIRED"/>
            <tx:method name="update*" propagation="REQUIRED"/>
            <tx:method name="find*" propagation="SUPPORTS" read-only="true"/>
            <tx:method name="select*" propagation="SUPPORTS" read-only="true"/>
            <tx:method name="get*" propagation="SUPPORTS" read-only="true"/>
        </tx:attributes>
    </tx:advice>

    <aop:config>
        <aop:advisor advice-ref="txAdvice"
                     pointcut="execution(* com.pong.service.*.*(..))"/>
    </aop:config>
</beans>
```

### 引入MySQL

1. 在Parent中的pom.xml中配置MySQL依赖：

2. 在manager模块中的mapper包的pom.xml配置相同依赖

3. 用SQLyog工具在创建数据库和一个测试用表

### 引入Tomcat

在manager的pom.xml配置tomcat7-maven-plugin插件

### 测试准备

1. 在web包的webapp文件夹（没有的话创建一个）中创建WEB-INF文件夹，通过idea生成web.xml,并作如下配置
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <display-name>pong-manager</display-name>

    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>

    <!--加载spring容器-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring/applicationContext-*.xml</param-value>
    </context-param>

    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <!--解决post乱码-->
    <filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!--springmvc的前端控制器-->
    <servlet>
        <servlet-name>pong-manager</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring/springmvc.xml</param-value>
        </init-param>

        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>pong-manager</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
```
2. 在webapp文件夹创建一个简单的jsp文件

。。。

#### 所有工作基本完成，文件夹情况和Maven依赖情况如下

![文件夹目录1.png](https://i.loli.net/2019/06/21/5d0bb3b83d81e75052.png)
![文件夹目录2.png](https://i.loli.net/2019/06/21/5d0bb3b850a9f94933.png)
![文件夹目录3.png](https://i.loli.net/2019/06/21/5d0bb3b8528c592076.png)


---
![Maven依赖1.png](https://i.loli.net/2019/06/21/5d0bb3b885c0188953.png)
![Maven依赖2.png](https://i.loli.net/2019/06/21/5d0bb3b8894b158944.png)


### 测试结果

![测试运行配置.png](https://i.loli.net/2019/06/21/5d0bb3b87e83f15925.png)
![测试结果.png](https://i.loli.net/2019/06/21/5d0bb3b84c9c125124.png)

### 190620 SSM框架整合完成第一步

### Mybatis的逆向工程

>MyBatis的一个主要的特点就是需要程序员自己编写sql，那么如果表太多的话，难免会很麻烦，所以mybatis官方提供了一个逆向工程，可以针对单表自动生成mybatis执行所需要的代码（包括mapper.xml、mapper.java、po..）。一般在开发中，常用的逆向工程方式是通过数据库的表生成代码。


这里我使用“generatorSqlmapCustom”逆向工程代码
来生成Mapper和Pojo文件，用于Spring、Mybatis、数据库的整合

代码链接：https://github.com/JeffersonQAQ/generatorSqlmapCustom.git

[![逆向工程.png](https://i.loli.net/2019/06/24/5d1079b7ca93e87590.png)](https://i.loli.net/2019/06/24/5d1079b7ca93e87590.png)

如上图

将mapper文件夹文件（UserMapper、UserMapper.xml）复制到SSM项目的manager模块的mapper文件夹 → src/main/java/com.pong.mapper 文件夹内

将pojo文件夹文件（User、UserExample）复制到SSM项目的manager模块的pojo文件夹  → src/main/java/com.pong.pojo  文件夹内

[![逆向工程2.png](https://i.loli.net/2019/06/24/5d1079b7bee4463907.png)](https://i.loli.net/2019/06/24/5d1079b7bee4463907.png)

[![逆向工程3.png](https://i.loli.net/2019/06/24/5d1079b7bef0071324.png)](https://i.loli.net/2019/06/24/5d1079b7bef0071324.png)

#### 引入jackson-databind依赖

### 写一个service Demo 来检测整合结果

关键代码：

UserServiceImpl

```java
package com.pong.service.impl;

import com.pong.mapper.UserMapper;
import com.pong.pojo.User;
import com.pong.pojo.UserExample;
import com.pong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);

        List<User> userList = userMapper.selectByExample(userExample);

        if (userList != null) {
            return userList.get(0);
        }
        return null;
    }
}
```

UserController

```java
package com.pong.controller;

import com.pong.pojo.User;
import com.pong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/{userid}")
    @ResponseBody
        public User getUserById(@PathVariable Integer userid){
            User user = userService.getUserById(userid);
            return  user;
    }
}
```



### 运行测试

[![测试结果2.png](https://i.loli.net/2019/06/24/5d1079b7ca3b728420.png)](https://i.loli.net/2019/06/24/5d1079b7ca3b728420.png)

### 过程中的问题

1. 未引入jackson-databind依赖 
2. 未给UserServiceimpl 添加@Service注解
3. 未给UserController 添加@Controller注解
4. org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)

#### 第四点为关键错误，可以从两个方面排查：

* Mapper interface和xml文件的定义对应不上，需要检查包名，namespace，函数名称等能否对应上；因为是用逆向工程生成的文件，所以一般没有错误

* mapper没有自动复制到响应位置，也会出错；maven默认会把src/main/resources下的所有配置文件以及src/main/java下的所有java文件打包或发布到target\classes下面，但是现实我们可能会在src/main/java下面也放置一些配置文件如hibernate配置文件或mybatis mapper配置文件等，如果不做一些额外配置，那我们打包后的项目可能找不到这些必须的资源文件，因此在pom.xml中增加类似如下配置：

```xml
<build>
	<resources>
		<resource>
			<directory>src/main/java</directory>
			<includes>
				<include>**/*.xml</include>
			</includes>
		</resource>
		<resource>
			<directory>src/main/resources</directory>
		</resource>
	</resources>
</build>
```
### 190624 SSM框架整合完成

## 搭建项目后台管理系统

### EasyUI

EasyUI是一个简单的HTML5网页前端框架，这里用它来做后台管理界面

官网：http://www.jeasyui.net/

* 选择基于JQuery的压缩包下载

### 配置EasyUI

* 在wabapp文件夹创建css、js子文件夹
* 解压EasyUI压缩包
* 复制解压包内的themes文件夹到css文件夹
* 复制解压包内的jquery.min.js、jquery.easyui.min.js 文件到js文件夹
* 配置springmvc.xml，添加：

```xml
<mvc:resources mapping="/css/**" location="/css/"/>
<mvc:resources mapping="/js/**" location="/js/"/>
```
！！过程中问题：css、js等静态文件被springmvc拦截，导致网页样式，事件失效

！！解决：把```<mvc:resources>```配置好就行了，注意路径问题

### 190625 完成设计布局 1



### PowerDesigner

#### 使用PowerDesigner设计数据库表

[![powerdesigner表创建.png](https://i.loli.net/2019/06/26/5d1315f27778062025.png)](https://i.loli.net/2019/06/26/5d1315f27778062025.png)

#### 测试连接数据库

！！测试连接时发现配置信息都正确却怎么也连接不上

！！需要给PowerDesigner配置32位的jdk

[![给PowerDesigner配置32位jdk.png](https://i.loli.net/2019/06/26/5d1315ef1a4a010744.png)](https://i.loli.net/2019/06/26/5d1315ef1a4a010744.png)

[![powerdesigner测试连接.png](https://i.loli.net/2019/06/26/5d131666494d672435.png)](https://i.loli.net/2019/06/26/5d131666494d672435.png)

#### 使用PowerDesigner创建数据库表

[![创建商品表.png](https://i.loli.net/2019/06/26/5d1315f37a2b623734.png)](https://i.loli.net/2019/06/26/5d1315f37a2b623734.png)

### 获取商品分类列表的后端实现

* 使用逆向工程对刚刚创建的product表和product_category表生成mapper，pojo文件

* 关键代码

ProductController

```java
/**
 * 商品分类管理控制器
 */
@Controller
@RequestMapping("/product_category")
public class ProductCategoryController {
    /*
    根据id返回数据列表
     */
    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITree> getProductCategoryByParentId(@RequestParam(value = "id",defaultValue = "0")short parentId){
        List<EasyUITree> easyUITrees = productCategoryService.findProductCategoryListByParentId(parentId);
        return easyUITrees;
    }
}
```

ProductControllerServiceImpl

```java
@Service
public class ProductControllerServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    
    @Override
    public List<EasyUITree> findProductCategoryListByParentId(Short parentId) {
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<ProductCategory> productCategoriesList = productCategoryMapper.selectByExample(productCategoryExample);
        List<EasyUITree> easyUITrees = new ArrayList(productCategoriesList.size());

        for (ProductCategory productCategory:productCategoriesList) {
                EasyUITree easyUITree  = new EasyUITree();
                easyUITree.setId(productCategory.getId());
                easyUITree.setText(productCategory.getName());
                easyUITree.setState(productCategory.getParentId()==0? "closed":"open");

                easyUITrees.add(easyUITree);
        }
        return easyUITrees;
    }
}
```

### 测试结果

[![测试结果4.png](https://i.loli.net/2019/06/26/5d1315f18c25967872.png)](https://i.loli.net/2019/06/26/5d1315f18c25967872.png)

### 过程中问题

是一个Maven的整合问题，出现“Could not resolve dependencies for project”的错误

解决：在Maven里对parent进行install解决

[![Maven依赖问题解决.png](https://i.loli.net/2019/06/26/5d1315ef0118972314.png)](https://i.loli.net/2019/06/26/5d1315ef0118972314.png)

---

### 商品分类列表的增删改实现

[![分类的增删改查2.png](https://i.loli.net/2019/07/01/5d19e9c87dda469186.png)](https://i.loli.net/2019/07/01/5d19e9c87dda469186.png)

### 前端关键代码

```JavaScript
<script>
        $(function () {
            $('#productCategory').tree({
                url: "/product_category/list",
                onContextMenu: function(e, node){
                    e.preventDefault();
                    // select the node
                    $('#productCategory').tree('select', node.target);
                    // display context menu
                    $('#mm').menu('show', {
                        left: e.pageX,
                        top: e.pageY
                    });
                },
                onAfterEdit:function (node) {
                    var _tree = $('#productCategory');
                    if (node.id == 0){
                        $.post("/product_category/add",{ parentId:node.parentId,name:node.text},function (data) {
                            if (data.status==200) {
                                _tree.tree("update",{
                                    target:node.target,
                                    id:data.msg
                                })
                            }else {
                                $.messager.alert("添加失败")
                            }
                        })
                    }else {
                        $.post("product_category/update",{id:node.id,name:node.text})
                    }
                }
            });
        })

        function append() {
            //添加分类
            var tree = $('#productCategory');
            var node = tree.tree('getSelected');
            tree.tree('append', {
                parent: (node?node.target:null),
                data: [
                    {
                        id:0,
                        parentId:node.id,
                        text:"新建子分类"
                    }
                ]
            });
            var _selected = tree.tree("find",0);
            tree.tree("select",_selected.target).tree('beginEdit',_selected.target)
        }

        function appendF() {
            //添加父分类
            var tree = $('#productCategory');
            var node = tree.tree('getSelected');
            tree.tree('append', {
                parent: null,
                data: [
                    {
                        id:0,
                        parentId:0,
                        text:"新建父分类"
                    }
                ]
            });
            var _selected = tree.tree("find",0);
            tree.tree("select",_selected.target).tree('beginEdit',_selected.target)
        }



        function reEdit() {
            //编辑
            var tree = $('#productCategory');
            var node = tree.tree('getSelected');
            tree.tree('beginEdit',node.target)

        }

        function remove() {
            //删除
            var tree = $('#productCategory');
            var node = tree.tree('getSelected');
            $.messager.confirm('确认','确定删除名为 '+node.text+' 的分类吗？',function(r){
                if(r){
                    $.post("product_category/delete",{parentId:node.attributes,id:node.id},function(){
                        tree.tree("remove",node.target);
                    });
                }
            });
        }
</script>
```
#### 基本效果图

[![分类的增删改查1.png](https://i.loli.net/2019/07/01/5d19e9c8698b098180.png)](https://i.loli.net/2019/07/01/5d19e9c8698b098180.png)

### 逐步实现增、删、改功能  --- 后端关键代码

1. 在common模块创建一个ResponseJsonResult实体类，用来打包服务器返回的json信息

```java

 private int status = 200;
    private String msg;
    private Object obj;
    private List<?> list = new ArrayList<Object>();

...get...set...

```
2. 在接口ProductCategoryService新增删改方法

```java

ResponseJsonResult addCategory(Short parentId, String name);

ResponseJsonResult updateCategory(Short id,String name);

ResponseJsonResult deleteCategory(Short parentId,Short id);

```

3. 在实现类ProductCategoryServiceImpl实现这三个方法

```java

/*
插入方法
*/

public ResponseJsonResult addCategory(Short parentId, String name) {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setParentId(parentId);
        productCategory.setName(name);

        productCategoryMapper.insert(productCategory);
        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setMsg(productCategory.getId()+"");

        return responseJsonResult;
    }


/*
更新方法
*/
 public ResponseJsonResult updateCategory(Short id, String name) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(name);
        productCategory.setId(id);

        productCategoryMapper.updateByPrimaryKey(productCategory);
        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setMsg(productCategory.getId()+"");

        return responseJsonResult;
    }


/*
删除方法
*/
 public ResponseJsonResult deleteCategory(Short parentId, Short id) {
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();

        if (parentId != 0){
            criteria.andIdEqualTo(id);

        }else {
            criteria.andIdEqualTo(id);
            ProductCategoryExample.Criteria criteriaL = productCategoryExample.createCriteria();
            criteriaL.andParentIdEqualTo(id);
            productCategoryExample.or(criteriaL);
        }

        productCategoryMapper.deleteByExample(productCategoryExample);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setStatus(200);
        responseJsonResult.setMsg("success");
        return responseJsonResult;
    }

```

### 测试

* 添加测试

[![分类的增删改查3.png](https://i.loli.net/2019/07/01/5d19e9c85692383815.png)](https://i.loli.net/2019/07/01/5d19e9c85692383815.png)


* 测试结果：

[![分类的增删改查_添加测试.png](https://i.loli.net/2019/07/01/5d19e9c85663b85560.png)](https://i.loli.net/2019/07/01/5d19e9c85663b85560.png)


* 修改测试

[![分类的增删改查_修改测试.png](https://i.loli.net/2019/07/01/5d19ec0b69a4697435.png)](https://i.loli.net/2019/07/01/5d19ec0b69a4697435.png)

* 删除测试

[![分类的增删改查_删除测试.png](https://i.loli.net/2019/07/01/5d19eb9a9baf397985.png)](https://i.loli.net/2019/07/01/5d19eb9a9baf397985.png)


### 过程中问题

删除方法中，需要对删除对象是否是父分类进行判断，因为父分类下面很可能有子分类

### 190701 实现对分类列表的增删改查

---

## 文件服务器搭建 fastDFS

### 什么是fastDFS

抛一个GitHub： https://github.com/happyfish100/fastdfs 

通过阅读文档可以得知：fastDFS是一个开源的高性能的分布式文件系统

其主要功能主要有：

* 文件存储
* 文件同步和访问
* 解决高并发负载均衡问题

特别适合小文件的海量存储，这里可以用来操作商城的图片存储部分！

#### fastDFS的工作原理：

[![fastdfs3.png](https://i.loli.net/2019/07/03/5d1cbdebcd06b36339.png)](https://i.loli.net/2019/07/03/5d1cbdebcd06b36339.png)

### 部署FastDFS 

虚拟机最小安装一个centOS系统

[![fastdfs5.png](https://i.loli.net/2019/07/03/5d1cbde9875fc47554.png)](https://i.loli.net/2019/07/03/5d1cbde9875fc47554.png)

阅读项目wiki，逐步完成部署

完成了Tracker Server 和Storage Server 部署后测试

[![fastdfs4.png](https://i.loli.net/2019/07/03/5d1cbde987dd626969.png)](https://i.loli.net/2019/07/03/5d1cbde987dd626969.png)

## 使用Nginx访问文件服务器

### 什么是Nginx

Nginx是一款轻量级HTTP方向代理服务器

* 处理静态文件，索引文件，自动索引文件
* 实现简单的负载均衡和容错
* 模块化结构

### 部署Nginx

在fastDFS的GitHub项目的wiki，同样有部署Nginx的教程，按照教程部署。

### 最终测试

简单存储一张照片，用外部浏览器读取

[![fastdfs2.png](https://i.loli.net/2019/07/03/5d1cbdea3a2f243865.png)](https://i.loli.net/2019/07/03/5d1cbdea3a2f243865.png)

[![fastdfs1.png](https://i.loli.net/2019/07/03/5d1cbdeb5d31133373.png)](https://i.loli.net/2019/07/03/5d1cbdeb5d31133373.png)

### 过程中问题

！！：外部浏览器访问不到

解决：在确定配置文件没有问题之后，认定为服务器防火墙没有关闭，关闭后实现访问

### 190703 完成fastDFS服务器部署

---

## SpringMVC整合fastDFS服务器

### FastDFS-Java-Client

项目Github：https://github.com/happyfish100/fastdfs-client-java

下载该项目，将其中Maven依赖的jar包导入本地Maven仓库

```xml
<dependency>
    <groupId>org.csource</groupId>
    <artifactId>fastdfs-client-java</artifactId>
    <version>1.27-SNAPSHOT</version>
</dependency>
```

* 在SSM项目的parent模块的pom.xml中导入上述依赖
* 在manager模块的web包的pom.xml同样导入该依赖

### fds_client.conf

* 在web包的resource创建一个conf文件夹用于放置配置文件
* 将FastDFS-Java-Client项目中fds_client.conf复制到conf文件夹

```conf
connect_timeout = 2
network_timeout = 30
charset = UTF-8
http.tracker_http_port = 8080
http.anti_steal_token = no
http.secret_key = FastDFS1234567890

tracker_server = 192.168.46.128:22122 //这里的ip换成fastDFS服务器ip
```

### 添加通用依赖

在parent模块的pom.xml和web的pom.xml导入

```xml
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.3.1</version>
</dependency>

<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.2</version>
</dependency>

<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.1</version>
</dependency>
```
### 创建fsatDFS客户端

* 在web包java文件夹中创建一个fastDFS文件夹并创建fastDFSClient.java

```java
private static StorageClient1 storageClient1 = null;

    static {
        try {
            // 获取配置文件
            String classPath = new File(fastDFSClient.class.getResource("/").getFile()).getCanonicalPath();
            String CONF_FILENAME = classPath + File.separator + "conf" + File.separator + "fdfs_client.conf";
            ClientGlobal.init(CONF_FILENAME);
            // 获取触发器
            TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);
            TrackerServer trackerServer = trackerClient.getConnection();
            // 获取存储服务器
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            storageClient1 = new StorageClient1(trackerServer, storageServer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @param fis      文件输入流
     * @param fileName 文件名称
     * @return
     */
    public static String uploadFile(InputStream fis, String fileName) {
        try {
            NameValuePair[] meta_list = null;

            //将输入流写入file_buff数组
            byte[] file_buff = null;
            if (fis != null) {
                int len = fis.available();
                file_buff = new byte[len];
                fis.read(file_buff);
            }

            String fileid = storageClient1.upload_file1(file_buff, getFileExt(fileName), meta_list);
            return fileid;
        } catch (Exception ex) {
            return null;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }


    private static String getFileExt(String fileName) {
        if (StringUtils.isBlank(fileName) || !fileName.contains(".")) {
            return "";
        } else {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
    }
```
* 在springmvc.xml中添加：

```xml
<!-- 文件上传 -->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver" p:defaultEncoding="UTF-8" >
    </bean>
```

* 在Controller文件夹创建FileController.java

```java
@RequestMapping(value = "uploadfile",method  = RequestMethod.POST)
    @ResponseBody
    public String fileupload(@RequestParam MultipartFile uploadfile) throws IOException {

        String fileId =  fastDFSClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
        if (fileId != null)
        System.out.println("上传成功");

       return fileId + " +++ " +uploadfile.getOriginalFilename();
    }
```

### Postman

>Postman是chrome的一款插件,用于做接口请求测试,无论是前端,后台还是测试人员,都可以用postman来测试接口,用起来非常方便

用Postman上传一张照片测试fastDFS是否配置成功

[![postman测试.png](https://i.loli.net/2019/07/04/5d1d93d19100463912.png)](https://i.loli.net/2019/07/04/5d1d93d19100463912.png)

### 测试结果

成功返回fileId和路径

[![postman测试2.png](https://i.loli.net/2019/07/04/5d1d93d1ee94434227.png)](https://i.loli.net/2019/07/04/5d1d93d1ee94434227.png)

并在外部浏览器成功浏览

[![postman测试3.png](https://i.loli.net/2019/07/04/5d1d93d247baf17436.png)](https://i.loli.net/2019/07/04/5d1d93d247baf17436.png)

### 过程中问题

要记得把fastDFS服务器的服务开启

### 190704完成SpringMVC对fastDFS的整合

---

## 在SpringMVC中整合FreeMarker 

### 什么是FreeMarker

通过阅读FreeMarker的官方手册，可以得知:
1. FreeMarker是一款模版引擎
2. 它可以基于模版和可变数据来生成输出文本
3. 输出的文本可以是HTML、电子邮件、配置文件、源代码等
4. 它是一个Java类库

基本原理如图所示：

[![freemarker.png](https://i.loli.net/2019/07/10/5d25c0b66bc3631831.png)](https://i.loli.net/2019/07/10/5d25c0b66bc3631831.png)

### 引入FreeMarker

#### 在parent模块的pom.xml中导入依赖

```xml
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.28</version>
</dependency>

<dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-context-support</artifactId>
     <version>${spring.version}</version>
</dependency>
```
* 在web包的pom中也导入上述依赖

### 配置springmvc.xml

```xml
<!--freemarker的配置在前，当当请求发现/WEB-INF/ftl/没有的时候，就会去/WEB-INF/jsp/查找-->
   <bean id="freemarkerConfig" class="org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer">
       <property name="templateLoaderPath" value="/WEB-INF/ftl/"/>
   </bean>
   <bean id="viewResolver" class="org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver">
       <property name="prefix" value=""/>
       <property name="suffix" value=".ftl"/>
       <property name="contentType" value="text/html; charset=UTF-8"/>
   </bean>
 ```
 ### 测试整合
 
 #### 编写一个Controller
 
 * 位于web包的controller文件夹创建一个FreeMarkerTest
 
 ```java
 @Controller
 public class FreemarkerTest {
 
     @RequestMapping("/hello")
     public String sayHello(Model model){
         model.addAttribute("name","pong");
         return "hello";
     }
 
     @RequestMapping("/hi")
     public String sayHi(Model model){
         model.addAttribute("name","pong");
         return "hi";
     }
```
#### 创建hello.ftl 和 hi.jsp 文件用于测试


* 在web包webapp文件夹创建一个ftl子文件夹，并创建hello.ftl文件
```ftl
<h1>Hello ${name}</h1>
```
* 在web包的jsp文件夹创建hi.jsp文件
```jsp
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hi ${name}</h1>
</body>
</html>
```
#### 测试结果

[![freemarker1.png](https://i.loli.net/2019/07/10/5d25c0b65d00512916.png)](https://i.loli.net/2019/07/10/5d25c0b65d00512916.png)

[![freemarker2.png](https://i.loli.net/2019/07/10/5d25c0b65d29236496.png)](https://i.loli.net/2019/07/10/5d25c0b65d29236496.png)

#### 190710完成了SpringMVC对FreeMarker的整合

---

## 商品添加界面搭建

### 前端实现

#### 使用到的easyUI主要组件：
* Form 表单
* Textbox 文本框
* Combobox 组合框
* Numberbox 数字框
* Linkbotton 链接按钮

#### 使用Ueditor富文本编辑器

#### 基本布局

[![商品添加页面.png](https://i.loli.net/2019/07/25/5d395ce0d9cac13110.png)](https://i.loli.net/2019/07/25/5d395ce0d9cac13110.png)

### 商品分类数据交互

实现前端商品分类选择组合后端数据实现

#### 在PageController中添加方法

```java
public String requestProductAdd(HttpServletRequest request){
        List<EasyUITree> categories = productCategoryService.findProductCategoryListByParentId((short) 0);
        request.getSession().setAttribute("categories",categories);
        return "product_add";
    }
```

#### 在parent的pom依赖新的jar包

```xml
 <dependency>
     <groupId>javax.servlet</groupId>
     <artifactId>servlet-api</artifactId>
     <version>${servlet-api}</version>
     <scope>provided</scope>
 </dependency>
```
在web的pom也引入上述依赖

### 在商品添加页面获取分类信息

```java
<%
   List<EasyUITree> list = (List<EasyUITree>) session.getAttribute("categories");
%>

   <tr>
       <td>商品分类</td>
       <td>
           <select id="cc" class="easyui-combobox" name="dept" style="width:200px;">
           <option value="0">请选择</option>
           <%
              for (int i=0;i<list.size();i++){
              EasyUITree item = list.get(i);
           %>
              <option value="<%=item.getId()%>"><%=item.getText()%></option>
           <%
              }
           %>
           </select>

           <p id="cbox" style="display: none"></p> //用于显示子分类
       </td>
   </tr>
```

### 让商品分类动态显示子分类

#### 创建product_add,js 整合js方法

```javascript
initProductCategories:function(){
        function loadSubCategory(value){
            var $sonBox = $("#productAddForm").find('#sonBox');

            if (value == 0){
                return;
            }else {
                $.getJSON('product_category/list',{id:value},function (data) {
                    var Str =  '';
                    Str = '<select id="productCateSelectId2" class="easyui-combobox" name="productCatSelect2" style="width:200px;">';
                    Str += '<option value="0">请选择</option>';

                    $.each(data,function (idx,item) {
                        Str += '<option value="'+item.id+'">'+item.text+'</option>';
                    })

                    Str += '</select>';
                    $sonBox.html(Str).show()
                })
            }
        }

        // 监听onChange
        $("#productAddForm").find("select[name='productCatSelect']").combobox({
          onChange:function () {
              var value = $("#productCateSelectId").val();
              loadSubCategory(value);
          }
        });
    },
```
### 商品图片上传
* fastDFS
* filebox
* ajaxFileUpload

#### fastDFS服务器在之前已搭建整合好

#### 关键！ajaxFileUpload.js 文件
```javascript

// ajaxFileUpload 原码
jQuery.extend({

    createUploadIframe: function(id, uri)
    {
        //create frame
        var frameId = 'jUploadFrame' + id;

        if(window.ActiveXObject) {
            var io = document.createElement('<iframe id="' + frameId + '" name="' + frameId + '" />');
            if(typeof uri== 'boolean'){
                io.src = 'javascript:false';
            }
            else if(typeof uri== 'string'){
                io.src = uri;
            }
        }
        else {
            var io = document.createElement('iframe');
            io.id = frameId;
            io.name = frameId;
        }
        io.style.position = 'absolute';
        io.style.top = '-1000px';
        io.style.left = '-1000px';

        document.body.appendChild(io);

        return io;
    },
    createUploadForm: function(id, fileElementId)
    {
        //create form
        var formId = 'jUploadForm' + id;
        var fileId = 'jUploadFile' + id;
        var form = jQuery('<form  action="" method="POST" name="' + formId + '" id="' + formId + '" enctype="multipart/form-data"></form>');
        var oldElement = jQuery('#' + fileElementId);
        var newElement = jQuery(oldElement).clone();
        jQuery(oldElement).attr('id', fileId);
        jQuery(oldElement).before(newElement);
        jQuery(oldElement).appendTo(form);
        //set attributes
        jQuery(form).css('position', 'absolute');
        jQuery(form).css('top', '-1200px');
        jQuery(form).css('left', '-1200px');
        jQuery(form).appendTo('body');
        return form;
    },

    ajaxFileUpload: function(s) {
        // TODO introduce global settings, allowing the client to modify them for all requests, not only timeout
        s = jQuery.extend({}, jQuery.ajaxSettings, s);
        var id = s.fileElementId;
        var form = jQuery.createUploadForm(id, s.fileElementId);
        var io = jQuery.createUploadIframe(id, s.secureuri);
        var frameId = 'jUploadFrame' + id;
        var formId = 'jUploadForm' + id;

        if( s.global && ! jQuery.active++ )
        {
            // Watch for a new set of requests
            jQuery.event.trigger( "ajaxStart" );
        }
        var requestDone = false;
        // Create the request object
        var xml = {};
        if( s.global )
        {
            jQuery.event.trigger("ajaxSend", [xml, s]);
        }

        var uploadCallback = function(isTimeout)
        {
            // Wait for a response to come back
            var io = document.getElementById(frameId);
            try
            {
                if(io.contentWindow)
                {
                    xml.responseText = io.contentWindow.document.body?io.contentWindow.document.body.innerHTML:null;
                    xml.responseXML = io.contentWindow.document.XMLDocument?io.contentWindow.document.XMLDocument:io.contentWindow.document;

                }else if(io.contentDocument)
                {
                    xml.responseText = io.contentDocument.document.body?io.contentDocument.document.body.innerHTML:null;
                    xml.responseXML = io.contentDocument.document.XMLDocument?io.contentDocument.document.XMLDocument:io.contentDocument.document;
                }
            }catch(e)
            {
                jQuery.handleError(s, xml, null, e);
            }
            if( xml || isTimeout == "timeout")
            {
                requestDone = true;
                var status;
                try {
                    status = isTimeout != "timeout" ? "success" : "error";
                    // Make sure that the request was successful or notmodified
                    if( status != "error" )
                    {
                        // process the data (runs the xml through httpData regardless of callback)
                        var data = jQuery.uploadHttpData( xml, s.dataType );
                        if( s.success )
                        {
                            // ifa local callback was specified, fire it and pass it the data
                            s.success( data, status );
                        };
                        if( s.global )
                        {
                            // Fire the global callback
                            jQuery.event.trigger( "ajaxSuccess", [xml, s] );
                        };
                    } else
                    {
                        jQuery.handleError(s, xml, status);
                    }

                } catch(e)
                {
                    status = "error";
                    jQuery.handleError(s, xml, status, e);
                };
                if( s.global )
                {
                    // The request was completed
                    jQuery.event.trigger( "ajaxComplete", [xml, s] );
                };


                // Handle the global AJAX counter
                if(s.global && ! --jQuery.active)
                {
                    jQuery.event.trigger("ajaxStop");
                };
                if(s.complete)
                {
                    s.complete(xml, status);
                } ;

                jQuery(io).unbind();

                setTimeout(function()
                { try
                {
                    jQuery(io).remove();
                    jQuery(form).remove();

                } catch(e)
                {
                    jQuery.handleError(s, xml, null, e);
                }

                }, 100);

                xml = null;

            };
        }
        // Timeout checker
        if( s.timeout > 0 )
        {
            setTimeout(function(){

                if( !requestDone )
                {
                    // Check to see ifthe request is still happening
                    uploadCallback( "timeout" );
                }

            }, s.timeout);
        }
        try
        {
            var form = jQuery('#' + formId);
            jQuery(form).attr('action', s.url);
            jQuery(form).attr('method', 'POST');
            jQuery(form).attr('target', frameId);
            if(form.encoding)
            {
                form.encoding = 'multipart/form-data';
            }
            else
            {
                form.enctype = 'multipart/form-data';
            }
            jQuery(form).submit();

        } catch(e)
        {
            jQuery.handleError(s, xml, null, e);
        }
        if(window.attachEvent){
            document.getElementById(frameId).attachEvent('onload', uploadCallback);
        }
        else{
            document.getElementById(frameId).addEventListener('load', uploadCallback, false);
        }
        return {abort: function () {}};

    },

    uploadHttpData: function( r, type ) {
        var data = !type;
        data = type == "xml" || data ? r.responseXML : r.responseText;
        // ifthe type is "script", eval it in global context
        if( type == "script" )
        {
            jQuery.globalEval( data );
        }

        // Get the JavaScript object, ifJSON is used.
        if( type == "json" )
        {
            eval( "data = " + data );
        }

        // evaluate scripts within html
        if( type == "html" )
        {
            jQuery("<div>").html(data).evalScripts();
        }

        return data;
    },
    handleError: function( s, xhr, status, e )      {
        // If a local callback was specified, fire it
        if ( s.error ) {
            s.error.call( s.context || s, xhr, status, e );
        }

        // Fire the global callback
        if ( s.global ) {
            (s.context ? jQuery(s.context) : jQuery.event).trigger( "ajaxError", [xhr, s, e] );
        }
    }
});
```

#### product_add.js 整合上传图片方法
```javascript
initPictureUpload:function(){
        $('#fileName').filebox({
           prompt:"选择图片",
           width:"300",
           buttonText:"请选择"
        });

        $('.uploadPIC').click(function () {
            $.ajaxFileUpload({
                url:'/uploadfile',
                fileElementId:'filebox_file_id_1',
                type:'post',
                
                success:function (data) {
                    console.log($(data).find("body").text());
                    $('#productIMG').attr("src","http://192.168.46.128:8888/"+$(data).find("body").text());
                    // 返回图片到前端预览
                }
            
            })
        });
    },
```

#### 测试结果

* 动态显示商品分类

[![商品分类测试结果.png](https://i.loli.net/2019/07/25/5d395ce0bc8ea25472.png)](https://i.loli.net/2019/07/25/5d395ce0bc8ea25472.png)

* 图片上传功能

[![图片上传测试结果.png](https://i.loli.net/2019/07/25/5d395ce14ac1684813.png)](https://i.loli.net/2019/07/25/5d395ce14ac1684813.png)


#### 过程中问题
* 注意命名规则
* 注意Jquery语法规范

#### 190725 实现动态显示分类和图片上传

---

### 实现商品数据提交到数据库

#### 前端准备

利用From表单提交商品信息，需要对一个商品列表的的每一项录入内容进行赋值，这里使用‘input’标签来赋值。

其中对商品分类、商品主图、商品描述这三个没有‘input’标签的内容额外创立‘input’标签赋值

```jsp
   <input type="hidden" name="categoryId" />
   <input type="hidden" name="image" />
   <input type="hidden" name="description" />
```

赋值手段是使用Jquery函数


```js
 // 对商品分类赋值
 
 // 如若有二级分类
  $("#productAddForm").find("select[name='productCatSelect2']").combobox({
       onChange:function () {
           var value = $("#productCateSelectId2").val();
           if (value == 0 ) {
               $("#productAddForm").find("input[name='categoryId']").val($('#productAddForm').find("input[name='productCateSelectId']").val());
           }else {
               $("#productAddForm").find("input[name='categoryId']").val(value)
           }
       }
  });

            
  // 只有一级分类
  $("#productAddForm").find("select[name='productCatSelect']").combobox({
        onChange:function () {
               var value = $("#productCateSelectId").val();
               $("#productAddForm").find("input[name='categoryId']").val(value);
               loadSubCategory(value);
        }
   });
  
```

```js
  // 对商品主图进行赋值
   $("#productAddForm").find("input[name='image']").val($(data).find("body").text());

```

```js
  // 对商品描述进行赋值
  $("#productAddForm").find("input[name='description']").val(UE.getEditor('editor').getContent())
  
```

其余细节不赘述...... 前端准备完毕

```js
  // 表单提交
  $.post("/product_save",$('#productAddForm').serialize(),function(data){
      if (data.status == 200){
          $.messager.alert("提示","提交成功！");
      }
  })
```

#### 后端代码实现

    因为已经通过逆向工程实现对Product实体类和增删改查工作的方法创建
    
    所以只要实现控制层和业务层核心函数就行了

#### Controller

```java
@RequestMapping("/product_save")
    @ResponseBody
    public ResponseJsonResult saveProduct(Product product){
        ResponseJsonResult responseJsonResult = productService.saveProduct(product);
        return  responseJsonResult;
    }
```

#### ProductService

```java
 public ResponseJsonResult saveProduct(Product product) {

        product.setStatus(1);
        productMapper.insert(product);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setStatus(200);


        return responseJsonResult;
    }
```

#### 测试结果


![商品列表存入数据库测试.png](https://i.loli.net/2019/08/04/KxnzXI6o5cPwJtq.png)

![商品列表存入数据库测试2.png](https://i.loli.net/2019/08/04/fPyLqF1SOgsmE9N.png)

![商品列表存入数据库测试3.png](https://i.loli.net/2019/08/04/3BOvng2Zb456z7e.png)

![商品列表存入数据库测试4.png](https://i.loli.net/2019/08/04/xAMi82LWIEljRFt.png)

#### 190804 实现商品列表存入数据库操作




