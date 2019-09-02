/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (49.74%)
 * Total Accepted:    423.5K
 * Total Submissions: 848.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // use dfs, add left child and right child at same height 
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int height = 0;
        levelHelper(root, height, ans);
        return ans;
    }

    public void levelHelper(TreeNode root, int height, List<List<Integer>> ans) {
        if (root == null) return ;
        if (ans.size() <= height) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(height).add(root.val);
        levelHelper(root.left, height + 1, ans);
        levelHelper(root.right, height + 1, ans);
    }

    public List<List<Integer>> levelOrder_nok(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        if (root == null) return ans;
        helper(root, curr, ans);
        System.out.printf("root.val=%d", root.val);
        List<Integer> rootList = new ArrayList<Integer>();
        rootList.add(root.val);
        ans.add(0, rootList);
        return ans;
    }

    private void helper(TreeNode node, List<Integer> curr,  List<List<Integer>> ans) {
        if (node == null) return;
        if (node.left != null && node.right != null) {
            curr.add(node.left.val);
            curr.add(node.right.val);
            ans.add(new ArrayList<Integer>(curr));
            curr.remove(curr.size() - 1);
            curr.remove(curr.size() - 1);
        }
        if (node.left != null && node.right == null) {
            curr.add(node.left.val);
            ans.add(new ArrayList<Integer>(curr));
            curr.remove(curr.size() - 1);
        }
        if (node.left == null && node.right != null) {
            curr.add(node.right.val);
            ans.add(new ArrayList<Integer>(curr));
            curr.remove(curr.size() - 1);
        }
        helper(node.left, curr, ans);
        helper(node.right, curr, ans);
    }

}
