/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (41.08%)
 * Likes:    1341
 * Dislikes: 232
 * Total Accepted:    245.3K
 * Total Submissions: 595.9K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to
 * 0. Do it in-place.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output: 
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output: 
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * 
 * 
 * Follow up:
 * 
 * 
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 * 
 * 
 */

// @lc code=start
class Solution {
    // public void setZeroes_nok(int[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     int i = 0, j = 0;
    
    //     while (i < m && j < n) {
    //         if (i < m && j < n && matrix[i][j] == 0) {
    //                 // set whole row to 0
    //                 for (int k = 0; k < m; k++) 
    //                     matrix[i][k] = 0;
    //                 // set whole col to 0
    //                 for (int l = 0; l < n; l++) 
    //                     matrix[l][j] = 0;
    
    //         } 
    //         i++;
    //         j++;
    //     }
    // }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int idx = 0; idx < m * n - 1; idx++) {
            int i = idx / n ;
            int j = idx / m ;
            if (i < m && j < n && matrix[i][j] == 0) {
                // set whole row to 0
                for (int k = 0; k < m; k++)
                    matrix[i][k] = 0;
                // set whole col to 0
                for (int l = 0; l < n; l++)
                    matrix[l][j] = 0;

            }
        }
    }
}
// @lc code=end

