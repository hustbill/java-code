/*
 * 234. Palindrome Linked List  QuestionEditorial Solution  My Submissions
Total Accepted: 55152
Total Submissions: 188771
Difficulty: Easy
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

Hide Company Tags Amazon Facebook
Hide Tags Linked List Two Pointers
Hide Similar Problems (E) Palindrome Number (E) Valid Palindrome (E) Reverse Linked List

 */
package lists;

public class PalindromeLinkedList {
    /*
   This can be solved by reversing the 2nd half and compare the two halves. Let's start with an example [1, 1, 2, 1].
   
   In the beginning, set two pointers fast and slow starting at the head.
   
   1 -> 1 -> 2 -> 1 -> null 
   sf
   (1) Move: fast pointer goes to the end, and slow goes to the middle.
   
   1 -> 1 -> 2 -> 1 -> null 
             s          f
   (2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.
   
   1 -> 1    null <- 2 <- 1           
   h                      s
   (3) Compare: run the two pointers head and slow together and compare.
   
   1 -> 1    null <- 2 <- 1             
        h            s
   In this end, check if slow == null. For this example, since slow != null, return false.
   */

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
		PalindromeLinkedList pl = new PalindromeLinkedList();
		ListNode head = new ListNode(1);
		ListNode next = new ListNode(2);
		head.next = next;
		next.next = new ListNode(1);
		
		System.out.println(pl.isPalindrome(head));

	}

}
