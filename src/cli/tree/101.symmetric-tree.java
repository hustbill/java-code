/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (44.15%)
 * Total Accepted:    446.4K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * 
 * But the following [1,2,2,null,3,null,3] is not:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
       //return isMirror(root, root);
       // iterative solution
       Queue<TreeNode> q = new LinkedList<TreeNode>();
       q.add(root);
       q.add(root);

       while(!q.isEmpty()) {
           TreeNode t1 = q.poll();
           TreeNode t2 = q.poll();

           if (t1 == null && t2 == null) continue; // go to next round
           if (t1 == null || t2 == null) return false;
           if (t1.val != t2.val) return false; // not symmetric 

           q.add(t1.left);
           q.add(t2.right);
           q.add(t1.right);
           q.add(t2.left);
        }
       return true ;

    }
    // Time: O(n), Space: O(n) 
    // Recursive solution; another one is iterative using Stack
    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null ||  node2 == null) return false;

        if (node1.val != node2.val) {
            return false;
        }
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }


}
