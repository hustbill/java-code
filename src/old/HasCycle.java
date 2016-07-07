package old;

import java.util.*;

public class HasCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(3);
		ListNode third = new ListNode(1);

		// head.next = second;
		// second.next = third;
		System.out.printf("Test case  %s \n", hasCycle(head) == true ? "success" : "failed");

	}

	public static boolean hasCycle(ListNode head) {
		/*
		 * 1. Use two pointers : fast and slow 2. slow moves step by step, fast
		 * moves two steps at time 3. if the Linked List has a cycle fast and
		 * slow will meet at some point Ref:
		 * https://leetcode.com/discuss/32906/o-1-space-solution
		 */
		if (head == null)
			return false;

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

	public static boolean hasCycle_hashtable(ListNode head) {
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		while (head != null) {
			if (ht.containsKey(head.val)) {
				int count = ht.get(head.val) + 1;
				ht.put(head.val, count);
			} else {
				ht.put(head.val, 1);
			}
			head = head.next;
		}

		for (int i : ht.values()) {
			if (i > 1) {
				return true;
			}
		}
		return false;
	}

}

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
