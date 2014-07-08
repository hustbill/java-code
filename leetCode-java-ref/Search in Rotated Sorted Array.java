/* Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.*/

/* Binary search, since it is rotated array, half of the array must be sorted. The detail is the "<" and "<=" .*/

public class Solution {
    public int search(int[] A, int target) {
        if(null==A ||0==A.length)
            return -1;
        int start=0,end=A.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==A[mid])
                return mid;
            else if(A[mid]<A[end]){
                if(A[mid]<target && target<=A[end])
                    start=mid+1;
                else
                    end=mid-1;
            }
            else{
                if(A[start]<=target && target<A[mid])
                    end=mid-1;
                else
                    start=mid+1;
            }
        }
        return -1;
    }
}

/* Follow up: What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.*/

/* The potential problem is the start or end may equal to the mid of the array, so we could not decide which half part
to continue. The solution is to move the start or end until it is not equal to the mid.*/
public class Solution {
    public boolean search(int[] A, int target) {
       if(null==A ||0==A.length)
            return false;
        int start=0,end=A.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==A[mid])
                return true;
            if(A[start]<A[mid]){
                if(A[start]<=target && target<A[mid])
                    end=mid-1;
                else
                    start=mid+1;
            }
            else if(A[start]>A[mid]){
                if(A[mid]<target && target<=A[end])
                    start=mid+1;
                else
                    end=mid-1;
            }
            else{
                start++;
            }
        }
        return false;
    }
}

