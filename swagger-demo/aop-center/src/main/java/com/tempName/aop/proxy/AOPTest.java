package com.tempName.aop.proxy;

import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import com.tempName.aop.proxy.imp.AOPMethod;
import com.tempName.aop.proxy.imp.AnimalInterface;

import java.lang.reflect.Method;
import java.util.Date;

@RunWith(BlockJUnit4ClassRunner.class)
public class AOPTest {

	public static void main(String[] args) {
		Class clazz = DogImp.class;
		AnimalInterface dog = AnimalFactory.getAnimal(clazz, new AOPMethod() {
			// 这里写方法执行前的AOP切入方法
			@Override
			public void before(Object proxy, Method method, Object[] args) {
//				if (method.getName().equals("getName")) {
					System.err.println(new Date() + " 成功拦截" + method.getName() + "方法,启动");
//				}
			}

			// 这里系方法执行后的AOP切入方法
			@Override
			public void after(Object proxy, Method method, Object[] args) {
//				if (method.getName().equals("setProperty")) {
					System.err.println(new Date() + " 成功拦截" + method.getName() + "方法,结束");
//				}

			}
		});
		System.out.println(clazz + " | " + dog);
		dog.say();
		String name1 = "我的名字是" + dog.getName();
		System.out.println(dog + " " + new Date() + " " + name1);
		dog.setName("二狗子");
		String name2 = "我的名字是" + dog.getName();
		System.out.println(dog + " " + new Date() + " " + name2);
		dog.getProperty();
	}
}
