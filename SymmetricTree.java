/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
 Input:	{1,2,2,#,3,3}
Output:	false
Expected:	true
 */
public class SymmetricTree {
	
	public static boolean isSymmetric(TreeNode root) {
	 	if (root == null ) return true;
		return checkChild(root.left, root.right);
	}

	public static boolean checkChild(TreeNode left, TreeNode right ) {
		if( left == null && right == null ) return true ;
		if ((left == null && right != null) ||  (left !=null && right == null )) return false;
		if(left !=null && right !=null) {
			if (left.val == right.val) {
				return(checkChild(left.left, right.right) && checkChild(left.right, right.left));
			}
			else {
				return false;
			}
		} else  return false;
	}

	public static void main(String args[]) {
	   //case 0 
     TreeNode root = new TreeNode(1);
	  TreeNode lChild = new TreeNode(2);
	   TreeNode rChild = new TreeNode(2);
	   root.left = lChild;
	   root.right = rChild;
	   
	   rChild.left = new TreeNode(3);
	   rChild.right = new TreeNode(3);
	   
	   System.out.println(" {1, 2, 2,  #, 3, 3} =" + isSymmetric(root));
	   
	   
	   //case 2 {1, 2}
	   // output: false;
	 	TreeNode root2 = new TreeNode(1);
		TreeNode lChild2 = new TreeNode(2);
		root2.left = lChild2;
		System.out.println(" {1,2} =" + isSymmetric(root2)); 
		
		
		// case 3 {1}
		TreeNode root3 = new TreeNode(1);
		System.out.println(" {1} =" + isSymmetric(root3)); 
		
				
	   
	}
	
	
 // Definition for binary tree
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
