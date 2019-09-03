/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (47.91%)
 * Total Accepted:    245.5K
 * Total Submissions: 510.9K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
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
class Solution {
    /* DFS
     *   stdout: 
  'lists: [[]]\n' +
  'lists: [[], []]\n' +
  'After lists: [[9], []]\n' +
  
  'lists: [[9], []]\n' +
  'lists: [[], [9], []]\n' +
  'After lists: [[15], [9], []]\n' +
  
  'lists: [[15], [9], []]\n' +
  'After lists: [[15, 7], [9], []]\n' +
  
  'After lists: [[15, 7], [9, 20], []]\n' +
  
  'After lists: [[15, 7], [9, 20], [3]]'
  */
    public List<List<Integer>> levelOrderBottom_DFS(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        dfs(root, lists, 0);
        return lists;
    }
    
    private void dfs(TreeNode root, List<List<Integer>> lists, int height) {
        if (root == null) return;
        if (lists.size() <= height) {
            lists.add(0, new ArrayList<Integer>()); // new insert list was added to first index
        }
        // System.out.println("lists: " + lists);
        dfs(root.left, lists, height + 1);
        dfs(root.right, lists, height + 1);
        lists.get(lists.size() - height - 1).add(root.val);
        // System.out.println("\nAfter lists: " + lists);
    }


    // BFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;
        queue.offer(root);

        while(!queue.isEmpty()) {
            int height = queue.size();
           // System.out.printf("\nheight=%d", height);
            List<Integer> curr = new ArrayList<Integer>();
            for (int i = 0; i < height; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                curr.add(queue.poll().val);
            }
            // System.out.println("\ncurr:" + curr);
            ret.add(0, curr);
        }
        return ret;
    }
   
    public List<List<Integer>> levelOrderBottom_my_ok(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int height = getHeight(root);
        while (ans.size() < height) {
            ans.add(new ArrayList<Integer>());
        }
        System.out.printf("ans.size() = %d", ans.size());
        helper(root, ans, height - 1);
        return ans;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        return Math.max(lh, rh) + 1;
   }


    private void helper(TreeNode node, List<List<Integer>> ans, int height) {
        if (node == null) return ;

        ans.get(height).add(node.val); // 非常巧妙，需要记住！！
        helper(node.left, ans, height - 1);
        helper(node.right, ans, height - 1);
    }
}
