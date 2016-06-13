package dfs;

/*
 * 44. Wildcard Matching 
Total Accepted: 59407 Total Submissions: 335592 Difficulty: Hard
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
Hide Company Tags Google Snapchat Facebook
Hide Tags Dynamic Programming Backtracking Greedy String
Hide Similar Problems (H) Regular Expression Matching

 */

public class WildcardMatch {

	public boolean isMatch_2D(String s, String p) {
		// ref: dp solution: https://www.youtube.com/watch?v=3ZDZ-N0EPV0
		char[] str = s.toCharArray();
		char[] pattern = p.toCharArray();

		// replace multiple * with one *
		// e.g. a***b***c --> a*b*c
		boolean isFirst = true;
		int writeIndex = 0;

		for (int i = 0; i < pattern.length; i++) {
			if (pattern[i] == '*') {
				if (isFirst) {
					pattern[writeIndex++] = pattern[i];
					isFirst = false;
				}
			} else {
				pattern[writeIndex++] = pattern[i];
				isFirst = true;
			}
		}

		// str - > row, pattern -> col, 2D matrix, dp solution
		/*
		 * T[i][j] = (1) T[i-1][j-1] if p[j] = ? || s[i-1] == p[j-1] (2)
		 * T[i][j-1] || T[i-1][j] if p[j]=* (3) False if s[i] != p[j] Time
		 * complexity : O(m * n) Space complexity : O(m * n) s = "xbylmz" , p =
		 * "x?y*z" --> true
		 */
		boolean[][] T = new boolean[str.length + 1][pattern.length + 1];
		T[0][0] = true;

		if (writeIndex > 0 && pattern[0] == '*') {
			T[0][1] = true;
		}

		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]) {
					T[i][j] = T[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					T[i][j] = T[i - 1][j] || T[i][j - 1];
				}
			}
		}
		return T[str.length][writeIndex];
	}

	/*  优化方法
	 * Though this solution is clear and easy to understand. It is not good
	 * enough in the interview. it takes O(mn) time and O(mn) space.
	 * 
	 * Improvement: 1) optimize 2d dp to 1d dp, this will save space, reduce
	 * space complexity to O(N). 
	 * 2) use iterative 2-pointer.
	 */
	
	public boolean isMatch(String s, String p) {
		// ref: https://leetcode.com/discuss/54278/my-java-dp-solution-using-2d-table
			
		return comparison(s,p);
	}
	

	public boolean comparison(String str, String pattern) {
		    int s = 0, p = 0, match = 0, starIdx = -1;            
	        while (s < str.length()){
	            // advancing both pointers
	            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
	                s++;
	                p++;
	            }
	            // * found, only advancing pattern pointer
	            else if (p < pattern.length() && pattern.charAt(p) == '*'){
	                starIdx = p;
	                match = s;
	                p++;
	            }
	           // last pattern pointer was *, advancing string pointer
	            else if (starIdx != -1){
	                p = starIdx + 1;
	                match++;
	                s = match;
	            }
	           //current pattern pointer is not star, last patter pointer was not *
	          //characters do not match
	            else return false;
	        }

	        //check for remaining characters in pattern
	        while (p < pattern.length() && pattern.charAt(p) == '*')
	            p++;

	        return p == pattern.length();	
	}
	
	/*
	 * Recursive and slow version of wild card matching.
	 */
	public boolean isMatchRecursive(String s, String p) {
		return isMatchingRecursiveUtil(s.toCharArray(), p.toCharArray(), 0, 0);
	}

	public boolean isMatchingRecursiveUtil(char[] text, char[] pattern, int pos1, int pos2) {
		if (pos2 == text.length) {
			return text.length == pos1;
		}

		if (pattern[pos2] != '*') {
			if (pos1 < text.length && (text[pos1] == pattern[pos2] || pattern[pos2] == '?')) {
				return isMatchingRecursiveUtil(text, pattern, pos1 + 1, pos2 + 1);
			} else {
				return false;
			}
		} else {
			// if we have a***b then skip to the last *
			while (pos2 < pattern.length - 1 && pattern[pos2 + 1] == '*') {
				pos2++;
			}
			pos1--; // ?
			while (pos1 < text.length) {
				if (isMatchingRecursiveUtil(text, pattern, pos1 + 1, pos2 + 1)) {
					return true;
				}
				pos1++;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "xbylmz", p = "x?y*z";
		WildcardMatch wcm = new WildcardMatch();
	
		long start = System.nanoTime();
		System.out.println(wcm.isMatch(s, p));
		long end = System.nanoTime();
		System.out.println("time of two pointers sol: " + (end - start));
		
		long start2 = System.nanoTime();
		System.out.println(wcm.isMatch_2D(s, p));
		long end2 =  System.nanoTime();
		System.out.println("time of 2D table sol: " + (end2 - start2));

		// System.out.println(wcm.isMatchRecursive(s, p));

	}
}
