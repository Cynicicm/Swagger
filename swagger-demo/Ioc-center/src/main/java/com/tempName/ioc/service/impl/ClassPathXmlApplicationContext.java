package com.tempName.ioc.service.impl;

import com.tempName.ioc.config.ConfigManager;
import com.tempName.ioc.entity.Bean;
import com.tempName.ioc.entity.Property;
import com.tempName.ioc.service.BeanFactory;
import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/4/27
 */

public class ClassPathXmlApplicationContext implements BeanFactory {

    /**
     * 获得读取的配置文件中的 Map 信息
     */
    private Map<String, Bean> map;
    private Map<String, Object> context = new HashMap<>();
    public ClassPathXmlApplicationContext(String path) {
        // 1.读取配置文件得到需要初始化的 Bean 信息
        Map<String, Bean> map = ConfigManager.getConfig(path);

        // 2.遍历配置，初始化 Bean
        for (Map.Entry<String, Bean> en : map.entrySet()) {
            String beanName = en.getKey();
            Bean bean = en.getValue();

            Object existBean = context.get(beanName);
            // 单例模式
            // 当容器中为空，并且 bean 的 scope 属性为 singleton 时
            if (existBean == null && "singleton".equals(bean.getScope())) {
                // 根据字符串创建 Bean 对象
                Object beanObj = createBean(bean);

                // 把创建好的 bean 对象放置到 map 中去
                context.put(beanName, beanObj);
            }
        }
    }

    private Object createBean(Bean bean) {
        // 创建该类对象
        Class clazz = null;
        try {
            clazz = Class.forName(bean.getClassName());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("没有找到类" + bean.getClassName());
        }

        Object beanObj = null;
        try {
            beanObj = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("没有提供无参构造器");
        }
        // 获得 bean 的属性，将其注入
        if (bean.getProperties() != null) {
            for (Property prop : bean.getProperties()) {
                // 注入分两种情况
                // 获得要注入的属性名称
                String name = prop.getName();
                String value = prop.getValue();
                String ref = prop.getRef();
                // 使用 BeanUtils 工具类完成属性注入，可以自动完成类型转换
                // 如果 value 不为 null，说明有
                if (value != null) {
                    Map<String, String[]> parmMap = new HashMap<>();
                    parmMap.put(name, new String[]{value});
                    try {
                        BeanUtils.populate(beanObj, parmMap);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException("请检查你的" + name + "属性");
                    }
                }

                if (ref != null) {
                    // 根据属性名获得一个注入属性的set方法
                    // Method setMethd = BeanUtil.getWriteMethod(beanObj, name);

                    // 看一看当前 IoC 容器中是否存在该 bean，有的话直接设置，没有的说使用递归，创建该 bean 对象
                    Object existBean = context.get(prop.getRef());
                    if (existBean == null) {
                        // 递归的创建一个 bean
                        existBean = createBean(map.get(prop.getRef()));
                        // 放置到 context 容器中
                        // 只有当 scope = "singleton" 时才往容器中放
                        if ("singleton"
                                .equals(map.get(prop.getRef()).getScope())) {
                            context.put(prop.getRef(), existBean);
                        }
                    }

                    try {
                        BeanUtils.setProperty(beanObj, name, existBean);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException("您的bean属性" + name
                                + "没有对应的set方法");
                    }
                }
            }
        }
        return beanObj;
    }

    @Override
    public Object getBean(String name) {
        return null;
    }
}
