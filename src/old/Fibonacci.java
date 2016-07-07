package old;
public class Fibonacci{
    public static int fibonacci(int n) {
        if ( n <=1) return 1;
        
        int last = 1;
        int nextToLast = 1;
        int answer = 1;
    
        for ( int i = 2; i < n; i++) {
            answer = last + nextToLast;
            System.out.printf("%d ", answer);
            nextToLast = last;
            last = answer;
        }
        
        return answer;
    }
    
    // evaluate the recursion solution for Fibonacci
    public static double eval (int n) {
        if ( n == 0) 
            return 1.0;
        else {
            double sum = 0.0;
            for ( int i = 0; i < n; i++) 
                sum += eval( i );
            return 2.0 * sum / n  + n;
        }
    }
    
    public static void main(String[] args) {
        fibonacci(5);
        int sum = (int)eval(5);
        System.out.printf( "sum = %d", sum);
    }

}

