/*105. Construct Binary Tree from Preorder and Inorder Traversal My Submissions QuestionEditorial Solution
Total Accepted: 66239 Total Submissions: 227810 Difficulty: Medium
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

Hide Company Tags Bloomberg
Hide Tags Tree Array Depth-first Search
Hide Similar Problems (M) Construct Binary Tree from Inorder and Postorder Traversal

*/
package tree;

public class ConstructBinaryTreeFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
		int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
		int[] output = { 1, 2, 3, 4, 5, 6, 7 };
		ConstructBinaryTreeFromArray cbt = new ConstructBinaryTreeFromArray();
		TreeNode root = cbt.buildTree(inorder, preorder);

		LevelOrderPrint lop = new LevelOrderPrint();
		lop.levelOrderPrint(root);

	}

	public TreeNode buildTree(int[] inorder, int[] preorder) {
		/*
		 * https://leetcode.com/discuss/12179/my-accepted-java-solution
		 * 
		 * I read this post, which is very helpful.
		 * http://articles.leetcode.com/construct-binary-tree-from-inorder-and-preorder-postorder-traversal
		 * The basic idea is here: Say we have 2 arrays, PRE and IN. Preorder
		 * traversing implies that PRE[0] is the root node. Then we can find
		 * this PRE[0] in IN, say it's IN[5]. Now we know that IN[5] is root, so
		 * we know that IN[0] - IN[4] is on the left side, IN[6] to the end is
		 * on the right side. Recursively doing this on subarrays, we can build
		 * a tree out of it
		 * 
		 */

		int preStart = 0;
		int inStart = 0;
		int inEnd = inorder.length - 1;
		return helper(inorder, preorder, preStart, inStart, inEnd);
	}

	private TreeNode helper(int[] inorder, int[] preorder, int preStart, int inStart, int inEnd) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[preStart]);

		int inIndex = 0; // index of current root in inorder

		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[preStart]) {
				inIndex = i;
			}
		}

		root.left = helper(inorder, preorder, preStart + 1, inStart, inIndex - 1);
		root.right = helper(inorder, preorder, preStart + inIndex - inStart + 1, inIndex + 1, inEnd);
		return root;

	}

	public void failed(int[] array, TreeNode node, int pos) {

		if (pos >= array.length - 3) {
			return;
		}
		node = new TreeNode(array[pos]);
		node.left = new TreeNode(array[pos + 1]);
		node.right = new TreeNode(array[pos + 2]);
	}

}
