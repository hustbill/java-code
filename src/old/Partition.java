package old;
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
        // Ref1: https://leetcode.com/discuss/21032/very-concise-one-pass-solution
        // Ref2: https://leetcode.com/discuss/22895/concise-java-code-with-explanation-one-pass
        /*the basic idea is to maintain two queues, the first one stores all nodes with val 
            less than x , and the second queue stores all the rest nodes. 
            Then concat these two queues. Remember to set the tail of second queue a null next, 
            or u will get TLE.
            */
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode p1 = node1;
        ListNode p2 = node2;
        
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next; 
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = null; //important! avoid cycle in linked list. otherwise u will get TLE.
        p1.next = node2.next;
        return node1.next;
    }

    public static void main(String[] args) {
        int[] A = { 1, 4, 3, 2, 5, 2};
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        for (int i : A) {
              p.next = new ListNode(i);
              p = p.next;
        }
        
        ListNode result = partition(head.next, 3);
        printListNode(result);
        
    }
    
    private static void printListNode( ListNode head) {
        while (head != null) {
            System.out.print ( head.val + " -> " );
            head = head.next;
        }
    }
}

