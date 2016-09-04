package lists;

import java.util.*;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderList rl = new ReorderList();
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		head.next = second;
		ListNode three = new ListNode(3);
		second.next = three;
		
		ListNode four = new ListNode(4);
		three.next = four;
		rl.printList(head);
		
		ListNode reverseList = rl.reverseList(head);
		System.out.println();
		rl.printList(reverseList);
		//rl.reorderList(head);
		//rl.printList(head);
		
	}
	private void printList(ListNode head) {
		while (head != null) {
			System.out.printf(" %d ", head.val);
			head = head.next;
		}

	}
	
	 public void reorderList(ListNode head) {
	        ListNode dummyHead = new ListNode(0);
	        dummyHead.next = head;
	        
	        ListNode p = head;
	        ListNode p1 = head;
	        
	        int length = 0;
	        while (p != null) {
	            p = p.next;
	            length++;
	        }
	        System.out.println("length = " + length);
	        ListNode l1 = head;
            ListNode l2 = head;
            
	        if (length % 2 == 0) {  // 1, 2, 3, 4
	            // merge 1->2  and 3->4
	            for (int i = 0; i < length /2 ; i++) {
	            	l1 = l1.next;	
	            }
	            
	        }
	        System.out.println();
	        reverseList(l1);
	        printList(l1);
	        for (int i =0; i < length/2; i++) {
	        	
	        }
	        System.out.println();
	        head = l1;
	        
	    }
	
	 
	 public ListNode reverseList(ListNode head) {
		 /*
	        head  |    head     newHead
	    4 1 3 5   |    1 3 5     4
	      1 3 5   |    3  5      1 4
	        3 5   |    5         3 1 4
	          5   |    null      5 3 1 4       
	     https://leetcode.com/discuss/34474/in-place-iterative-and-recursive-java-solution
	        
	        */
	        ListNode newHead = null;
	        
	        while (head !=null) {
	            ListNode next = head.next;
	            head.next = newHead;
	            newHead = head;
	            head = next;
	        }
	        return newHead;
	    }

}
