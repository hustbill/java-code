/*
107. Binary Tree Level Order Traversal II
Total Accepted: 75568 Total Submissions: 225036 Difficulty: Easy
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Hide Tags Tree Breadth-first Search
Hide Similar Problems (E) Binary Tree Level Order Traversal

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
public class LevelOrderBottom {
    
      public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 1. bfs 
        // https://leetcode.com/discuss/22538/my-dfs-and-bfs-java-solution
        // - using queue https://leetcode.com/discuss/67186/java-solution-using-queue
        // - using queue https://leetcode.com/discuss/22533/java-solution-with-a-queue-used
        Queue<TreeNode> q = new LinkedList<TreeNode>();
         List<List<Integer>> res = new LinkedList<List<Integer>>();
         
         if (root == null) return res;
         q.offer(root);
         while (!q.isEmpty()) {
             int levelNum = q.size();
             List<Integer> subList = new LinkedList<>();
             for (int i=0; i < levelNum; i++) {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                subList.add(q.poll().val);
             }
             res.add(0, subList);
         }
        return res;
    }
    
    
    public List<List<Integer>> levelOrderBottom_DFS(TreeNode root) {
        //2. dfs  test case: [3,9,20,15,7] and [1, 2]
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return ;
        
        if (height >= res.size()) {
            res.add(0, new LinkedList<Integer>());
        }
        
        helper(res, root.left, height + 1);
        helper(res, root.right, height + 1);
        res.get(res.size() - height -1).add(root.val);
        
    }
}