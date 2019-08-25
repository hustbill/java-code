/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (42.67%)
 * Total Accepted:    247.4K
 * Total Submissions: 579.5K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
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
    //Ref: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int pre_idx = 0 ;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
      int len1 = preorder.length;
      int len2 = inorder.length;
      if (len1 == 0 || len2 == 0 || len1 != len2) return null;

      int idx = 0;
      for (int val : inorder) {
        map.put(val, idx++);
      }

      return helper(preorder, 0, len2); 
    }

    private TreeNode helper(int[] preorder, int in_left, int in_right) {
      // if there is no element to construct subtree
      if (in_left == in_right) {
        return null;
      }

      // pick up pre_idx element as a root
      int rootVal = preorder[pre_idx];
      TreeNode root = new TreeNode(rootVal);

      // root splits inorder list
      // into left and right subtrees
      int idx = map.get(rootVal); // index in inorder array
      
      // recursion
      pre_idx++;

      // build left subtree
       root.left =  helper(preorder, in_left, idx);

      // build right subtree
       root.right = helper(preorder, idx + 1,  in_right);
      return root;
    }
}
