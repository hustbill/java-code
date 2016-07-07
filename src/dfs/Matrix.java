package dfs;

import java.util.*;

class Pair {
	int x, y;

	public Pair(int i, int j) {
		y = i;
		x = j;
	}
}

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[3][3];
		// List<Pair> result = getPath(matrix);

		int direction = 0;
		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		Matrix matrix1 = new Matrix();
		List<Pair> result = matrix1.spiralOrder(matrix);
		System.out.println(result.size());

		for (Pair p : result) {
			matrix1.printNode(p.x, p.y);
		}
	}

	public static List<Pair> getPath(int[][] matrix) {
		List<Pair> res = new ArrayList<Pair>();
		dfs(res, matrix, 0, 0);
		return res;
	}

	public void printNode(int x, int y) {
		System.out.print("(" + x + "," + y + ") \t");
	}

	public void printPath(int startx, int starty, int W, int H) {
		int i = startx;
		int j = starty;
		for (; i < W; i++) {
			printNode(i,j);
		}

		for (; j < H; j++) {
			printNode(i,j);
		}
		
		for (; i > 0; i--) {
			printNode(i,j);
		}
		
		for (; j > 0; j--) {
			printNode(i,j);
		}
	}

	public List<Pair> spiralOrder(int[][] matrix) {
		List<Pair> res = new ArrayList<Pair>();
		int bottom = 0;
		int left = 0;
		int right = 0;
		int up = 0;
		int index = 0;

		int H = matrix.length;
		int W = matrix[0].length;

		printPath(0, 0, W, H);

		return res;
	}

	public static void dfs(List<Pair> res, int[][] matrix, int i, int j) {
		int m = matrix.length;
		int n = matrix[0].length;

		if (i >= 0 && i < m && j >= 0 && j < n) {
			if (matrix[i][j] == 0) {
				matrix[i][j] = 1;
				res.add(new Pair(i, j));
			}

			dfs(res, matrix, i, j + 1);
			dfs(res, matrix, i + 1, j);

			// dfs(res, matrix, i, j - 1);
			// dfs(res, matrix, i-1, j);
			//
		}
	}
}
