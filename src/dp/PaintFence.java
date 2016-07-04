/*
 * 276. Paint Fence My Submissions QuestionEditorial Solution
Total Accepted: 10079 Total Submissions: 31886 Difficulty: Easy
There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

Hide Company Tags Google
Hide Tags Dynamic Programming
Hide Similar Problems (E) House Robber (M) House Robber II (M) Paint House (H) Paint House II

 */
package dp;

public class PaintFence {
    public int numWays(int n, int k) {
    	
        /* idea:  e.g.   n = 3, k = 2 (r,w)
            two fences, two color: (r, r), (r, w) (w, r), (w, w)
            diff2 = k * (k - 1) = 2 * ( 2- 1)  = 2
            same2 = k = 2
            total2 = diff2 + same2 = 2 + 2 = 4
            
            three fences, two color:
            same3 = diff2;
            diff3 = (total) * (k-1) = (diff2 + same2) * (k -1)
            ref: https://discuss.leetcode.com/topic/23426/o-n-time-java-solution-o-1-space
        */
          if(n == 0) {
              return 0;
          } else if(n == 1) {
              return k;
          }
          
         int diffCounts = k * (k -1) ; // n = 2
         int sameCounts = k;
         
         for (int i = 2 ; i < n; i++) {  // n > 2
             int temp = diffCounts;
             diffCounts = (diffCounts + sameCounts) * ( k - 1);
             sameCounts = temp;
         }
           return diffCounts + sameCounts;
       }

	public static void main(String[] args) {
		PaintFence pf = new PaintFence();
		int n = 4,  k = 3;
		
		System.out.println(pf.numWays(n, k)); // 66
		/*
		 * 	n, c  			Diff     	Same   total
		 *  n= 2 c = 3      6			 3     9
		 *  n= 3 c = 3      (6+3)*2=18	 6     24
		 *  n= 4 c = 3      (18+6)*2=48  18    66
		 * 
		 * */

	}

}
