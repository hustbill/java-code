package microsoftOTS;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Merge3SortedLists {
	public static void main(String[] args) {
		Merge3SortedLists mgs = new Merge3SortedLists();
		ListNode list1 = new ListNode(1);
		ListNode next1 = new ListNode(3);
		list1.next = next1;
		next1.next = new ListNode(7);
		
		
		ListNode list2 = new ListNode(2);
		ListNode next2 = new ListNode(4);
		list2.next = next2;
		next2.next = new ListNode(6);
		
		ListNode list3 = new ListNode(4);
		ListNode next3 = new ListNode(8);
		list3.next = next3;
		next3.next = new ListNode(12);
		
		
		ListNode[] lists = { list1, list2, list3};
		ListNode result = mgs.mergeKLists(lists);
		 while (result != null) {
			 System.out.print(result.val + " ");
			 result = result.next;
		 }
		
		
	}
	    public ListNode mergeKLists(ListNode[] lists) {
	    // Solution 1:  divide and conquer  using two way merge 
	    //  O(nklogk) runtime,  O(1) space
	    // testcase: [[1, 3, 7], [2, 4, 6], [ 4, 8, 12]]
	    	// [1,2,3,4,4,6,7,8,12]
	    if (lists == null || lists.length == 0) return null;
	        int end = lists.length - 1;
	        while (end > 0) {
	            int start = 0;
	            while (start < end) {
	                lists[start] = mergeTwoLists(lists[start], lists[end]);
	                start++;
	                end--;
	            }
	        }
	        return lists[0];
	        
	    }
	    
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode dummyHead = new ListNode(0);
	        ListNode p = dummyHead;
	        
	        while (l1 != null && l2 != null) {
	            if (l1.val < l2.val) {
	               p.next = new ListNode(l1.val);
	               p = p.next;
	               l1 = l1.next;
	            } else {
	                p.next = new ListNode(l2.val);
	                p = p.next;
	                l2 = l2.next;
	            }
	        }
	        
	        if (l1 != null) {
	            p.next =  l1;
	        }
	        
	         if (l2 != null) {
	            p.next = l2;
	        }
	        
	        return dummyHead.next;
	    }
	}
