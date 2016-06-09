package tree;

/*
 * 96. Unique Binary Search Trees My Submissions QuestionEditorial Solution
Total Accepted: 85049 Total Submissions: 225189 Difficulty: Medium
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
Hide Company Tags Snapchat
Hide Tags Tree Dynamic Programming
Hide Similar Problems (M) Unique Binary Search Trees II

 */
import java.util.*;

public class NumTree {

	public static void main(String[] args) {
		NumTree nt = new NumTree();
		int n = 3;
		System.out.println(nt.numTrees(n));
	}

	// DP: the relationship between n=2 (1->3 ..) and n=3 (1->3->2...) 
	
	/** DP solution
	 * https://leetcode.com/discuss/17674/dp-problem-10-lines-with-comments
	 * Taking 1~n as root respectively:
	 *      1 as root: # of trees = F(0) * F(n-1)  // F(0) == 1
	 *      2 as root: # of trees = F(1) * F(n-2) 
	 *      3 as root: # of trees = F(2) * F(n-3)
	 *      ...
	 *      n-1 as root: # of trees = F(n-2) * F(1)
	 *      n as root:   # of trees = F(n-1) * F(0)
	 *
	 * So, the formulation is:
	 *      F(n) = F(0) * F(n-1) + F(1) * F(n-2) + F(2) * F(n-3) + ... + F(n-2) * F(1) + F(n-1) * F(0)
	 */
	public int numTrees(int n) {
		int[] F = new int[n + 1];
		F[0] = F[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				F[i] += F[j - 1] * F[i - j];
			}
		}

		return F[n];
	}

	/* https://leetcode.com/discuss/24282/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
	 * G(n): the number of unique BST for a sequence of length n.
	 * 
	 * F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the
	 * root of BST, and the sequence ranges from 1 to n.
	 * 
	 * G(n), is the sum of BST F(i) using each number i as a root. i.e. G(n) =
	 * F(1, n) + F(2, n) + ... + F(n, n).
	 * 
	 * To construct an unique BST out of the entire sequence [1, 2, 3, 4, 5, 6,
	 * 7] with 3 as the root, which is to say, we need to construct an unique
	 * BST out of its left subsequence [1, 2] and another BST out of the right
	 * subsequence [4, 5, 6, 7], and then combine them together (i.e. cartesian
	 * product). 
	 * 
	 * The tricky part is that we could consider the number of unique
	 * BST out of sequence [1,2] as G(2), and the number of of unique BST out of
	 * sequence [4, 5, 6, 7] as G(4). Therefore, F(3,7) = G(2) * G(4).
	 * 
	 * F(i, n) = G(i-1) * G(n-i) 1 <= i <= n Combining the above two formulas,
	 * we obtain the recursive formula for G(n). i.e.
	 * 
	 * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
	 * 
	 * 
	 */


	public int numTrees_failed(int n) {
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (paths.size() == 0) {
				paths.add(new ArrayList<>(i));
			}
			for (int j = 0; j < paths.size(); j++) {
				List<Integer> path = paths.get(j);
				for (int k = 0; k < path.size(); k++) {
					path.add(k, i);
					System.out.println("path" + path);
					if (isValidBST(path)) {
						paths.add(path);
					}

				}
			}
		}

		return paths.size();

	}

	public boolean isValidBST(List<Integer> path) {
		return path.size() % 2 == 0;
	}
}
