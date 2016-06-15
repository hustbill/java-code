package v201605;

public class DetectCycleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode detectCycle(ListNode head) {
		/*
		 * https://leetcode.com/discuss/47292/java-o-1-space-solution-with-
		 * detailed-explanation Define two pointers slow and fast. Both start at
		 * head node, fast is twice as fast as slow. If it reaches the end it
		 * means there is no cycle, otherwise eventually it will eventually
		 * catch up to slow pointer somewhere in the cycle.
		 * 
		 * Let the distance from the first node to the the node where cycle
		 * begins be A, and let say the slow pointer travels travels A+B. The
		 * fast pointer must travel 2A+2B to catch up. The cycle size is N. Full
		 * cycle is also how much more fast pointer has traveled than slow
		 * pointer at meeting point.
		 * 
		 * A+B+N = 2A+2B N=A+B From our calculation slow pointer traveled
		 * exactly full cycle when it meets fast pointer, and since originally
		 * it travled A before starting on a cycle, it must travel A to reach
		 * the point where cycle begins! We can start another slow pointer at
		 * head node, and move both pointers until they meet at the beginning of
		 * a cycle.
		 */

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				ListNode slow2 = head;
				while (slow2 != slow) {
					slow2 = slow2.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}
}
