package com.zerozzl.study.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationCommonAspect {

	@Pointcut("execution(* com.zerozzl.study.common.dao.impl.UserDaoImpl.*(..))")
	public void pointCut() {
	}

	@Before("execution(* com.zerozzl.study.common.dao.impl.UserDaoImpl.*(..))")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("AOP Before Advice...");
	}

	@After("pointCut()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("AOP After Advice...");
	}

	@AfterReturning(pointcut = "pointCut()",
			returning = "returnVal")
	public void afterReturn(JoinPoint joinPoint,
			Object returnVal) {
		System.out.println("AOP AfterReturning Advice:" + returnVal);
	}

	@AfterThrowing(pointcut = "pointCut()",
			throwing = "error")
	public void afterThrowing(JoinPoint joinPoint,
			Throwable error) {
		System.out.println("AOP AfterThrowing Advice..." + error);
		System.out.println("AfterThrowing...");
	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("AOP Aronud before...");
		Object obj = pjp.proceed();
		System.out.println("AOP Aronud after...");
		return obj;
	}

}
