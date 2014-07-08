/* Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.*/

/*This method uses the recursive way, what need to pay attention to is the "<" or "<=" in case there are duplicated 
number in the tree.*/

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
    public boolean isValidBST(TreeNode root) {
        return Helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean Helper(TreeNode root, int minVal, int maxVal){
        if(null==root)
            return true;
        if(root.val<=minVal || root.val>=maxVal)
            return false;
        else
            return Helper(root.left,minVal,root.val) && Helper(root.right,root.val, maxVal);
    }
}


/* Follow up: Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3 */
   
/* It is similar to the above solution, find out the left and right subtrees, then use recursive way to construct. */


public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
    public ArrayList<TreeNode> generateTrees(int start, int end){
        ArrayList<TreeNode> result=new ArrayList<TreeNode>();
        if(start>end){
            result.add(null);
            return result;
        }
        for(int i=start;i<=end;++i){
            for(TreeNode left:generateTrees(start,i-1)){
                for(TreeNode right:generateTrees(i+1,end)){
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
