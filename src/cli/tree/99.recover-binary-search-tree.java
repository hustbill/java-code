/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (35.45%)
 * Total Accepted:    125.8K
 * Total Submissions: 354.9K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,null,null,2]
 * 
 * 1
 * /
 * 3
 * \
 * 2
 * 
 * Output: [3,1,null,null,2]
 * 
 * 3
 * /
 * 1
 * \
 * 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,1,4,null,null,2]
 * 
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 * 
 * Output: [2,1,4,null,null,3]
 * 
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 * 
 * 
 * Follow up:
 * 
 * 
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
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
    // idea: find two swapped nodes during the inorder traversal, and swap node values.
    // There are 3 different approaches to implement inorder traversal: iterative, recursive and morris.
    // using three pointers:  x, y , pred
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque();
        TreeNode x = null, y = null, pred = null;

        while (!stack.isEmpty() || root != null) {
          while (root != null) {
            stack.add(root);
            root = root.left;
          }
          root = stack.removeLast();
          if (pred != null && root.val < pred.val) {
            // first swap occurrence
            y = root;
            // second swap occurrence
            if (x == null) x = pred;
            else break;
          }
          pred = root;
          root = root.right;
        }
        swap(x,y);
    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
