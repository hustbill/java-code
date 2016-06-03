package tree;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        // using dfs
        List<String> res = new ArrayList<String>();
        
        if (root == null)  {
            return res;
        }
        dfs(root, "", res);
        
        return res;
    }
    
    // https://leetcode.com/discuss/52072/accepted-java-simple-solution-in-8-lines
    // [1, 2 ,3 ,5] => ["1->2->5","1->3"]
    public void dfs(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val );
        }
        
        if (root.left != null) {
            dfs(root.left,  path + root.val + "->" , res);
        }
        
        if (root.right != null) {
          dfs(root.right, path + root.val + "->", res);
        }
    }
}