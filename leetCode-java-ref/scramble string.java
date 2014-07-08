/* Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.*/

/* The first solution uses three demension dynamic programming. dp[k][i][j] presents whether s2 from index j
with the length of k could be scrambled from s1 from index i.
Here are the formular:
1. init: dp[1][i][j]=(s1[i]==s2[j])?true:false
2. dp[k][i][j] = ( dp[divlen][i][j] && dp[k-divlen][i+divlen][j+divlen] )  ||  ( dp[divlen][i][j+k-divlen] && dp[k-divlen][i+divlen][j] ) (divlen = 1,2,3...k-1) As long as one conticion is meet, it stops.*/


public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        int len=s1.length();
        if(0==len)
            return true;
        boolean[][][] dp=new boolean[len+1][len][len];
        for(int i=0;i<len;++i){
            for(int j=0;j<len;++j){
                dp[1][i][j]= s1.charAt(i)==s2.charAt(j) ? true :false;
            }
        }
        for(int k=2;k<=len;++k){
            for(int i=0;i<=len-k;++i){
                for(int j=0;j<=len-k;++j){
                    dp[k][i][j]=false;
                    for(int divlen=1;divlen<k && !dp[k][i][j];++divlen){
                        if((dp[divlen][i][j] && dp[k-divlen][i+divlen][j+divlen])||
                        (dp[divlen][i][j+k-divlen] && dp[k-divlen][i+divlen][j])){
                            dp[k][i][j]=true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[len][0][0];
    }
}

/*The second solution use recursive method. In this solution, we need to add some condition check to reduce the complexity of recursion. */

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        int len=s1.length();
        if(0==len)
            return true;
        if(s1.equals(s2))
            return true;
        char[] cs1=s1.toCharArray();
        Arrays.sort(cs1);
        char[] cs2=s2.toCharArray();
        Arrays.sort(cs2);
        String ss1=new String(cs1);
        String ss2=new String(cs2);
        if(!ss1.equals(ss2))
            return false;
        for(int i=1;i<len;++i){
            String s1Left=s1.substring(0,i);
            String s1Right=s1.substring(i);
            String s2Left=s2.substring(0,i);
            String s2Right=s2.substring(i);
            if(isScramble(s1Left,s2Left) && isScramble(s1Right,s2Right))
                return true;
            s2Left=s2.substring(len-i);
            s2Right=s2.substring(0,len-i);
            if(isScramble(s1Left,s2Left) && isScramble(s1Right,s2Right))
                return true;
        }
        return false;
    }
}
