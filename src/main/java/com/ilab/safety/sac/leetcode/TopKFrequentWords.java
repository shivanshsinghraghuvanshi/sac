package com.ilab.safety.sac.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class TopKFrequentWords {
	public static void main(String[] args) {
		// String[] nameArr = new String[] { "i", "love", "leetcode", "i", "love",
		// "coding" };
		// topKFrequent(nameArr, 2);
		String[] a = new String[] { "hit" };
		System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", a));
	}

	public ListNode mergeKLists(ListNode[] lists) {
		for (int i = 1; i < lists.length; i++) {
			lists[0] = mergeTwoLists(lists[0], lists[i]);
		}
		return lists[0];
	}

	public String mostCommonWord(String paragraph, String[] banned) {

		// 1). replace the punctuations with spaces,
		// and put all letters in lower case
		String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

		// 2). split the string into words
		String[] words = normalizedStr.split("\\s+");

		Set<String> bannedWords = new HashSet<>();
		for (String word : banned)
			bannedWords.add(word);

		Map<String, Integer> wordCount = new HashMap<>();
		// 3). count the appearance of each word, excluding the banned words
		for (String word : words) {
			if (!bannedWords.contains(word))
				wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}

		// 4). return the word with the highest frequency
		return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}

	}

	public static List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		for (String word : words) {
			if (!wordMap.containsKey(word)) {
				wordMap.put(word, 1);
			} else {
				Integer curr = wordMap.get(word);
				wordMap.put(word, ++curr);
			}
		}

		List<String> myList = new ArrayList<>(wordMap.keySet());
		Comparator<Entry<String, Integer>> myComp = new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}

		};
		Map<Integer, SimpleEntry<Integer, String>> x = new HashMap<>();
		x.put(1, new SimpleEntry<>(1, "shivansh"));

		SimpleEntry<Integer, String> pair = x.get(1);
		Integer id = pair.getKey();
		String name = pair.getValue();
		Collections.sort(myList, (w1, w2) -> wordMap.get(w1).equals(wordMap.get(w2)) ? w1.compareTo(w2)
				: wordMap.get(w2) - wordMap.get(w1));

		return myList.subList(0, k);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class LRUCache extends LinkedHashMap<Integer, Integer> {

	private int capacity;

	public LRUCache(int capacity) {
		super(capacity, 0.75F, true);
		this.capacity = capacity;
	}

	public int get(int key) {
		return super.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		super.put(key, value);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}
}
