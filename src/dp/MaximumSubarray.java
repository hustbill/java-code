package dp;

public class MaximumSubarray {
	  public int maxSubArray1(int[] nums) {
	        // Solution1: 
	        // Refer: https://leetcode.com/discuss/15805/accepted-o-n-solution-in-java
	        // update 7/21/16 
		  // f(k) =  Maximum sum of subarray ending at index k.
		  // f(k) = max(f(k-1) + A[k], A[k]);
	        int[] A= nums;
	        int maxSoFar = A[0], maxEndingHere=A[0];
	        for (int i=1; i<A.length; ++i) {
	            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
	            maxSoFar = Math.max(maxSoFar, maxEndingHere);
	        }
	        return maxSoFar;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
