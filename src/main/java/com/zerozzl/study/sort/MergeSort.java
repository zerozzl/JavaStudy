package com.zerozzl.study.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

	public static int[] sort(int[] arr) {
		int[] result = Arrays.copyOf(arr, arr.length), tmp = new int[result.length];
		merge(result, 0, arr.length - 1, tmp);
		return result;
	}

	private static void merge(int[] arr,
			int begin,
			int end,
			int[] tmp) {
		if (begin < end) {
			int mid = (begin + end) / 2;
			merge(arr, begin, mid, tmp);
			merge(arr, mid + 1, end, tmp);
			merge(arr, begin, mid, end, tmp);
		}
	}

	private static void merge(int[] arr,
			int begin,
			int mid,
			int end,
			int[] tmp) {
		int i = begin, j = mid + 1, k = begin;
		while (i <= mid && j <= end) {
			if (arr[i] < arr[j]) {
				tmp[k++] = arr[i++];
			} else {
				tmp[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			tmp[k++] = arr[i++];
		}
		while (j <= end) {
			tmp[k++] = arr[j++];
		}
		for (k = begin; k <= end; k++) {
			arr[k] = tmp[k];
		}
	}

	public static void main(String[] args) {
		System.out.println("MergeSort:");
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
