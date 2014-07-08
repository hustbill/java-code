/* Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of 
one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".*/

/* The DP solution, DP[i] means whether the words from 0 to i could be found in dictionary, DP[i] is true when DP[j] is 
true and word from i to j could be found in dictionary. */

ublic class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(null==s || null==dict)
            return false;
        boolean[] DP=new boolean[s.length()+1];
        DP[0]=true;
        for(int len=1;len<=s.length();++len){
            for(int j=0;j<len;++j){
                if(DP[j] && dict.contains(s.substring(j,len))){
                    DP[len]=true;
                }
                if(DP[len])
                    break;
            }
        }
        return DP[s.length()];
    }
}

/* Follow up: Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word 
is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].
A solution is ["cats and dog", "cat sand dog"].*/

/* The difference is we need to record the positons of each path. So when we are doing the DP process, we record the 
positions j that could reach i.*/

public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        int len=s.length();
        boolean[] dp=new boolean[len+1];
        dp[0]=true;
        ArrayList<ArrayList<Integer>> records=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=len;++i){
            records.add(new ArrayList<Integer>());
        }
        for(int i=1;i<=len;++i){
            for(int j=0;j<i;++j){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i]=true;
                    records.get(i).add(j);
                }
            }
        }
        ArrayList<String> result=new ArrayList<String>();
        helper(s,len,records,result,"");
        return result;
    }
    public void helper(String s, int end, ArrayList<ArrayList<Integer>> records, ArrayList<String> result, String current){
        ArrayList<Integer> prevs=records.get(end);
        for(int i=0;i<prevs.size();++i){
            int n=prevs.get(i);
            String str=s.substring(n,end);
            String r=str;
            if(!current.equals("")){
                    r+=" "+current;
            }
            if(0==n){
                result.add(r);
               // return ; //there should be no return. 
            }
            else{
                helper(s,n,records,result,r);
            }
        }
    }
}
