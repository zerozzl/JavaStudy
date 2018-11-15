package com.zerozzl.study.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.zerozzl.study.model.User;

public class BeanFactoryTest {

	private static void xmlBeanFactoryTest() {
		Resource resource = new ClassPathResource("application-context.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		User user = factory.getBean("userBean", User.class);
		System.out.println(user);
	}

	private static void applicationContextTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "application-context.xml" });

		User user = context.getBean("userBean", User.class);
		System.out.println(user);
	}

	public static void main(String[] args) {
		System.out.println("run xmlBeanFactoryTest...");
		xmlBeanFactoryTest();
		System.out.println("run applicationContextTest...");
		applicationContextTest();
	}

}
