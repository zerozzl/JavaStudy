package com.zerozzl.study.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zerozzl.study.common.model.TeacherDO;
import com.zerozzl.study.common.model.UserDO;

@Configuration
public class AnnotationConfigurationTest {

	@Bean(name = "user")
	public UserDO createUser() {
		return new UserDO();
	}
	
	@Bean(name = "teacher")
	public TeacherDO createTeacher() {
		return new TeacherDO();
	}

	public static void main(String[] args) {
		// ͨ通过一个带有@Configuration的POJO装载Bean的配置
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfigurationTest.class);
		UserDO user = ctx.getBean("user", UserDO.class);
		System.out.println(user);
	}

}
