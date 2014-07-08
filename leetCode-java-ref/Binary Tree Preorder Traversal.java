/* Given a binary tree, return the preorder traversal of its nodes' values. */

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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(null==root)
            return result;
        Stack<TreeNode> nodes=new Stack<TreeNode>();
        nodes.push(root);
        while(false==nodes.empty()){
            TreeNode current=nodes.pop();
            result.add(current.val);
            if(null!=current.right)
                nodes.push(current.right);
            if(null!=current.left)
                nodes.push(current.left);
        }
        return result;
    }
}
