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
    
    
    public static void main(String[] args) {
        fibonacci(5);
    }

}

