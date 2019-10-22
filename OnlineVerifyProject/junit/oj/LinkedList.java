package oj;


import java.util.*;

public class LinkedList {
		public void reorderList(ListNode head) {
			if (head == null || head.next == null) 
				return;
			// step 1. cut the list to two halves
			// prev will be the tail of 1st half
			// slow will be the head of 2nd half
			ListNode prev = null, slow = head, fast = head, l1 = head;
			
			while (fast != null && fast.next != null) {
				prev = slow;
				slow = slow.next;
				fast = fast.next.next;
			}
			
			prev.next = null;
			
			// step 2. reverse the 2nd half
			ListNode l2 = reverse(slow);
			
			// step 3 merge the two halves
			merge(l1, l2);			
		}
		
		public ListNode reverse(ListNode head) {
			ListNode prev = null, curr = head, next = null;
			
			while (curr != null) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			
			return prev;
		}
	
	    public ListNode reverseList(ListNode head) {
	        ListNode prev = new ListNode(0);
	        prev.next = head;
	        ListNode p1 = head;
	        ListNode p2 = head.next;
	        ListNode p = head;       

	        while (p != null && p2 != null) {
	        	p = p.next;
	            p1.next = p2.next;
	            p2.next = prev.next;
	            prev.next = p2;
	            p2 = p1.next;
	        }
	        return prev.next;
	    }
	    
	    // merge
	    void merge(ListNode l1, ListNode l2) {
	    	while (l1 != null) {
	    		ListNode n1 = l1.next, n2 = l2.next;
	    		l1.next = l2;
	    		
	    		if (n1 == null)
	    			break;	    		
	    		l2.next = n1;
	    		l1 = n1;
	    		l2 = n2;	    		
	    	}
	    }
	    
	    // doesn't work
	    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
	        ListNode dummy = new ListNode(0);
	        dummy.next = p1;
	        ListNode p ;

	        while (p2 != null) {
	            p = new ListNode(p1.val);
	            p.next = new ListNode(p2.val);
	            p2 = p2.next;
	            p1 = p1.next;
	            p = p.next;
	        }
	        return dummy.next;
	    }
	 
	 
	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		head.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;
		ListNode five = new ListNode(5);
		four.next = five;
		five.next = new ListNode(6);
		
		
		LinkedList ts  = new LinkedList();
		ts.printList(head);
		System.out.println();
		
		ts.reorderList(head);
		ts.printList(head);
		
		
	}
	
	public void printList(ListNode head) {
		ListNode p = head;
		while (p != null) {
			System.out.printf( p.val + "->");
			p = p.next;
		}
	}
}

//Definition for singly-linked list.
class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
}
