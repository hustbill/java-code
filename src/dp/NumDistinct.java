/*
115. Distinct Subsequences   QuestionEditorial Solution  My Submissions
Total Accepted: 59855
Total Submissions: 198263
Difficulty: Hard
Contributors: Admin
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

Hide Tags Dynamic Programming String

*/
public class NumDistinct {
    
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        NumDistinct nd = new NumDistinct();
        System.out.println(nd.numDistinct(s,t));
    }
    
    // http://blog.csdn.net/fly_yr/article/details/50408457
    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0  || t == null || t.length() == 0) {
            return 0;
        }   
        
        int lens = s.length();
        int lent = t.length();
        int[][] dp = new int[lens + 1][lent + 1];
        dp[0][0] = 1;  // s(0, i) -> t(0) 的方法数为1
        for (int i = 1; i <= lens; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= lent; j++) {
                dp[i][j] = dp[i-1][j];
                if (s.charAt(i -1 ) == t.charAt(j -1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[lens][lent];
    }
}