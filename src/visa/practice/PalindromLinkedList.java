package visa.practice;

public class PalindromLinkedList {

	public PalindromLinkedList() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * solution: 思路 
	 * fast-slow pointer to get the left half and right half
	 * reverse right half
	 * compare left half and right half, if not equal, return false, else move to next 
	 * and compare fast.next and slow.next
	 * 
	 */
	public static boolean isPalindromLinkedList(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if (fast != null) {  // odd Nodes: let right half smaller
			slow = slow.next;
		}
		
		slow = reverse(slow);
		fast = head;
		
		while (slow != null) {
			if (fast.val != slow.val) return false;
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}
	
	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode first = new ListNode(1);
		first.next = new ListNode(2);
		first.next.next = new ListNode(1);
		boolean result = isPalindromLinkedList(first);
		
		System.out.println("the first linkedlist is " + result); // 1->2->1 true
		
		ListNode second = new ListNode(2);
		second.next = first;
		
		result = isPalindromLinkedList(second); // 2->1->2-1  false
		System.out.println("the second linkedlist is " + result);
	}

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

