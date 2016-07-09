/*
 * 73. Set Matrix Zeroes  QuestionEditorial Solution  My Submissions
Total Accepted: 70785
Total Submissions: 208447
Difficulty: Medium
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

Hide Company Tags Microsoft
Hide Tags Array
Hide Similar Problems (M) Game of Life

 */
package matrix;

import java.util.*;

public class SetZeroes {
	public void setZeroes(int[][] matrix) {
		// https://discuss.leetcode.com/topic/15193/my-ac-java-o-1-solution-easy-to-read
		int m = matrix.length;
		int n = matrix[0].length;
		boolean fc = false, fr = false;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						fr = true;
					if (j == 0)
						fc = true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
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

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 0, 9, 5 }, { 1, 0, 7, 9, 5 }, { 6, 4, 7, 8, 5 }, { 3, 2, 7, 9, 5 },
				{ 4, 1, 7, 9, 0 } };
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));

		SetZeroes sz = new SetZeroes();
		sz.setZeroes(matrix);
		System.out.println("after set zeroes");
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
		/*
		 * after set zeroes [0, 0, 0, 0, 0] [0, 0, 0, 0, 0] [6, 0, 0, 8, 0] [3,
		 * 0, 0, 9, 0] [0, 0, 0, 0, 0]
		 * 
		 */
	}

}
