package com.zerozzl.study.lang.reflect;

class XYZ {
	public static String name = "xyz";

	static {
		System.out.println("xyz静态块");
	}

	public XYZ() {
		System.out.println("xyz构造了");
	}
	
}

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// 不会初始化静态块
		Class clazz1 = XYZ.class;
		System.out.println("------");
		// 会初始化
		Class clazz2 = Class.forName("com.zerozzl.study.lang.reflect.XYZ");

		// 第一种方式获取Class对象
		XYZ stu1 = new XYZ();// 这一new 产生一个Student对象，一个Class对象。
		Class stuClass = stu1.getClass();// 获取Class对象
		System.out.println(stuClass.getName());

		// 第二种方式获取Class对象
		Class stuClass2 = XYZ.class;
		System.out.println(stuClass == stuClass2);// 判断第一种方式获取的Class对象和第二种方式获取的是否是同一个

		// 第三种方式获取Class对象
		try {
			Class stuClass3 = Class.forName("com.zerozzl.study.lang.reflect.XYZ");// 注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
			System.out.println(stuClass3 == stuClass2);// 判断三种方式是否获取的是同一个Class对象
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
