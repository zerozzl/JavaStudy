package com.zerozzl.study.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zerozzl.study.common.model.User;

public class AutoScanApplicationContextTest {

	public static void main(String args[]) {
		// ͨ通过一个带有@Configuration的POJO装载Bean的配置
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "AutoScanApplicationContextTest.xml" });
		User user1 = ctx.getBean("user", User.class);
		System.out.println(user1);
	}

}
