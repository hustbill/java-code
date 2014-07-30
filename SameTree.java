package leetcodeSolution;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode p = new  TreeNode(1);
		
		
		p.left =  new TreeNode(2);
		p.right = new TreeNode(4);
		
		p.left.left = new TreeNode(3);
		p.left.right = new TreeNode(5);
		
		p.right.left = new TreeNode(6);
		p.right.right= new TreeNode(7);
		
		
		p.right.left.left = new TreeNode(8);
		p.right.right.right= new TreeNode(9);
		
		
		TreeNode q = new  TreeNode(1);
		q.left =  new TreeNode(2);
		q.right = new TreeNode(4);
		
		q.left.left = new TreeNode(3);
		q.left.right = new TreeNode(8);
		
		q.right.left = new TreeNode(6);
		q.right.right= new TreeNode(7);
		
		q.right.left.left = new TreeNode(8);
		q.right.right.right= new TreeNode(3);
		

		boolean result = isSameTree(p,q);
		System.out.println(result);
			
	}
	
    public static boolean isSameTree(TreeNode p, TreeNode q) {
    	if (p == null && q == null)
            return true;
    	if ((p == null && q != null) || (p !=null && q == null)) 
    		return false;
    	
    	
    	if( isSameTree(p.left, q.left) == false) {
    		return false;
    	}
    	
    	if( isSameTree(q.right, q.right) == false) {
    		return false;
    	}
    		
    	if (p.val != q.val) 
    		return false;
        return true;
            
      }

}
	

	

