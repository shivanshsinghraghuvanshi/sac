package com.ilab.safety.sac.revision;

public class Tester {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(5);
		Node n3 = new Node(1);
		Node n4 = new Node(8);
		LinkedList ll = new LinkedList();
		ll.add(n1);
		ll.add(n2);
		ll.add(n3);
		ll.add(n4);
		ll.printList();
	}
}