package com.ilab.safety.sac.revision;

public class BstTester {

	public boo
}

class TreeNode {
	public int data;
	public TreeNode leftChiNode;
	public TreeNode rightChiNode;

	public TreeNode(int value) {
		this.data = value;
	}

	public void insert(int value) {
		if (value == data) {
			return;
		}
		if (value < data) {
			if (leftChiNode == null) {
				leftChiNode = new TreeNode(value);
			} else {
				leftChiNode.insert(value);
			}
		} else {
			if (rightChiNode == null) {
				rightChiNode = new TreeNode(value);
			} else {
				rightChiNode.insert(value);
			}
		}
	}

	public void inorderTraversal() {
		if (leftChiNode != null) {
			leftChiNode.inorderTraversal();
		}
		System.out.print(data + " : ");

		if (rightChiNode != null) {
			rightChiNode.inorderTraversal();
		}
	}
}

class BST {
	private TreeNode root;

	public void insert(int value) {
		if (root == null) {
			root = new TreeNode(value);
		} else {
			root.insert(value);
		}
	}

	public void traverseInorder() {
		if (root == null)
			return;
		root.inorderTraversal();
	}
}