/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * algorithms
 * Medium (52.87%)
 * Total Accepted:    251.1K
 * Total Submissions: 472.7K
 * Testcase Example:  '[3,1,4,null,2]\n1'
 *
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,1,4,null,2], k = 1
 * ⁠  3
 * ⁠ / \
 * ⁠1   4
 * ⁠ \
 * 2
 * Output: 1
 * 
 * Example 2:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * ⁠      5
 * ⁠     / \
 * ⁠    3   6
 * ⁠   / \
 * ⁠  2   4
 * ⁠ /
 * ⁠1
 * Output: 3
 * 
 * 
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to
 * find the kth smallest frequently? How would you optimize the kthSmallest
 * routine?
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
        // DFS recursive, Time Complexity: O(N)
        // counting could be looked up frequently and BST itself could be altered (inserted/deleted) by multiple times,
        // so that's the main reason that I stored them in an array.
        public int kthSmallest(TreeNode root, int k) {
            if (root == null || k <= 0) return -1;
            List<Integer> res = new ArrayList<>();
            helper(root, k, res);
            return res.get(k - 1);
        }

        private void helper(TreeNode root, int k, List<Integer> res) {
            if (root == null) return;
            helper(root.left, k, res);
            if (k == 0) return; // stop early when meet kth
            res.add(root.val);
            k--;
            helper(root.right, k, res);
        }

       // time complexity: O(N) best, O(N^2) worst
        public int kthSmallest_binary_search(TreeNode root, int k) {
        int count = getNodeCount(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count); // 1 is counted as current node
        }
        return root.val;
    }

    public int getNodeCount(TreeNode n)  {
        if (n == null) return 0;
        return getNodeCount(n.left) + 1 + getNodeCount(n.right);
    }
}
