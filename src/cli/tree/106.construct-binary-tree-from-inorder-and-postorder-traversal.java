/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (40.61%)
 * Total Accepted:    165.6K
 * Total Submissions: 407.7K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      int len1 = inorder.length;
      int len2 = postorder.length;
      
      if (len1 == 0 || len2 == 0 || len1 != len2)  {
        return null;
	    }
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < len1; i++) {
        map.put(inorder[i],i);
      }
      return helper(postorder, len2 - 1, map, 0, len1 - 1); // root pos in postorder is len2 - 1
    }

    private TreeNode helper(int[] postorder, int pos, HashMap<Integer, Integer> map, int begin, int end) {
      int rootVal = postorder[pos];
      TreeNode root = new TreeNode(rootVal);
      int idx = map.get(postorder[pos]);

      // left child tree 
      if (begin < idx) 
        root.left = helper(postorder, pos - (end - idx + 1), map, begin, idx - 1);
      if (idx < end) 
        root.right = helper(postorder, pos - 1, map, idx + 1, end); 
      return root;
    }
}
