# spring-demo
my spring demo

## 1. spring 体系结构

![spring 体系结构](spring.png)



## 2. spring 配置文件

### 2.1 基本配置

用于配置对象交由spring配置

默认情况下调用的是类中的无参构造函数，没有无参构造函数则不能创建成功

- 基本配置文件

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation=
                   "http://www.springframework.org/schema/beans 
                   http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    </beans>
    ```

    

基本属性：

- id：bean实例在spring容器中的唯一标识

- class：Bean 的全限定名称

    ```xml
     <bean id="userDao" class="dao.impl.UserDaoImpl" />
    ```



### 2.2 范围配置

配置bean时可以指定对象的作用范围（scope），取值如下

| 取值范围       | 说明                                                         |
| -------------- | ------------------------------------------------------------ |
| singleton      | 默认的，单例的                                               |
| prototype      | 多例的                                                       |
| request        | web项目中，Spring创建一个Bean对象，将对象存入request域中     |
| session        | web项目中，Spring创建一个Bean对象，将对象存入session域中     |
| global session | web项目中，应用在Portlet环境，如果没有Portlet环境那么global session相当于session |

### 2.3 生命周期方法

init-method：指定类中的初始化方法名称

destroy-method：指定类中的销毁方法名称

### 2.4 实例化方式

- 无参构造方法实例化

    它会根据默认无参构造方法创建对象，如果bean中没有默认无参构造方法，将会创建失败

    ```xml
     <bean id="userDao" class="dao.impl.UserDaoImpl" />
    ```

    

- 工厂静态方法实例化

    UserDaoStaticFactory.java

    ```java
    package dao.factory;
    
    import dao.UserDao;
    import dao.impl.UserDaoImpl;
    
    public class UserDaoStaticFactory {
        public static UserDao createUserDao() {
            return new UserDaoImpl();
        }
    }
    
    ```

    配置文件

    ```xml
    <bean id="userDao4Factory" class="dao.factory.UserDaoStaticFactory" factory-method="createUserDao" />
    ```

- 工厂实例方法实例化

    UserDaoDynamicFactory.java

    ```java
    package dao.factory;
    
    import dao.UserDao;
    import dao.impl.UserDaoImpl;
    
    public class UserDaoDynamicFactory {
        public UserDao createUserDao() {
            return new UserDaoImpl();
        }
    }
    
    ```

    

    配置文件

    ```xml
    <bean id="UserDaoDynamicFactory" class="dao.factory.UserDaoDynamicFactory"/>
    <bean id="userDao4DynamicFactory" factory-bean="UserDaoDynamicFactory" factory-method="createUserDao" />
    ```

### 2.5 依赖注入（Dependency injection）

依赖注入时spring框架核心IOC的具体实现。在编写程序时，通过控制反转，把对象的创建交给了spring，但是代码中不可能出翔没有依赖的情况。IOC解耦只能降低依赖关系，但不会消融，业务层仍然会调用持久层的方法，业务层与持久层的依赖关系交由spring维护。

- 方式

    - 构造方法

        UserServiceImpl.java

        ```java
        package service.impl;
        
        import dao.UserDao;
        import service.UserService;
        
        public class UserServiceImpl implements UserService {
        
            private UserDao userDao;
        
            public UserServiceImpl(UserDao userDao) {
                this.userDao = userDao;
            }
        
        }
        
        
        ```

        配置文件

        ```xml
        <bean id="userService" class="service.impl.UserServiceImpl">
            <constructor-arg name="userDao" ref="userDao" />
        </bean>
        ```

    - set方法

        UserServiceImpl2.java

        ```java
        package service.impl;
        
        import dao.UserDao;
        import service.UserService;
        
        public class UserServiceImpl2 implements UserService {
            private UserDao userDao;
        
            public void setUserDao(UserDao userDao) {
                this.userDao = userDao;
            }
        
        }
        
        ```

        配置文件

        ```xml
        <bean id="userService2" class="service.impl.UserServiceImpl2">
            <property name="userDao" ref="userDao"/>
        </bean>
        ```

        p 命名空间注入

        p命名空间注入本质也是set方法注入，但比较上述的set方法注入更加方便。

        引入命名空间

        ```xml
        <bean id="userService" class="service.impl.UserServiceImpl2" p:userDao-ref="userDao"/>
        ```

- 不同数据类型的注入

    在 Spring 中还可以对基本数据类型、集合等都可以在容器中进行注入

    - 基础数据类型注入

        BasicDI.java

        ```java
        package dao.impl;
        
        
        public class BasicDI {
            private String username;
            private Integer age;
        
            public void setUsername(String username) {
                this.username = username;
            }
        
            public void setAge(Integer age) {
                this.age = age;
            }
        }
        
        ```

        

        配置文件

        ```xml
        <bean id="userDao2" class="dao.impl.BasicDI">
            <property name="username" value="zhangsan"/>
            <property name="age" value="12"/>
        </bean>
        ```

    - 集合数据类型(List)注入

        ListDI.java

        ```java
        package dao.impl;
        
        import java.util.List;
        
        public class ListDI {
            private List<String> strList;
        
            public void setStrList(List<String> strList) {
                this.strList = strList;
            }
        }
        
        ```

        配置文件

        ```xml
        <bean id="listDI" class="dao.impl.ListDI">
            <property name="strList">
                <list>
                    <value>abc</value>
                    <value>def</value>
                    <value>ghi</value>
                </list>
            </property>
        </bean>
        ```

    - 集合数据类型 （Map<String, User>）注入

        MapDI.java

        ```java
        package dao.impl;
        
        import pojo.User;
        
        import java.util.Map;
        
        public class MapDI {
            private Map<String, User> userMap;
        
            public void setUserMap(Map<String, User> userMap) {
                this.userMap = userMap;
            }
        }
        
        ```

        配置文件

        ```xml
        <bean id="u1" class="pojo.User"/>
        <bean id="u2" class="pojo.User"/>
        <bean id="mapDI" class="dao.impl.MapDI">
            <property name="userMap">
                <map>
                    <entry key="user1" value-ref="u1"/>
                    <entry key="user2" value-ref="u2"/>
        
                </map>
            </property>
        </bean>
        ```

    - 集合数据类型 （Properties）的注入

        PropertiesDI.java

        ```java
        package dao.impl;
        
        import java.util.Properties;
        
        public class PropertiesDI {
            private Properties properties;
        
            public void setProperties(Properties properties) {
                this.properties = properties;
            }
        }
        
        ```

        

        配置文件

        ```xml
        <bean id="propertiesDI" class="dao.impl.PropertiesDI">
            <property name="properties">
                <props>
                    <prop key="p1">value1</prop>
                    <prop key="p2">value2</prop>
                    <prop key="p3">value3</prop>
                </props>
            </property>
        </bean>
        ```

### 2.6 引入其他配置文件

```xml
<import resource="applicationContext-xxx.xml"/>
```



### 2.7 配置数据源

- 导入依赖

    - c3p0和druid坐标

        ```xml
        <!--    c3p0 坐标    -->
        <dependency>
            <groupId>c3p0</groupId>
            <artifactId>c3p0</artifactId>
            <version>0.9.1.2</version>
        </dependency>
        <!--    druid 坐标    -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.10</version>
        </dependency>
        ```

        

    - mysql数据库驱动坐标

        ```xml
        
        <!--  mysql 驱动  -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.39</version>
        </dependency>
        ```

        

- 创建`jdbc.properties`文件

    ```properties
    jdbc.driver=com.mysql.jdbc.Driver
    jdbc.url=jdbc:mysql://localhost:3306/test
    jdbc.username=root
    jdbc.password=root
    ```

- `Spring`配置文件引入`jdbc.properties`

    - 引入context命名空间

        xmlns:context = "http://www.springframework.org/schema/context"

    - 引入约束路径

        http://www.springframework.org/schema/schema

        http://www.springframework.org/schema/context/spring-context.xsd

    - 引入配置文件

        ```xml
        <context:property-placeholer location="classpath:jdbc.peoprerties"/>
        <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        	<property name="driverClass" value="${jdbc.driver}"/>
            <property name="jdbcUrl" value="${jdbc.url}"/>
            <property name="user" value="${jdbc.username}"/>
            <property name="password" value="${jdbc.password}"/>
        </bean>
        ```

        