/*
 * 116. Populating Next Right Pointers in Each Node  QuestionEditorial Solution  My Submissions
Total Accepted: 94383
Total Submissions: 257617
Difficulty: Medium
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
package tree;

public class NextRightPointers116 {
	/**
	 * Definition for binary tree with next pointer. public class TreeLinkNode {
	 * int val; TreeLinkNode left, right, next; TreeLinkNode(int x) { val = x; }
	 * }
	 */
	public void connect(TreeLinkNode root) {
		connectRecursive(root);
	}
	// 7/17/16 重做。看思路后秒过

	/*
	 * Recursive solution
	 * https://leetcode.com/discuss/32318/my-recursive-solution-java
	 * 知道自己为什么失利了，没有用到next 这个特性
	 * 
	 */
	public void connectRecursive(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			root.left.next = root.right;
		}
		if (root.next != null && root.right != null) {
			root.right.next = root.next.left;
		}
		connectRecursive(root.left);
		connectRecursive(root.right);
	}

	// Java solution with O(1) memory+ O(n) time
	// https://leetcode.com/discuss/19061/java-solution-with-o-1-memory-o-n-time
	public void connectIterative(TreeLinkNode root) {
		TreeLinkNode level_start = root;
		while (level_start != null) {
			TreeLinkNode cur = level_start;

			while (cur != null) {
				if (cur.left != null) {
					cur.left.next = cur.right;
				}
				// 跨越两个子树，用到next指向
				// 当前节点的右子节点不为空， 当前节点的next节点不为空，则当前节点的右子节点指向右边。
				if (cur.right != null && cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			level_start = level_start.left;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
