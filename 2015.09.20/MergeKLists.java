/*

Code it now: https://oj.leetcode.com/problems/merge-k-sorted-lists/ Difficulty: Hard, Frequency: High

Question:

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its
complexity.

*/

import java.util.*;

public class MergeKLists{

	// Solution1 for merge k sorted lists
	// implementing this divide and conquer algorithm iteratively
	public static ListNode mergeKLists1(List<ListNode> lists) {
		if(lists.isEmpty())  return null;
		int end = lists.size() -1;
		while ( end > 0) {
			int begin = 0; 
			while(begin < end) {
				lists.set(begin, merge2Lists(lists.get(begin), 
					lists.get(end)));			
				begin++;
				end--;
			}			
		}
		return lists.get(0);		
	}
	
	// solution 1 for merge  two sorted lists
	private static ListNode merge2Lists1(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
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
		if (l1 != null) p.next = l1;
		if (l2 != null) p.next = l2;
		return dummyHead.next;
	}


	// solution 2 for merge two sorted lists
	private static ListNode merge2Lists(ListNode l1, ListNode l2) {
		// l1 , l2
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if (l1.val < l2.val) {
			l1.next = merge2Lists(l1.next, l2);
			return l1;				
		} else {
			l2.next = merge2Lists(l2.next, l1);
			return l2;
		}
	}
	
	
	// solution 2 for merge k sorted lists
	//  use Heap and priority queue
	/* 
		We could use a min heap of size k. The heap is first initialized with the smallest element
		from each list. Then as we extract the nodes out from the heap, we must remember to
		insert its next node into the heap. As each insert operation into the heap costs log(k) and
		there are a total of nk elements, the total runtime complexity is O(nk log k).
		Ignoring the extra space that is used to store the output list, we only use extra space of
		O(k) due to the heap.
		*/
		
		// private static final Comparator<ListNode> listComparator =
		// 	new Comparator<ListNode>() {
		// 	@Override
		// 	public int compare(ListNode x, ListNode y) {
		// 		return x.val - y.val;
		// 		}
		// 	};
		//
		// public static ListNode mergeKLists(List<ListNode> lists) {
		// 	if (lists.isEmpty()) return null;
		// 		Queue<ListNode> queue = new PriorityQueue<>(lists.size(), listComparator);
		// 	for (ListNode node : lists) {
		// 		if (node != null) {
		// 			queue.add(node);
		// 		}
		// 	}
		// 	ListNode dummyHead = new ListNode(0);
		// 	ListNode p = dummyHead;
		// 	while (!queue.isEmpty()) {
		// 		ListNode node = queue.poll();
		// 		p.next = node;
		// 		p = p.next;
		// 		if (node.next != null) {
		// 			queue.add(node.next);
		// 		}
		// 	}
		// 	return dummyHead.next;
		// }
		//
	
		
		public static ListNode mergeKLists(List<ListNode> lists) {
			// Ref :  下面的解法，和上面是一致的。 但是加了注释。更加好懂。
			// http://www.programcreek.com/2013/02/leetcode-merge-k-sorted-lists-java/
			/* 
				We could use a min heap of size k. The heap is first initialized with the smallest element
				from each list. Then as we extract the nodes out from the heap, we must remember to
				insert its next node into the heap. As each insert operation into the heap costs log(k) and
				there are a total of nk elements, the total runtime complexity is O(nk log k).
				Ignoring the extra space that is used to store the output list, we only use extra space of
				O(k) due to the heap.
				*/
			if (lists.size() == 0)
				return null;
 
			//PriorityQueue is a sorted queue
			PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), // why add lists.size()? ans: init Q
					new Comparator<ListNode>() {
						public int compare(ListNode a, ListNode b) {
							if (a.val > b.val)
								return 1;
							else if(a.val == b.val)
								return 0;
							else 
								return -1;
						}
					});
 
			//add first node of each list to the queue
			for (ListNode list : lists) {
				if (list != null)
					q.add(list);
			}
 
			ListNode head = new ListNode(0);
			ListNode p = head; // serve as a pointer/cursor
 
			while (q.size() > 0) {
				ListNode temp = q.poll();
				//poll() retrieves and removes the head of the queue - q. 
				p.next = temp;
 
				//keep adding next element of each list
				if (temp.next != null)
					q.add(temp.next);
 
				p = p.next;
			}
 
			return head.next;
		}


	public static void main(String[] args ) {
		testcase();
	}

	public static void print(ListNode head) {
		ListNode tmpNode = head;
		while(tmpNode != null) {
			System.out.print(tmpNode.val + " -> ");
			tmpNode = tmpNode.next;
		}
		System.out.print("null");
	}

	public static void testcase() {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		print(head);
		
		System.out.println();
		ListNode firstNode = new ListNode(2);
		insert(firstNode, 3);
		insert(firstNode, 5);
		insert(firstNode, 7);
		insert(firstNode, 8);
		print(firstNode);

		System.out.println();
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(head);
		lists.add(firstNode);
		print(mergeKLists(lists));
		//print(mergeTwoLists(head, firstNode));
		System.out.println();
	}
	
	public static void insert(ListNode head, int val) {
		ListNode currNode = head;
		ListNode nextNode = head.next;
		
		if(currNode.val > val) {
			ListNode tmpNode = head;
			head = new ListNode(val);
			head.next = tmpNode;
			return;
		}
		
		if(nextNode != null && nextNode.val > val) {
			currNode.next = new ListNode(val);
			currNode.next.next = nextNode;
			return;
		}
		
		while( nextNode !=null && nextNode.val < val) {
			currNode = nextNode;
			nextNode = nextNode.next;
		}
		currNode.next = new ListNode(val);
		currNode.next.next = nextNode;
	}
	
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	
	

}