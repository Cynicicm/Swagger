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
			// ����д����ִ��ǰ��AOP���뷽��
			@Override
			public void before(Object proxy, Method method, Object[] args) {
//				if (method.getName().equals("getName")) {
					System.err.println(new Date() + " �ɹ�����" + method.getName() + "����,����");
//				}
			}

			// ����ϵ����ִ�к��AOP���뷽��
			@Override
			public void after(Object proxy, Method method, Object[] args) {
//				if (method.getName().equals("setProperty")) {
					System.err.println(new Date() + " �ɹ�����" + method.getName() + "����,����");
//				}

			}
		});
		System.out.println(clazz + " | " + dog);
		dog.say();
		String name1 = "�ҵ�������" + dog.getName();
		System.out.println(dog + " " + new Date() + " " + name1);
		dog.setName("������");
		String name2 = "�ҵ�������" + dog.getName();
		System.out.println(dog + " " + new Date() + " " + name2);
		dog.getProperty();
	}
}
