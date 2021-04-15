package org.seckill.test.datastructurenew.sort.array;

import java.util.Arrays;

/**
 * @author cgm
 * @date 2021-04-12 12:21
 */
public class MergeSort {
	private static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
		int i = lo;
		int j = mid;
		for (int k = lo; k < hi; k++) {
			aux[k] = a[k];
		}

		for (int k = lo; k < hi; k++) {
			if (i == mid) {
				a[k] = aux[j++];
			} else if (j == hi) {
				a[k] = aux[i++];
			} else if (aux[j].compareTo(aux[i]) < 0) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}



	public static <T extends Comparable<? super T>> void mergeSortRecursion(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		T[] aux = (T[]) new Comparable[data.length];
		mergeSort(data, aux,0, data.length);
	}

	public static <T extends Comparable<? super T>> void mergeSortIteration(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		int length = data.length;
		T[] result = Arrays.copyOf(data, data.length);
		for (int block = 1; block < length; block *= 2) {
			for (int start = 0; start <length; start += block * 2) {
				int low = start;
				int mid = Math.min(start + block, length);
				int high = Math.min(start + 2 * block, length);
				int start1 = low;
				int end1 = mid;
				int start2 = mid;
				int end2 = high;
				while (start1 < end1 && start2 < end2) {
					result[low++] = result[start1].compareTo(result[start2]) < 0 ? result[start1++] : result[start2++];
				}
				while(start1 < end1) {
					result[low++] = result[start1++];
				}
				while(start2 < end2) {
					result[low++] = result[start2++];
				}
				System.out.println(Arrays.deepToString(result));
			}
		}
		data = Arrays.copyOf(result, result.length);
	}



	private static <T extends Comparable<? super T>> void mergeSort(T[] data, T[] aux, int start, int end) {
//		if (start >= end) {
//			return;
//		}
		if (end - start <= 1) {
			return;
		}
		int mid = (start + end) >> 1;
		mergeSort(data, aux, start, mid);
		mergeSort(data, aux, mid, end);
		merge(data, aux, start, mid, end);
 	}


//	private static <T extends Comparable<? super T>> void merge(T[] data, int start, int mid, int end) {
//		T[] temp = (T[]) new Comparable[end - start + 1];
//		for (int i = start; i <= end; i++) {
//			temp[i - start] = data[i];
//		}
//
//		int leftPoint = 0;
//		int rightPoint = mid + 1 - start;
//		int point = start;
//		while (leftPoint + start <= mid && rightPoint + start <= end) {
//			if (temp[leftPoint].compareTo(temp[rightPoint]) > 0) {
//				data[point++] = temp[rightPoint++];
//			} else {
//				data[point++] = temp[leftPoint++];
//			}
//		}
//		if (leftPoint + start == mid + 1) {
//			while (rightPoint + start <= end) {
//				data[point++] = temp[rightPoint++];
//			}
//		}
//		if (rightPoint + start == end + 1) {
//			while (leftPoint + start <= mid) {
//				data[point++] = temp[leftPoint++];
//			}
//		}
//
//		System.arraycopy(temp, 0, data, start, temp.length);
//	}

	public static void main(String[] args) {
		Integer[] a = {4, 2, 1, 6, 3, 7, 9, 8, 5};

		//Integer[] a = {1, 2, 4, 6, 3, 5, 7, 8, 9};

		//merge(a, 0, a.length /2, a.length - 1);
		mergeSortRecursion(a);
		//mergeSortIteration(a);
		System.out.println(Arrays.deepToString(a));
	}
}
