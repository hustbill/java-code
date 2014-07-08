/* Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure. */

/* The key point for this problem is when there are only two elements swapped by mistake in BST.

[1,2,3,4,5,6,7] -> [1,2,6,4,5,3,7]

We inorder traverse this tree, when we visit a node, we remember it, because it is just the previous element for the 
next node we visit in ascending order. when we firstly come up with a node which breaks the order, it should be the 
larger  element which is misplaced. When we secondly come up with a node which breaks the order, it should be the 
smaller one which is misplaced.

The only exception is that we have that two continuous element swapped . To handle this case, when we first come up 
witha node which breaks the rule, we store both two elements. If we later meet another misplaced node, we replace the 
smaller element that we stored previously.

The inorder traverse of tree could be done iteratively. So that we do not have to make recursive call. */


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
    public void recoverTree(TreeNode root) {
        TreeNode n1=null, n2=null;
        TreeNode prev=new TreeNode(Integer.MIN_VALUE);
        TreeNode current=root;
        Stack<TreeNode> nodes=new Stack<TreeNode>();
        while(!nodes.empty() || null!=current){
            if(null!=current){
                nodes.push(current);
                current=current.left;
            }
            else{
                current=nodes.pop();
                if(current.val<prev.val){
                    if(null==n1){
                        n1=prev;
                        n2=current;
                    }
                    else
                        n2=current;
                }
                prev=current;
                current=current.right;
            }
        }
        n1.val^=n2.val;
        n2.val^=n1.val;
        n1.val^=n2.val;
    }
}
