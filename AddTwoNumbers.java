/*
Add Two Numbers

https://leetcode.com/problems/add-two-numbers/

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import java.util.*;

import java.util.LinkedList;

public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			int carry = 0;
			ListNode l = new ListNode(0) ;
			if(l1 == null)  l= l2;
			if(l2 == null)  l= l1;
			if (l1 != null && l2 != null) {
				 //System.out.println("l1.val=" + l1.val + " l2.val=" + l2.val );
				 if (l1.val + l2.val >=10 ) {
				 	l.val = l1.val + l2.val -10;
					 //System.out.println("elem=" + elem);
					 carry = 1;
					 l.next= addTwoNumbersWithCarry(l1.next, l2.next, carry);
					 //System.out.println("first");
			 } else {
				 	l.val = l1.val + l2.val;
			     	//System.out.println("l.val= " + l.val);
					 l.next = addTwoNumbers(l1.next, l2.next);
			 }
		 }
			 return l;
	    }
	
	    public  static ListNode addTwoNumbersWithCarry(ListNode l1, ListNode l2, int carry) {
			ListNode l = new ListNode(0) ;
			if (l1 == null && l2 == null) {
				l.val = carry;
				//l.next = new ListNode(1);
			}
			if (l1 == null & l2 != null) {
				if( l2.val + carry < 10) {
					l.val = l2.val + carry;
					l.next = addTwoNumbers(null, l2.next);
				} else {
					l.val = l2.val + carry -10;
					// append a new ListNode(1) to  the end of l2
					l.next = addTwoNumbersWithCarry(null, l2.next, carry);
				}
			}
			if( l1 != null && l2 == null ) {
				if(l1.val + carry < 10) {
					l.val = l1.val + carry;
					l.next = addTwoNumbers(l1.next, null);
				} else {
					l.val = l1.val + carry - 10;
					// append a new ListNode(1) to the end of l1
					l.next = addTwoNumbersWithCarry(l1.next, null, carry);
				}
			}
			if (l1 != null && l2 != null) {
				 //System.out.println("l1.val=" + l1.val + " l2.val=" + l2.val );
				if (l1.val + l2.val + carry >= 10) {
					l.val  = l1.val + l2.val + carry -10;
					//System.out.println("second");
					//System.out.println("l.val = " + l.val);
					l.next = addTwoNumbersWithCarry(l1.next, l2.next, carry);
				} else {
					l.val= l1.val + l2.val + carry;
					//System.out.println("third");
					//System.out.println("l.val = " + l.val);
					l.next  =  addTwoNumbers(l1.next, l2.next);
				}
			}
			return l;
	    }

   
	
	
	
	public static void main(String[] args) {
		/*
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(5);
		
		ListNode l3 = new ListNode(4);
		l1.next = l3;
		ListNode l5 = new ListNode(3);
		l3.next = l5;
		
		ListNode l4 = new ListNode(6);
		l2.next = l4;
		ListNode l6 = new ListNode(4);
		l4.next = l6;
		
		printList(l1);
		//System.out.println();
		printList(l2);
		//System.out.println("\nl =");
		ListNode l = addTwoNumbers(l1, l2);
		printList(l);
	  */
			/* 
		  ListNode l1 = new ListNode(5);
		  ListNode l2 = new ListNode(5);
		  
		  ListNode l = addTwoNumbers(l1, l2);
		  printList(l);
	    */
	  		  ListNode l1 = new ListNode(1);
	  		  ListNode l2 = new ListNode(9);
			  ListNode l3 = new ListNode(9);
			  l2.next = l3;
		  
	  		  ListNode l = addTwoNumbers(l1, l2);
	  		  printList(l);
				
	  
	}
	
	public static void printList(ListNode l) {
		if( l != null) {
  		 //System.out.print(l.val + "->");
		 l= l.next; 
		 printList(l);
	  }
	}
}



/**
 * Definition for singly-linked list.
  */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 