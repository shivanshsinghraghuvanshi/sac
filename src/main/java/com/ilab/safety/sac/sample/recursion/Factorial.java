package com.ilab.safety.sac.sample.recursion;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(fact(2));
	}

	public static int fact(int num) {
		if (num == 0) {
			return 1;
		}
		return num * fact(num - 1);
	}
}
