/**
 * 
 */
package lists;

/**
 * 19. Remove Nth Node From End of List
Medium

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

Hint1: Maintain two pointers and update one with a delay of n steps.
 * @author huazhang
 *
 */
public class RemoveNthFromEnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode testList1 = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		testList1.next = node1;
		node1.next = node2;
		
		RemoveNthFromEnd rmn = new RemoveNthFromEnd();
		
		ListNode ans = rmn.removeNthFromEnd(testList1, 2);
		System.out.print("[1,2, 3] 2 => ans = " + ans.toString(ans));
		
	}
	
	public ListNode removeNthFromEnd0(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = head;
        ListNode q = head;
        ListNode prev = new ListNode(0);
        prev.next = q;
        
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        if (len == n) {
            prev.next = q.next;
            return prev.next;
        }
        int idx = 0; 
        while (idx != len - n) {
            q = q.next;
            prev = prev.next;
            idx++;
        }
        prev.next = q.next;
        q.next = null;
        return dummyHead.next;
    }
    
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = head;
    
        int len = 0;
        
        while (p != null) {
            p = p.next;
            len++;
        }
        
        len = len - n;
        /*
            len     q       q.next
             3      0       1
             2      1       2
             1      2       3
             0      3       4
             
          1->2->[3] --> (4) --> 5
                 ^
                 q
        */
        ListNode q = dummyHead;
        while (len > 0) {
             len--;
             q = q.next;
         }
         q.next = q.next.next;
        
        return dummyHead.next;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // two pointers
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move first pointer in front so that the gap between first and second is n nodes
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        
        return dummy.next;
    }

}
