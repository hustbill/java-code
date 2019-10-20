/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (49.38%)
 * Total Accepted:    715.5K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * <p>Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.</p>
 * 
 * <p><b>Example:</b>
 * <pre>
 * <b>Input:</b> 1->2->4, 1->3->4
 * <b>Output:</b> 1->1->2->3->4->4
 * </pre>
 * </p>
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
      public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }

        p.next = l1 != null ? l1 : l2;
        return dummy.next;
    }  
}
