/* Sort a linked list using insertion sort.*/

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
    public ListNode insertionSortList(ListNode head) {
        if(null==head || null==head.next)
            return head;
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        ListNode l2=head;
        while(null!=l2){
            ListNode pre=findPlace(dummy,l2);
            ListNode orig=l2.next;
            l2.next=pre.next;
            pre.next=l2;
            l2=orig;
        }
        return dummy.next;
    }
    public ListNode findPlace(ListNode l1, ListNode l2){
        ListNode pre=null,cur=l1;
        while(null!=cur && cur.val<=l2.val){
            pre=cur;
            cur=cur.next;
        }
        return pre;
    }
}
