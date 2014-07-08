/* Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/

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
    public void flatten(TreeNode root) {
        if(null==root)
            return ;
        TreeNode leftNode=root.left;
        TreeNode rightNode=root.right;
        if(null!=leftNode){
            root.left=null;
            root.right=leftNode;
            if(null!=rightNode){
                TreeNode rightMost=leftNode;
                while(null!=rightMost.right){
                    rightMost=rightMost.right;
                }
                rightMost.right=rightNode;
            }
            
        }
        flatten(root.right);
    }
}
