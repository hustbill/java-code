import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal_recursive(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;

        if (root.left != null) {
            ret.addAll(inorderTraversal(root.left));
        }
        ret.add(root.val);
        if (root.right != null) {
            ret.addAll(inorderTraversal(root.right));
        }
        return ret;        
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            ret.add(p.val);
            p = p.right;
        }
        return ret;
    }

    // public static void main(String[] args) {
    //     Solution st = new Solution();
    //     TreeNode root = new TreeNode(3);
    //     TreeNode left = new TreeNode(2);
    //     TreeNode right = new TreeNode(6);

    //     root.left = left;
    //     root.right = right;
    //     left.left = new TreeNode(1);
    //     right.left = new TreeNode(5);
    //     right.right = new TreeNode(7);
    //     List<Integer> ret = st.inorderTraversal(root);
    //     System.out.print(ret);
    // }
}
/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
*/
// @lc code=end

