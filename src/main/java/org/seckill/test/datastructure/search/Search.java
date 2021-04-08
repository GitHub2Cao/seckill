package org.seckill.test.datastructure.search;

/**
 * @author cgm
 * @date 2021-04-07 18:20
 */
public class Search {
	public static <T extends Comparable<? super T>> boolean linearSearch(T[] data, int start, int end, T target) {
		int index = start;
		boolean found = false;
		while (index <= end && !found) {
			if (data[index].equals(target)) {
				found = true;
			}
			index++;
		}
		return found;
	}

	public static <T extends Comparable<? super T>> boolean binarySearchRecursion(T[] data, int start, int end, T target) {
		boolean found = false;
		int midPoint = (start + end) / 2;
		if (data[midPoint].compareTo(target) == 0) {
			found = true;
		} else if (data[midPoint].compareTo(target) > 0) {
			if (start <= midPoint - 1) {
				found = binarySearchRecursion(data, start, midPoint - 1, target);
			}
		} else if (midPoint + 1 <= end) {
			found = binarySearchRecursion(data, midPoint + 1, end, target);
		}
		return found;
	}

	public static <T extends Comparable<? super T>> boolean binarySearchIteration(T[] data, int start, int end, T target) {
		boolean found = false;
		while (start < end) {
			int midPoint = (start + end) / 2;
			if (data[midPoint].compareTo(target) == 0) {
				found = true;
				break;
			}
			if (data[midPoint].compareTo(target) > 0) {
				end = midPoint - 1;
				continue;
			}
			if (data[midPoint].compareTo(target) < 0) {
				start = midPoint + 1;
				continue;
			}
		}
		return found;
	}

	public static void main(String[] args) {
		Integer[] array = {1, 2, 4, 10, 20, 100, 110};
		System.out.println(linearSearch(array, 0, array.length - 1, 1));
		System.out.println(binarySearchRecursion(array, 0, array.length - 1, 10));
		System.out.println(binarySearchIteration(array, 0, array.length - 1, 10));
	}


}
