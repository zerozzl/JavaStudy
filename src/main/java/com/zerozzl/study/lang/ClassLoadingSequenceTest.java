package com.zerozzl.study.lang;

class ClassLoadingSequenceSuper {
	
	static {
		System.out.println("Super static before");
	}
	
	public ClassLoadingSequenceSuper() {
		System.out.println("Super construct");
	}
	
	{
		System.out.println("Super non static");
	}
	
	static {
		System.out.println("Super static after");
	}
	
}

public class ClassLoadingSequenceTest extends ClassLoadingSequenceSuper {

	static {
		System.out.println("Child static before");
	}
	
	public ClassLoadingSequenceTest() {
		System.out.println("Child construct");
	}
	
	{
		System.out.println("Child non static");
	}
	
	static {
		System.out.println("Child static after");
	}
	
	public static void main(String[] args) {
		System.out.println("=======================");
		new ClassLoadingSequenceTest();
		System.out.println("=======================");
		new ClassLoadingSequenceTest();
	}
	
}
