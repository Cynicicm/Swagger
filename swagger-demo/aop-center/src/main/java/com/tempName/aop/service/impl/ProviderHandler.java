package com.tempName.aop.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: jwen
 * @date: 2021/4/29
 */

public class
ProviderHandler implements InvocationHandler {
    Object target;

    public Object bind(Object target){
        this.target = target;
        //这里生成了代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("ProviderHandler Method : Before");
        Object obj = method.invoke(target, args);
        System.out.println("ProviderHandler Method : After");
        return obj;
    }
}
