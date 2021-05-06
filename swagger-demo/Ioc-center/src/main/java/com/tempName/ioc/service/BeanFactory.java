package com.tempName.ioc.service;

/**
 * @description:
 * @author: jwen
 * @date: 2021/4/27
 */
public interface BeanFactory {
    // 核心方法 getBean
    Object getBean(String name);
}
