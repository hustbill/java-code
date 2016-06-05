package tree;

import java.util.*;

public class PreOrderTraversal {
	 public List<Integer> preorderTraversal(TreeNode root) {
	        // test case: [1,2, 5, 3, 4, 6, 7] => [1,2,3,4,5,6,7]
	        // https://leetcode.com/discuss/19798/accepted-iterative-solution-in-java-using-stack
	        List<Integer> res = new LinkedList<>();
	        Deque<TreeNode> stack = new LinkedList<>();
	        stack.add(root);
	        
	        while(!stack.isEmpty()) {
	            TreeNode node = stack.pop();
	            if (node != null) {
	                res.add(node.val);
	                stack.push(node.right);
	                stack.push(node.left);
	            }
	        }
	        return res;
	    }

	    
	    public List<Integer> preorderTraversal_recursive(TreeNode root) {
	        List<Integer> res = new ArrayList<>();
	        
	        if (root == null) {
	            return res;
	        }
	        
	        res.add(root.val);
	        
	        res.addAll(preorderTraversal(root.left));
	        res.addAll(preorderTraversal(root.right));
	        
	        return res;
	    }

}
