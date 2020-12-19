package com.tempName.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"com.tempName.product","com.tempName.user","com.tempName.commons"})
public class ProductCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCenterApplication.class, args);
    }

}

