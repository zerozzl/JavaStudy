package com.zerozzl.study.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zerozzl.study.common.model.Teacher;
import com.zerozzl.study.common.model.User;

@Configuration
public class AnnotationConfigurationTest {

	@Bean(name = "user")
	public User createUser() {
		return new User();
	}
	
	@Bean(name = "teacher")
	public Teacher createTeacher() {
		return new Teacher();
	}

	public static void main(String[] args) {
		// ͨ通过一个带有@Configuration的POJO装载Bean的配置
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfigurationTest.class);
		User user = ctx.getBean("user", User.class);
		System.out.println(user);
	}

}
