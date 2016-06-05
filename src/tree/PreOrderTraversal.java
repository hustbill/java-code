package tree;

import java.util.*;

public class PreOrderTraversal {
	 public List<Integer> preorderTraversal(TreeNode root) {
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
