package com.zerozzl.study.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class XmlLogAspect {

	public void logBefore(JoinPoint point) {
		System.out.println("Log before method");
	}

	public void logAfter(JoinPoint point) {
		System.out.println("Log after method");
	}

	public void logAfterReturning(JoinPoint point,
			Object result) {
		System.out.println("xml aspects logging afterReturningAdvice");
	}

	public void logAfterThrowing(JoinPoint point,
			Exception e) {
		System.out.println("xml aspects logging afterThrowingAdvice");
	}

	public Object logAround(ProceedingJoinPoint point) throws Throwable {
		System.out.println("xml aspects logging aroundAdvice");
		Object result = point.proceed();
		System.out.println("xml aspects logging aroundAdvice");
		return result;
	}

}
