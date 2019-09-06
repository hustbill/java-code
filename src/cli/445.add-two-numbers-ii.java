/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (50.94%)
 * Total Accepted:    104.1K
 * Total Submissions: 203.7K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the
 * lists is not allowed.
 * 
 * 
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
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
       // use two stacks, LIFO, don't need reverse l1 and l2
       Stack<Integer> s1 = new Stack<Integer>();
       Stack<Integer> s2 = new Stack<Integer>();

       while (l1 != null) {
           s1.push(l1.val);
           l1 = l1.next;
       }
       while (l2 != null) {
           s2.push(l2.val);
           l2 = l2.next;
       }
       
       int sum = 0;
      ListNode curr = new ListNode(0);
       //  start with 0, If need to update curr, then check if curr is modified to 1
       while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty())  sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            curr.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = curr;
            curr = head;
            sum /= 10;
       }
    
      return curr.val == 1 ? curr : curr.next; // check if curr is modified to 1, val == 1 means new node. 
    }
}
