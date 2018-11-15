package com.zerozzl.study.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Sample2 {

	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static void main(String[] args) throws Exception {
		// 正常的调用
		Sample2 apple = new Sample2();
		apple.setPrice(5);
		System.out.println("Apple Price:" + apple.getPrice());
		
		// 使用反射调用
		Class clz = Class.forName("com.zerozzl.study.java.lang.reflect.Sample2");
		Method setPriceMethod = clz.getMethod("setPrice", int.class);
		Constructor appleConstructor = clz.getConstructor();
		Object appleObj = appleConstructor.newInstance();
		setPriceMethod.invoke(appleObj, 14);
		Method getPriceMethod = clz.getMethod("getPrice");
		System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));
	}

}
