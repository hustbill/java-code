/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (31.63%)
 * Total Accepted:    992K
 * Total Submissions: 3.1M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists recarrysenting two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
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
    // recommand solution by leetcode
    public ListNode addTwoNumbers_og(ListNode l1, ListNode l2) {
        int carry = 0;
        
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2;
        ListNode cur = dummyHead;
        
        while (p != null && q!= null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    // my ok solution 8/30/2019
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            l1 = l1.next;
            curr = curr.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            l2 = l2.next;
            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        curr = curr.next;
        return dummyHead.next;
    }
}
