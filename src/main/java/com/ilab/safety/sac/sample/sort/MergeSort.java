package com.ilab.safety.sac.sample.sort;

public class MergeSort {
	public static void main(String[] args) {
		int[] num = new int[] { 20, -15, 35, 35, 1, 5, -22 };
		mergeSort(num, 0, num.length);
		for (int i : num) {
			System.out.println(i);
		}
	}

	public static void mergeSort(int[] input, int start, int end) {
		int mid = (start + end) / 2;

		// exit condtion
		if (end - start < 2) {
			return;
		}
		// call the recursion to manage left and rightside

		mergeSort(input, start, mid);
		mergeSort(input, mid, end);
		sort(input, start, mid, end);
	}

	public static void sort(int[] input, int start, int mid, int end) {
		// check the exit condition
		if (input[mid - 1] <= input[mid]) {
			return;
		}

		int i = start, j = mid, tempIndex = 0;
		int[] tempArray = new int[end - start];

		while (i < mid && j < end) {
			tempArray[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
		}

		// Copy the remaining items
		System.arraycopy(input, i, input, tempIndex + start, mid - i);
		// Make the temp array copy to input array

		System.arraycopy(tempArray, 0, input, start, tempIndex);
	}
}
