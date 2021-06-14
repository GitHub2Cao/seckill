package org.seckill.test.datastructurenew.sort.array;

import java.util.Arrays;

/**
 * @author cgm
 * @date 2021-04-17 12:22
 */
public class QuickSort {
	public static <T extends Comparable<? super T>> void sort(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}

		sort(data, 0, data.length - 1);
	}

	private static <T extends Comparable<? super T>> void sort(T[] data, int start, int end) {
		if (start >= end) {
			return;
		}
		int partition = partition(data, start, end);
		sort(data, start, partition - 1);
		sort(data, partition + 1, end);
	}

	private static <T extends Comparable<? super T>> int partition(T[] data, int start, int end) {
		T partitionValue = data[start];
		int left = start;
		int right = end;
		while (left < right) {
			while (left < right && data[left].compareTo(partitionValue) <= 0) {
				left++;
			}
			while (data[right].compareTo(partitionValue) > 0) {
				right--;
			}
			if (left < right) {
				swap(data, left, right);
			}
		}
		swap(data, start, right);
		return right;

	}

	private static <T extends Comparable<? super T>> void swap(T[] data, int indexFrom, int indexTo) {
		T temp;
		temp = data[indexFrom];
		data[indexFrom] = data[indexTo];
		data[indexTo] = temp;
	}


	public static void main(String[] args) {
		Integer[] a = {4, 2, 1, 6, 3, 7, 9, 8, 5};
		sort(a);
		System.out.println(Arrays.deepToString(a));
	}


}
