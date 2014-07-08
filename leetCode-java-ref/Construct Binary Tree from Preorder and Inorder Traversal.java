/*Given preorder and inorder traversal of a tree, construct the binary tree.*/

/*This method uses the recursive way to get the left and right child for the root. */
/*It is similiar to construct binary tree from post-order and inorder. However, you cannot build binary tree using 
preorder and postorder traversal because you cannot find the index of the root.*/

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(0==inorder.length || inorder.length != preorder.length)
            return null;
        int length=inorder.length;
        TreeNode root= new TreeNode(preorder[0]);
        int index=0;
        while(inorder[index]!=root.val){
            index++;
        }
        if(index>0)
            root.left=buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        if(index<length-1)
            root.right=buildTree(Arrays.copyOfRange(preorder,index+1,length),Arrays.copyOfRange(inorder,index+1,length));
        return root;
    }
}


