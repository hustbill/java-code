/*
 * 109. Convert Sorted List to Binary Search Tree My Submissions QuestionEditorial Solution
Total Accepted: 70639 Total Submissions: 230681 Difficulty: Medium
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Hide Company Tags Zenefits
Hide Tags Depth-first Search Linked List
Hide Similar Problems (M) Convert Sorted Array to Binary Search Tree

https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ConvertSortedListToBST_109 {
	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */
	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	private static ListNode node;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		ListNode head = new ListNode(nums[0]);
		for (int i : nums) {
			head.next = new ListNode(i);
		}
		
		TreeNode result = sortedListToBST(head);
	
		
		//System.out.print(head);
		levelOrderPrint(result);
	
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


	public static TreeNode sortedListToBST(ListNode head) {
		// ref:
		// https://leetcode.com/discuss/23676/share-my-o-1-space-and-o-n-time-java-code
		if (head == null) {
			return null;
		}

		ListNode runner = head;
		node = head;
		int size = 0;
		while (runner != null) {
			size++;
			runner = runner.next;
		}
		return inorderHelper(0, size - 1);
	}

	public static TreeNode inorderHelper(int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;

		TreeNode left = inorderHelper(start, mid - 1);
		TreeNode treeNode = new TreeNode(node.val);
		treeNode.left = left;
		node = node.next;

		TreeNode right = inorderHelper(mid + 1, end);
		treeNode.right = right;

		return treeNode;
	}
}
