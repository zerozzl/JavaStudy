package com.zerozzl.study.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

	public static int[] sort(int[] arr) {
		int[] result = Arrays.copyOf(arr, arr.length);
		quicksort(result, 0, result.length - 1);
		return result;
	}

	private static void quicksort(int[] arr,
			int begin,
			int end) {
		if (begin < end) {
			int partition = getPartition(arr, begin, end);
			quicksort(arr, begin, partition - 1);
			quicksort(arr, partition + 1, end);
		}
	}

	private static int getPartition(int[] arr,
			int begin,
			int end) {
		int i = begin, j = end;
		int target = arr[i];
		while (i < j) {
			while (i < j && arr[j] > target) {
				j--;
			}
			if (i < j) {
				arr[i] = arr[j];
				i++;
			}
			while (i < j && arr[i] < target) {
				i++;
			}
			if (i < j) {
				arr[j] = arr[i];
				j--;
			}
		}
		arr[i] = target;
		return i;
	}

	public static void main(String[] args) {
		System.out.println("QuickSort:");
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
