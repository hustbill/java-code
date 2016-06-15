package tree;
/*
 * 108. Convert Sorted Array to Binary Search Tree My Submissions QuestionEditorial Solution
Total Accepted: 76395 Total Submissions: 203808 Difficulty: Medium
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

Hide Company Tags Airbnb
Hide Tags Tree Depth-first Search
Hide Similar Problems (M) Convert Sorted List to Binary Search Tree

https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class ConvertArrayToBST_108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		TreeNode head = sortedArrayToBST(nums);
		
		//System.out.print(head);
		levelOrderPrint(head);
	
	}
	
	//level order printing
	public static void levelOrderPrint(TreeNode root){
	    Queue<TreeNode> que = new LinkedList<TreeNode>();
	    TreeNode mark = new TreeNode(0);
	    if(root != null){
	        que.add(root);
	        que.add(mark);
	    }
	    while(!que.isEmpty()){
	    	TreeNode temp = que.poll();
	        if(temp != mark)
	        System.out.print(temp.val);
	        if(temp == mark){
	            if(que.peek() == mark || que.isEmpty()){
	                return;
	            }
	            que.add(mark);
	            System.out.println();
	        }
	        if(temp.left != null){
	            que.add(temp.left);
	        }
	        if(temp.right != null){
	            que.add(temp.right);
	        }
	    }
	}

	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */

	public static TreeNode sortedArrayToBST(int[] nums) {

		//return sortedArrayToBST_recursive(nums);
		return sortedArrayToBST_iterative(nums);
		
	}

	public static TreeNode sortedArrayToBST_iterative(int[] nums) {
		/*
		 * https://leetcode.com/discuss/36616/java-iterative-solution It is very
		 * similar to doing a tree inorder traversal, I use three stacks -
		 * nodeStack stores the node I am going to process next, and
		 * leftIndexStack and rightIndexStack store the range where this node
		 * need to read from the nums.
		 */
		if (nums == null || nums.length == 0)
			return null;

		TreeNode head = new TreeNode(0); // 0 as a placeholder

		Deque<TreeNode> nodeStack = new LinkedList<TreeNode>() {
			{
				push(head);
			}
		};
		Deque<Integer> leftIndexStack = new LinkedList<Integer>() {
			{
				push(0);
			}
		};
		Deque<Integer> rightIndexStack = new LinkedList<Integer>() {
			{
				push(nums.length - 1);
			}
		};

		while (!nodeStack.isEmpty()) {
			TreeNode currNode = nodeStack.pop();
			int left = leftIndexStack.pop();
			int right = rightIndexStack.pop();
			int mid = left + (right - left) / 2; // avoid overflow
			currNode.val = nums[mid];

			if (left <= mid - 1) {
				currNode.left = new TreeNode(0);
				nodeStack.push(currNode.left);
				leftIndexStack.push(left);
				rightIndexStack.push(mid - 1);
			}

			if (mid + 1 <= right) {
				currNode.right = new TreeNode(0);
				nodeStack.push(currNode.right);
				leftIndexStack.push(mid + 1);
				rightIndexStack.push(right);
			}
		}
		return head;
	}

	public static TreeNode sortedArrayToBST_recursive(int[] nums) {
		/*
		 * refer to ctci 1. Insert into the tree the midle elment of the array
		 * 2. Insert (into the left subtree) the left subarray elements 3.
		 * Insert (into the right substree) the right subarray elements
		 */

		return createBST(nums, 0, nums.length - 1);

	}

	public static TreeNode createBST(int[] nums, int start, int end) {
		if (end < start) {
			return null;
		}

		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);

		root.left = createBST(nums, start, mid - 1);
		root.right = createBST(nums, mid + 1, end);

		return root;
	}

}
