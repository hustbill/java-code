/* Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. */

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
    public ListNode partition(ListNode head, int x) {
        ListNode lessThan=new ListNode(0);
        ListNode gtThan=new ListNode(x);
        ListNode lessCur=lessThan,gtCur=gtThan,cur=head;
        while(null!=cur){
            if(cur.val<x){
                lessCur.next=cur;
                lessCur=lessCur.next;
            }
            else{
                gtCur.next=cur;
                gtCur=gtCur.next;
            }
            cur=cur.next;
        }
        lessCur.next=gtThan.next;
        gtCur.next=null;
        return lessThan.next;
    }
}
