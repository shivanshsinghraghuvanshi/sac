package com.ilab.safety.sac.revision;

public class BubbleSort {
	public static void main(String[] args) {
		int[] num = new int[] { 3, 6, 1, 2, 11, 5, 7, 7, 9, 13, 19, 17 };
		sort(num);
	}

	public static void sort(int[] num) {
		int sortIndex = num.length;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < sortIndex - 1; j++) {
				if (num[j] > num[j + 1]) {
					int temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}
			sortIndex--;
		}
		for (int i : num) {
			System.out.print(i + " ->");
		}
	}
}
