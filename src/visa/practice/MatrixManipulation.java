package visa.practice;

import java.util.LinkedList;
import java.util.List;

public class MatrixManipulation {

	public MatrixManipulation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		
		List<Integer> res = spiralOrderMatrix(array);
		System.out.print(res);

	}
	
	private static List<Integer> generateNumList(int[][] array) {
		List<Integer> res = new LinkedList<Integer>();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				res.add(array[i][j]);
			}
		}
		
		return res;
	}
	
	// Ref: https://blog.csdn.net/CSDN_FlyYoung/article/details/78061102
	private static List<Integer> spiralOrderMatrix(int[][] matrix) {
		List<Integer> res = new LinkedList<Integer>();
		int sr = 0, sc = 0 ;
		int dr = matrix.length - 1;
		int dc = matrix[0].length - 1;
		
		while (sr <= dr && sc <= dc) {
			// add the items outside
			addItems(matrix, res, sr++, sc++, dr--, dc--);
		}
		
		return res;
	}
	
	private static void addItems(int[][] m, List<Integer> res, int sr, int sc, int dr, int dc) {
		if (sr == dr) {
			for (int i = sc; i <= dc; i++) {
				res.add(m[sr][i]);
			}
		} else if (sc == dc) {
			for (int i = sr; i <= dr; i++) {
				res.add(m[i][sc]);
			}
		} else {
			int curC = sc;
			int curR = sr;
			
			// add one row from left to right
			while (curC != dc) {
				res.add(m[sr][curC]);
				curC++;
			}
			
			// add one col from top to bottom
			while (curR != dr) {
				res.add(m[curR][dc]);
				curR++;
			}
			
			// add one row from right to left
			while (curC != sc) {
				res.add(m[dr][curC]);
				curC--;
			}
		
			// add one col from bottom to up
			while (curR != sr) {
				res.add(m[curR][sc]);
				curR--;
			}
		}
		
		
	}

}
