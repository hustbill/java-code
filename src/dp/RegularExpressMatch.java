/*
 * 10. Regular Expression Matching  QuestionEditorial Solution  My Submissions
Total Accepted: 86843
Total Submissions: 387233
Difficulty: Hard
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
Hide Company Tags Google Uber Airbnb Facebook Twitter
Hide Tags Dynamic Programming Backtracking String
Hide Similar Problems (H) Wildcard Matching

 */
package dp;

public class RegularExpressMatch {

	public boolean isMatch(String s, String p) {
		// 参考视频 https://www.youtube.com/watch?v=l3hda49XcDE
		int M = s.length(), N = p.length();
		boolean[][] T = new boolean[M + 1][N + 1];

		T[0][0] = true;
		char[] pattern = p.toCharArray();
		char[] str = s.toCharArray();

		// deal with patterns like a*, a*b, a*b*c
		for (int j = 1; j < T[0].length; j++) {
			if (pattern[j - 1] == '*') {
				T[0][j] = T[0][j - 2];
			}
		}

		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (pattern[j - 1] == '.' || str[i - 1] == pattern[j - 1]) {
					T[i][j] = T[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					T[i][j] = T[i][j - 2];
					if (pattern[j - 2] == '.' || pattern[j - 2] == str[i - 1]) {
						T[i][j] = T[i][j] | T[i - 1][j];
					}
				} else {
					T[i][j] = false;
				}
			}
		}
		return T[M][N];
	}

	public static void main(String[] args) {
		RegularExpressMatch rem = new RegularExpressMatch();
		String str = "aab", pattern = "c*a*b";
		System.out.println(rem.isMatch(str, pattern)); // true

	}

}
