package lists;

import java.util.*;

public class MergeKLists {

	public static Comparator<ListNode> comparator = new Comparator<ListNode>() {
		@Override
		public int compare(ListNode x, ListNode y) {
			return x.val - y.val;
		}
	};

	public static ListNode mergeKListsPQ(ListNode[] lists) {
		/*
		 * Ref : 下面的解法，和leetcode clean code handbook v1.03 上是一致的。 
		 * 但是加了注释。更加好懂。
		 * http://www.programcreek.com/2013/02/leetcode-merge-k-sorted-lists-
		 * java/ We could use a min heap of size k. The heap is first
		 * initialized with the smallest element from each list.
		 * 
		 * Then as we extract the nodes out from the heap, we must remember to
		 * insert its next node into the heap.
		 * 
		 * As each insert operation into the heap costs log(k) and there are a
		 * total of nk elements, the total runtime complexity is O(nk log k).
		 * 
		 * Ignoring the extra space that is used to store the output list, we
		 * only use extra space of O(k) due to the heap.
		 * 
		 * 测试例子 
		 * [1, 3, 5]
		 * [2, 4]
		 * [6, 7]
		 * 
		 * Q  {1, 2, 6}    从q中取出1， 然后把1的next 3 放入q中。  p->1
		 * Q  { 2, 3, 6}    从q中取出2， 然后把2的next 4 放入q中。  p->1->2
		 * Q  { 3, 4, 6}    从q中取出3， 然后把2的next 5 放入q中。  p->1->2->3
		 * Q  { 4, 5, 6}    从q中取出4,  p->1->2->3->4
		 * Q  { 5, 6}       从q中取5,  p->1->2->3->4->5
		 * Q  { 6}          从q中取6,  然后把6的next 7 放入q中  p->1->2->3->4->5->6
		 * Q  { 7}          从q中取7,  p->1->2->3->4->5->6->7
		 * 
		 */
		if (lists == null || lists.length == 0)
			return null;
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, comparator);
		for (ListNode node : lists) {
			if (node != null)
				q.add(node);
		}

		ListNode head = new ListNode(0);
		ListNode p = head; // serve as a pointer /cursor

		while (q.size() > 0) {
			ListNode temp = q.poll(); // poll () retrieves and removes the head
										// of the queue -q.
			p.next = temp;

			if (temp.next != null) // keep adding next element of each list
				q.add(temp.next);

			p = p.next;
		}

		return head.next;
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		
		int end = lists.length - 1;
		while (end > 0) {
			int cur = 0 ; // start from 0
			while (cur < end) {
				lists[cur] = merge2sortedLists(lists[cur], lists[end]);
				cur++;
				end--;
			}
		}
		return lists[0];
	}
	
	// 2018-10-24 revisit here. 思路很清晰
	public static ListNode merge2sortedLists(ListNode l1, ListNode l2) {
		if (l2 == null) return l1;
		if (l1 == null) return l2;
		
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		
		while(l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				p.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			p = p.next;
		}
		
		if (l1 != null)  p.next = l1;
		if (l2 != null)  p.next = l2;
		
		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);

		// l1.next = l4;
		// l2.next = l5;
		// l3.next = l6;
		// l6.next = l7;
		//
		// List<ListNode> inputList = new ArrayList<ListNode>();
		// inputList.add(l1);
		// inputList.add(l2);
		// inputList.add(l3);

		ListNode[] lists = { l1, l2, l3, l4, l5, l6, l7 };
		ListNode head = mergeKLists(lists);
		while (head != null) {
			System.out.printf(" %d ", head.val);
			head = head.next;
		}

	}
}

// class ListNode {
// int val;
// ListNode next;
// ListNode(int x) { val = x; }
// }