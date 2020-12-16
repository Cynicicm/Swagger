package com.tempName.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *  使得MybatisPlus逻辑删除生效
 *
 * @author wenjie
 * @date Create on 2020/12/8
 */

@Configuration
public class MyBatisPlusConfig {
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

}
