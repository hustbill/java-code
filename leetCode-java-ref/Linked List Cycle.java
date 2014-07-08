/* Given a linked list, determine if it has a cycle in it.*/

/* To solve this problem, we use two nodes fast and slow, the speed of fast is twice as the slow one.*/

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
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(null!=fast && null!=fast.next){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
}

/* Follow up: Given a linked list, return the node where the cycle begins. If there is no cycle, return null. */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(null!=fast && null!=fast.next){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                break;
        }
        if(null==fast || null==fast.next)
            return null;
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
