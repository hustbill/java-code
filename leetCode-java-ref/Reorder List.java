/* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.*/

/* Three steps to solve the question:
1. divide the list into half
2. reverse the second half
3. merge first and reversed second half.*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(null==head || null==head.next)
            return ;
        /*divide the list*/
        ListNode fast=head,slow=head;
        while(null!=fast.next && null!=fast.next.next){
            fast=fast.next.next;
            slow=slow.next;
        }
        /*reverse the second half*/
        ListNode pre=slow.next;
        ListNode cur=pre.next;
        slow.next=null;
        pre.next=null;
        while(null!=cur){
            ListNode tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        ListNode second=pre,first=head;
        while(null!=second){
            ListNode tmp=second.next;
            second.next=first.next;
            first.next=second;
            first=second.next;
            second=tmp;
        }
    }
}
