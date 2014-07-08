/* Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]*/
  
/* Summary: problems related to print all the results, DFS is a good solution.*/

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
        if(null==s || 0==s.length())
            return result;
        ArrayList<String> palin=new ArrayList<String>();
        partitionHelper(s,0,result,palin);
        return result;
    }
    public void partitionHelper(String s, int start, ArrayList<ArrayList<String>> result, ArrayList<String> palin){
        if(start==s.length()){
            ArrayList<String> tmp=new ArrayList<String>(palin);
            result.add(tmp);
            return ;
        }
        for(int i=start+1;i<=s.length();++i){
            String str=s.substring(start,i);
            if(isPalindrome(str)){
                palin.add(str);
                partitionHelper(s,i,result,palin);
                palin.remove(palin.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str){
        int start=0,end=str.length()-1;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

/*Follow up: Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.*/

/* For the minimum/maximum, shortest ... problems, you can think the DP solution. In this problem, D[i] is the minimum
cut number from i to n, D[i]=min(D[j+1]+1) if subtring from i to j is palindrome.*/

public class Solution {
    public int minCut(String s) {
        int len=s.length();
        int[] D=new int[len+1];
        boolean[][] DP=new boolean[len][len];
        for(int i=0;i<=len;++i){
            D[i]=len-i;
        }
        for(int i=len-1;i>=0;--i){
            for(int j=i;j<len;++j){
                if(s.charAt(i)==s.charAt(j) && (j-i<2 || DP[i+1][j-1])){
                    DP[i][j]=true;
                    D[i]=Math.min(D[i],D[j+1]+1);
                }
            }
        }
        return D[0]-1;
    }
}
