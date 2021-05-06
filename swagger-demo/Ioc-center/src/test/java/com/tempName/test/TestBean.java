package com.tempName.test;

import com.tempName.ioc.entity.Person;
import com.tempName.ioc.entity.Student;
import com.tempName.ioc.service.BeanFactory;
import com.tempName.ioc.service.impl.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @description:
 * @author: jwen
 * @date: 2021/4/27
 */

public class TestBean {

    /**
     * 这个IoC实现有点问题，目前来说跑不通，估计是 xml 文件的路径读取或 ConfigManager 类存在问题
     */
    @Test
    public void testForIOC() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("Application.xml");
        Person person = (Person) beanFactory.getBean("person");
        Person person1 = (Person) beanFactory.getBean("person");
        System.out.println(person == person1);
        System.out.println(person);
        Student student = (Student) beanFactory.getBean("student");
        Student student1 = (Student) beanFactory.getBean("student");
        String name = student.getName();
        System.out.println(name);
        System.out.println(student == student1);
    }
}
