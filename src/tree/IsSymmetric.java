/*
 * Date : 06/02/2016 
 */
package tree;


public class IsSymmetric {
	
	public boolean isSymmetric(TreeNode root) {
        // [1, 2, 2, 4, 3, 3,4, 5, 6, 7, 8, 8, 7,6, 3]
        // [1]
        // [1, 2, 2]
        
        if (root == null) return true;
    
        if (root.left == null && root.right == null) {
           return true;
        }
       
        if (root.left == null || root.right == null) {
           return false;
        }
       
        if (root.left.val  == root.right.val) {
            return helper(root.left.left, root.right.right) &&
            helper(root.right.left, root.left.right);
        }
        
        return false;
        
    }
    
    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        
         if (left == null || right == null) {
           return false;
        }

       if ( left.val == right.val) {
         
           return helper(left.left, right.right)  && helper(left.right, right.left);
       } 
       return false;
    }

}
