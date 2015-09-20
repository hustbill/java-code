package leetcodeSolution;

/**
* Definition for singly-linked list.
*/
public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
     /** Returns the element of this node. */
 	public int getVal() { return val; }
 	/** Returns the next  node of this node. */
 	public ListNode getNext() { return next; }
 	//Modifier  methods:
 	/** Sets the next node of this node. */
 	public void setVal(int newVal) { val = newVal; }
 	/** Sets the next node of this node .*/
 	public void setNext(ListNode newNext) { next = newNext ; }
 }
