/*
 * 114. Flatten Binary Tree to Linked List
Total Accepted: 85527 Total Submissions: 271828 Difficulty: Medium
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Subscribe to see which companies asked this question

Hide Tags Tree Depth-first Search

 */
package tree;

public class FlattenBinaryTree {

	public static void main(String[] args) {
		
//		int[] inorder = { 3, 2, 4, 1, 5, 6 };
//		int[] preorder = { 1, 2, 3, 4, 5, 6 };
//		int[] output = { 1, 2, 3, 4, 5, 6 };
//		ConstructBinaryTreeFromArray cbt = new ConstructBinaryTreeFromArray();
//		TreeNode root = cbt.buildTree(inorder, preorder);		
		
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(5);
		root.left = left;
		root.right = right;
//		left.left = new TreeNode(3);
//		left.right = new TreeNode(4);
//		right.right = new TreeNode(6);
		
		LevelOrderPrint printer = new LevelOrderPrint();
		
		printer.levelOrderPrint(root);
		  

		FlattenBinaryTree fbt = new FlattenBinaryTree();
		System.out.println("\n after, root = ");
		fbt.flatten(root);
		printer.levelOrderPrint(root);

	}

	public void flatten(TreeNode root) {
		// https://leetcode.com/discuss/30719/my-short-post-order-traversal-java-solution-for-share
		// post order traversal Java solution
		flatten(root,null);
	}
	
	/*  test case : 
	 *       1
	 *      /  \
	 *     2    5
	 *     
	 *     root    root.right   root.left     pre
	 *     5        null         null         从 null 变成 5
	 *     2        2->5         null         变成 2->5
	 *     1        1->2->5      null         1->2->5
	 */
	private TreeNode flatten(TreeNode root, TreeNode pre) {
	    if(root==null) return pre;
	    pre=flatten(root.right,pre);    
	    pre=flatten(root.left,pre);
	    root.right=pre;
	    root.left=null;
	    pre=root;
	    return pre;
	}


	public void flattenNormal(TreeNode root) {
		/*
		 * https://leetcode.com/discuss/27643/straightforward-java-solution
		 * idea: the solution is based on recursiong. We simply flatten left and
		 * right subtrees, and past sublist to the right child of the root.
		 * (don't forget to set left child to null) Testcase: [1, 2, 5, 3, 4, 6]
		 * => [1,null,2,null,3,null,4,null,5,null,6]
		 */
		if (root == null)
			return;

		TreeNode left = root.left;
		TreeNode right = root.right;

		root.left = null;

		flatten(left);
		flatten(right);

		root.right = left;
		TreeNode cur = root;
		while (cur.right != null) {
			cur = cur.right;
		}
		cur.right = right;
	}

}
