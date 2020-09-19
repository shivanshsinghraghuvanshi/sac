package com.ilab.safety.sac.sample.sort;

public class InsertionSort {
	public static void main(String[] args) {
		int[] num = new int[] { 20, -15, 35, 35, 1, 5, -22 };
		// int sortIndex = 1;
		for (int sortIndex = 1; sortIndex < num.length; sortIndex++) {
			int tempValue = num[sortIndex];
			int i;
			for (i = sortIndex; i > 0; i--) {
				if (tempValue < num[i - 1]) {
					num[i] = num[i - 1];
				}
			}
			num[i] = tempValue;
		}
		// Show the result
		for (int x : num) {
			System.out.println(x);
		}
	}
}
