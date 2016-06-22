/*
 * 222. Count Complete Tree Nodes My Submissions QuestionEditorial Solution
Total Accepted: 35906 Total Submissions: 139981 Difficulty: Medium
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Hide Tags Tree Binary Search
Hide Similar Problems (E) Closest Binary Search Tree Value
 */
package tree;

public class CountBTNodes {

	int height(TreeNode root) {
		return root == null ? -1 : 1 + height(root.left);
	}

	// https://leetcode.com/discuss/38930/concise-java-solutions-o-log-n-2
	public int countNodes(TreeNode root) {
		int h = height(root);
		return h < 0 ? 0
				: height(root.right) == h - 1 ? (1 << h) + countNodes(root.right)
						: (1 << h - 1) + countNodes(root.left);
	}

	public int recursive(TreeNode root) { // beat 78%
		/*
		 * Explanation
		 * https://leetcode.com/discuss/38930/concise-java-solutions-o-log-n-2
		 * 
		 * The height of a tree can be found by just going left. Let a single
		 * node tree have height 0. Find the height h of the whole tree. If the
		 * whole tree is empty, i.e., has height -1, there are 0 nodes.
		 * 
		 * Otherwise check whether the height of the right subtree is just one
		 * less than that of the whole tree, meaning left and right subtree have
		 * the same height.
		 * 
		 * If yes, then the last node on the last tree row is in the right
		 * subtree and the left subtree is a full tree of height h-1. So we take
		 * the 2^h-1 nodes of the left subtree plus the 1 root node plus
		 * recursively the number of nodes in the right subtree. If no, then the
		 * last node on the last tree row is in the left subtree and the right
		 * subtree is a full tree of height h-2. So we take the 2^(h-1)-1 nodes
		 * of the right subtree plus the 1 root node plus recursively the number
		 * of nodes in the left subtree. Since I halve the tree in every
		 * recursive step, I have O(log(n)) steps. Finding a height costs
		 * O(log(n)). So overall O(log(n)^2).
		 */
		if (root == null)
			return 0;

		TreeNode left = root;
		TreeNode right = root;
		int height = 0;

		while (right != null) {
			left = left.left;
			right = right.right;
			height++;
		}

		if (left == null)
			return (1 << height) - 1;
		return 1 + recursive(root.left) + recursive(root.right);

	}

	public int countNodesTLE(TreeNode root) {
		// [1, 2, 3, 4, 5, 6,7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
		// 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32]
		if (root == null)
			return 0;

		return countNodes(root.left) + countNodes(root.right) + 1;
	}

	public static void main(String[] args) {
		int[][] nums;

		ConvertArrayToBST_108 cbst = new ConvertArrayToBST_108();
		CountBTNodes cb = new CountBTNodes();

		nums = new int[][] { { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 } };
		for (int i = 0; i < nums.length; i++) {

			TreeNode root = cbst.sortedArrayToBST(nums[i]);
			System.out.println(cb.countNodes(root));
		}

	}

}
