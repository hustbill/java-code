/* Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
every node never differ by more than 1.*/

/* The first method uses the recursive way, the running time is O(n2), because for each node, it will get the height of 
its two children.*/
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
    public boolean isBalanced(TreeNode root) {
        if(null==root)
            return true;
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        if(Math.abs(leftHeight-rightHeight)>1)
            return false;
        else
            return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int getHeight(TreeNode root){
        if(null==root)
            return 0;
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
}


/* This method uses the iternative way, the running time is O(n), space is O(lgn), since in the getHeight function, it 
will test the balanced tree.*/

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(-1==getHeight(root))
            return false;
        else
            return true;
    }
    public int getHeight(TreeNode root){
        if(null==root)
            return 0;
        int leftHeight=getHeight(root.left);
        if(-1==leftHeight)
            return -1;
        int rightHeight=getHeight(root.right);
        if(-1==rightHeight)
            return -1;
        int diff=Math.abs(leftHeight-rightHeight);
        if(diff>1)
            return -1;
        else
            return Math.max(leftHeight,rightHeight)+1;
    }
}
