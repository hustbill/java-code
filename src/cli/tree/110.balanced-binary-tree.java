/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 *
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (41.56%)
 * Total Accepted:    347.4K
 * Total Submissions: 835.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * 
 * a binary tree in which the depth of the two subtrees of every node never
 * differ by more than 1.
 * 
 * 
 * Example 1:
 * 
 * Given the following tree [3,9,20,null,null,15,7]:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * Return true.
 * 
 * Example 2:
 * 
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * 
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   2
 * ⁠   / \
 * ⁠  3   3
 * ⁠ / \
 * ⁠4   4
 * 
 * 
 * Return false.
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
    int lh = 0;
    int rh = 0;
    
    // O(N) time complexity
    // bottom up approach, each node in the tree only need be accessed once.
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        
        int lH = getHeight(node.left);
        if (lH == -1) {
            return -1; // stop traversal, is not balanced binary tree
        }
        
        int rH = getHeight(node.right);
        if (rH == -1) {
            return - 1;
        }

        if (Math.abs(rH -lH) > 1) {
            return -1;
        }
        return Math.max(lH, rH) + 1;
    }

    public boolean isBalanced_failed(TreeNode root) { // 
        if (root == null) return true;

        if (root.left != null) lh++; // 当出现第一个左子树节点为叶子节点时，应该停止lh++
        if (root.right != null) rh++;
       
        return Math.abs(lh - rh) > 1 ? false: isBalanced(root.left) && isBalanced(root.right);
    }
}
