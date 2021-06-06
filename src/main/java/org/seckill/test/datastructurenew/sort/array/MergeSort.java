package org.seckill.test.datastructurenew.sort.array;

import java.util.Arrays;

/**
 * @author cgm
 * @date 2021-04-12 12:21
 */
public class MergeSort {
	public static <T extends Comparable<? super T>> void mergeSort(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		mergeSort(data, 0, data.length - 1);
	}

	public static <T extends Comparable<? super T>> void mergeSort(T[] data, int min, int max) {
		if (min == max) {
			return;
		}
		int pivot = (min + max) >> 1;
		T[] temp = (T[]) new Comparable[data.length];
		mergeSort(data, min, pivot);
		mergeSort(data, pivot + 1, max);
		merge(data, temp, min, pivot, max);
	}

	public static <T extends Comparable<? super T>> void mergeSortaa(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		int lenght = data.length;
		T[] temp = (T[]) new Comparable[lenght];
		for (int sz = 1; sz < lenght; sz = sz + sz) {
			for (int lo = 0; lo < lenght - sz; lo += sz + sz) {
				merge(data, temp, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, lenght - 1));
			}
		}
	}

	private static <T extends Comparable<? super T>> void merge(T[] data, T[] temp, int min, int pivot, int max) {
		int size = max - min + 1;
		int index;
		for (index = 0; index < size; index++) {
			temp[index] = data[min + index];
		}

		int left = 0;
		int right = pivot - min + 1;
		for (index = 0; index < size; index++) {
			if (right <= max - min) {
				if (left <= pivot - min) {
					if (temp[left].compareTo(temp[right]) > 0) {
						data[index + min] = temp[right++];
					} else {
						data[index + min] = temp[left++];
					}
				} else {
					data[index + min] = temp[right++];
				}
			} else {
				data[index + min] = temp[left++];
			}
		}
	}

	private static <T extends Comparable<? super T>> void merge2(T[] data, T[] temp, int min, int pivot, int max) {
		int mid = pivot + 1;
		int third = min;
		int tmp = min;
		while (min <= pivot && mid <= max) {
			if (data[min].compareTo(data[mid]) < 0) {
				temp[third++] = data[min++];
			} else {
				temp[third++] = data[mid++];
			}
		}
		while (mid <= max) {
			temp[third++] = data[mid++];
		}
		while (min <= pivot) {
			temp[third++] = data[min++];
		}
		while (tmp <= max) {
			data[tmp] = temp[tmp++];
		}
	}


	public static void main(String[] args) {
		Integer[] a = {4, 2, 1, 6, 3, 7, 9, 8, 5};
		//mergeSortRecursion(a);

		//Integer[] a = {1, 2, 4, 6, 3, 5, 7, 8, 9};
		//Integer[] a = {1};
		//merge(a, 0, a.length / 2, a.length - 1);
		//mergeSortRecursion(a);
		//iteration(a);
		mergeSort(a);
		System.out.println(Arrays.deepToString(a));
	}
}
