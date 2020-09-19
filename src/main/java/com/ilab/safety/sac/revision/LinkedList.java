package com.ilab.safety.sac.revision;

class LinkedList {

	private Node head;

	public void add(Node incoming) {
		Node node = new Node(incoming.data);
		node.next = head;
		head = node;
	}

	@Override
	public String toString() {
		return head.toString();
	}

	public void printList() {
		Node current = head;
		System.out.print("HEAD ->");
		while (current != null) {
			System.out.print(current + "->");
			current = current.next;
		}
	}

}

class Node {
	public int data;
	public Node next;

	public Node(int value) {
		this.data = value;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
}