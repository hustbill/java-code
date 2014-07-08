/* Sort a linked list in O(n log n) time using constant space complexity.*/

/* The time complexity for insert sort is O(n2), the time complexity for quick sort, merge sort, and heap sort is O(nlogn).
The method below use the merge sort.*/

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
    public ListNode sortList(ListNode head) {
        if(null==head || null==head.next)
            return head;
        ListNode fast=head,slow=head;
        while(null!=fast.next && null!=fast.next.next){
            fast=fast.next.next;
            slow=slow.next;
        }
        fast=slow;
        slow=slow.next;
        fast.next=null;
        fast=sortList(head);
        slow=sortList(slow);
        return merge(fast,slow);
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode iter1=l1, iter2=l2, head=null,tail=null;
        int num=0;
        while(null!=iter1 || null!=iter2){
            int num1= null==iter1? Integer.MAX_VALUE:iter1.val;
            int num2= null==iter2? Integer.MAX_VALUE:iter2.val;
            if(num1<num2){
                num=num1;
                iter1= null==iter1?null:iter1.next;
            }
            else{
                num=num2;
                iter2= null==iter2?null:iter2.next;
            }
            if(null==head){
                head=new ListNode(num);
                tail=head;
            }
            else{
                tail.next=new ListNode(num);
                tail=tail.next;
            }
        }
        return head;
    }
} 
