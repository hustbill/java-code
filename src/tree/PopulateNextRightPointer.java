/*116. Populating Next Right Pointers in Each Node My Submissions QuestionEditorial Solution
Total Accepted: 90839 Total Submissions: 248248 Difficulty: Medium
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, 
the next pointer should be set to NULL.

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
Hide Company Tags Microsoft
Hide Tags Tree Depth-first Search
Hide Similar Problems (H) Populating Next Right Pointers in Each Node II (M) Binary Tree Right Side View
*/

package tree;

/**
 * Definition for binary tree with next pointer.
 */

public class PopulateNextRightPointer {

	public void connect(TreeLinkNode root) {
		connectRecursive(root);
	}

	//Java solution with O(1) memory+ O(n) time
	//https://leetcode.com/discuss/19061/java-solution-with-o-1-memory-o-n-time
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

	/* Recursive solution
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

	public void connect_failed(TreeLinkNode root) {
		if (root == null)
			return;
		if (root.left != null) {
			root.left.next = root.right;

			if (root.left.right != null && root.right.left != null) {
				root.left.right.next = root.right.left;
			}
		}
		connect(root.left);
		connect(root.right);
	}

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode left = new TreeLinkNode(2);
		TreeLinkNode right = new TreeLinkNode(3);
		root.left = left;
		root.right = right;

		TreeLinkNode four = new TreeLinkNode(4);
		TreeLinkNode five = new TreeLinkNode(5);
		left.left = four;
		left.right = five;

		four.right = new TreeLinkNode(8);
		five.left = new TreeLinkNode(9);

		TreeLinkNode six = new TreeLinkNode(6);
		TreeLinkNode seven = new TreeLinkNode(7);

		TreeLinkNode ten = new TreeLinkNode(10);
		TreeLinkNode eleven = new TreeLinkNode(11);

		right.left = six;
		right.right = seven;

		five.right = ten;
		six.left = eleven;

		PopulateNextRightPointer rnp = new PopulateNextRightPointer();

		rnp.connect(root);
		if (root != null) {

			System.out.println(root.left.left.next.val); // 5
			System.out.println(root.left.left.right.next.val); // 9
			System.out.println(root.left.right.next.val); // 6
			System.out.println(root.left.right.left.next.val); // 10
			System.out.println(root.left.right.right.next.val); // 11

		}

	}

}
