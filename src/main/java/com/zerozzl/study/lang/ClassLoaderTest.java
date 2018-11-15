package com.zerozzl.study.lang;

public class ClassLoaderTest {

	public static void main(String[] args) {
		ClassLoader cl = ClassLoaderTest.class.getClassLoader();
		System.out.println("ClassLoader is:" + cl.toString());
		System.out.println("ClassLoader\'s parent is:" + cl.getParent().toString());
		System.out.println("ClassLoader\'s grand father is:" + cl.getParent().getParent().toString());

		cl = int.class.getClassLoader();
		System.out.println("ClassLoader is:" + cl.toString());
	}

}
