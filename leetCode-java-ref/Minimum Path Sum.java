/* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the 
sum of all numbers along its path.*/

/* dp problem, running time O(n2), space O(n).*/

public class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        if(0==m)
            return 0;
        int n=grid[0].length;
        int[] dp=new int[n];

        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(j>0)
                    dp[j]=i>0?Math.min(dp[j],dp[j-1]):dp[j-1];
                dp[j]+=grid[i][j];
            }
        }
        return dp[n-1];
    }
}
