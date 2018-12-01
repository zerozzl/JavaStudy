package com.zerozzl.study.spring.aop;

import java.util.List;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zerozzl.study.common.dao.UserDao;
import com.zerozzl.study.common.dao.impl.UserDaoImpl;
import com.zerozzl.study.common.model.UserDO;

public class AopSpringNativeTest {

	public static void imple1() {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new UserDaoImpl());
		proxyFactory.addAdvice(new SpringNativeAspect());
		UserDao proxy = (UserDao) proxyFactory.getProxy();
		List<UserDO> users = proxy.selectAll();
		System.out.println(users);
	}

	public static void imple2() {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "AopSpringNativeTest.xml" });
		UserDao proxy = (UserDao) ctx.getBean("aopSpringNativeProxy");
		List<UserDO> users = proxy.selectAll();
		System.out.println(users);
	}

	public static void main(String[] args) {
		System.out.println("imple 1");
		imple1();
		System.out.println("imple 2");
		imple2();
	}

}
