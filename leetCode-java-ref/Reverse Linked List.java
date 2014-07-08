/* Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL*/

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode preM=new ListNode(0);
        for(int i=1;i<=n;++i){
            if(i==m){
                preM=pre;
            }
            if(i>m){
                pre.next=head.next;
                head.next=preM.next;
                preM.next=head;
                head=pre;
            }
            pre=head;
            head=head.next;
        }
        return dummy.next;
    }
}
