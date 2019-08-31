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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        
        ListNode ans = new ListNode(0);
        ListNode p = ans;
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if (sum >= 10) {
                ans.next = new ListNode(sum - 10);
                carry = 1;
            } else {
                ans.next = new ListNode(sum);
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            ans = ans.next;
        }
        
        while (l1 != null) {
            if (l1.val + carry >= 10) {
                ans.next = new ListNode(l1.val + carry - 10);
                carry = 1;
            } else {
                ans.next = new ListNode(l1.val + carry);
                carry = 0;
            }           
            l1 = l1.next;
            ans = ans.next;        
        }
        
        while (l2 != null) {
            if (l2.val + carry >= 10) {
                ans.next = new ListNode(l2.val + carry - 10);
                carry = 1;
            } else {
                ans.next = new ListNode(l2.val + carry);
                carry = 0;
            }
            
            l2 = l2.next;
            ans = ans.next;        
        }
        
        if (carry == 1) {
            ans.next = new ListNode(1);
             carry = 0;
        }
        ans = ans.next;
        return p.next;
    }
}
