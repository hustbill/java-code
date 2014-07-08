/* Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. */

/* In most of list questions, we will use two pointers to record the index of listnode, sometimes we need three pointers
to do that. */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(null==head || null==head.next)
            return head;
        ListNode pre=head;
        ListNode cur=pre.next;
        while(null!=cur){
            if(cur.val == pre.val){
                pre.next=cur.next;
                cur=pre.next;
            }
            else{
                pre=cur;
                cur=cur.next;
            }
        }
        return head;
    }
}

/* Follow up: Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.*/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        while(null!=pre.next){
            ListNode cur=pre.next;
            while(null!=cur.next && cur.val==cur.next.val){
                cur=cur.next;
            }
            if(cur!=pre.next){
                pre.next=cur.next;
            }
            else{
                pre=pre.next;
            }
        }
        return dummy.next;
    }
}


