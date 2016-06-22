/*
 * 270. Closest Binary Search Tree Value 
Total Accepted: 13710 Total Submissions: 39124 Difficulty: Easy
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Hide Company Tags Microsoft Google Snapchat
Hide Tags Tree Binary Search
Hide Similar Problems (M) Count Complete Tree Nodes (H) Closest Binary Search Tree Value II

 */
package tree;

public class ClosestValueBST {
	
	public int closestValue(TreeNode root, double target) {
		
		int ret1 = closestValueIter(root, target);  // beat 62.39%
		int ret2 = recursive(root, target);  //beat 62.39%
		
		return ret1 == ret2 ? ret2 : ret1;
	}
	
	public int closestValueIter(TreeNode root, double target) {
		/*  
		 * https://leetcode.com/discuss/60089/clean-and-concise-java-solution
		 * test case:
		[4, 2, 6, 1, 3, 5, 7]  4.428571  -> 4
        [1, 2], 3.428571 - > 2
        [2, 1], 2147483647.0  -> 2
        [8, 1], 6.0  - 8
        */
        
      int ret = root.val; // 保持起始的root值，和下次的iteration 做比较
      
      while (root != null) {
    	  if (Math.abs(target - root.val ) < Math.abs( target - ret )) {
    		  ret = root.val;
    	  } 
    	  root = root.val > target ? root.left : root.right;
      }
      return ret;
    }
    
    public int recursive(TreeNode root, double target) {
    	// https://leetcode.com/discuss/54438/4-7-lines-recursive-iterative-ruby-c-java-python
        int a = root.val;
        TreeNode kid = target > a ? root.right : root.left;
        if (kid == null)  return a;
        
        int b = recursive(kid, target);
        return Math.abs(a - target)  < Math.abs(b - target) ? a : b;
        
        
//        if (Math.abs( root.val -  target) <= 0.5) {
//            return root.val;
//        } else if ( target - (double) root.val > 0.5) {
//            return helper(root.right, target, root.val);
//        } else  if ((double)root.val - target > 0.5){
//            return helper(root.left, target, root.val);
//        } else {
//        	System.out.println("here wrong!");
//        	return lastVal;
//        }
    }

	public static void main(String[] args) {
		
		int[][] nums;
		
		ConvertArrayToBST_108 cbst = new ConvertArrayToBST_108();
		ClosestValueBST  cv = new ClosestValueBST();
		
		nums = new int[][] {{1, 2, 3, 4, 5, 6, 7}, {1, 2}, {2, 1} , {8, 1}};
		double[] targets = {4.428571, 3.428571, 2147483647.0 , 6.0};
		for (int i = 0; i < targets.length; i++) {
			double target = targets[i];
			TreeNode root = cbst.sortedArrayToBST(nums[i]);
			System.out.println(cv.closestValue(root, 	target));
		}
		
	}

}
