/*
*  Compute opimal ordering of matrix multiplication.
* c contains the number of columns for each of the n matrices
* c[0] is the number of rows in matrix 1
* The minimum number of multiplications is left in m[1][n]
*  Acutal ordering is computed via naother procedure using lastChange
* m and lastChange are indexed starting at 1, instead of 0.
* Note: Entries below main digonals of m and lastChange
* are meaningless and uninitialized.
*/

import java.util.*;

public class OptMatrix {
    public static void optMatrix(int[] c, long [][] m, int [][] lastChange) {
        int n = c.length - 1;
    
        for (int left =1; left <= n; left++) {
            m[left][left] = 0;
        } 
        for (int k = 1; k < n; k++)  // k is right - left
            for ( int left = 1 ; left <= n - k; left++) {
                // For each position 
                int right = left + k;
                m [ left ][ right ] = Integer.MAX_VALUE; //INFINITY;
                for ( int i = left; i < right; i++) {
                    long thisCost = m [ left ][ right ] +  m[ i + 1][right]
                        + c[left - 1] * c[i] * c[right];
                    if (thisCost < m[ left ][ right ]) {  // update min
                        m[ left ][ right ] = thisCost;
                        lastChange[ left ][ right ] = i;
                    }
                
                }
        
            }
            for (int[] arr : lastChange) {
                System.out.println();
                for (int j : arr) {
                    System.out.printf(" %d ", j);
                }
            }
    
    }
    
    public static void main(String[] args) {
        int[] c = { 50, 10, 40};
        long[][] m = {{10, 20, 35}, {20, 50,90}, {40,20,30}};
            int[][] lastChange = new int[3][3];
        optMatrix(c , m , lastChange);
    }
    
}
