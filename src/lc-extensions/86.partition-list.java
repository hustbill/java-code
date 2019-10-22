/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (38.70%)
 * Likes:    843
 * Dislikes: 226
 * Total Accepted:    182.2K
 * Total Submissions: 470.2K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        //dummy heads of the 1st and 2nd queues
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);  
        //current tails of the two queues;      
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = curr1.next;
            } else {
                curr2.next = head;
                curr2 = curr2.next;
            }
            head = head.next;
        }
        //important! avoid cycle in linked list. otherwise u will get TLE.
        curr2.next = null;  
        // For this list: 5->6->1->2, x=3, at last cur2 points to 6, 
        //cur1 points to 2, we must set 6->1 to 6->null, otherwise there will be a cycle.
        // concat two lists
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
// @lc code=end

