/* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.*/

/* Simple question, just binary search.*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int start=0,end=m*n-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            int midVal=matrix[mid/n][mid%n];
            if(target==midVal)
                return true;
            else if(target>midVal)
                start=mid+1;
            else
                end=mid-1;
        }
        return false;
    }
}
