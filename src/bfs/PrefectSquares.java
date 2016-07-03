/*
 * 279. Perfect Squares My Submissions QuestionEditorial Solution
Total Accepted: 39701 Total Submissions: 118444 Difficulty: Medium
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Dynamic Programming Breadth-first Search Math
Hide Similar Problems (E) Count Primes (M) Ugly Number II

 */
package bfs;

import java.util.Arrays;

public class PrefectSquares {
	
    public int numSquares(int n) {
    	
    	   int[] dp = new int[n+1];
           // 将所有非平方数的结果置最大，保证之后比较的时候不被选中
           Arrays.fill(dp, Integer.MAX_VALUE);
           // 将所有平方数的结果置1
           for(int i = 0; i * i <= n; i++){
               dp[i * i] = 1;
           }
           
           for (int k= 2;  k <= n; k++) {
        	  	for (int i = 1;  i * i <= k; i++) {
        	  		dp[k]  = Math.min(dp[k- i*i] + 1, dp[k] ) ;	
            	}
           }
    	return dp[n];
        
    }

    /*
	There are two ways: 
	Dp way: Same as the min coins shown as above
	1. state space
	int[] dp=new int[n+1]
	
	2. Initilizaton
	dp[1]=1, since we only need 1^2
	
	3. Fomula: 
	i>1, dp[i]=min{dp[i], dp[i-j*j]+1}, where 1<=j and j*j<=i
	
	4. Return dp[n]
	
	
	Way 2: Math way
	

*/
// T(n*sqrt(n)), S(n)

    public int numSquares1(int n) {
        if(n<1) return 0; 
        int[] dp=new int[n+1];
        dp[1]=1; 
        
        for(int i=2; i<=n; i++){
            int min=Integer.MAX_VALUE; 
            for(int j=1; j*j<=i; j++){
                min=Math.min(min, dp[i-j*j]+1);
            }
            dp[i]=min;
        }
        return dp[n];
    }


//Math way, 
//T(sqrt(n)), S(1) not understand and not see. 

    public int numSquares2(int n) {
        int m = n;
        while( m % 4 == 0 )
            m = m>>2;
        if(m % 8 == 7)
            return 4;

        int sqrtOfn = (int) Math.sqrt(n);
        if(sqrtOfn * sqrtOfn == n)//Is it a Perfect square?
            return 1;
        else{
                for(int i = 1; i <= sqrtOfn; ++i){
                    int remainder = n - i*i;
                    int sqrtOfNum = (int) Math.sqrt(remainder);
                    if(sqrtOfNum * sqrtOfNum == remainder)
                        return 2;
                }
            }
         return 3;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrefectSquares ps = new PrefectSquares();
		int n = 12;
		System.out.println(ps.numSquares(n));
	}

}
