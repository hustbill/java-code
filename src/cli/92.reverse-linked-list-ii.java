/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (35.80%)
 * Total Accepted:    219.1K
 * Total Submissions: 604.4K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);  // create a dummy head to mark the head of this list
        dummy.next = head;

        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing 

        for (int i = 0; i < m - 1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reverse 
        ListNode then = start.next;  // a pointer to a node that will be reversed

        // 1 - 2 - 3 - 4 - 5; m = 2, n = 4  --> pre = 1, start = 2, then = 3
        // dummy -> 1->2->3->4 -> 5 
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy-> 1 - 3 - 2 - 4 - 5; pre = 1, stat = 2, then = 4
        // second reversing: dummy-> 1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
        return dummy.next;
    }
}
