package com.zerozzl.study.spring.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.zerozzl.study.common.model.TeacherDO;
import com.zerozzl.study.common.model.UserDO;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {

	private static void xmlBeanFactoryTest() {
		Resource resource = new ClassPathResource("BeanFactoryTest.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		TeacherDO teacher = factory.getBean("teacherBean", TeacherDO.class);
		UserDO user1= factory.getBean("userBean1", UserDO.class);
		UserDO user2 = factory.getBean("userBean2", UserDO.class);
		System.out.println(teacher);
		System.out.println(user1);
		System.out.println(user2);
	}

	private static void applicationContextTest() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "BeanFactoryTest.xml" });
		UserDO user = context.getBean("userBean1", UserDO.class);
		System.out.println(user);
	}

	public static void main(String[] args) {
		System.out.println("run xmlBeanFactoryTest...");
		xmlBeanFactoryTest();
		System.out.println("run applicationContextTest...");
		applicationContextTest();
	}

}
