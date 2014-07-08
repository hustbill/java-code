/* Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.*/

/* recursive approach, each recursive focus on one node. For each recursive,
construct sum to sum*10+current node value, if reach leaf node, return sum, otherwise, add the sum of left subtree and 
right subtree.*/

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
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    public int helper(TreeNode root, int sum){
        if(null==root)
            return 0;
        sum=sum*10+root.val;
        if(null==root.left&&null==root.right)
            return sum;
        return helper(root.left,sum)+helper(root.right,sum);
    }
}
