/* Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].*/

/* The solution use binary search. Since the elememts in the array are integers, we can find the target as target-0.5
and target+0.5 to get the lower and upper bound.*/

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start=0,end=A.length-1;
        int[] result=new int[]{-1,-1};
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==A[mid]){
                int tmp=mid;
                while(tmp>=start && A[tmp]==target){
                    tmp--;
                }
                result[0]=tmp+1;
                tmp=mid;
                while(tmp<=end && A[tmp]==target){
                    tmp++;
                }
                result[1]=tmp-1;
                return result;
            }
            else if(target<A[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return result;
    }
}

/* Use target-0.5 and target+0.5 to search. */

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result=new int[]{-1,-1};
        int low=searchTarget(A,target-0.5);
        if(low>=A.length || A[low]!=target)
            return result;
        result[0]=low;
        result[1]=searchTarget(A,target+0.5)-1;
        return result;
    }
    public int searchTarget(int[] A,double target){
        int start=0,end=A.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==A[mid])
                return mid;
            else if(target>A[mid])
                start=mid+1;
            else
                end=mid-1;
        }
        return start;
    }
}
