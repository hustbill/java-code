/* Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.*/

/* This is the recursive version*/

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
    public int maxDepth(TreeNode root) {
        if(null==root)
            return 0;
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}

/*This is the iternative version, which is similiar to the internative post-order traversal. Since post-order traversal
record the nodes of uppper level, while inorder and preorder cannot.*/

public class Solution {
    public int maxDepth(TreeNode root) {
        if(null==root)
            return 0;
        int maxDep=0;
        int stackSize=1;
        Stack<TreeNode> nodes=new Stack<TreeNode>();
        TreeNode pre=null;
        TreeNode cur=root;
        nodes.push(cur);
        while(false==nodes.empty()){
            cur=nodes.peek();
            if(null==pre || cur==pre.left || cur==pre.right){
                if(null!=cur.left){
                    nodes.push(cur.left);
                    stackSize++;
                }
                else if(null!=cur.right){
                    nodes.push(cur.right);
                    stackSize++;
                }
            }
            else if(pre==cur.left){
                if(null!=cur.right){
                    nodes.push(cur.right);
                    stackSize++;
                }
            }
            else{
                nodes.pop();
                stackSize--;
            }
            pre=cur;
            maxDep=Math.max(stackSize,maxDep);
        }
        return maxDep;
    }

}
