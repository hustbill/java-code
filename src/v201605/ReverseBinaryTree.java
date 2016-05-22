package v201605;

public class ReverseBinaryTree {

	public ReverseBinaryTree() {
		// TODO Auto-generated constructor stub
	}
	
	public TreeNode reverseBinaryTree(TreeNode root) {
		if (root == null || root.left == null) return root;
		
		return root;
	}
	
	public boolean isBST(TreeNode root) {
		if (root == null) return true;
		
		if (root.left.val < root.val
				&& root.val < root.right.val)  {
			return isBST(root.left) && isBST(root.right);
			
		}
		
		return false;
	}

}
