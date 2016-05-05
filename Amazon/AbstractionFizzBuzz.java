//Abstraction with FizzBuzz
import java.util.*;

public class AbstractionFizzBuzz {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 10, 15};
        for (int n : arr) {
           System.out.println(alternativeFizzBuzz(n));  
        }
           
        
    }
    public static List<String> alternativeFizzBuzz(final int n)  {
        final List<String> toReturn = new ArrayList<String>(n);
        for (int i = 1; i <= n; i++) {
            final String word = 
                toWord(3, i, "Fizz") + toWord(5, i, "Buzz");
            //if (word.length() == 0) {
            if (word.isEmpty()) {
                toReturn.add(Integer.toString(i));
            } else {
                toReturn.add(word);
            }
        }
        return toReturn;
    }
    
    private static String toWord(final int divisor, final int value, final String word) {
            return value % divisor == 0 ? word : "";
    }
}