package com.zerozzl.study.spring.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.zerozzl.study.common.model.Teacher;
import com.zerozzl.study.common.model.User;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {

	private static void xmlBeanFactoryTest() {
		Resource resource = new ClassPathResource("BeanFactoryTest.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		
		Teacher teacher = factory.getBean("teacherBean", Teacher.class);
		User user1= factory.getBean("userBean1", User.class);
		User user2 = factory.getBean("userBean2", User.class);
		System.out.println(teacher);
		System.out.println(user1);
		System.out.println(user2);
	}

	private static void applicationContextTest() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "BeanFactoryTest.xml" });
		User user = context.getBean("userBean1", User.class);
		System.out.println(user);
	}

	public static void main(String[] args) {
		System.out.println("run xmlBeanFactoryTest...");
		xmlBeanFactoryTest();
		System.out.println("run applicationContextTest...");
		applicationContextTest();
	}

}
