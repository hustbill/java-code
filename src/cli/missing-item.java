// you can also use imports, for example:
// 2019-09-09 11:09 pm test
//  MissingInteger
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        if (A[A.length - 1] < 0) return 1;
        
        int gap = A[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] > 1){
                gap = Math.min(gap, A[i] - 1);
            } else {
                gap = A[A.length - 1] + 1;
            }
          
        }
        
        return gap;
    }
}
