/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (42.87%)
 * Total Accepted:    247K
 * Total Submissions: 574.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
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
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
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
    // BFS
    public List<List<Integer>> zigzagLevelOrder_BFS(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean order = true;  // to change zigzag order 
        queue.offer(root);
        while (!queue.isEmpty()) {
            int height = queue.size();
            List<Integer> curr = new ArrayList<Integer>();
            for (int i = 0; i < height;  i++) {
                TreeNode p = queue.poll();
                if (order) {
                    curr.add(p.val);
                } else {
                    curr.add(0, p.val);
                }
                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);
            }
            ret.add(curr);
            order = order ? false: true;
        }
        return ret;
    }
    
    // DFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        helper(root, ret, 0);
        return ret;
    }

    private void helper(TreeNode root, List<List<Integer>> ret, int height) {
        if (root == null) return ;
        if (ret.size() <= height) {
            ret.add(new ArrayList<Integer>());
        }
        if (height % 2 == 0) {
            ret.get(height).add(root.val);
        } else {
            ret.get(height).add(0, root.val);
        }
        helper(root.left, ret, height + 1);
        helper(root.right, ret, height + 1);
    }
}
