/* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).*/

/* This solution uses BFS to level order traversal, in BFS, the data structure is Queue, not Stack, which is used in DFS.
We keep current and next level, then switch when current level is finished.*/

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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
        if(null==root)
            return result;
        int cur=1,next=0;
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        ArrayList<Integer> curLevel= new ArrayList<Integer>();
        nodes.add(root);
        while(nodes.size()>0){
            TreeNode node=nodes.peek();
            nodes.remove();
            cur--;
            if(null!=node){
                curLevel.add(node.val);
                nodes.add(node.left);
                nodes.add(node.right);
                next+=2;
            }
            if(0==cur){
                if(curLevel.size()>0)
                    result.add(curLevel);
                cur=next;
                next=0;
                curLevel=new ArrayList<Integer>();
            }
        }
        return result;
    }
}

/* Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root). */

/* This solution uses DFS to level order traversal, in DFS, the data structure is Stack. */
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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(null==root)
            return result;
        for(int i=getHeight(root);i>0;--i){
            ArrayList<Integer> currentLevel= new ArrayList<Integer>();
            printLevel(root,currentLevel,i);
            result.add(currentLevel);
        }
        return result;
    }
    public int getHeight(TreeNode root){
        if(null==root)
            return 0;
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
    public void printLevel(TreeNode root, ArrayList<Integer> currentLevel, int level){
        if(null==root)
            return;
        if(1==level)
            currentLevel.add(root.val);
        else{
            printLevel(root.left,currentLevel,level-1);
            printLevel(root.right,currentLevel,level-1);
        }
    }
}
