# Hibernate

## 一. maven创建工程

1. 点击新建项目

2. 选择maven-xxx-webapp

3. 输入GroupId和ArtifactId

4. 输入工程名

5. finish

## 二. 配置pom.xml文件

1. 加入struts2的依赖, 如下:

    ```xml
        <!--为了测试的, 学习hibernate可以不加-->
        <!-- https://mvnrepository.com/artifact/org.apache.struts/struts2-core -->
        <dependency>
            <groupId>org.apache.struts</groupId>
            <artifactId>struts2-core</artifactId>
            <version>2.5.13</version>
        </dependency>

    ```
    
2. 加入Hibernate依赖

    ```xml
       <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>5.2.10.Final</version>
        </dependency>
    ```
    
3. 加入jdbc
    ```xml
           <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
           <dependency>
               <groupId>mysql</groupId>
               <artifactId>mysql-connector-java</artifactId>
               <version>6.0.6</version>
           </dependency>
    ```
    
4. 修改junit版本为4.12

    ```xml
           <dependency>
               <groupId>junit</groupId>
               <artifactId>junit</artifactId>
               <version>4.12</version>
               <scope>test</scope>
           </dependency>
    ```
    
## 三. 配置hibernate

1. 打开`Project Structure`, 快捷键`command + ;`

2. 选择左边的`Modules`, 选中工程名并点击`+`

3. 找到`Hibernate`选项, 点击

4. 点击下面的`+`, 添加配置文件, 目录/文件名/版本保持默认即可

5. 在`resources`文件夹下找到该配置文件, 对其进行如下一一配置.

    ```xml
       <hibernate-configuration>
           <session-factory>
               <property name="connection.url">jdbc:mysql://localhost:3306/day6hibernate</property>
               <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
               <property name="connection.username">root</property>
               <property name="connection.password">root</property>
       
               <!--配置方言, Hibernate会根据方言的不同生成不同的SQL语句-->
               <!--如果jdbc的版本在5.x以上, 使用MySQL5Dialect-->
               <!--否则使用MySQLDialect-->
               <property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
               <!--设置为true, 那么在项目运行时会打印出sql语句-->
               <property name="show_sql">true</property>
               <!--对打印的sql语句进行格式化-->
               <property name="format_sql">true</property>
               <!-- DB schema will be updated if needed -->
               <!--看文档-->
                <property name="hibernate.hbm2ddl.auto">update</property>
       
               <!--加载映射文件-->
               <mapping resource="Student.hbm.xml"/>
           </session-factory>
       </hibernate-configuration>
    ```
    
6. 创建映射文件

    1. 在`resources`文件夹下创建映射文件
    
    2. 文件名为`JavaBean.hbm.xml`, 其中`JavaBean`为实体类的名字
    
    3. 添加文件头, 到`hibernate-core-5.2.10.Final.jar!/org/hibernate/hibernate-mapping-3.0.dtd`文件中查看具体文件头
    
    3. 具体内容如下:
    
        ```xml
           <!DOCTYPE hibernate-mapping PUBLIC
                   "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
                   "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
           <hibernate-mapping>
               <class name="com.lanou3g.domain.Student">
                   <id name="id" >
                       <generator class="native"/>
                   </id>
           
                   <property name="name"/>
                   <property name="gender"/>
                   <property name="age"/>
           
               </class>
           </hibernate-mapping>
        ```
        
## 四. Hibernate基本操作

1. 加载配置

```java
    Configuration cfg = new Configuration();
    cfg.configure("hibernate.cfg.xml");
```
   
2. 获取`SessionFactory`对象

```java
    SessionFactory sf = cfg.buildSessionFactory();
```

3. 打开会话

```java
sess = sf.openSession();
```

4. 开启事务

```java
trans = sess.beginTransaction();
```

5. 执行操作

```text
吧啦吧啦吧啦
```

6. 提交事务

```java
trans.commit();
```

7. 关闭会话

```java
sess.close();
```