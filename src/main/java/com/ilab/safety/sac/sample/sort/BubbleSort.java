package com.ilab.safety.sac.sample.sort;

public class BubbleSort {
	public static void main(String[] args) {
		int[] num = new int[] { 20, -15, 35, 35, 1, 5, -22 };
		int sortIndex = num.length;
		int startIndex = 0;
		for (int j = 0; j < num.length; j++) {
			for (int i = startIndex; i < sortIndex - 1; i++) {
				if (num[i] > num[i + 1]) {
					int temp = num[i];
					num[i] = num[i + 1];
					num[i + 1] = temp;
				}
			}
			sortIndex--;
		}

		// Show the result
		for (int i : num) {
			System.out.println(i);
		}

	}
}
