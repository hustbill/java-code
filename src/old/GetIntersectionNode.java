package old;
/*
160. Intersection of Two Linked Lists
Total Accepted: 58252 Total Submissions: 194579 Difficulty: Easy
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/


import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class GetIntersectionNode {
    private static int length(ListNode node) {
        int length = 0;
        while(node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
     public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         /* https://leetcode.com/discuss/17177/concise-java-solution-o-1-memory-o-n-time
            1, Get the length of the two lists.
            2, Align them to the same start point.
            3, Move them together until finding the intersection point, or the end null
             */
         int lenA = length(headA), lenB = length(headB);
         // move headA and headB to the same start point 
         while (lenA > lenB) {
             headA = headA.next;
             lenA--;
         }
         while (lenA < lenB) {
             headB = headB.next;
             lenB--;
         }
         // find the intersection until end
         while (headA != headB) {
             headA = headA.next;
             headB = headB.next;
         }
         return headA;
     }
    
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        /* https://leetcode.com/discuss/66203/java-solution-without-knowing-the-difference-in-len
I found most solutions here preprocess linkedlists to get the difference in len.
             Actually we don't care about the "value" of difference, 
            we just want to make sure two pointers reach the intersection node at the same time.

   We can use two iterations to do that. In the first iteration,
             we will reset the pointer of one linkedlist to the head of another linkedlist 
            after it reaches the tail node. In the second iteration, we will move two pointers
             until they points to the same node. Our operations in first iteration will help us 
            counteract the difference. So if two linkedlist intersects, 
            the meeting point in second iteration must be the intersection point. 
            If the two linked lists have no intersection at all,
             then the meeting pointer in second iteration must be the tail node of both lists,
             which is null
            */
        // boundary check
        if( headA == null || headB== null) {
            return null;
        }
        
        ListNode p1 = headA;
        ListNode p2 = headB;
        
    
        //if p1 & p2 have different len, then we will stop the loop after second iteration
        while (p1 != p2) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }


   public static void main(String[] args) {
       int[] A = { 1, 3,  5, 7};
       int[] B = {2,  3,  5, 7};
       int[] C = { 16, 19, 21};
       int[] D = {5, 7, 8};
       
       ListNode head = new ListNode(0);
       ListNode p = head;
       
       for (int i : A) {
             p.next = new ListNode(i);
             p = p.next;
       }
       
       ListNode l1 = head.next;
       printListNode(l1);
       
       System.out.println();
       
       ListNode head2 = new ListNode(0);
       ListNode p2 = head2;
       for (int i : B) {
             p2.next = new ListNode(i);
             p2 = p2.next;
       }
       
       ListNode l2 = head2.next;
       printListNode(l2);

       ListNode l3 = getIntersectionNode(l1, l2);
       System.out.println("\nl3 = ");
       printListNode(l3);
           
           
   }
   
   private static void printListNode( ListNode head) {
       while (head != null) {
           System.out.print ( head.val + " -> " );
           head = head.next;
       }
   }
}