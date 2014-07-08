/* Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.*/

/* It seems that the problem is simple, but when both s1 and s2 have the correct character for s3, there is a choice
problem. This problem could be solve by recursion and dp.*/

/* The recursion version*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        return helper(s1,0,s2,0,s3,0);
    }
    public boolean helper(String s1, int p1, String s2, int p2, String s3, int p3){
        if(p3==s3.length())
            return true;
        if(p1==s1.length())
            return s2.substring(p2).equals(s3.substring(p3));
        if(p2==s2.length())
            return s1.substring(p1).equals(s3.substring(p3));
        if(s1.charAt(p1)==s3.charAt(p3) && s2.charAt(p2)==s3.charAt(p3))
            return helper(s1,p1+1,s2,p2,s3,p3+1) || helper(s1,p1,s2,p2+1,s3,p3+1);
        else if(s1.charAt(p1) == s3.charAt(p3))
            return helper(s1,p1+1,s2,p2,s3,p3+1);
        else if(s2.charAt(p2)==s3.charAt(p3))
            return helper(s1,p1,s2,p2+1,s3,p3+1);
        else 
            return false;
    }
}

/* The dynamic programming version.*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        if(0==s1.length())
            return s2.equals(s3);
        if(0==s2.length())
            return s1.equals(s3);
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        dp[0][0]=true;
        for(int i=1;i<=s1.length();++i){
            if(s1.charAt(i-1)==s3.charAt(i-1) && dp[i-1][0])
                dp[i][0]=true;
        }
        for(int j=1;j<=s2.length();++j){
            if(s2.charAt(j-1)==s3.charAt(j-1) && dp[0][j-1])
                dp[0][j]=true;
        }
        for(int i=1;i<=s1.length();++i){
            for(int j=1;j<=s2.length();++j){
                if(s1.charAt(i-1)==s3.charAt(i+j-1) && dp[i-1][j])
                    dp[i][j]=true;
                if(s2.charAt(j-1)==s3.charAt(i+j-1) && dp[i][j-1])
                    dp[i][j]=true;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
