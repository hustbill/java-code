package old;
/*24. Swap Nodes in Pairs
Total Accepted: 80031 Total Submissions: 234004 Difficulty: Medium
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

Hide Company Tags Microsoft Bloomberg
Hide Tags Linked List
Hide Similar Problems (H) Reverse Nodes in k-Group

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapPairs {
    public static void main(String[] args) {
        
    }
    
    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode newhead = new ListNode(-1);//dummy
        newhead.next = head;
        ListNode temp = newhead;

        ListNode one = null;
        ListNode two = null;

        // {dummy->1->2->3->4->null}
        //explanation for one loop rest are same.


        while(temp.next!= null && temp.next.next!=null) {
            // temp points to dummy in the beginning.
            // one -> 1
            one = temp.next;
            //two -> 2
            two = temp.next.next;
            // 1-> = 2.next = 3;
            one.next=two.next;
            // 2-> = 1
            two.next = one;
            //now dummy should point to 2
            //if the below is not done dummy->1;
            temp.next = two;
            // temp was pointing to dummy
            //temp->1 
            temp = one;

            // now { dummy->2->1->3->4 } 

        }
        return newhead.next;
    }
    
    public ListNode swapPairs(ListNode head) {
        // https://leetcode.com/discuss/29123/my-simple-java-solution-for-share
        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        
        ListNode current = dummy;
        
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        
        return dummy.next;
        
    }
}