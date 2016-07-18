/*
 * 
236. Lowest Common Ancestor of a Binary Tree My Submissions QuestionEditorial Solution
Total Accepted: 46265 Total Submissions: 160631 Difficulty: Medium
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Hide Company Tags Amazon LinkedIn Apple Facebook Microsoft
Hide Tags Tree
Hide Similar Problems (E) Lowest Common Ancestor of a Binary Search Tree

 */
package tree;

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		/* https://leetcode.com/discuss/45399/my-java-solution-which-is-easy-to-understand
		 * 
		 * leEco phone interview question  July 14, 2016
		 * 		  ___ 1_____
		 * 		/           \
		 * 	__2 ___       __ 3 ___
		 * /	   \     /        \
		 * 4        5    6        7
		 */

		// p, q in the same subtree, q is the child of p,  e.g  (p,q) is (2, 5) or (3, 7)
		if (root == null || root == p || root == q)  {  
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		if (left != null && right != null)  {
			return root;   // p, q are in the different subtree of root  e.g. (p,q) is (4, 6)
		}
		return left != null ? left : right;
		
	}

	public TreeNode dfs_failed(TreeNode root, TreeNode p, TreeNode q) {
		
		TreeNode node = root;

		if (node == null)
			return null;

		if (node == p || node == q) {
			return node;
		}

		if (node.left != null) {

			node = dfs_failed(node.left, p, q);
		}
		if (node.right != null) {
			node = dfs_failed(node.right, p, q);
		}

		return node;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
		int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
		int[] output = { 1, 2, 3, 4, 5, 6, 7 };
		ConstructBinaryTreeFromArray cbt = new ConstructBinaryTreeFromArray();
		TreeNode root = cbt.buildTree(inorder, preorder);
			
		LowestCommonAncestor lca = new LowestCommonAncestor();
		TreeNode commonAncesor = lca.lowestCommonAncestor(root, root.left , root.left.right);  // (p,q) = (2, 5)
		
		String res = commonAncesor == null ?  "Null" : String.valueOf(commonAncesor.val);  // 2
		 System.out.println(res);
	}

}
