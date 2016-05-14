package com.hustbill;

// Java program to connect nodes at same level 
// NimbleRx coding question 
// Date: 2016-05-12

// A binary tree node
class Node {

	int val;
	Node left, right, next;

	Node(int item) {
		val = item;
		left = null;
		right = null;
		next = null;
	}
}

public class ConnectedTree {

	static Node root;

	// set the next of root and calls helper recursively for other nodes
	void connectNodes(Node p) {
		p.next = null; // Set the next for root

		// recursively set the next for rest of the nodes
		helper(p);
	}

	// set next of all descendants of p.
	public void helper(Node p) {

		if (p == null) {
			return;
		}

		if (p.left != null) {
			p.left.next = p.right;
		}

		// set the next node for p's right child
		if (p.right != null) {
			if (p.next != null) {
				p.right.next = p.next.left;
			} else {
				p.right.next = null; // if p is the right most child at its
										// level
			}
		}

		// Set next for other nodes
		helper(p.left);
		helper(p.right);
	}

	public static void main(String args[]) {
		ConnectedTree tree = new ConnectedTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(4);
		
		tree.root.right.left = new Node(7);
		tree.root.right.right = new Node(3);

		// set next nodes in all nodes
		tree.connectNodes(root);

		// Let us check the values of next nodes
		System.out.println("Check the next node in the ConnecteTree " );
		System.out.println("Print -1 if there is no next node :\n");
		
		int rootNext = root.next != null ? root.next.val : -1;
		System.out.println("next of " + root.val + " is " + rootNext);

		int leftNext = root.left.next != null ? root.left.next.val : -1;
		System.out.println("next of " + root.left.val + " is " + leftNext);

		int rightNext = root.right.next != null ? root.right.next.val : -1;
		System.out.println("next of " + root.right.val + " is " + rightNext);
		
		int leftLeftNext = root.left.left.next != null ? root.left.left.next.val : -1;
		System.out.println("next of " + root.left.left.val + " is " + leftLeftNext);  //4
		
		int leftRightNext = root.left.right.next != null ? root.left.right.next.val : -1;
		System.out.println("next of " + root.right.right.val + " is " + leftRightNext);  //7
		

	}

}
