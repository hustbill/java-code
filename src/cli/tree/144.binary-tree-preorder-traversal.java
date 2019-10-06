/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (52.31%)
 * Total Accepted:    367.8K
 * Total Submissions: 702.9K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,2,3]
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
	Stack<TreeNode> stack = new Stack<TreeNode>();
	List<Integer> ans = new ArrayList<Integer>();
	if (root == null) return ans;

	TreeNode p = root;
        stack.push(p);	
        while (!stack.isEmpty()) {
	  p = stack.pop();
	  ans.add(p.val);
	  if (p.right != null) {
	     stack.push(p.right);
          } 
          if (p.left != null) {
             stack.push(p.left);
          }
	}	
      return ans;   
    }
}

