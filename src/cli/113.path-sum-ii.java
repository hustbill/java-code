/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (41.84%)
 * Total Accepted:    251.1K
 * Total Submissions: 599.6K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // dfs 
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(root, sum, cur, ans);
        return ans;
    }

    private void helper(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> ans) {
        if (root == null) return;

        if (root.left == null && root.right == null && sum == root.val) {
            cur.add(root.val);
            ans.add(new ArrayList<Integer>(cur));
            return;
        } else {
            cur.add(root.val);
            helper(root.left, sum - root.val, new ArrayList<Integer>(cur), ans);
            helper(root.right, sum -root.val, new ArrayList<Integer>(cur), ans);
        }
        cur.remove(cur.size() - 1);

    }
}
