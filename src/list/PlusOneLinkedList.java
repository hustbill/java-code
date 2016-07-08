/*
 * 369. Plus One Linked List  
Total Accepted: 1189
Total Submissions: 2373
Difficulty: Medium
Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
Hide Company Tags Google
Hide Tags Linked List
Hide Similar Problems (E) Plus One

 */
package list;

import java.util.Arrays;

public class PlusOneLinkedList {

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */

	public ListNode plusOne(ListNode head) {
		/*
		 * At the first glance, I want to reverse the inputs, add one, then
		 * reverse back. But that is too intuitive and I don't think this is an
		 * expected solution. Then what kind of alg would adding one in reverse
		 * way for list?
		 * 
		 * Recursion! With recursion, we can visit list in reverse way! So here is my
		 * recursive solution.
		 * https://discuss.leetcode.com/topic/49541/java-recursive-solution
		 */
		if (dfs(head) == 0) {
			return head;
		} else {
			ListNode newHead = new ListNode(1);
			newHead.next = head;
			return newHead;
		}
	}

	// Recursion solution
	public int dfs(ListNode head) {
		if (head == null)
			return 1;

		int carry = dfs(head.next);
		if (carry == 0)
			return 0;

		int val = head.val + 1;
		head.val = val % 10;
		return val / 10;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(9);
		ListNode next = new ListNode(9);
		head.next = next;
		next.next = new ListNode(9);
		PlusOneLinkedList pll = new PlusOneLinkedList();

		printLinkedList(head);
		ListNode newHead = pll.plusOne(head);

		printLinkedList(newHead);

	}

	public static void printLinkedList(ListNode head) {
		while (head != null) {
			if (head.next != null) {
				System.out.print(head.val + " -> ");
			} else {
				System.out.print(head.val + "\n");
			}
			head = head.next;
		}
	}

}
