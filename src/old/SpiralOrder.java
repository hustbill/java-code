package old;
import java.util.*;

public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
            // Ref:  book clean code handbook v1.03
            /* We simulate walking the matrix from top left corner in a spiral manner.  In the outmost level, we traverse n steps right,  m-1 steps down, n-1 steps left, and m-2 steps up, then we continue traverse into next inner level.
        
              A cleaner solution si to keep track of our current  position and the number of steps in both horizontal and vertical directions.  As we change direction we decrement the steps in that  direction. When the number of steps in a direction becomes zero, we know that we have fininshed traversing the entire matrix. 
               Testcase:  [[1,2,3],[6,9,8],[7,4,5]]
              */
        
            List<Integer> elements = new ArrayList<Integer>();
            if (matrix.length == 0 ) return elements;
        
            int m = matrix.length, n = matrix[0].length;
            int row = 0, col = -1;
        
            while (true) {
                // right
                for (int i=0; i < n; i++) {
                    elements.add(matrix[row][++col]);
                }
                // change direction
                if(--m == 0) break;
                // down
                for (int i=0; i < m; i++) {
                    elements.add(matrix[++row][col]);
                }
            
                // change direction
                if(--n == 0) break;
                // left
                for (int i=0; i < n; i++) {
                    elements.add(matrix[row][--col]);
                }
            
                // change direction
                if(--m == 0) break;
                // up
                for (int i=0; i < m; i++) {
                    elements.add(matrix[--row][col]);
                }
                // change solution back to right
                if(--n == 0) break;                                
            }
            return elements;
    }
        
    public static void main(String[] args) {
        int[][] matrix =  {{1,2,3},{6,9,8},{7,4,5}};
        List<Integer> res =  spiralOrder(matrix);
        for (Integer i : res)
        System.out.println(i + " ");
    }
}