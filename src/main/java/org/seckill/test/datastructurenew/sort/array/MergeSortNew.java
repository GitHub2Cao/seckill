package org.seckill.test.datastructurenew.sort.array;

import java.util.Arrays;

/**
 * @author cgm
 * @date 2021-04-13 22:25
 */
public class MergeSortNew {
	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int left, int right) {
		// 优化点2：当数组比较小时，可以使用插入排序，效率更高。
		if (left >= right) {
			return;
		} else {
			//分开的左数组的最后一个下标
			int center = (left + right) / 2;
			//左边归并排序
			mergeSort(arr, left, center);
			//右边归并排序
			mergeSort(arr, center + 1, right);
			//优化点1：若已经有序，则不需要归并。更适用于近乎有序的数组。
			if (arr[center] > arr[center + 1]) {
				//两侧进行归并
				merge(arr, left, center, right);
			}
		}
	}

	public static void merge(int[] arr, int left, int center, int right) {

		//拷贝原数组段arr到copy，排序结果放在原数组段arr。两个数组之间有left的偏移量
		int[] copy = new int[right - left + 1];
		for (int i = left; i <= right; i++) {
			copy[i - left] = arr[i];
		}

		int resP = left;//结果集arr中放置排序结果的起始下标
		int leftP = 0;//copy中左数组的待排序数据的下标
		int rightP = center + 1 - left;//copy中右数组的待排序数据的下标
		//leftP和rightP使用时先加上偏移量left

		//前期两侧都有未排序数据时
		while (leftP + left < center + 1 && rightP + left < right + 1) {
			if (copy[leftP] <= copy[rightP]) {
				arr[resP++] = copy[leftP++];
			} else {
				arr[resP++] = copy[rightP++];
			}
		}
		//有一侧没有数据时
		if (leftP + left == center + 1) {
			while (rightP + left < right + 1) {
				arr[resP++] = copy[rightP++];
			}
		}
		if (rightP + left == right + 1) {
			while (leftP + left < center + 1) {
				arr[resP++] = copy[leftP++];
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {4, 2, 1, 6, 3, 7, 9, 8, 5};
		mergeSort(a);
		//mergeSortIteration(a);
		System.out.println(Arrays.toString(a));
	}
}
