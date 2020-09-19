package com.ilab.safety.sac.revision;

import java.util.LinkedList;
import java.util.List;

public class PalindromeTester {
	public static void main(String[] args) {

		System.out.println(Palindrome.testPalindrome("abccbae"));
	}
}

class Palindrome {
	public static boolean testPalindrome(String s) {

		String lowerCase = s.toLowerCase();

		LinkedList<Character> stack = new LinkedList<>();
		LinkedList<Character> queue = new LinkedList<>();

		for (char c : lowerCase.toCharArray()) {
			if (c >= 'a' && c <= 'x') {
				stack.push(c);
				queue.addLast(c);
			}
		}

		while (!stack.isEmpty()) {
			if (!stack.pop().equals(queue.remove()))
				return false;
		}

		return true;
	}
}
