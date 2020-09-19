package com.ilab.safety.sac.sample.datastructure;

public class BSTTester {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(25);
		tree.insert(1);
		tree.insert(17);
		tree.insert(99);
		tree.insert(22);
		tree.insert(37);
		tree.insert(3);
		tree.insert(78);
		tree.insert(82);

		tree.inorderTraversal();
		System.out.println();

		// System.out.println(tree.get(99).getValue());

		// System.out.println(tree.min());
		// System.out.println(tree.max());
		tree.delete(22);

		tree.inorderTraversal();
	}
}

class BinaryTree {
	private TreeNode root;

	public void insert(int value) {
		if (root != null) {
			root.insert(value);
		} else {
			root = new TreeNode(value);
		}
	}

	public void inorderTraversal() {
		if (root != null) {
			root.inorderTraversal();
		}
	}

	public TreeNode get(int value) {
		if (root != null) {
			return root.get(value);
		}
		return null;
	}

	public int min() {
		if (root != null) {
			return root.min();
		} else {
			return Integer.MIN_VALUE;
		}
	}

	public int max() {
		if (root != null) {
			return root.max();
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public void delete(int value) {
		root = delete(root, value);
	}

	private TreeNode delete(TreeNode subRoot, int value) {
		if (subRoot == null) {
			return subRoot;
		}

		if (value < subRoot.getValue()) {
			subRoot.setLeftNode(delete(subRoot.getLeftNode(), value));
		} else if (value > subRoot.getValue()) {
			subRoot.setRightNode(delete(subRoot.getRightNode(), value));
		} else {

			if (subRoot.getLeftNode() == null) {
				return subRoot.getRightNode();
			} else if (subRoot.getRightNode() == null) {
				return subRoot.getLeftNode();
			} // else {
			subRoot.setValue(subRoot.getRightNode().min());
			subRoot.setRightNode(delete(subRoot.getRightNode(), subRoot.getValue()));
			// }
		}
		return subRoot;
	}
}

class TreeNode {
	private int data;
	private TreeNode leftNode;
	private TreeNode rightNode;

	public TreeNode(int value) {
		this.data = value;
	}

	// insert the node
	public void insert(int value) {
		// ignore duplicate values
		if (value == data) {
			return;
		}
		if (value < data) {
			if (leftNode != null) {
				leftNode.insert(value);
			} else {
				leftNode = new TreeNode(value);
			}
		} else {
			if (rightNode != null) {
				rightNode.insert(value);
			} else {
				rightNode = new TreeNode(value);
			}
		}
	}

	// Inorder Traversal
	public void inorderTraversal() {
		if (leftNode != null) {
			leftNode.inorderTraversal();
		}
		System.out.print(data + " ");
		if (rightNode != null) {
			rightNode.inorderTraversal();
		}
	}

	// get Node
	public TreeNode get(int value) {
		if (value == data) {
			return this;
		}
		if (value < data) {
			if (leftNode != null) {
				return leftNode.get(value);
			}
		} else {
			if (rightNode != null) {
				return rightNode.get(value);
			}
		}
		return null;
	}

	// min of tree
	public int min() {
		if (leftNode != null) {
			return leftNode.min();
		} else {
			return data;
		}
	}

	// max of tree
	public int max() {
		if (rightNode != null) {
			return rightNode.max();
		} else {
			return data;
		}
	}

	public int getValue() {
		return data;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public TreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public void setValue(int data) {
		this.data = data;
	}
}


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

	public String rserialize(TreeNode root, String str) {
		// Recursive serialization.
		if (root == null) {
			str += "null,";
		} else {
			str += str.valueOf(root.val) + ",";
			str = rserialize(root.left, str);
			str = rserialize(root.right, str);
		}
		return str;
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return rserialize(root, "");
	}

	public TreeNode rdeserialize(List<String> l) {
		// Recursive deserialization.
		if (l.get(0).equals("null")) {
			l.remove(0);
			return null;
		}

		TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
		l.remove(0);
		root.left = rdeserialize(l);
		root.right = rdeserialize(l);

		return root;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] data_array = data.split(",");
		List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
		return rdeserialize(data_list);
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));