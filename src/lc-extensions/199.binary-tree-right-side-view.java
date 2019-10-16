import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (49.89%)
 * Likes:    1338
 * Dislikes: 72
 * Total Accepted:    199.9K
 * Total Submissions: 400.6K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
 * 
 */

// @lc code=start
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if (root == null)
            return ret;
        queue.offer(root);
        while (!queue.isEmpty()) {
            // number of nodes at current level
            int levelNum = queue.size();
            
            // Traverse all ndoes of current level
            for (int i = 1; i <= levelNum; i++) {
                TreeNode curr = queue.poll();
                // Add the right most element at the level
                if (i == levelNum)
                    ret.add(curr.val);
                //Add left node to queue
                if (curr.left != null)
                    queue.offer(curr.left);
                // Add right node to queue
                if (curr.right != null)
                    queue.offer(curr.right);              
            }
        }
        return ret;

    }

    // first level order traversal
    // second, get the rightmost item from sublist, add into result list.
    public List<Integer> rightSideView_my_original_ok(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> lists = new ArrayList<>();

        if (root == null)
            return ret;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> sublist = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) 
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            lists.add(sublist);
        }

        for (List<Integer> list : lists) {
            ret.add(list.get(list.size() - 1));
        }
        return ret;

    }
}
// @lc code=end

