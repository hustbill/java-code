package dp;

public class RangeSumMatrixMutable {
	/*
	 * 308. Range Sum Query 2D - Mutable Total Accepted: 3488 Total Submissions:
	 * 16286 Difficulty: Hard Given a 2D matrix matrix, find the sum of the
	 * elements inside the rectangle defined by its upper left corner (row1,
	 * col1) and lower right corner (row2, col2).
	 * 
	 * Range Sum Query 2D The above rectangle (with the red border) is defined
	 * by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum =
	 * 8.
	 * 
	 * Example: Given matrix = [ [3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1,
	 * 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5] ]
	 * 
	 * sumRegion(2, 1, 4, 3) -> 8 update(3, 2, 2) sumRegion(2, 1, 4, 3) -> 10
	 * Note: The matrix is only modifiable by the update function. You may
	 * assume the number of calls to update and sumRegion function is
	 * distributed evenly. You may assume that row1 ≤ row2 and col1 ≤ col2. Hide
	 * Company Tags Google Hide Tags Binary Indexed Tree Segment Tree Hide
	 * Similar Problems (M) Range Sum Query 2D - Immutable (M) Range Sum Query -
	 * Mutable
	 * 
	 * 
	 */

	private int[][] dp;
	private int[][] matrix;
	private int[][] colSums;

	public RangeSumMatrixMutable(int[][] matrix) {
		//        //第一种解法 dp https://leetcode.com/discuss/70948/15ms-easy-to-understand-java-solution
        // 第二种解法 Java 2D Binary Indexed Tree Solution clean and short 17ms
        //https://leetcode.com/discuss/71169/java-2d-binary-indexed-tree-solution-clean-and-short-17ms
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		colSums = new int[m + 1][n];

		this.matrix = matrix;
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < n; j++) {
				colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
			}
		}

	}

	public void update(int row, int col, int val) {
		for (int i = row + 1; i < colSums.length; i++) {
			colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
		}
		matrix[row][col] = val;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int ret = 0;
		for (int j = col1; j < col2; j++) {
			ret += colSums[row2 + 1][j] - colSums[row1][j];
		}
		
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0,
		// 1, 5 }, { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } };
		int[][] matrix = { { 1 } };

		// Your NumMatrix object will be instantiated and called as such:
		RangeSumMatrixMutable numMatrix = new RangeSumMatrixMutable(matrix);

		// int sum2 = numMatrix.sumRegion(2, 1, 4, 3); // 8
		// numMatrix.update(3, 2, 2);
		// int sum3 = numMatrix.sumRegion(2, 1, 4, 3); // 10
		// System.out.printf("sum2 = %d, sum3 = %d", sum2, sum3);

		int sum1 = numMatrix.sumRegion(0, 0, 0, 0);
		System.out.println("sum1 = " + sum1);
		numMatrix.update(0, 0, -1);
		sum1 = numMatrix.sumRegion(0, 0, 0, 0);
		System.out.println("sum1 changed = " + sum1);
	}

}
