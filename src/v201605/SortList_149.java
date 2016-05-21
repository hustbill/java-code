package v201605;

//SortList_149
/*
148. Sort List   My Submissions QuestionEditorial Solution
Total Accepted: 70033 Total Submissions: 281580 Difficulty: Medium
Sort a linked list in O(n log n) time using constant space complexity.

Hide Tags Linked List Sort
Hide Similar Problems (E) Merge Two Sorted Lists (M) Sort Colors (M) Insertion Sort List

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class SortList_149 {
	public static void main(String[] args) {
		ListNode root  = new ListNode(1);
		root.next = new ListNode(3);
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(4);
		
		System.out.print("input : " );
		printListNode(root);
		
		ListNode result = sortList(root);

		
		System.out.print("result : " );
		printListNode(result);
		
	}
	
	public static void printListNode(ListNode node) {
		// print result listNode
		
		while (node != null) {
			System.out.print( node.val + " ");
			node = node.next;
		}
		System.out.println();
		
	}
	
    public static ListNode sortList(ListNode head) {
        // ref : https://leetcode.com/discuss/44369/java-merge-sort-solution
        // test case: [1, 3, 5,  4, 2]
        if (head == null || head.next == null)  {
            return head;
        }
        // step1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        // step2 : sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        // step3 : merge l1 and l2
       return merge(l1, l2);
    }
    
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;
        
        while (l1 != null && l2 != null) {
             if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
       
        
        if (l1 != null) {
            p.next = l1;
        }
        
        if (l2 != null) {
            p.next = l2;
        }
        
        return l.next;
    }
}