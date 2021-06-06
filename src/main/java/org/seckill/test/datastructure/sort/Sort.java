package org.seckill.test.datastructure.sort;

import java.util.Arrays;

/**
 * @author cgm
 * @date 2021-04-07 20:06
 */
public class Sort {
	/**
	 * 反复地将某一特定值放到它在列表中的最终已排序位置从而完成对某一列表值的排序
	 *
	 * @param data bb
	 * @param <T>  b
	 */
	public static <T extends Comparable<? super T>> void selectionMin2MaxSort(T[] data) {
		int minIndex;
		T temp;
		for (int index = 0; index < data.length; index++) {
			minIndex = index;
			for (int scan = index + 1; scan < data.length; scan++) {
				if (data[minIndex].compareTo(data[scan]) > 0) {
					minIndex = scan;
				}
			}
			if (index != minIndex) {
				temp = data[minIndex];
				data[minIndex] = data[index];
				data[index] = temp;
			}
			//System.out.println(Arrays.deepToString(data));
		}
	}

	/**
	 * 反复地将某一特定值放到它在列表中的最终已排序位置从而完成对某一列表值的排序
	 *
	 * @param data
	 * @param <T>
	 */
	public static <T extends Comparable<? super T>> void selectionMax2MinSort(T[] data) {
		int maxIndex;
		T temp;
		for (int index = 0; index < data.length; index++) {
			maxIndex = index;
			for (int scan = index + 1; scan < data.length; scan++) {
				if (data[maxIndex].compareTo(data[scan]) < 0) {
					maxIndex = scan;
				}
			}
			temp = data[maxIndex];
			data[maxIndex] = data[index];
			data[index] = temp;
		}
	}

	public static <T extends Comparable<? super T>> void selectionDoubleMax2MinSort(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		T temp;
		for (int i = 0; i < (data.length >> 1) - 1; i++) {
			int minPos = i;
			int maxPos = data.length - i - 1;
			for (int j = i; j < data.length - i; j++) {
				if (data[j].compareTo(data[minPos]) < 0) {
					minPos = j;
				}
				if (data[j].compareTo(data[maxPos]) > 0) {
					maxPos = j;
				}
			}
			if (i != minPos) {
				temp = data[i];
				data[i] = data[minPos];
				data[minPos] = temp;
			}
			if (maxPos != data.length - i - 1) {
				if (maxPos == i) {
					maxPos = minPos;
				}
				temp = data[maxPos];
				data[maxPos] = data[data.length - i - 1];
				data[data.length - i - 1] = temp;
			}
		}
	}

	/**
	 * 反复地将某一特定值插入到该列表某个已排序的子集中来完成对列表值的排序
	 *
	 * @param data
	 * @param <T>
	 */
	public static <T extends Comparable<? super T>> void insertionMin2MaxSort(T[] data) {
		for (int index = 1; index < data.length; index++) {
			T value = data[index];
			int position = index;
			while (position > 0 && data[position - 1].compareTo(value) > 0) {
				data[position] = data[position - 1];
				position--;
			}
			data[position] = value;
		}
	}

	/**
	 * 反复地将某一特定值插入到该列表某个已排序的子集中来完成对列表值的排序
	 *
	 * @param data
	 * @param <T>
	 */
	public static <T extends Comparable<? super T>> void insertionMax2MinSort(T[] data) {
		for (int index = 1; index < data.length; index++) {
			T value = data[index];
			int position = index;
			while (position > 0 && data[position - 1].compareTo(value) < 0) {
				data[position] = data[position - 1];
				position--;
			}
			data[position] = value;
		}
	}

	public static <T extends Comparable<? super T>> void insertionSortAsc(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		for (int i = 1; i < data.length; i++) {
			T value = data[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (value.compareTo(data[j]) > 0) {
					data[j + 1] = data[j];
				} else {
					break;
				}
			}
			data[j + 1] = value;
		}
	}

	public static <T extends Comparable<? super T>> void bubbleMax2MinSort(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		int position;
		int scan;
		T temp;
		for (position = data.length; position > 0; position--) {
			boolean finished = true;
			for (scan = 0; scan < position - 1; scan++) {
				if (data[scan].compareTo(data[scan + 1]) > 0) {
					temp = data[scan];
					data[scan] = data[scan + 1];
					data[scan + 1] = temp;
					finished = false;
				}
			}
			if (finished) {
				break;
			}
		}
	}

	public static <T extends Comparable<? super T>> void bubbleMin2MaxSort(T[] data) {
		int position;
		int scan;
		T temp;
		for (position = data.length; position > 0; position--) {
			boolean finished = true;
			for (scan = 0; scan < position - 1; scan++) {
				if (data[scan].compareTo(data[scan + 1]) < 0) {
					temp = data[scan];
					data[scan] = data[scan + 1];
					data[scan + 1] = temp;
					finished = false;
				}
			}
			if (finished) {
				break;
			}
		}
	}

	public static <T extends Comparable<? super T>> void bubbleSortAsc(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		T temp;
		for (int i = 0; i < data.length; i++) {
			boolean finished = true;
			for (int scan = 0; scan < data.length - i - 1; scan++) {
				if (data[scan].compareTo(data[scan + 1]) > 0) {
					temp = data[scan];
					data[scan] = data[scan + 1];
					data[scan + 1] = temp;
					finished = false;
				}
			}
			if (finished) {
				break;
			}
		}
	}

	public static <T extends Comparable<? super T>> void bubbleSortDesc(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		T temp;
		for (int i = 0; i < data.length; i++) {
			boolean finished = true;
			for (int scan = 0; scan < data.length - i - 1; scan++) {
				if (data[scan].compareTo(data[scan + 1]) < 0) {
					swap(data, scan, scan + 1);
					finished = false;
				}
			}
			if (finished) {
				break;
			}
		}
	}

	private static <T extends Comparable<? super T>> void swap(T[] data, int indexFrom, int indexTo) {
		T temp;
		temp = data[indexFrom];
		data[indexFrom] = data[indexTo];
		data[indexTo] = temp;
	}

	public static <T extends Comparable<? super T>> void quickSort(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		quickSort(data, 0, data.length - 1);
	}

	private static <T extends Comparable<? super T>> void quickSort(T[] data, int start, int end) {
		if (start < end) {
			int partitionIndex = partition(data, start, end);
			quickSort(data, start, partitionIndex - 1);
			quickSort(data, partitionIndex + 1, end);
		}
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

	public static void main(String[] args) {
		//Integer[] array = {1, 5, 2, 4, 10, 1000, 20, 100, 110};
		//Integer[] array = {8, 3, 10, 2, 7, 6, 9, 12, 13};
		Integer[] array = {4, 2, 1, 6, 3, 7, 9, 8, 5};
		//Integer[] array = {1};
		//bubbleMax2MinSort(array);
		//System.out.println(Arrays.deepToString(array));
		//selectionDoubleMax2MinSort(array);
		quickSort(array);
		System.out.println(Arrays.deepToString(array));
	}
}
