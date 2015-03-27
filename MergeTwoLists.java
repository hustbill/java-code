/*
Merge Two Sorted Lists
https://oj.leetcode.com/problems/merge-two-sorted-lists/

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    if (l1 == null) return l2;
	     if (l2 == null) return l1;

	     if (l1.val < l2.val) {
	       l1.next = mergeTwoLists(l1.next, l2);
	       return l1;
	     } else {
	       l2.next = mergeTwoLists(l2.next, l1);
	       return l2;
	     }
		
    }
	
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
		System.out.println();
		ListNode firstNode = new ListNode(2);
		insert(firstNode, 3);
		insert(firstNode, 5);
		insert(firstNode, 7);
		insert(firstNode, 8);
		print(firstNode);
		System.out.println();
		print(mergeTwoLists(head, firstNode));
		System.out.println();
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