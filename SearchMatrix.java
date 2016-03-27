import java.util.*;

public class SearchMatrix {
	public static void main(String[] args) {
		int[][] matrix = {  {1,   3,  5,  7},
                              {10, 11, 16, 20},
                              {23, 30, 34, 50}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = 0;
        for (int i=0; i < m; i++) {
            if (target > matrix[0][])
        }
    }
}