package old;
/*
74. Search a 2D Matrix My Submissions Question
Total Accepted: 74543 Total Submissions: 222239 Difficulty: Medium
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

Hide Tags Array Binary Search
Hide Similar Problems (M) Search a 2D Matrix II
*/
import java.util.*;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = { {1,   3,  5,  7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int[][] matrix2 =  {{1}, {3}};
        int[][] matrix3 = {{-5}};
        int target = 3;
    
        System.out.println(searchMatrix(matrix1, target) == true ?
            " Test case 1 success" : " Test case 1 failed");
        System.out.println(searchMatrix(matrix2, target) == true ?
            " Test case 2 success" : " Test case 2 failed");
        System.out.println(searchMatrix(matrix3, target) == false ? 
            " Test case 3 success" : " Test case 3 failed");
    }
	
    public static boolean searchMatrix(int[][] matrix, int target) {
        /*
            Use binary search.  Don't treat it as a 2D matrix, just treat it as a sorted array
            m * n matrix convert to an array => matrix[x][y] => a[x * n + y]
            an array convert to m * n matrix => a[x] =>matrix[x / n][x % n];
            https://leetcode.com/discuss/15379/binary-search-on-an-ordered-matrix
            https://leetcode.com/discuss/10735/dont-treat-it-as-a-2d-matrix-just-treat-it-as-a-sorted-list
            */
            int m = matrix.length, n = matrix[0].length;
        int begin = 0, end = m * n - 1;
        
        while (begin <= end) {
            int mid = begin + (end - begin)/2 ;
            int mid_val = matrix[mid / n][mid % n];
            if (mid_val == target) {
                return true;
            } else if (mid_val < target) {
                //Should move a bit further, otherwise dead loop.
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
        
        
    // pass case 1 and 2, failed at case 3
    public static boolean searchMatrix_mine(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int rowUp = 0, rowDown = m-1, colLeft = 0, colRight = n-1;
        
        while(rowUp  <= rowDown ) {
            int mid = rowUp + (rowDown - rowUp)/2;
            int mid_val = matrix[rowUp][0] + (matrix[rowDown][n-1] - matrix[rowUp][0])/2;
            //System.out.printf("mid_val = %d ", mid_val);

            if (target == mid_val) {
                rowUp = mid;
                rowDown = mid;
                break;
            }
            else if (target > mid_val) {
                rowUp = mid + 1;
            } else {
                rowDown = mid -1;
            } 
           
        }
        
        while (colLeft <= colRight) {
            int mid = colLeft + (colRight - colLeft)/2;
            // System.out.printf("rowUp = %d, rowDown= %d \n", rowUp, rowDown);  
            // rowUp=1 , ArrayIndexOutOfBoundsException,  matrix[0][0] = -5 for case 3s
            //System.out.printf("colLeft = %d, colRight= %d\n", colLeft, colRight);
            int mid_val = matrix[rowUp][colLeft] + (matrix[rowUp][colRight] - matrix[rowUp][colLeft])/2;
            //System.out.printf("mid_val = %d\n", mid_val);
            if (target == mid_val ) return true;
            else if (target >  mid_val) {
                colLeft = mid + 1;
                System.out.printf("colLeft = %d, colRight= %d\n", colLeft, colRight);
            } else {
                colRight = mid ;
            }
            //System.out.printf("colLeft = %d, colRight= %d\n", colLeft, colRight);
        }
        return false;
    }
}