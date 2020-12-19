package com.tempName.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wenjie
 * @date Create on 2020/12/14
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.tempName.user.controller"))
                .paths(PathSelectors.any())
                .build()
                // 添加登录认证
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI测试")
                .description("TempName团队")
                .version("1.0")
                .build();
    }

    public List<ApiKey> securitySchemes() {
        // 设置请求头信息
        List<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("Authorization","Authorization","header"));
        return apiKeys;
    }

    public List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();

        securityContexts.add(SecurityContext.builder()
            .securityReferences(securityReferences())
            .forPaths(PathSelectors.any())
            .build());

        return securityContexts;
    }

    public List<SecurityReference> securityReferences() {
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = new AuthorizationScope("global","accessEverything");

        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization",authorizationScopes));

        return  securityReferences;
    }

}
