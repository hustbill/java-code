/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxDepth {

    public static int maxDepth(TreeNode root) {
         if(root == null) {
             return 0;
         }
         else 
             return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
 	}
	
    public static int maxDepth2(TreeNode root) {
		int level = 0;
		if(root != null) {
			level++;
			if(root.left != null ||root.right != null) 
				return searchInDepth(root.left, root.right, level);
			else 
				return level;
		}
		else 
			return  level;
	}
	
	public static int searchInDepth(TreeNode left, TreeNode right, int level) {
		if(left !=  null  && right != null) {
		    level++;
			// System.out.println();
		// 	System.out.println("level=" + level);
		//     System.out.println(String.format("left=%d, right=%d", left.val, right.val));
			
			return searchInDepth(left.left, left.right, level)> searchInDepth(right.left, right.right, level)?
				searchInDepth(left.left, left.right, level):searchInDepth(right.left, right.right, level);
		}
		if(left !=  null  && right == null) {
			level++;
			// System.out.println();
			// System.out.println("level=" + level);
			// System.out.println(String.format("left=%d", left.val));
			return searchInDepth(left.left, left.right, level);
		}
		if(left ==  null  && right != null) {
			level++;
			// System.out.println();
	// 		System.out.println("level=" + level);
	// 		System.out.println(String.format(" right=%d",  right.val));
			return searchInDepth(right.left, right.right, level);
		}
		
			return level;
		}
	

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x;}
	}
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1) ;
		TreeNode  second = new TreeNode(2);
		TreeNode  third = new TreeNode(3);
		root.left = second;
	 //  	root.right = third;
		
		// TreeNode  forth = new TreeNode(4);
// 		TreeNode  fifth = new TreeNode(5);
// 		third.left = forth;
// 		third.right = fifth;
		
		//TreeNode  sixth = new TreeNode(6);
		//fifth.right = sixth;
		
		TreeNode outPut = root;
		System.out.println(String.format("The depth of the tree is : %d ", maxDepth(root)));
		
		

	
	}
	
}