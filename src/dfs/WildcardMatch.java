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

	 public boolean isMatch(String s, String p) {
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
	        
	        // str - > row,  pattern -> col,  2D matrix, dp solution 
	        /*  T[i][j]  =  (1) T[i-1][j-1]              if p[j] = ? || s[i-1] == p[j-1]
	                        (2)  T[i][j-1] || T[i-1][j]  if p[j]=*
	                        (3)  False                   if s[i] != p[j]
	            Time complexity : O(m * n)   Space complexity : O(m * n)
	            s = "xbylmz" , p = "x?y*z" --> true
	        */
	        boolean[][] T = new boolean[str.length + 1][pattern.length + 1];
	        T[0][0] = true;
	        
	        if (writeIndex > 0 && pattern[0] == '*') {
	            T[0][1] = true;
	        }
	        
	        for (int i = 1; i < T.length; i++) {
	            for (int j = 1; j < T[0].length; j++) {
	                if (pattern[j-1] == '?'  || str[i-1] == pattern[j-1]  ) {
	                    T[i][j] = T[i-1][j-1];
	                } else if (pattern[j-1] == '*') {
	                    T[i][j] =  T[i-1][j] || T[i][j-1];
	                }
	            }
	        }
	        return T[str.length][writeIndex];
	    }
	
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
		 String s = "xbylmz", p = "x?y*z";
		 WildcardMatch wcm = new WildcardMatch();
		 System.out.println(wcm.isMatch(s, p) );

		}
}
