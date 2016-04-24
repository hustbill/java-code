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


public class InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        
        Stack<TreeNode>  stack = new Stack<TreeNode>();
        ArrayList<Integer>  result = new ArrayList<Integer>();
        TreeNode curt = root;
        
        while (curt != null && !stack.empty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.peek();
            stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        two.right = new TreeNode(3);
        root.right = two;
    
        System.out.println((root.val));
        
        Iterator<Integer> it = inorderTraversal(root).iterator();
        while(it.hasNext()) {
           
            System.out.println(it.next());
        }
    }
}

class TreeNode {
    int  val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

