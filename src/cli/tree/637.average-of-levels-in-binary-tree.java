/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
 *
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 *
 * algorithms
 * Easy (59.49%)
 * Total Accepted:    87.8K
 * Total Submissions: 147.4K
 * Testcase Example:  '[3,9,20,15,7]'
 *
 * Given a non-empty binary tree, return the average value of the nodes on each
 * level in the form of an array.
 * 
 * Example 1:
 * 
 * Input:
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on
 * level 2 is 11. Hence return [3, 14.5, 11].
 * 
 * 
 * 
 * Note:
 * 
 * The range of node's value is in the range of 32-bit signed integer.
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
    public List<Double> averageOfLevels(TreeNode root) {
       List<List<Integer>> lists = new ArrayList<List<Integer>>();
       helper(root, lists, 0);
       List<Double> ret = getAverageOfLevels(lists);
       return ret;           
    }

    private List<Double> getAverageOfLevels(List<List<Integer>> lists) {
        List<Double> ret = new ArrayList<Double>();
        for (List<Integer> list : lists) {
            long sum = 0;
            int size = list.size();
            for (Integer element : list) {
                sum += element; // Use long sum to avoid 2^32 - 1 overflow
            }
            double average = (double)sum / size; // Force convert sum to double
           ret.add(average);
        }
        return ret;
    }

    // DFS helper: get the elements of each level
    private void helper(TreeNode root, List<List<Integer>> lists, int height) {
        if (root == null) return ;
        if (lists.size() <= height) {
            lists.add(new ArrayList<Integer>());
        }
        lists.get(height).add(root.val);
        helper(root.left, lists, height + 1);
        helper(root.right, lists, height + 1);
    }
}
