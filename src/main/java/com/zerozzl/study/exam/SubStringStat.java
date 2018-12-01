package com.zerozzl.study.exam;

import org.apache.commons.lang3.StringUtils;

/*
 * 1. 有一串字符串String s = "ababab", 这个字符串可以看做由3个"ab"构成,即n=3, L = "ab", s = nL.
 * 现在要求编写一段程序,使用单例模式,输入任意字符串s,输出nL. 如输入: aaaaa 输出 5a ,输入: ababa 输出: 1ababa
 */
public class SubStringStat {
	// 创建一个对象
	private static SubStringStat instance;

	// 让构造函数为 private，这样该类就不会被实例化
	private SubStringStat() {
	}

	// 获取唯一可用对象
	public static SubStringStat getInstance() {
		if (instance == null) {
			instance = new SubStringStat();
		}
		return instance;
	}

	// 编写用来解题的方法
	public static String compress(String s) {
		String result = "";
		if (StringUtils.isBlank(s)) {
			result = "你输入为空!";
		} else if (s.contains(" ")) {
			result = "请不要输入空格!";
		} else {
			int length = s.length();
			System.out.println("length: " + length);
			int count = 0;

			for (int i = 1; i <= length; i++) {
				String cut = s.substring(0, i);
				String[] strings1 = s.split(cut);
				if (strings1.length == 0) {
					System.out.println("切分到: " + i);
					count = i;
					break;
				}

			}
			result = length / count + s.substring(0, count);
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "ababa";
		String result = "";
		SubStringStat stat = SubStringStat.getInstance();
		result = stat.compress(s);
		System.out.println(result);
	}

}
