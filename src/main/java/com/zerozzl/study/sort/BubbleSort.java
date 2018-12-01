package com.zerozzl.study.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

	public static int[] sort(int[] arr) {
		int[] result = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < result.length - 1; i++) {
			for (int j = 0; j < result.length - i - 1; j++) {
				if (result[j] > result[j + 1]) {
					int tmp = result[j];
					result[j] = result[j + 1];
					result[j + 1] = tmp;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("BubbleSort:");
		int[] array = { 3, 1, 4, 7, 2, 1, 9, 5, 10, 6, 8, 2 };
		int[] result = sort(array);
		System.out.print("Before: ");
		for (int a : array) {
			System.out.print(a + ", ");
		}
		System.out.println();

		System.out.print("After: ");
		for (int a : result) {
			System.out.print(a + ", ");
		}
	}

}
