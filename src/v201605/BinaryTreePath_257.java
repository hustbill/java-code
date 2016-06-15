/**
 * 
 */
package v201605;

import java.util.*;

import tree.LevelOrderPrint;

/**
 * @author huazhang
 *
 */
public class BinaryTreePath_257 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(4);
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);

		root.left = two;
		root.right = seven;

		two.left = new TreeNode(1);
		two.right = new TreeNode(3);

		seven.left = new TreeNode(6);
		seven.right = new TreeNode(9);

		System.out.println("Input: ");
		LevelOrderPrint printer = new LevelOrderPrint();
		printer.levelOrderPrint(root);

		System.out.println("result :");
		List<String> list = binaryTreePaths(root);

		for (String s : list) {
			System.out.println(s + " ");
		}

	}
	
	//   // [1, 2 ,3 ,5] => ["1->2->5","1->3"]
	public static List<String> binaryTreePaths(TreeNode root) {
		if (root == null) {
			return null;
		}

		List<String> result = new ArrayList<>();
		dfsHelper(root, "", result);

		return result;
	}

	// https://leetcode.com/discuss/52072/accepted-java-simple-solution-in-8-lines
	public static void dfsHelper(TreeNode root, String path, List<String> result) {
		if (root.left == null && root.right == null) {
			result.add(path + root.val);
		}

		if (root.left != null) {
			dfsHelper(root.left, path + root.val + "->", result);
		}

		if (root.right != null) {

			dfsHelper(root.right, path + root.val + "->", result);
		}

	}

	// update version using StringBuilder
	/*https://leetcode.com/discuss/52072/accepted-java-simple-solution-in-8-lines
	 * 
	 * The time complexity for the problem should be O(n), since we are
	 * basically visiting each node in the tree. Yet an interviewer might ask
	 * you for further optimization when he or she saw a string concatenation. A
	 * string concatenation is just too costly. A StringBuilder can be used
	 * although a bit tricky since it is not immutable like string is.
	 * 
	 * When using StringBuilder, We can just keep track of the length of the
	 * StringBuilder before we append anything to it before recursion and
	 * afterwards set the length back. Another trick is when to append the "->",
	 * since we don't need the last arrow at the end of the string, we only
	 * append it before recurse to the next level of the tree. Hope the solution
	 * helps!
	 */
	
	public static List<String> binaryTreePaths_sb(TreeNode root) {
		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		dfs(res, root, sb);
		
		return res;
		
	}
	
	// dfs Helper Optimal
	public static void dfs(List<String> res, TreeNode root, StringBuilder sb) {
		if (root == null)  {
			return;
		}
		int len = sb.length();
		sb.append(root.val);
		
		if (root.left == null && root.right == null) {
			res.add(sb.toString());
		} else {
			sb.append("->");
			dfs(res, root.left, sb);
			dfs(res, root.right, sb);
		}
		sb.setLength(len);
	}

}
