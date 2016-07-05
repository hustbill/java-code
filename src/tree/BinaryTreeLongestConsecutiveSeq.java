/*
 * 298. Binary Tree Longest Consecutive Sequence My Submissions QuestionEditorial Solution
Total Accepted: 9973 Total Submissions: 26688 Difficulty: Medium
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
Hide Company Tags Google
Hide Tags Tree
Hide Similar Problems (H) Longest Consecutive Sequence

 */
package tree;

public class BinaryTreeLongestConsecutiveSeq {

	    int max = 0;
	    
	    public int longestConsecutive(TreeNode root) {
	        /*  https://discuss.leetcode.com/topic/28234/easy-java-dfs-is-there-better-time-complexity-solution
	            Just very intuitive depth-first search, 
	            send cur node value to the next level and compare it with the next level node.
	        */
	        if (root == null) return 0;
	        helper(root, 0, root.val + 1);
	        return max;
	    }
	    
	    public void helper(TreeNode root, int cur, int target) {
	        if (root == null) return;
	        if (root.val == target) {
	            cur++;
	        } else {
	            cur = 1;
	        }
	        
	        max = Math.max(cur, max);
	        helper(root.left, cur, root.val + 1);
	        helper(root.right, cur, root.val + 1);
	    }
    
    // doesn't work.  我的方法不凑效
    public int dfs(TreeNode root, int count) {
    	if (root == null) return count;
    	if (root.right == null && root.left == null) {
    		return count;
    	}
    	
    	if (root.left != null) {
    		if (root.val > root.left.val) {
    			dfs(root.left, count + 1);
    		}
    	}
    	
    	if (root.right != null) {
    		if (root.val > root.right.val) {
    			dfs(root.right, count + 1);
    		}
    	}
    	return count;
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		TreeNode three = new TreeNode(3);
		root.right = three;
		three.left = new TreeNode(2);
		
		TreeNode four = new TreeNode(4);
		three.right = four;
		four.right = new TreeNode(5);
		
		BinaryTreeLongestConsecutiveSeq blcs = new BinaryTreeLongestConsecutiveSeq();
		int result = blcs.longestConsecutive(root);
		System.out.println(result);  // 3
		

	}

}
