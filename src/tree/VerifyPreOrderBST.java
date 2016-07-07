/*255. Verify Preorder Sequence in Binary Search Tree
Total Accepted: 8634 Total Submissions: 23097 Difficulty: Medium

Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?

Hide Company Tags Zenefits
Hide Tags Tree Stack
Hide Similar Problems (M) Binary Tree Preorder Traversal*/
package tree;

import java.util.Stack;

public class VerifyPreOrderBST {
	public boolean verifyPreorder(int[] preorder) {
		/*
		 * store the nodes using a stack path. if path.isEmpty() or p <
		 * path.peek(), we still in the left subtree, just push p into path;
		 * 
		 * if p > path.peek(), we pop the node as a low bound, push p into path.
		 * For the next p if smaller than low bound. return false, since being
		 * in their right subtree means we must never come across a smaller
		 * number anymore.
		 * https://leetcode.com/discuss/51543/java-o-n-and-o-1-extra-space
		 * 
		 * test case : [4, 2, 1, 3, 6, 8,5] => false
		 */
		if (preorder == null || preorder.length == 0) {
			return true;
		}
		int low = Integer.MIN_VALUE;
		Stack<Integer> path = new Stack<>();
		for (int p : preorder) {
			if (p < low) {
				return false;
			}
			while (!path.isEmpty() && p > path.peek()) {
				low = path.pop();
			}
			path.push(p);
		}
		return true;
	}
}
