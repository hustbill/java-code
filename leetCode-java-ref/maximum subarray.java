/* Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.*/

/* Traverse the array from left to right to get the maximum, when the sum is negtive, reset it to 0.*/

public class Solution {
    public int maxSubArray(int[] A) {
        int sum=0,result=A[0];
        for(int i=0;i<A.length;++i){
            sum=Math.max(sum+A[i],A[i]);
            result=Math.max(sum,result);
        }
        return result;
    }
}

/* Divide and conquer, three conditions: maximum subarray in the left half, in the right half, across the mid.*/

public class Solution {
    public int maxSubArray(int[] A) {
        int max=Integer.MIN_VALUE;
        return helper(A,0,A.length-1,max);
    }
    public int helper(int[] A, int start, int end, int max){
        if(start>end)
            return Integer.MIN_VALUE;
        int mid=start+(end-start)/2;
        int leftMax=helper(A,start,mid-1,max);
        int rightMax=helper(A,mid+1,end,max);
        max=Math.max(max,Math.max(leftMax,rightMax));
        
        int sum=0,leftSum=0,rightSum=0;
        for(int i=mid-1;i>=start;--i){
            sum+=A[i];
            leftSum=Math.max(sum,leftSum);
        }
        sum=0;
        for(int i=mid+1;i<=end;++i){
            sum+=A[i];
            rightSum=Math.max(sum,rightSum);
        }
        max=Math.max(max,A[mid]+leftSum+rightSum);
        return max;
    }
}
