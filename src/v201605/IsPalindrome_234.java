package v201605;

/*
234. Palindrome Linked List

Total Accepted: 46880 Total Submissions: 166483 Difficulty: Easy
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

Hide Company Tags Amazon Facebook
Hide Tags Linked List Two Pointers
Hide Similar Problems (E) Palindrome Number (E) Valid Palindrome (E) Reverse Linked List
*/
/**
 * Definition for singly-linked list.
 */
//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode(int x) {
//		val = x;
//	}
//}
public class IsPalindrome_234 {
	public static void main(String[] args) {
		ListNode root  = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(1);
		
		System.out.println(isPalindrome(root));
	}
	
	public static boolean isPalindrome(ListNode head) {
		// ref"
		// https://leetcode.com/discuss/45656/easy-understand-java-solution-o-1-space-cost
		if (head == null) {
			return true;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		ListNode p3 = p1.next;
		ListNode pre = p1;
		// find mid pointer, and reverse head half part
		while (p2.next != null && p2.next.next != null) {
			p2 = p2.next.next;
			pre = p1;
			p1 = p3;
			p3 = p3.next;
			p1.next = pre;
		}

		// odd number of elements, need left move p1 one step
		if (p2.next == null) {
			p1 = p1.next;
		} else { // even number of elements, do nothing

		}
		// compare from mid to head/tail
		while (p3 != null) {
			if (p1.val != p3.val) {
				return false;
			}
			p1 = p1.next;
			p3 = p3.next;
		}
		return true;

	}
}
