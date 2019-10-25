package oj;

import com.eclipsesource.json.JsonArray;
import java.lang.Integer;

class Solution {
	public void setZeroes(int[][] matrix) {
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

public class MainClass {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static int[][] stringToInt2dArray(String input) {
		JsonArray jsonArray = JsonArray.readFrom(input);
		if (jsonArray.size() == 0) {
			return new int[0][0];
		}

		int[][] arr = new int[jsonArray.size()][];
		for (int i = 0; i < arr.length; i++) {
			JsonArray cols = jsonArray.get(i).asArray();
			arr[i] = stringToIntegerArray(cols.toString());
		}
		return arr;
	}

	public static String int2dArrayToString(int[][] array) {
		if (array == null) {
			return "null";
		}
		if (array.length == 0) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder("[");
		for (int[] item : array) {

			sb.append(String.valueOf(item));
			sb.append(",");
		}

		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	// public static void main(String[] args) throws IOException {
	// BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	// String line;
	// while ((line = in.readLine()) != null) {
	// int[][] matrix = stringToInt2dArray(line);

	public static void main(String[] args) {
		/*
		 * test case 2 [[0,1,2,0],[3,4,5,2],[1,3,1,5]] test case 1 {{1,1,1,1},{1,0,1,
		 * 1},{1,1,1,1}}
		 * 
		 * [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
		 * 
		 * [[1,0]]
		 * 
		 * [[0], [1]]
		 * 
		 * [[-5,7,2147483647,3],[0,3,6,-2147483648],[8,3,-3,-6],[-9,-9,8,0]]
		 */
		int[][] matrix = { { -5, 7, 2147483647, 3 }, { 0, 3, 6, -2147483648 }, { 8, 3, -3, -6 }, { -9, -9, 8, 0 } };

		printMatrix(matrix);
		new Solution().setZeroes(matrix);
		printMatrix(matrix);
		// String out = int2dArrayToString(matrix);
		// for (int i= 0; i < matrix.length; i++ ) {
		// for (int j = 0; j < matrix[0].length; j++) {
		// System.out.print(matrix[i][j] + "\t");
		// }
		// System.out.println();
		// }

		// System.out.print(out);
		// }
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}