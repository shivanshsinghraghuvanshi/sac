package com.ilab.safety.sac.revision;

public class MergeSort {

	public static void main(String[] args) {
		int[] num = new int[] { 20, -15, 35, 35, 1, 5, -22 };
		merge(num, 0, num.length);
		for (int i : num) {
			System.out.println(i);
		}
	}

	public static void merge(int[] num, int start, int end) {

		// exit condition
		if (end - start < 2) {
			return;
		}

		int mid = (end + start) / 2;
		merge(num, start, mid);
		merge(num, mid, end);

		sort(num, start, mid, end);
	}

	public static void sort(int[] num, int start, int mid, int end) {

		// exit condition
		if (num[mid - 1] <= num[mid]) {
			return;
		}

		// setting up the merge process
		int i = start, j = mid, tempIndex = 0;
		int[] tempArr = new int[end - start];

		while (i < mid && j < end) {
			tempArr[tempIndex++] = num[i] <= num[j] ? num[i++] : num[j++];
		}

		// process the remaining items
		System.arraycopy(num, i, num, tempIndex + start, mid - i);
		System.arraycopy(tempArr, 0, num, start, tempIndex);
	}
}
