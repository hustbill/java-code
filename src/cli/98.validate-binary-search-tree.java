/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (26.14%)
 * Total Accepted:    454.2K
 * Total Submissions: 1.7M
 * Testcase Example:  '[2,1,3]'
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * Input: [2,1,3]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * 
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
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
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    
    }
    /*
     * The idea above could be implemented as a recursion. 
     * One compares the node value with its upper and lower limits if they are available.
     * Then one repeats the same step recursively for left and right subtrees
     * ltt 98.validate-binary-search-tree.java -t '[10,5,15,null,null,6,20]'
     * */
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;
        
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }

        if (upper != null && val >= upper) {
            return false;
        }
        // need to keep val, lower or upper for nextuse
        if (!helper(node.right, val, upper)) return false;
        if (!helper(node.left, lower, val)) return false;
        
        return true;
    }
    
    public boolean isValidBST_failed(TreeNode root) {
      if (root == null) return true;
      if (root.left == null && root.left == null)  return true;
      if (root.right == null && root.left != null) return (root.left.val < root.val) && isValidBST(root.left); 
      if (root.left == null && root.right != null) return (root.right.val > root.val) && isValidBST(root.right);
       
       if (root.left != null && root.right != null) {
          if (root.val > root.left.val &&  root.right.val >  root.val) {
              return isValidBST(root.left) && isValidBST(root.right);    
          } else {
            return false;
         }

       }
       return false;
    }
}
