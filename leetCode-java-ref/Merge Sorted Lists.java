/* Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of 
the first two lists.*/

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=null,tail=null;
        ListNode iter1=l1,iter2=l2;
        int num=0;
        while(null!=iter1 || null!=iter2){
            int num1= null==iter1 ? Integer.MAX_VALUE : iter1.val;
            int num2= null==iter2? Integer.MAX_VALUE : iter2.val;
            if(num1<num2){
                num=num1;
                iter1 = null==iter1? null : iter1.next;
            }
            else{
                num=num2;
                iter2 = null==iter2? null : iter2.next;
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

/* Follow up: Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.*/

/* This is based on the first question, we can use merge sort. The run time complexity is O(nlgk), where n is the number
of the nodes in all lists and k is the number of nonempty lists. */

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int last=lists.size()-1;
        if(last<0)
            return null;
        while(last>0){
            int start=0;
            while(start<last){
                lists.set(start,merge2Lists(lists.get(start++),lists.get(last--)));
            }
        }
        return lists.get(0);
    }
}
