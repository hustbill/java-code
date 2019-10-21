/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (32.71%)
 * Likes:    1148
 * Dislikes: 81
 * Total Accepted:    177.5K
 * Total Submissions: 541.7K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode right = slow;
        ListNode reversedRight = reverseList(right);
        ListNode left = head;
        
        head = mergeTwoList(left, reversedRight);
    }

    publiv ListNode mergeTwoList(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(0);
        dummy.next = p1;

        while (p2 != null) {
            p = new ListNode(p1.val);
            p.next = new ListNode(p2.val);
            p2 = p2.next;
            p1 = p1.next;
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p = head;       

        while (p != null && p2 != null) {
            p = p.next;
            p1.next = p2.next;
            p2.next = prev.next;
            prev.next = p2;
            p2 = p1.next;
        }
        return prev.next;
    }
}
// @lc code=end

