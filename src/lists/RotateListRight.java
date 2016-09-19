package lists;

import java.util.*;

public class RotateListRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		RotateListRight rl = new RotateListRight();
		//rl.printList(head);
		int k = 2;
		System.out.println("after rotatation");
		ListNode result = rl.rotateRight(head, k);
		rl.printList(result);
	}
	
	private void printList(ListNode head) {
		System.out.println();
		while (head != null) {
			System.out.printf(" %d ", head.val);
			head = head.next;
		}
	}
	
	public ListNode rotateRight(ListNode head, int k) {
        /* Ref : https://leetcode.com/discuss/9533/share-my-java-solution-with-explanation
        Since n may be a large number compared to the length of list. So we need to know the length of linked list.After that, move the list after the (l-n%l )th node to the front to finish the rotation.

            So the code has three parts.
            1) Get the length
            2) Move to the (l-n%l)th node
            3)Do the rotation
            Ex: {1,2,3} k=2 Move the list after the 1st node to the front
            Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the front. */
        if (head == null || head.next == null) return head;
        
        int len = 0;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        
        while (fast.next != null) {   // get the length
            fast = fast.next;
            len++;
        }
         // move to the (len - k%len) th node
        for (int i=len - k%len; i> 0; i--) {
            slow = slow.next;
        }
        printList(slow);
        // Do the rotation
        fast.next = dummyHead.next;
        dummyHead.next = slow.next;  // Dummy: 0->2->3
        slow.next = null; //slow : 1-> null    dummy: 0->2->3->1->null
        return  dummyHead.next;
    }
}
