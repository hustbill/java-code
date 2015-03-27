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
import java.util.*;
import java.util.Hashtable;
import java.util.ArrayList;

public class DetectCycle {
	public static ListNode detectCycle(ListNode head) {
		try {
			ListNode leftNode = head;
			ListNode rightNode = head;
			System.out.println("Begin: leftNode=" + leftNode.val);
			do {
				leftNode = leftNode.next;
				//System.out.println("First: leftNode= " + leftNode.val);
				rightNode = rightNode.next.next;
				//System.out.println("First: rightNode= " + rightNode.val);
			} while(rightNode != leftNode);
			
			rightNode  = head;
			//System.out.println("Second: head= " + head.val);
			//System.out.println("Second: rightNode= " + rightNode.val);
			while( rightNode != leftNode) {
				leftNode = leftNode.next;
				rightNode = rightNode.next;
					/* 	System.out.println("Second: leftNode= " + leftNode.val);
						System.out.println("Second: rightNode= " + rightNode.val); */
			}
			//System.out.println("third: leftNode= " + leftNode.val);
			return leftNode;
		}
		catch(NullPointerException  e){
	
			return null;
		}
	}

    public static ListNode detectCycleHashMap(ListNode head) {
	 Hashtable<Integer, ListNode> nodeTable = new Hashtable<Integer, ListNode>();
	 if (head != null) {
		 while( head.next != null) {
				nodeTable.put(head.val, head);
				System.out.println(String.format("head.val =%d", head.val));
				head = head.next;
				
			}
	 	}
		//convert current Hashtable keys to an ArrayList
		ArrayList<Integer> keyList = Collections.list(nodeTable.keys());
		int index = searchDuplicate( keyList);
		if(index > 0 ) {
		   ListNode startCycleNode = nodeTable.get(index);
			return startCycleNode;
		}
		else
			return null;
   }
	
   public static int searchDuplicate( ArrayList keyList) {
	   int ret = 0;
	   int step = 2;
	   for(int i=0, j= i+step; i< keyList.size()-1; i++) {
	   	 	   
			   if(keyList.get(i) == keyList.get(j) ) {
					  if( keyList.get(i+1) == keyList.get(j+1)) {
						   ret =i;
					   }
			   }
	   	 	   else {
					step++;
				}
	   	 	 
	   }
	   
	   return ret;
	
   }
	
	
	public static void main(String args[]) {
		ListNode root = new ListNode(5);
		ListNode secondNode = new ListNode(2);
		root.next  = secondNode;
		
		ListNode thirdNode = new ListNode(3);
		secondNode.next = thirdNode;
		
		ListNode forthNode = new ListNode(7);
		thirdNode.next  = forthNode;
		
		ListNode fifthNode = new ListNode(2);
		forthNode.next = fifthNode;
		
		ListNode sixthNode = new ListNode(3);
		fifthNode.next = sixthNode;
		
		ListNode seventhNode = new ListNode(7);
		sixthNode.next = seventhNode;
			
		ListNode eighthNode = new ListNode(2);
		seventhNode.next = eighthNode;
		
		ListNode ninthNode = new ListNode(3);
		eighthNode.next = ninthNode;
		
		ListNode tenthNode = new ListNode(7);
		ninthNode.next = tenthNode;
		/* 
		while(root != null && root.next != null) {
 			System.out.println(String.format("%d -> %d", root.val, root.next.val));
 			root = root.next;
 		} */
		ListNode startCycleNode = detectCycle(root);
      if(startCycleNode != null )
		System.out.println(String.format("detectCycle(%d)=%d", root.val, startCycleNode.val));
		

	}
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}