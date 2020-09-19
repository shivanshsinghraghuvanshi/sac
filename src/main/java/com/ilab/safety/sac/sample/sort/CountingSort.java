package com.ilab.safety.sac.sample.sort;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Comparator;

public class CountingSort {
	public static void main(String[] args) {
		String[] s = new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
		// sort(num, 30);

		String[] q = reorderLogFiles(s);
		for (String i : q) {
			System.out.println(i);
		}
	}

	public static void sort(int input[], int bound) {
		int[] counting = new int[bound + 1];
		for (int i = 0; i < input.length; i++) {
			counting[input[i]]++;
		}
		int index = 0;
		for (int j = 0; j <= bound; j++) {
			if (counting[j] > 0) {
				input[index++] = j;
				counting[j]--;
			}
		}
	}

	public static String[] reorderLogFiles(String[] logs) {
		Comparator<String> myComp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String[] split1 = o1.split(" ", 2);
				String[] split2 = o2.split(" ", 2);
				boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
				boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
				if (!isDigit1 && !isDigit2) {
					int cmp = split1[1].compareTo(split2[1]);
					if (cmp != 0)
						return cmp;
					// logs of same content, compare the identifiers
					return split1[0].compareTo(split2[0]);
				}
				if (!isDigit1 && isDigit2)
					// the letter-log comes before digit-logs
					return -1;
				else if (isDigit1 && !isDigit2)
					return 1;
				else
					// case 3). both logs are digit-log
					return 0;
			}
		};

		Arrays.sort(logs, myComp);
		return logs;
	}

	public static boolean isNumeric(String str) {
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}
}
