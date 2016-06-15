package tree;

public class SortedListToBST {

	public static void main(String[] args) {

		
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		head.next = second;
		second.next = third;

		ListNode fourth = new ListNode(4);

		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = new ListNode(7);

		SortedListToBST list2bst = new SortedListToBST();

		TreeNode result = list2bst.sortedListToBST(head);
		LevelOrderPrint lp = new LevelOrderPrint();

		lp.levelOrderPrint(result);

	}
	
	
	// not thread safe, but it is easy to understand.
	private ListNode node;

	public TreeNode sortedListToBST(ListNode head) {
	    if(head == null){
	        return null;
	    }

	    int size = 0;
	    ListNode runner = head;
	    node = head;

	    while(runner != null){
	        runner = runner.next;
	        size ++;
	    }

	    return inorderHelper(0, size - 1);
	}

	public TreeNode inorderHelper(int start, int end){
	    if(start > end){
	        return null;
	    }

	    int mid = start + (end - start) / 2;
	    TreeNode left = inorderHelper(start, mid - 1);

	    TreeNode treenode = new TreeNode(node.val);
	    treenode.left = left;
	    node = node.next;

	    TreeNode right = inorderHelper(mid + 1, end);
	    treenode.right = right;

	    return treenode;
	}

	public TreeNode sortedListToBST_fastSlow(ListNode head) {
		// https://leetcode.com/discuss/83856/share-my-java-solution-1ms-very-short-and-concise
		if (head == null)
			return null;
		return dfs(head, null);

	}

	public TreeNode dfs(ListNode head, ListNode tail) {
		ListNode slow = head;
		ListNode fast = head;
		
		if (head == tail) return null;
		
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		TreeNode root = new TreeNode(slow.val);
		root.left = dfs(head,slow);
		root.right = dfs(slow.next, tail);
		 
		return root;
	}

}

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
