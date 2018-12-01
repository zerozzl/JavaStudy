package com.zerozzl.study.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

	public static int[] sort(int[] arr) {
		int[] result = Arrays.copyOf(arr, arr.length);
		for (int gap = result.length / 2; gap > 0; gap /= 2) {
			for (int i = 0; i < gap; i++) {
				for (int j = i + gap; j < result.length; j += gap) {
					int tmp = result[j];
					int k = j - gap;
					while (k >= 0 && result[k] > tmp) {
						result[k + gap] = result[k];
						k -= gap;
					}
					result[k + gap] = tmp;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("ShellSort:");
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
