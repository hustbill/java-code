/*
 * 
 */
package lists;

import dfs.WildcardMatch;

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		if (head == null)
			return true;

		while (fast.next != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null)
			slow = slow.next;
		slow = reverse(slow);

		while (slow != null && head.val == slow.val) {
			head = head.next;
			slow = slow.next;
		}
		return slow == null;
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "xbylmz", p = "x?y*z";
		WildcardMatch wcm = new WildcardMatch();
	
		long start = System.nanoTime();
		System.out.println(wcm.isMatch(s, p));
		long end = System.nanoTime();
		System.out.println("time of two pointers sol: " + (end - start));
		
		long start2 = System.nanoTime();
		System.out.println(wcm.isMatch_2D(s, p));
		long end2 =  System.nanoTime();
		System.out.println("time of 2D table sol: " + (end2 - start2));

		// System.out.println(wcm.isMatchRecursive(s, p));

	}

//	public static void main(String[] args) {
//		PalindromLinkedList pl = new PalindromLinkedList();
//		ListNode head = new ListNode(1);
//		ListNode next = new ListNode(2);
//		head.next = next;
//		next.next = new ListNode(1);
//		
//		System.out.println(pl.isPalindrome(head));
//
//	}

}
