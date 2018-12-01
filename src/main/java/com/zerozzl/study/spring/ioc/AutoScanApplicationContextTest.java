package com.zerozzl.study.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zerozzl.study.common.model.UserDO;

public class AutoScanApplicationContextTest {

	public static void main(String args[]) {
		// ͨ通过一个带有@Configuration的POJO装载Bean的配置
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "AutoScanApplicationContextTest.xml" });
		UserDO user1 = ctx.getBean("user", UserDO.class);
		System.out.println(user1);
	}

}
