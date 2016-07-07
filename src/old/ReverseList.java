package old;
/*
206. Reverse Linked List My Submissions Question
Total Accepted: 89216 Total Submissions: 232012 Difficulty: Easy
Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?

Subscribe to see which companies asked this question

Hide Tags Linked List
Hide Similar Problems (M) Reverse Linked List II (M) Binary Tree Upside Down (E) Palindrome Linked List

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

//
//  ReverseList.java
//  java-code
//
//  Created by hua zhang on 2016-03-04.
//  Copyright 2016 hua zhang. All rights reserved.
//

public class ReverseList {
    /*
        head  |    head     newHead
    4 1 3 5   |    1 3 5     4
      1 3 5   |    3  5      1 4
        3 5   |    5         3 1 4
          5   |    null      5 3 1 4       
     https://leetcode.com/discuss/34474/in-place-iterative-and-recursive-java-solution
        
        */
    public static ListNode reverseList(ListNode head) {
        return reverseList_iterative_sol(head);
    }
    
    public static ListNode reverseList_iterative_sol(ListNode head) {
        ListNode newHead = null;
           while(head != null){
               ListNode next = head.next;
               head.next = newHead;
               newHead = head;
               head = next;
           }
           return newHead;
    }
    
    private ListNode reverseList_recursive_sol(ListNode head) {
           return helper(head, null);
       }
    
       private ListNode helper(ListNode head, ListNode newHead) {
           if (head == null) 
               return newHead;
           ListNode next = head.next;
           head.next = newHead;
           return helper(next, head);
       }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = forth;
  
       printNode(head); 
        
       
        System.out.println();
        printNode(reverseList(head));
    }
    
    private static void printNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}