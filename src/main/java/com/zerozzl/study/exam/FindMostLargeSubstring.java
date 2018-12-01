package com.zerozzl.study.exam;

/* 需求：找到两个字符串的最长共同子串
 * 思路：
 * 1.先看短的那个字符串是否在长的那个字符串中，如果存在，短的那个字符串就是最大共同子串
 * 2.如果不存在，那么就将短的那个子串进行长度递减的方式取子串，去长串中判断是否存在，如果
 *     存在，找到！
 */
public class FindMostLargeSubstring {

	/**
	 * 获得最大子串
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static String getMaxSubstring(String s1,
			String s2) {
		String max = null;
		String min = null;
		max = (s1.length() > s2.length()) ? s1 : s2;
		min = max.equals(s1) ? s2 : s1;
		for (int i = 0; i < min.length(); i++) {
			for (int a = 0, b = min.length() - i; b <= min.length(); a++, b++) {
				// 取短字符串的的子串，并判断该子串在长字符串中是否存在
				String sub = min.substring(a, b);
				if (max.contains(sub))
					return sub;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String s1 = "qwerabcdtyuiop";
		String s2 = "xcabcdvbn";
		String s = getMaxSubstring(s1, s2);
		System.out.println("s = " + s);
	}

}
