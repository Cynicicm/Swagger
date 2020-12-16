package com.tempName;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ProductCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCenterApplication.class, args);
    }

}

