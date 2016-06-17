/*
 * 74. Search a 2D Matrix My Submissions QuestionEditorial Solution
Total Accepted: 82742 Total Submissions: 241991 Difficulty: Medium
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
package matrix;

public class Search2DMatrix {
	
	 public boolean searchMatrix(int[][] matrix, int target) {
         /*
            Use binary search.  Don't treat it as a 2D matrix, just treat it as a sorted array
            m * n matrix convert to an array => matrix[x][y] => a[x * n + y]
            an array convert to m * n matrix => a[x] =>matrix[x / n][x % n];
            https://leetcode.com/discuss/15379/binary-search-on-an-ordered-matrix
            https://leetcode.com/discuss/10735/dont-treat-it-as-a-2d-matrix-just-treat-it-as-a-sorted-list
            
            1ms  beat 6.1% 
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
    
        /*The basic idea is from right corner,
            if the current number greater than target col - 1 in same row,
                else if the current number less than target, row + 1 in same column,
                finally if they are same, we find it, and return return.
            test case: 
                [[1, 3]]
                3 
           2ms ,  beats 3.1% java submissions
           https://leetcode.com/discuss/68637/java-clear-solution
        */
        public boolean searchMatrix_sol2(int[][] matrix, int target) {
            int i = 0, j = matrix[0].length - 1;
            while (i < matrix.length && j >= 0 ) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    j--;  // col - 1
                } else {
                    i++;  // row + 1
                }
            }
            return false;
            
        }
}
