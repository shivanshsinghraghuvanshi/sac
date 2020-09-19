package com.ilab.safety.sac.sample.sort;

public class SelectionSort {
	public static void main(String[] args) {
		int[] num = new int[] { 20, -15, 7, 35, 1, 5, -22 };
		int sortIndex = num.length;

		for (int j = 0; j < num.length; j++) {
			int largestIndex = 0;
			for (int i = 1; i < sortIndex; i++) {
				if (num[i] > num[largestIndex]) {
					largestIndex = i;
				}
			}
			int temp = num[largestIndex];
			num[largestIndex] = num[sortIndex - 1];
			num[sortIndex - 1] = temp;

			// decrese the unsorted partition
			sortIndex--;
		}
		// Show the result
		for (int i : num) {
			System.out.println(i);
		}
	}
}
