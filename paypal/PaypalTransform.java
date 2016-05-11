/**
 * Created by hua zhang on 4/9/2016.
 */
import java.util.*;

public class PaypalConvert {
	public static void main(String[] args) {
		String str = "Paypal rocks";
		System.out.printf("Input: %s\n", str);

		char[][] matrix = convert2Matrix(str);

		System.out.println("\nOutput matrix");

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static char[][] convert2Matrix(String str) {
		char[][] A;
		str = str.replaceAll("\\s", ""); // skip whitespace
		int n = (int) Math.sqrt(str.length()) + 1;
		A = new char[n][n];

		if (str == null || str.length() == 0)
			return A;
		int index = 0;
        
		for (int step = 0; step < n; step++) {
			for (int row = step, col = 0; row >= 0; row--, col++) {
				if (index >= str.length())
					break;
				A[row][col] = str.charAt(index++);
			}
		}
        
        // deal with 's'
		for (int step = 1; step < n; step++) {
			for (int row = n - 1, col = step; row >= step; row--, col++) {
				if (index >= str.length())
					break;
				A[row][col] = str.charAt(index++);

			}
		}
		return A;
	}

}