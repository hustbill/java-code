package tree;

public class AmazonOA {

	public static TreeNode LCABST(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == root || q == root) return root;
		if((root.val > p.val && root.val < q.val) ||
				(root.val < p.val && root.val > q.val)) {
			return root;
		} else if(root.val > p.val && root.val > q.val) {
			return LCABST(root.left, p, q);
		} else if(root.val < p.val && root.val < q.val) {
			return LCABST(root.right, p, q);
		} else {
			return null;
		}
	}
	public static int findlen(TreeNode root, int n) {
		return finddistancebst(root, n)-1;
	}
	public static int finddistancebst(TreeNode root, int n) {
		if(root == null) return 0;
		int x = 0;
		if(root.val == n) return x+1;
		if(root.val > n) {
			x = finddistancebst(root.left, n);
		} else {
			x = finddistancebst(root.right, n);
		}
		if(x > 0)
			return x+1;
		else return 0;
	}

}
