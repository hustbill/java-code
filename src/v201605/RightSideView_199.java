/*
199. Binary Tree Right Side View My Submissions QuestionEditorial Solution
Total Accepted: 43290 Total Submissions: 123548 Difficulty: Medium
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

Credits:
Special thanks to @amrsaqr for adding this problem and creating all test cases.

Hide Company Tags Amazon
Hide Tags Tree Depth-first Search Breadth-first Search
Hide Similar Problems (M) Populating Next Right Pointers in Each Node

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class RightSideView {
    public List<Integer> rightSideView_sol1(TreeNode root) {
       /* The core idea of this algorithm:
        1. Each depth of the tree only select one node
        2. View depth is current size of result list
            https://leetcode.com/discuss/31348/my-simple-accepted-solution-java
            */
        List<Integer> list = new ArrayList<>();
        helper(list, root, 0);
        return list;
    }
    
    public void helper(List<Integer> list, TreeNode root, int depth) {
        if (root == null) return ;
        
        if (depth == list.size()) {
            list.add(root.val);
        }
        
        helper(list, root.right, depth + 1);
        helper(list, root.left, depth + 1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
         //https://leetcode.com/discuss/30464/reverse-level-order-traversal-java
         // Reverse Level Order Traversal, java
         List<Integer> list = new ArrayList<>();
         Queue<TreeNode> queue = new LinkedList<>();
         if (root == null) return list;
         
         queue.offer(root);
         
         while(queue.size() != 0) {
             int size = queue.size();
             for(int i=0; i < size; i++) {
                 TreeNode cur = queue.poll();
                 if (i == 0) list.add(cur.val);
                 if (cur.right != null) queue.offer(cur.right);
                 if (cur.left != null) queue.offer(cur.left);
             }
         }
         return list;
    } 
}