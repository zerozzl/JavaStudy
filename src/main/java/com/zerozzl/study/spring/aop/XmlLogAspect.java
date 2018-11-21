package com.zerozzl.study.spring.aop;

public class XmlLogAspect {

	public void logBefore() {
		System.out.println("Log before method");
	}

	public void logAfter() {
		System.out.println("Log after method");
	}

}
