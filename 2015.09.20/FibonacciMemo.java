import java.util.*;

public class FibonacciMemo {
    static int fibonacciMemo(int n) {
      return fibonacciHelper(n, new int[n+1]);
    
    }

    static int fibonacciHelper(int i, int[] memo) {
        if (i == 0 || i == 1) return i;

        if (memo[i] == 0) {
            memo[i] = fibonacciHelper(i - 1, memo) + fibonacciHelper(i - 2, memo);
        }
        return memo[i];
    }
    
    public static void main(String[] args) {
        System.out.print(fibonacciMemo(12));
    }
}
