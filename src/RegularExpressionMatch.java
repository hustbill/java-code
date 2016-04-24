/*10. Regular Expression Matching My Submissions Question
Total Accepted: 69282 Total Submissions: 322971 Difficulty: Hard
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
isMatch("aab", "c*a*b") → true*/

public class RegularExpressionMatch {
    
    public static void main(String[] args) {
       String[] s = {"aa", "aa", "aaa", "aa", "aa", "ab", "aab"} ;
       String[]  p = {"a", "aa", "aa", "a*", ".*", ".*", "c*a*b"};
       
       for (int i = 0; i < s.length; i++) {
           System.out.println(isMatch(s[i], p[i]));
       }   
    }
    
    public static boolean isMatch(String s, String p) {
        // Ref : https://leetcode.com/discuss/32424/clean-java-solution
        if ( p.isEmpty()) {
            return s.isEmpty();
        }
        
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.isEmpty() || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        
        // P.length() >= 2
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            s = s.substring(1);
        }
        return isMatch(s, p.substring(2));
    }
    
    
}