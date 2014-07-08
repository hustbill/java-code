/* Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree. */

/* One needs to handle three cases:
Left tree path plus the current root.
Right tree path plus the current root.
The path passes through the root and hence one needs to consider the left path + current root + right path.
In addition compare with the max path so far and update accordingly. */
/*Java doesn't allow to modify passed-in parameters. For this problem, we need to keep track two things during recursions:
the max subpath sum and the current max sum for a given node. One way is to let the helper method return an array of two 
items; Another way is to pass in the current max as an array of one item.*/

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
    public int maxPathSum(TreeNode root) {
        ArrayList<Integer> curMax=new ArrayList<Integer>(1);
        curMax.add(Integer.MIN_VALUE);
        helper(root,curMax);
        return curMax.get(0);
    }
    public int helper(TreeNode root, ArrayList<Integer> curMax){
        if(null==root)
            return 0;
        int leftMax=Math.max(0,helper(root.left,curMax));
        int rightMax=Math.max(0,helper(root.right,curMax));
        curMax.set(0,Math.max(curMax.get(0),root.val+leftMax+rightMax));
        return Math.max(leftMax,rightMax)+root.val;
    }
}
