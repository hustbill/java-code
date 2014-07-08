/* Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL. */

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
    public ListNode rotateRight(ListNode head, int n) {
        if(null==head || null==head.next)
            return head;
        int length=0,i=0;
        ListNode fast=head,slow=head,tmp=head;
        while(null!=tmp){
            length++;
            tmp=tmp.next;
        }
        n=n%length;
        for(;i<n;++i){
            fast=fast.next;
        }
        for(;i<length-1;++i){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=head;
        head=slow.next;
        slow.next=null;
        return head;
    }
}
