package com.ilab.safety.sac.leetcode;

import java.util.ArrayList;
import java.util.List;

class MinStack {

	/** initialize your data structure here. */
	List<Pair<Integer, Integer>> stackList;

	public MinStack() {
		stackList = new ArrayList<>();
	}

	public void push(int x) {
		if (stackList.isEmpty()) {
			stackList.add(new Pair<Integer, Integer>(x, x));
		} else {
			Pair<Integer, Integer> lastEntry = stackList.get(stackList.size() - 1);
			int minimum = (lastEntry.min < x) ? lastEntry.min : x;
			stackList.add(new Pair<Integer, Integer>(x, minimum));
		}
	}

	public void pop() {
		stackList.remove(stackList.size() - 1);
	}

	public int top() {
		Pair<Integer, Integer> lastEntry = stackList.get(stackList.size() - 1);
		return lastEntry.elem;
	}

	public int getMin() {
		Pair<Integer, Integer> lastEntry = stackList.get(stackList.size() - 1);
		return lastEntry.min;
	}
}

class Pair<T, U> {
	public T elem;
	public U min;

	public Pair(T elem, U min) {
		this.elem = elem;
		this.min = min;
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
