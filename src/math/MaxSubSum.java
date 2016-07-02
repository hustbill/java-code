package math;

public class MaxSubSum {
	
	    public int maxSubArray1(int[] nums) { 
	        int[] A= nums;
	        int maxSoFar = A[0], maxEndingHere=A[0];
	        for (int i=1; i<A.length; ++i) {
	            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
	            maxSoFar = Math.max(maxSoFar, maxEndingHere);
	        }
	        return maxSoFar;
	    }
}
