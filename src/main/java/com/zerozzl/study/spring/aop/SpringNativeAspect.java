package com.zerozzl.study.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class SpringNativeAspect implements MethodBeforeAdvice, AfterReturningAdvice {

	@Override
	public void before(Method method,
			Object[] objects,
			Object o) throws Throwable {
		System.out.println("before");
	}

	@Override
	public void afterReturning(Object arg0,
			Method arg1,
			Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("afterReturning");
	}

}
