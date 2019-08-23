package lists;


//  Definition for singly-linked list.

 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     
     public String toString(ListNode node) {
    	 String ans = "";
    	 while (node != null) {
    		 ans = node.next != null ? ans.concat(node.val + ", ") : ans.concat(node.val + ""); 
    		 node = node.next;
    	 }
    	 return ans;
     }
 }
