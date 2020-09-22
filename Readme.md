# Swagger

学习目标：

- 了解Swagger的作用和概念

- 了解前后端分离

- 在SpringBoot中集成Swagger

## Swagger简介

**前后端分离**

Vue + SpringBoot

后端时代：前端只用管理静态页面。    后端是主力。



前后端分离时代：

- 后端：控制层，服务层，数据访问层【后端团队】
- 前端：前端控制层，视图层【前端团队】
  - 伪造后端数据，json（mock）。已经不需要后端。

- 前后端如何交互？===> API
- 前后端相对独立，松耦合
- 前后端甚至可以部署在不同的服务器上



产生一个问题：

- 前后端集成联调，前端人员和后端人员无法做到，及时协商，尽早解决，最后导致问题集中爆发

解决方案：

- 首先指定schema，实时更新最新的API，降低集成风险
- 早些年：制定word文档
- 前后端分离：
  - 前端测试后端接口：postman
  - 后端提供接口，需要实时更新最新的消息及改动

**Swagger**

- 号称世界上最流行的API框架
- RestFul API文档在线自动生成工具 => API文档与API定义同步更新
- 直接运行，可以在线测试API接口
- 支持多种语言：Java、PHP ...

## 在项目中使用Swagger

需要springfox

- swagger2
- ui



## SpringBoot集成Swagger

1.新建SpringBoot项目

2.导入jar包

```xml
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>3.0.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>3.0.0</version>
</dependency>

```

3.建立Hello工程

4.配置Swagger ===> Config

```java
@Configuration
@EnableSwagger2   //开启Swagger2
public class SwaggerConfig {

}
```

5.[测试运行](http://localhost:8080/swagger-ui.html)

![image-20200922223923667](C:\Users\15867\AppData\Roaming\Typora\typora-user-images\image-20200922223923667.png)

## 配置Swagger

Swagger的bean实例Docket；

```java
public class SwaggerConfig {

    //配置Swagger的Docket的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }
    //配置Swagger信息=apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("文杰","","");
        return new ApiInfo("Swagger的API文档",
                "swagger学习",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
```

## 配置扫描接口及开关

Docket.select();