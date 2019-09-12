/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (31.16%)
 * Total Accepted:    263.9K
 * Total Submissions: 841.5K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    // Approach 2: Layer-by-Layer
    // The answer will be all the elements in clockwise order from the first-outer layer, followed by the elements from the second-outer layer, and so on.
    // https://leetcode.com/problems/spiral-matrix/solution/
    public List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> ret = new ArrayList<>();
       if (matrix.length == 0 ) 
           return ret;

       int r1 = 0, r2 = matrix.length - 1;
       int c1 = 0, c2 = matrix[0].length - 1;

       while (r1 <= r2 && c1 <= c2) {
           for (int c = c1; c <= c2; c++) ret.add(matrix[r1][c]);
           for (int r = r1 + 1; r <= r2; r++) ret.add(matrix[r][c2]);
           if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--)  ret.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ret.add(matrix[r][c1]);
            }
           r1++;
           r2--;
           c1++;
           c2--;
       }
       return ret;
    }
}
