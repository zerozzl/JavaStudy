package com.zerozzl.study.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {

	public static int[] sort(int[] arr) {
		int[] result = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < result.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < result.length; j++) {
				if(result[j] < result[min]) {
					min = j;
				}
			}
			
			if (min != i) {
				int tmp = result[i];
				result[i] = result[min];
				result[min] = tmp;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("SelectionSort:");
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
