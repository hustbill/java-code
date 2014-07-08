/* Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.*/

/*Here are 3 ways to solve the problem, recursive, BFS and DFS.*/

/* The recursive version*/
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(null==root)
            return false;
        if(root.val==sum && null==root.left && null==root.right)
            return true;
        else
            return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}

/* The BFS version, the DFS version is similar, the difference is using stack or queue.*/
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(null==root)
            return false;
        Queue<TreeNode> nodes=new LinkedList<TreeNode>();
        Queue<Integer> sums=new LinkedList<Integer>();
        nodes.add(root);
        sums.add(root.val);
        while(!nodes.isEmpty()){
            TreeNode node=nodes.poll();
            int accsum=sums.poll();
            if(accsum==sum && null==node.left && null==node.right)
                return true;
            if(null!=node.left){
                nodes.add(node.left);
                sums.add(accsum+node.left.val);
            }
            if(null!=node.right){
                nodes.add(node.right);
                sums.add(accsum+node.right.val);
            }
        }
        return false;
    }
}


/* Follow up: Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]*/

public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
        if(null==root)
            return result;
        ArrayList<Integer> cur=new ArrayList<Integer>();
        helper(root,sum,result,cur);
        return result;
    }
    public void helper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cur){
        if(null==root)
            return ;
        if(sum==root.val && null==root.left && null==root.right){
            cur.add(root.val);
            ArrayList<Integer> tmp=new ArrayList<Integer>(cur);
            result.add(tmp);
            cur.remove(cur.size()-1);
            return ;
        }
        cur.add(root.val);
        helper(root.left,sum-root.val,result,cur);
        helper(root.right,sum-root.val,result,cur);
        cur.remove(cur.size()-1);
    }
}
