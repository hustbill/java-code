/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (49.89%)
 * Total Accepted:    199.9K
 * Total Submissions: 400.6K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * <p>Given a binary tree, imagine yourself standing on the <em>right</em> side
 * of it, return the values of the nodes you can see ordered from top to
 * bottom.</p>
 * 
 * <p><strong>Example:</strong></p>
 * 
 * <pre>
 * <strong>Input:</strong>&nbsp;[1,2,3,null,5,null,4]
 * <strong>Output:</strong>&nbsp;[1, 3, 4]
 * <strong>Explanation:
 * </strong>
 * ⁠  1            &lt;---
 * ⁠/   \
 * 2     3         &lt;---
 * ⁠\     \
 * ⁠ 5     4       &lt;---
 * </pre>
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
    /*
     * bfs
     * 1. first level order traversal
     * 2. get the rightmost item from sublit, add into result list
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) return ret;

        queue.offer(root);

        while (!queue.isEmpty()) {
            // Number of nodes at current level
            int levelNum = queue.size();
            // / Traverse all ndoes of current level
            for (int i = 1; i <= levelNum; i++) {
                // Add the right most element at the level
                TreeNode curr = queue.poll();
                if (i == levelNum) {
                    ret.add(curr.val);
                }
                // Add left node to queue
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                // Add right node to queue
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return ret;
    }
}
