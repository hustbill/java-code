/*
 * 131. Palindrome Partitioning My Submissions QuestionEditorial Solution
Total Accepted: 66490 Total Submissions: 239524 Difficulty: Medium
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
Hide Company Tags Bloomberg
Hide Tags Backtracking
Hide Similar Problems (H) Palindrome Partitioning II

 */
package dfs;

import java.util.*;

public class ParlindromePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParlindromePartition pt = new ParlindromePartition();
		String s = "aab";
		List<List<String>> res = pt.partition(s);
		// System.out.print(res);

	}

	public List<List<String>> partition(String s) {
		/*
		 * Time complexity is O(n*(2^n)). The function isPalindrome is O(n)
		 * https://leetcode.com/discuss/18984/java-backtracking-solution if the
		 * input is "aab", check if [0,0] "a" is palindrome. then check [0,1]
		 * "aa", then [0,2] "aab".
		 * 
		 * While checking [0,0], the rest of string is "ab", use ab as input to
		 * make a recursive call.
		 */
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> cur = new ArrayList<>();

		backtrack(res, cur, 0, s);
		System.out.print(res);
		return res;
	}

	public void backtrack(List<List<String>> res, List<String> cur, int pos, String s) {
		if (pos == s.length()) {
			res.add(new ArrayList<String>(cur));
		}

		for (int i = pos; i < s.length(); i++) {
			if (isPalindrome(s, pos, i)) {
				cur.add(s.substring(pos, i + 1));
				backtrack(res, new ArrayList<String>(cur), i + 1, s);
				cur.remove(cur.size() - 1);
			}
		}
	}

	public boolean isPalindrome(String str, int l, int r) {
		while (l < r) {
			if (str.charAt(l++) != str.charAt(r--)) {
				return false;
			}
		}
		return true;
	}

}
