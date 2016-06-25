package dp;

public class RangeSumMatrixMutable {
	/*
	 * 308. Range Sum Query 2D - Mutable 
Total Accepted: 3488 Total Submissions: 16286 Difficulty: Hard
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
Hide Company Tags Google
Hide Tags Binary Indexed Tree Segment Tree
Hide Similar Problems (M) Range Sum Query 2D - Immutable (M) Range Sum Query - Mutable


	 */



		private int[][] dp;

		public RangeSumMatrixMutable(int[][] matrix) {
			// https://leetcode.com/discuss/69047/clean-and-easy-to-understand-java-solution
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
				return;
			}
			int m = matrix.length;
			int n = matrix[0].length;
			dp = new int[m + 1][n + 1]; // dp[0][0] = 0, dp[0][j] = 0, dp[i][0] = 0,
										// 第一行第一列初始值为0

			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
				}
			}

		}

	    public void update(int row, int col, int val) {
	        for (int i = row; i < dp.length; i++) {
	            for(int j = col; j < dp[0].length; j++) {
	                dp[i][j] = dp[i][j] + val;
	            }
	        }
	    }

		public int sumRegion(int row1, int col1, int row2, int col2) {
			// if assurm row1 <= row2 and col1 <= col2  
		       //return dp[row2 + 1][col2 + 1 ] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
		        int iMin = Math.min(row1, row2);
		        int iMax = Math.max(row1, row2);

		        int jMin = Math.min(col1, col2);
		        int jMax = Math.max(col1, col2);

		        return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];  
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
					{ 1, 0, 3, 0, 5 } };

			// Your NumMatrix object will be instantiated and called as such:
			RangeSumMatrixMutable numMatrix = new RangeSumMatrixMutable(matrix);
			
			int sum2 = numMatrix.sumRegion(2, 1, 4, 3); // 8
			numMatrix.update(3, 2, 2);
			int sum3 = numMatrix.sumRegion(2, 1, 4, 3); // 10
			System.out.printf("sum2 = %d, sum3 = %d", sum2, sum3);
		}

}
