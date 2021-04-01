package com.alibaba.alibole;

import java.util.Arrays;

/**
 * @author cgm
 * @date 2021-03-20 15:11
 * 现有n根木材，要把这n根木材截成相同长度的m段，求可以截取的最大段长 //• 木材长度为正整数，截段后的长度也是正整数； //•
 * 木材只能截段成长度更短的多段木材（且长度为正整数），不能“拼接”；
 * 比如n=4，木材长度分别为[20,66,8,42]，m=3。 可以截取的最大段长为33 [16,4 ] [66] 64 + 2, [8], 42 32 + 8 + 2
 * 比如n=3，木材长度分别为[10,5,13]，m=4。 可以截取的最大段长为5。
 * 比如n=1，木材长度分别为[20]，m=20。可以截取的最大段长为1。
 */
public class LoggingGame {
	public static void main(String[] args) {


		int[] array = {20, 66, 8, 42};

		System.out.println(maxLength(array, 4));
		System.out.println(maxLength(array, 6));

		//maxLength(array, 3));

		System.out.println(getMaxValue(array));
//		System.out.println(voting(array, 1, array.length));
//		System.out.println(voting(array, 3, array.length));
//		System.out.println(voting(array, array.length, 4));
//		System.out.println(voting(array, array.length, 5));

		//voting(array, array.length, 4);
		//voting(array, array.length, 5);
	}

	static class Value {
		private int maxSize;
		private int maxValue;

		public Value(int maxSize, int maxValue) {
			this.maxSize = maxSize;
			this.maxValue = maxValue;
		}

		public int getMaxValue() {
			return maxValue;
		}

		public void setMaxValue(int maxValue) {
			this.maxValue = maxValue;
		}

		public int getMaxSize() {
			return maxSize;
		}

		public void setMaxSize(int maxSize) {
			this.maxSize = maxSize;
		}

		@Override
		public String toString() {
			return "Value{" +
					"maxSize=" + maxSize +
					", maxValue=" + maxValue +
					'}';
		}
	}

	public static Value getMaxValue(int[] array) {
		Arrays.sort(array);
		int min = array[0];
		int max = array[array.length - 1];

		int maxValue = 1;
		int maxkey = 1;
		int maxSize = 1;
		for (int i = 1; i <= max; i++) {
			if (maxLength(array, i) * i > maxValue) {

				maxValue = maxLength(array, i) * i;
				maxSize = maxLength(array, i);
				maxkey = i;
			}
		}
		return new Value(maxkey, maxSize);

	}

	public static int maxLength(int[] array, int maxSize) {
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i];
		}
		// 开始取1.
		int firstVote = 1;
		while (voting(array, maxSize, firstVote)) {
			firstVote *= 2;
		}


		int end = firstVote;
		int start = firstVote / 2;
		while (true) {
			if (voting(array, maxSize, start) && !voting(array, maxSize, start + 1)) {
				break;
			}
			int mid = (start + end) / 2;
			if (voting(array, maxSize, mid)) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return start;
	}

	public static boolean voting(int[] L, int m, int l) {
		int count = 0;
		for (int i = 0; i < L.length; i++) {
			count += L[i] / l;
		}
		if (count >= m) {
			return true;
		}
		return false;
	}
}
