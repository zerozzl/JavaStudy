package com.zerozzl.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zerozzl.study.model.User;

@Configuration
public class AnnotationConfigurationTest {

	@Bean(name = "user")
	public User createUser() {
		return new User();
	}

	public static void main(String[] args) {
		// ͨ通过一个带有@Configuration的POJO装载Bean的配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfigurationTest.class);
		User user = ctx.getBean("user", User.class);
		System.out.println(user);
	}

}
