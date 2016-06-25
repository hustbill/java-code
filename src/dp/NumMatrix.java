package dp;

public class NumMatrix {

	private int[][] dp;

	public NumMatrix(int[][] matrix) {
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

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };

		// Your NumMatrix object will be instantiated and called as such:
		NumMatrix numMatrix = new NumMatrix(matrix);
		int sum1 = numMatrix.sumRegion(1, 2, 2, 4); // 12
		int sum2 = numMatrix.sumRegion(2, 1, 4, 3); // 8
		int sum3 = numMatrix.sumRegion(0, 1, 2, 3); // 19
		System.out.printf("sum1 = %d, sum2 = %d, sum3 = %d", sum1, sum2, sum3);

	}

}
