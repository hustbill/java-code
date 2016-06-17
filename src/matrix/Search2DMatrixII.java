/*
 * 240. Search a 2D Matrix II
 * 
Total Accepted: 39653 Total Submissions: 113405 Difficulty: Medium
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

Hide Company Tags Amazon Google Apple
Hide Tags Binary Search Divide and Conquer
Hide Similar Problems (M) Search a 2D Matrix

 */
package matrix;

public class Search2DMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{-5}, {-1}};
		int[][] matrix2 =  { { 1, 3, 5}, { 2, 4, 6}, { 9, 11, 19}} ;
		int target = -2;
		
		Search2DMatrixII search2d = new Search2DMatrixII();
		System.out.println(search2d.searchMatrix(matrix, target));  // false
		
		int target2 = 11;
		System.out.println(search2d.searchMatrix(matrix2, target2));  // true
		
	}
	
	 /* https://leetcode.com/discuss/48852/my-concise-o-m-n-java-solution
    We start search the matrix from top right corner, initialize the current position to top right corner, 
    
    if the target is greater than the value in current position, then the target can not be in entire row of current position because the row is sorted, if the target is less than the value in current position, then the target can not in the entire column because the column is sorted too. We can rule out one row or one column each time, so the time complexity is O(m+n).
    Runtime: 13 ms  beat 52%
    */
public boolean searchMatrix(int[][] matrix, int target) {
    
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
        return false;
    }
    
    int row = 0, col = matrix[0].length - 1;
    while (row < matrix.length && col >= 0) {  // start from top right corner
        if (matrix[row][col] == target) {
            return true;
        } else if ( matrix[row][col] < target) { // move down
            row++;
        } else {
            col--;  // move left
        }
    }
    
    return false;
}
    
public boolean searchMatrix_failed(int[][] matrix, int target) {
  
    int rstart = 0, rend = matrix.length - 1;
    int cstart = 0, cend = matrix[0].length - 1;
    
    while ( cstart < cend) {
        int cmid = cstart + (cend - cstart) / 2;
        int rmid = rstart + (rend - rstart) / 2;
        if (matrix[rmid][cmid] == target) {
            return true;
        } else if (matrix[rmid][cmid] > target) {
            rend = rmid - 1;
            cend = cmid - 1;
        } else {
            rstart =rmid + 1;
            cstart = cstart + 1;
        }
    }
    return false;
}
	

}
