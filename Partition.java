/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
https://leetcode.com/problems/partition-list/
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}


public class Partition {
    public static ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead.next;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        int len = 0;
        while (fast.next != null) {
            fast = fast.next;
            len++;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] A = { 1, 4, 3, 2, 5, 2};
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        for (int i : A) {
              p.next = new ListNode(i);
              p = p.next;
        }
        
        if (head.next != null) {
            ListNode result = partition(head.next, 2);
            printListNode(result);
        }
        
        
       
    }
    
    private static void printListNode( ListNode head) {
        while (head.next != null) {
            System.out.print (" " + head.next.val);
            head = head.next;
        }
    }
}

