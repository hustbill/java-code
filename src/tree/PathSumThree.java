/*
 * 113. Path Sum II
Total Accepted: 83983 Total Submissions: 293023 Difficulty: Medium
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
Hide Company Tags Bloomberg
Hide Tags Tree Depth-first Search
Hide Similar Problems (E) Path Sum (E) Binary Tree Paths

 */
package tree;

import java.util.*;

public class PathSumThree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(8);
		root.left = left;
		root.right = right;

		left.left = new TreeNode(11);
		left.left.left = new TreeNode(7);
		left.left.right = new TreeNode(2);

		right.left = new TreeNode(13);
		right.right = new TreeNode(9);
		right.right.left = new TreeNode(6);
		right.right.right = new TreeNode(1);

		PathSumThree pts = new PathSumThree();
		int sum = 22;
		List<List<Integer>> paths = pts.pathSum(root, sum);
		System.out.println(paths);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		// https://leetcode.com/discuss/16980/dfs-with-one-linkedlist-accepted-java-solution
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
		/*
		 * using ArrayList allows O(1) access to the each node, that means
		 * removing the last element takes only O(1). If you use LinkedList,
		 * initially we have traverse the list to the last node then remove it,
		 * which takes O(n) time. I
		 */
		dfs(root, sum, result, cur);
		return result;

	}

	public void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
		if (root == null)
			return;

		path.add(new Integer(root.val));

		if (root.left == null && root.right == null && root.val == sum) {
			result.add(new ArrayList(path)); // [[5, 4, 11, 2]]
			// result.add(path); // [[]]
			/*
			 * when you use add function of List, it just add a copy of
			 * reference of the object into the List instead of a new copy of
			 * the object. So if you don't create a new copy, all the reference
			 * you add to your result refer to the same object.
			 * 
			 */
		} else {
			dfs(root.left, sum - root.val, result, path);
			dfs(root.right, sum - root.val, result, path);
		}

		path.remove(path.size() - 1);
	}

}
