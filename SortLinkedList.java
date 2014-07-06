package leetcodeSolution;

public class Solution {

	public static ListNode insertionSortList(ListNode head) {
		 
		if (head == null || head.next == null)
			return head;
 
		ListNode newHead = new ListNode(head.val);
		ListNode pointer = head.next;
 
		// loop through each element in the list
		while (pointer != null) {
			// insert this element to the new list
 
			ListNode innerPointer = newHead;
			ListNode next = pointer.next;
 
			if (pointer.val <= newHead.val) {
				ListNode oldHead = newHead;
				newHead = pointer;
				newHead.next = oldHead;
			} else {
				while (innerPointer.next != null) {
 
					if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
						ListNode oldNext = innerPointer.next;
						innerPointer.next = pointer;
						pointer.next = oldNext;
					}
 
					innerPointer = innerPointer.next;
				}
 
				if (innerPointer.next == null && pointer.val > innerPointer.val) {
					innerPointer.next = pointer;
					pointer.next = null;
				}
			}
 
			// finally
			pointer = next;
		}
 
		return newHead;
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
 
		n1 = insertionSortList(n1);
 
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

//	    
//	    public static class SingleSortedList {
//	    	protected ListNode head;
//	    	protected ListNode tail;
//	    	long size;   // number of nodes in the list
//	        // constructor 
//	        public SingleSortedList() {
//	            head = null;
//	            size = 0;
//	        }
//	        /** Returns where the list is empty */
//	    	public boolean isEmpty() { return (size ==0); }
//	    	/** Returns the first node of the list */
//	    	public ListNode getFirst() throws IllegalStateException {
//	    		if (isEmpty()) throw new IllegalStateException("List is empty");
//	    		return head.getNext();
//	    	}
//	   
//	    	
//	    	public void addFirst(ListNode v) {
//	    		v.setNext(head);
//	    		head = v;
//	    	    size++;
//	    	}
//	    	public void addLast(ListNode v) {
//	    		v.setNext(null);
//	    		tail = v;
//	    		size++;
//	    	}
//	    	
//	    	
//	    }
//	    	
//	  	  public  ListNode insertionSortList(ListNode head) {
//	  		   System.out.println("The original sorted list is :  ");
//		       SingleSortedList ssl = new SingleSortedList();
//		       // assume the sortedList is decreasing.
//		       ListNode[] nodeList = new ListNode[15];
//		       for(int i=0; i< 15; i++) {
//		    	    nodeList[i] = new ListNode(2*i+1);
//		    	    ssl.addFirst(nodeList[i]);
//		       }
//		       ListNode first = ssl.getFirst();
//		       ListNode li = first.getNext();
//		       while (li != null) {  
//		            System.out.print(li.getVal() + ", "); 
//		            li = li.getNext();  
//		       }
//		       
//	  		 ListNode firstNode = ssl.getFirst();
//	  		 System.out.println("\nFirst node is: " + firstNode.val);
//	  		 System.out.println("\nhead is: " + head.val);
//	  		 if( firstNode.val < head.val) { return null; }
//	  		 
//	  		 ListNode p = firstNode.getNext();
//	  		 while (p!=null) {
//	  			 ListNode prev = p;
//	  			 if( head.val >  p.val ){
//	  				 head.setNext(p);
//	  				 firstNode.setNext(head);
//	  				 ssl.size++;
//	  				 System.out.println("\nAdd new ListNode into sorted list "); 
//	  				 //return firstNode;
//	  			 }
//	  			 System.out.println("\np is: " + p.val);
//	  			 p=p.getNext();
//	  		 }
//	  	   ListNode top = ssl.getFirst();
//	       li = top.getNext();
//	       while (li!= null) {  
//	            System.out.print(li.getVal() + ", "); 
//	            li = li.getNext();  
//	       }
//  		    return top;	
//	   }
//	  
 }

