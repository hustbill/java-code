/* Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node. */

/* This method is similar to the maximum depth of a binary tree, the difference is the base condition. We should check the 
leaf  noede.*/


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(null==root)
            return 0;
        if(null==root.left && null==root.right)
            return 1;
        int leftDepth=Integer.MAX_VALUE;
        if(null!=root.left)
            leftDepth=minDepth(root.left);
        int rightDepth=Integer.MAX_VALUE;
        if(null!=root.right)
            rightDepth=minDepth(root.right);
        return Math.min(leftDepth,rightDepth)+1;
    }
}
