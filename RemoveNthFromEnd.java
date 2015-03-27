/*
Remove Nth Node From End of List 
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

*/


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
public class RemoveNthFromEnd {
   
	
	public static void addFirst(ListNode head, int item) {
		head = new ListNode(item);
		head.next = head;
	}
	
	public static void insert(ListNode head, int val) {
		ListNode currNode = head;
		ListNode nextNode = head.next;
		
		if(currNode.val > val) {
			ListNode tmpNode = head;
			head = new ListNode(val);
			head.next = tmpNode;
			return;
		}
		
		if(nextNode != null && nextNode.val > val) {
			currNode.next = new ListNode(val);
			currNode.next.next = nextNode;
			return;
		}
		
		while( nextNode !=null && nextNode.val < val) {
			currNode = nextNode;
			nextNode = nextNode.next;
		}
		currNode.next = new ListNode(val);
		currNode.next.next = nextNode;
	}
	// Reference:  http://www.cnblogs.com/springfor/p/3862219.html
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        
		if(head == null || head.next == null)
            return null;
            
        ListNode faster = head;
        ListNode slower = head; //slower pointer (will finally point to the target remove node-1)  
        // set up the distance between slower pointer and faster pointer 
        for(int i = 0; i<n; i++)
            faster = faster.next;
            
        if(faster == null){// case of removing the head node  
            head = head.next;
            return head;
        }
        
        while(faster.next != null){
            slower = slower.next;
            faster = faster.next;
        }
        
        slower.next = slower.next.next;
        return head;
        
        }
	
	//delete node by val
    public static void delete(ListNode head, int val) {
		ListNode  prevNode = null;
		ListNode currNode = head;
		
		if(head.val == val) { 
		   head = head.next;
		   return ;
		}
		while ( currNode != null && currNode.val != val) {
			prevNode = currNode;
			currNode = currNode.next;
		}
		if(currNode == null) {
		   System.out.println("A node with that value does not exist.");
		 }
		 else {
			prevNode.next = currNode.next;
		}
	}
	
	public static void print(ListNode head) {
		ListNode tmpNode = head;
		while(tmpNode != null) {
			System.out.print(tmpNode.val + " -> ");
			tmpNode = tmpNode.next;
		}
		System.out.print("null");
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		print(head);
		delete(head, 5);
		System.out.println();
		System.out.println();
		print(head);
		insert(head, 8);
		print(head);
		removeNthFromEnd(head, 2);
		print(head);
	}
	
		public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}