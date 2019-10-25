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

	/*
	 Use first row and first column as markers. 
	  fr = first row,  fc = first col
    if matrix[i][j] = 0, mark respected row and col marker = 0; indicating
       that later this respective row and col must be marked 0;
    And because you are altering first row and column, 
       you need to  have two variables to track their own status. 
    So, for ex, if any one of the first row is 0, fr = 0, 
       and at the end set all first row to 0;

	*/
    public void setZeroes(int[][] matrix) {
			int m = matrix.length;
			int n = matrix[0].length;
			
			boolean fc = false, fr = false;  // first row, first column as markers
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] == 0) {
						if (i == 0) fr = true;
						if (j == 0) fc = true;
						matrix[0][j] = 0;
						matrix[i][0] = 0;
					}
				}
			}

			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					if (matrix[0][j] == 0 || matrix[i][0] == 0) {
						matrix[i][j] = 0;
					}
				}
			}

			if (fr) {
				for (int j = 0; j < n; j++) {
					matrix[0][j] = 0;
				}
			}

			if (fc) {
				for (int i = 0; i < m; i++) {
					matrix[i][0] = 0;
				}
			}
		}


    // hua zhang 2019-10-24 spend 2 hours to figure out the soltuon,
    // pass the leetcode oj
   public void setZeroes_ok(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;

		int m = matrix.length;
		int n = matrix[0].length;

		if (m == 1) {
			for (int j = 0; j < n; j++) {
				if (matrix[0][j] == 0) {
					for (int k = 0; k < n; k++) {
						matrix[0][k] = 0;
					}
					return;
				}
			}
		}

		if (n == 1) {
			for (int i = 0; i < m; i++) {
				if (matrix[i][0] == 0) {
					for (int k = 0; k < m; k++) {
						matrix[k][0] = 0;
					}
					return;
				}
			}
		}

		int idx = 0;
		boolean[][] visit = new boolean[m][n];
		while (idx <= m * n - 1) {
			int i = idx / n;
			int j = idx % n;
			if (i < m && j < n && matrix[i][j] == 0 && visit[i][j] == false) {
				// set whole row to 0
				for (int k = 0; k < n; k++) {
					if (matrix[i][k] != 0) {
						matrix[i][k] = 0;
						visit[i][k] = true;
					}
				}

				// set whole col to 0
				for (int l = 0; l < m; l++) {
					if (matrix[l][j] != 0) {
						matrix[l][j] = 0;
						visit[l][j] = true;
					}
				}
			}
			idx++;
		}
	}
}
// @lc code=end

