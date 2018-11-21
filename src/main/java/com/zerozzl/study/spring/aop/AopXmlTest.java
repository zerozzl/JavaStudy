package com.zerozzl.study.spring.aop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zerozzl.study.common.dao.UserDao;
import com.zerozzl.study.common.model.User;

public class AopXmlTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("AopXmlTest.xml");
		UserDao userDao = ctx.getBean("userDao", UserDao.class);
		List<User> users = userDao.selectAll();
		System.out.println(users);
	}

}
