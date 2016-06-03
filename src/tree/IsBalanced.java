package tree;

public class IsBalanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return getHeight(root) != -1;
		   
	}
	
	// get the height of balanced tree
	// 思路： 先计算左子树的高度，再计算右子树高度，在计算过程中，如果左右子树高度超过1，则返回－1
	// https://leetcode.com/discuss/29893/solution-height-every-recursion-avoid-further-useless-search
	public int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int lh = getHeight(node.left);
		if (lh == -1) {
			return -1;
		}
		
		int rh = getHeight(node.right);
		if (rh == -1) {
			return -1;
		}
		
		if (Math.abs(rh - lh) > 1) {
			return -1;
		}
		return Math.max(lh, rh) + 1;
	}
	
	
	// failed 
	// lp  left subtree depth,  rp - right subtree depth
	
	public void helper(TreeNode left, TreeNode right, int lp, int rp) {
		if (left == null && right == null) {
			return ;
		}
		
		 System.out.println("lp = "+ lp + ", rp = " + rp);
		
		if (left != null) {
			lp++;
			helper(left.left, left.right, lp, rp);
		}
		
		 System.out.println("lp2 = "+ lp + ", rp2 = " + rp);
		 
		if (right != null) {
			rp++;
			helper(right.left, right.right, lp, rp);
		}
		
		 System.out.println("lp3 = "+ lp + ", rp3 = " + rp);
		
		
	
		
	}

}
