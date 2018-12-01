package com.zerozzl.study.exam;

/*
 * 给定n个整数（可能为负数）组成的序列a[1],a[2],a[3],…,a[n],求该序列如a[i]+a[i+1]+…+a[j]的子段和的最大值。当所给的整数均为负数时定义子段和为0，依此定义，所求的最优值为： Max{0,a[i]+a[i+1]+…+a[j]},1<=i<=j<=n
 * 例如，当（a[1],a[2],a[3],a[4],a[5],a[6]）=(-2,11,-4,13,-5,-2)时，最大子段和为20。
 */
public class FindMaxSubArray {

	public static int find(int[] array) {
		if (array.length == 0 || array == null) {
			return 0;
		}
		int sum = 0;
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (sum <= 0) { // 如果当前连续n项的和小于等于0,则没必要与后面的元素相加
				sum = array[i]; // Sum重新赋值
			} else {
				sum += array[i]; // 如果Sum的值大于0,则继续与后面的元素相加,
			}
			if (sum > max) { // 每次改变Sum的值都有与max进行比较
				max = sum; // 如果Sum的值大于max,则将Sum的值赋值给max
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] array = { -2, 11, -4, 13, -5, -5, -2 };
		int result = find(array);
		System.out.println("连续子数组之最大和为：" + result);
	}

}
