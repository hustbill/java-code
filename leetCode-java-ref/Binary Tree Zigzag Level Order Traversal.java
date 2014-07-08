/* Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right 
to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]*/

/* This problem is similar to the level order traversal, which can be implemented using one Queue. However, in the zigzag
level traversal, one queue is not enough, we use two stacks to store the nodes for current level and next level, then 
switch when current level is empty. */

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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
        if(null==root)
            return result;
        ArrayList<Integer> temp=new ArrayList<Integer>();
        Stack<TreeNode> cur=new Stack<TreeNode>();
        Stack<TreeNode> next=new Stack<TreeNode>();
        boolean left2right=true;
        cur.add(root);
        while(!cur.empty()){
            TreeNode node=cur.pop();
            if(null!=node){
                temp.add(node.val);
                if(left2right){
                    next.push(node.left);
                    next.push(node.right);
                }
                else{
                    next.push(node.right);
                    next.push(node.left);
                }
            }
            if(cur.empty()){
                if(temp.size()>0)
                    result.add(temp);
                cur=(Stack)next.clone();
                next=new Stack<TreeNode>();
                temp=new ArrayList<Integer>();
                left2right=!left2right;
            }
        }
        return result;
    }
}
