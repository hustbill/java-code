

/*

Sort List 
https://leetcode.com/problems/sort-list/

Sort a linked list in O(n log n) time using constant space complexity.


Solution: 
Keys for solving the problem

Break the list to two in the middle
Recursively sort the two sub lists
Merge the two sub lists
This is my accepted answer for the problem.

*/

class ListNode {
	int val;
	ListNode next;
 
	ListNode(int x) {
		val = x;
		next = null;
	}
}
 

public class SortList {
    public static ListNode sortList(ListNode head) {
    /*
    	Ref: http://www.programcreek.com/2012/11/leetcode-solution-merge-sort-linkedlist-in-java/
    	Keys for solving the problem
			1.Break the list to two in the middle
			2.Recursively sort the two sub lists
			3.Merge the two sub lists
    	
    	code by myself
    	
    		
    */
    
    	if (head == null || head.next == null)
    		return head;
    	int count =0;
    	ListNode p = head;
    	while(p != null ) {
    		count++;
    		p = p.next;
    	}
    	
    	// break up to two lists: l and r
    	int middle = count/2;
    	    	
    	ListNode l = head;  
    	ListNode r = null ;
    	ListNode p2 = head;
    	
    	int halfCount =0 ;
    	while (p2 != null) {
    	   halfCount++;
    	   ListNode next = p2.next;
    	   if( halfCount == middle) {
    	   	 p2.next = null;
    	   	 r = next;
    	   	}
    	   p2 = next;  // why?	
    	}
    	
    	ListNode  l1 = sortList(l);  // sort left part
    	ListNode  r1 = sortList(r);  // sort right part
    	
    	// merge l1 and r1
    	ListNode result = merge(l1, r1);
    	return result;
    }
    
    public static ListNode merge(ListNode l, ListNode r) {
    	ListNode dummyHead = new ListNode(100);
    	ListNode pnew = dummyHead;
    	
    	
		while(l != null  || r!= null) {
			if( r == null) {
				while(l != null) {
					pnew.next = new ListNode(l.val);
					l = l.next;
					pnew = pnew.next;
				}
			} else if(l == null) {
				pnew.next = new ListNode(r.val);
				r = r.next;
				pnew = pnew.next;
			
			} else {
				if( l.val < r.val) {
					pnew.next = new ListNode(l.val);
					l = l.next;
					pnew = pnew.next;
					
				} else if( l.val == r.val) {
					pnew.next = new ListNode(l.val);
					pnew.next.next = new ListNode(l.val);
					pnew = pnew.next.next;
					l =  l.next;
					r = r.next;
				
				} else {
					pnew.next = new ListNode(r.val);
					r = r.next;
					pnew = pnew.next;
				}
			}
		}   	
		return dummyHead.next;
    }
    
	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
 
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
 
		n1 = sortList(n1);
 
		printList(n1);
	}
    public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}

}

