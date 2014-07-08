/*Given inorder and postorder traversal of a tree, construct the binary tree*/

/*This method uses the recursive way to get the left and right child for the root. */

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(0==inorder.length || inorder.length != postorder.length)
            return null;
        int length=inorder.length;
        TreeNode root= new TreeNode(postorder[length-1]);
        int index=0;
        while(inorder[index]!=root.val){
            index++;
        }
        if(index>0)
            root.left=buildTree(Arrays.copyOfRange(inorder,0,index),Arrays.copyOfRange(postorder,0,index));
        if(index<length-1)
            root.right=buildTree(Arrays.copyOfRange(inorder,index+1,length),Arrays.copyOfRange(postorder,index,length-1));
        return root;
    }
}
