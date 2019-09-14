/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (47.87%)
 * Total Accepted:    148.1K
 * Total Submissions: 307.3K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n2 in spiral order.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 * 
 */
class Solution {
    // 参考 54 题解法 Approach 2: Layer-by-Layer
    // The answer will be all the elements in clockwise order from the first-outer layer, followed by the elements from the second-outer layer, and so on.
    // https://leetcode.com/problems/spiral-matrix/solution/
    public int[][] generateMatrix(int n) {
       
       int[][] matrix = new int[n][n];
       if (n < 1) return matrix;

       int r1 = 0, r2 = n - 1;
       int c1 = 0, c2 = n - 1;
       int val = 1;
       while (r1 <= r2 && c1 <= c2) {
           for (int c = c1; c <= c2; c++) matrix[r1][c] = val++;
           for (int r = r1 + 1; r <= r2; r++) matrix[r][c2] = val++;
           if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--)  matrix[r2][c] = val++;
                for (int r = r2; r > r1; r--) matrix[r][c1] = val++;
            }
           r1++;
           r2--;
           c1++;
           c2--;
        }
       return matrix;
    }

}
