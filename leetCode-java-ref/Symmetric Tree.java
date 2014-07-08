/* Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3  */
   
/* This first method use the recursive way */

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
    public boolean isSymmetric(TreeNode root) {
        if(null==root)
            return true;
        if(null==root.left && null==root.right)
            return true;
        return subSymmetric(root.left, root.right);
    }
    public boolean subSymmetric(TreeNode leftN, TreeNode rightN){
        if(null==leftN && null==rightN)
            return true;
        if(null==leftN || null==rightN)
            return false;
        if(leftN.val != rightN.val)
            return false;
        return subSymmetric(leftN.left,rightN.right) && subSymmetric(leftN.right,rightN.left);
    }
}

/* The second method uses the iternative way, which uses two queues to keep the subnodes of left child and right child.*/

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(null==root)
            return true;
        if(null==root.left && null==root.right)
            return true;
        Queue<TreeNode> leftChild=new LinkedList<TreeNode>();
        Queue<TreeNode> rightChild=new LinkedList<TreeNode>();
        leftChild.add(root.left);
        rightChild.add(root.right);
        while(leftChild.size()>0 && rightChild.size()>0){
            TreeNode leftN=leftChild.peek();
            TreeNode rightN=rightChild.peek();
            leftChild.remove();
            rightChild.remove();
            if(!(null==leftN && null==rightN)){
                if(null==leftN || null==rightN)
                    return false;
                if(leftN.val!=rightN.val)
                    return false;
                leftChild.add(leftN.left);
                leftChild.add(leftN.right);
                rightChild.add(rightN.right);
                rightChild.add(rightN.left);
            }
        }
        if(leftChild.size()>0 ||rightChild.size()>0)
            return false;
        else 
            return true;
    }
}
