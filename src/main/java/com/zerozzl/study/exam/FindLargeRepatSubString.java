package com.zerozzl.study.exam;

public class FindLargeRepatSubString {

	// 求解字符串中的最长重复子串
	public static String find(String input) {
		// 参数检查
		if (input == null || input.length() == 0) {
			return null;
		}
		// 重复子串的最长长度
		int max = 0;
		// 最长重复子串的起始位置
		int first = 0;
		int k = 0;
		for (int gap = 1; gap < input.length(); gap++) {
			for (int i = 0; i < input.length() - gap; i++) {
				char a = input.charAt(i), b = input.charAt(i + gap);
				if (a == b) {
					k++;
				} else {
					k = 0;
				}
				if (k > max) {
					max = k;
					first = i - k + 1;
				}
			}
		}
		if (max > 0) {
			return input.substring(first, first + max);
		}
		return null;
	}

	public static void main(String[] args) {
		String str1 = "aababc";
		String result = FindLargeRepatSubString.find(str1);
		System.out.println(result);
	}
}
