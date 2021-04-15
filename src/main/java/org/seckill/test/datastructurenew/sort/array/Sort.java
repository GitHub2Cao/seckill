package org.seckill.test.datastructurenew.sort.array;

/**
 * @author cgm
 * @date 2021-04-10 22:52
 */
public class Sort {
	/**
	 *
	 * @param data
	 * @param <T>
	 */
	public static <T extends Comparable<? super T>> void selectionSortAsc(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}

		for (int i = 0; i < data.length - 1; i++) {
			int minIndex = i;
			for (int scan = i + 1; scan < data.length; scan++) {
				if (data[minIndex].compareTo(data[scan]) > 0) {
					minIndex = scan;
				}
				swap(data, minIndex, i);
			}
		}
	}

	public static <T extends Comparable<? super T>> void selectionSortDesc(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}

		for (int i = 0; i < data.length - 1; i++) {
			int maxIndex = i;
			for (int scan = i + 1; scan < data.length; scan++) {
				if (data[maxIndex].compareTo(data[scan]) < 0) {
					maxIndex = scan;
				}
				swap(data, maxIndex, i);
			}
		}
	}

	public static <T extends Comparable<? super T>> void bubbleSortAsc(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		print(data);
		boolean finished = true;
		for (int i = 0; i < data.length - 1; i++) {
			for (int scan = i + 1; scan < data.length; scan++) {
				if (data[i].compareTo(data[scan]) > 0) {
					swap(data, i, scan);
					finished = false;
				}
			}
			print(data);
			if (finished) {
				return;
			}
		}
	}

	public static <T extends Comparable<? super T>> void bubbleSortDesc(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}

		for (int i = 0; i < data.length - 1; i++) {
			for (int scan = i + 1; scan < data.length; scan++) {
				if (data[i].compareTo(data[scan]) < 0) {
					swap(data, i, scan);
				}
			}
		}
	}

	public static <T extends Comparable<? super T>> void insertionSortAsc(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		for (int i = 1; i < data.length; i++) {
			int index = i;
			T temp = data[index];
			while (index > 0 && temp.compareTo(data[index - 1]) < 0) {
				data[index] = data[index - 1];
				index--;
			}
			data[index] = temp;
		}
	}

	public static <T extends Comparable<? super T>> void insertionSortDesc(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		for (int i = 1; i < data.length; i++) {
			int index = i;
			T temp = data[index];
			while (index > 0 && temp.compareTo(data[index - 1]) > 0) {
				data[index] = data[index - 1];
				index--;
			}
			data[index] = temp;
		}
	}

	/**
	 * 1959年.
	 * @param data
	 * @param <T>
	 */
	public static <T extends Comparable<? super T>> void shellSortAsc(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}
		for (int gap = data.length >> 1; gap > 0; gap = gap >> 1) {
			for (int i = gap; i < data.length; i++) {
				int index = i;
				T temp = data[index];
				while (index >= gap && temp.compareTo(data[index - gap]) < 0) {
					data[index] = data[index - gap];
					index = index - gap;
				}
				data[index] = temp;
			}
		}
	}

	public static <T extends Comparable<? super T>> void shellSortDesc(T[] data) {
		if (data == null || data.length == 1) {
			return;
		}

		for (int gap = data.length >> 1; gap > 0; gap = gap >> 1) {
			for (int i = gap; i < data.length; i++) {
				int index = i;
				T temp = data[index];
				while (index >= gap && temp.compareTo(data[index - gap]) > 0) {
					data[index] = data[index - gap];
					index = index - gap;
				}
				data[index] = temp;
			}
		}
	}

	private static <T extends Comparable<? super T>> void swap(T[] data, int index1, int index2) {
		if (data == null) {
			return;
		}
		if (index1 == index2) {
			return;
		}

		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

	private static <T extends Comparable<? super T>> void print(T[] data) {
		if (data == null) {
			return;
		}
		for (T item : data) {
			System.out.printf("%s ", item.toString());
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] data = {2, 3, 2, 5, 1, 7, 10};

//		selectionSortAsc(data);
//		System.out.println(Arrays.deepToString(data));
//		selectionSortDesc(data);
//		System.out.println(Arrays.deepToString(data));

//		bubbleSortAsc(data);
//		System.out.println(Arrays.deepToString(data));
//		bubbleSortDesc(data);
//		System.out.println( Arrays.deepToString(data));

//		insertionSortAsc(data);
//		print(data);
//		insertionSortDesc(data);
//		print(data);

		shellSortAsc(data);
		print(data);

		shellSortDesc(data);
		print(data);
	}
}
