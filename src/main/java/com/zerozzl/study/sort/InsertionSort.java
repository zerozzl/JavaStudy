package com.zerozzl.study.sort;

import java.util.Arrays;

/**
 * 直接插入排序
 */
public class InsertionSort {

	public static int[] sort(int[] arr) {
		int[] result = Arrays.copyOf(arr, arr.length);
		for (int i = 1; i < result.length; i++) {
			int tmp = result[i];
			int j = i - 1;
			while (j >= 0 && result[j] > tmp) {
				result[j + 1] = result[j];
				j--;
			}

			result[j + 1] = tmp;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("InsertionSort:");
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
