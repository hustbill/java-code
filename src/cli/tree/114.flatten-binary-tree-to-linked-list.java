/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (43.72%)
 * Total Accepted:    257.9K
 * Total Submissions: 589.2K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 
 * The flattened tree should look like:
 * 
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
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
/*
 * 思路  分三步：
1）处理右子树，把当前root (原right node ）赋给 prev 保存
2）处理左子树，把上一轮prev 加到当前root (原left node) 的右子节点， 再把root给 prev保存
3）处理原root，把prev 赋给最初的root的右子节点，最后把flatten完毕的root赋给prev保存

参考链接： https://leetcode.com/discuss/30719/my-short-post-order-traversal-java-solution-for-share
*/

/*  test case :
	 *       1
	 *      /  \
	 *     2    5
	 *
	 *     root    root.right   root.left     pre
	 *     5        null         	null         从 null 变成 5
	 *     2        2->5        	null         变成 2->5
	 *     1       1->2->5      null         1->2->5
	 */

    TreeNode prev = null;

    public void flatten(TreeNode root) {
        // post order travesal Java solution
      if (root == null) return;

           flatten(root.right);
           flatten(root.left);

            root.right = prev;
            root.left = null;
            prev = root;

    }
}
