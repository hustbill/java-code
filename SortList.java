import java.util.ArrayList;

public class SortList {
	
	static int  displayList(ListNode head) {
		int count =0;
		ListNode  outPut = head;
		while(outPut != null) {
			//System.out.print(String.format("%d->", outPut.val));
			System.out.print(outPut.val + " ");
			outPut = outPut.next; 
			count++;
		}
		System.out.println();
		return count;
	}
	
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	

	
	public static void main(String args[]) {
   		ListNode head =null,  temp = null, next = null;
   		int[] nodeArray = { 1, 3, 7 , 8 , 11, 24, 9, 61, 48 ,19, 17};
   		for(int i = 0; i< nodeArray.length -1; i++) {   			
	    
			head.next = new ListNode(nodeArray[i]);
		  }
		
		//ListNode list = sortList(head);
		
		displayList(head);
	
		
		System.out.println();
		
	}
	
}