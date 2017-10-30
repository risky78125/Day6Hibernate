# Hibernate

## 一. maven创建工程

1. 点击新建项目

2. 选择maven-xxx-webapp

3. 输入GroupId和ArtifactId

4. 输入工程名

5. finish

## 二. 配置pom.xml文件

1. 加入struts2的依赖, 如下:

    ```
        <!-- https://mvnrepository.com/artifact/org.apache.struts/struts2-core -->
        <dependency>
            <groupId>org.apache.struts</groupId>
            <artifactId>struts2-core</artifactId>
            <version>2.5.13</version>
        </dependency>

    ```