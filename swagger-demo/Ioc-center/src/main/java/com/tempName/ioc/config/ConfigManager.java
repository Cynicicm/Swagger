package com.tempName.ioc.config;

import com.tempName.ioc.entity.Bean;
import com.tempName.ioc.entity.Property;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/4/27
 */

public class ConfigManager {
    private static Map<String, Bean> map = new HashMap<String, Bean>();

    /**
     * 读取配置文件并返回结果
     * 返回 Map 集合便于注入， key 是每个 Bean 的 name 属性， value 是对应的那个 Bean 对象
     *
     * @param path
     * @return
     */
    public static Map<String, Bean> getConfig(String path) {
        /**
         * dem4j 实现
         *  1.创建解析器
         *  2.加载配置文件，得到 document 对象
         *  3.定义 xpath 表达式，取出所有 Bean 元素
         *  4.对 Bean 元素继续遍历
         *      4.1.将 Bean 元素的 name/class 属性封装到 bean 类属性中
         *      4.2.获得 bean 下的所有 property 子元素
         *      4.3.将属性 name/value/ref 封装到 Property 类中
         *       *  5.将 property 对象封装到 bean 对象中
         *  6.将 bean 对象封装到 Map 集合中，返回 map
         */

        // 1.创建解析器
        SAXReader reader = new SAXReader();

        // 2.加载配置文件，得到 document 对象
        final InputStream is = ConfigManager.class.getResourceAsStream(path);
        Document doc = null;

        // 3.定义 xpath 表达式，取出所有 Bean 元素
        String xpath = "//bean";

        // 4.对 Bean 元素进行遍历
        List<Element> list = doc.selectNodes(xpath);
        if (list != null) {
            // 4.1.将 Bean 元素的 name/class 属性封装到 bean 类属性中
            for (Element bean : list) {
                Bean b = new Bean();
                String name = bean.attributeValue("name");
                String clazz = bean.attributeValue("class");
                String scope = bean.attributeValue("scope");
                b.setName(name);
                b.setClassName(clazz);
                if (scope != null) {
                    b.setScope(scope);
                }

                // 4.2.获得 bean 下所有 property 子元素
                List<Element> children = bean.elements("property");

                // 4.3将属性 name/value/ref 封装到类 Property 类中
                if (children != null) {
                    for (Element child : children) {
                        Property prop = new Property();
                        String pName = child.attributeValue("name");
                        String pValue = child.attributeValue("value");
                        String pRef = child.attributeValue("ref");
                        prop.setName(pName);
                        prop.setRef(pRef);
                        prop.setValue(pValue);
                        // 5.将 property 对象封装到 bean 对象中
                        b.getProperties().add(prop);
                    }
                }

                // 6.将 bean 对象封装到 Map 集合中，返回 map
                map.put(name, b);
            }
        }
        return map;
    }
}