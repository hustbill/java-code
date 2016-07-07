package old;
/*44. Wildcard Matching
Total Accepted: 49512 Total Submissions: 294526 Difficulty: Hard
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
Hide Company Tags Google
Hide Tags Dynamic Programming Backtracking Greedy String
Hide Similar Problems (H) Regular Expression Matching
*/

public class WildcardMatching {
    
    public static void main(String[] args) {
       String[] s = {"aa", "aa", "aaa", "aa", "aa", "ab", "aab"} ;
       String[]  p = {"a", "aa", "aa", "*", "a*", "?*", "c*a*b"};
       
       for (int i = 0; i < s.length; i++) {
           System.out.println(isMatch(s[i], p[i]));
       }   
    }
    
    public static boolean isMatch(String s, String p) {
      // Ref : https://leetcode.com/discuss/54278/my-java-dp-solution-using-2d-table
      // Using 2D table - dp solution
      boolean[][] match = new boolean[s.length() + 1] [p.length() + 1];
      match[s.length()][p.length()] = true;
      for (int i=p.length() - 1; i>=0 ; i--) {
          if (p.charAt(i) != '*') 
              break;
          else 
              match[s.length()][i] = true;
      }
      
      for (int i=s.length() - 1; i >= 0; i--) {
          for (int j= p.length() -1;  j >= 0; j--) {
              if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') 
                  match[i][j] = match[i+1][j+1];
              else if (p.charAt(j) == '*')
                  match[i][j] = match[i+1][j] || match[i][j+1];
              else 
                  match[i][j] = false;
          }
      }
      return match[0][0];
    }
}