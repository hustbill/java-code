

/*
* Symantec :  10/2/ 2015
*  Update  :  04/04/2016  Amazon AWS phone interview
*"Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” 
instead of the number and for the multiples of five print “Buzz”.
For numbers which are multiples of both three and five print “FizzBuzz”."
*
*/

import java.util.*;

public class FizzBuzz {

    public static void main(String[] args) {
        int n = 21;
        printFizzBuzz(n);
        System.out.println("********* updated version with code reuse , and logical abstraction **************");
        System.out.print(alternativeFizzBuzz(n));
    }
 
    /*FizzBuzz
        page 66 java programming exposed
        Interviewers often look for examples of code reuse, and logical abstraction.  
        My code does not to this particularly well.
        It should be possible to provide an abstraction over the different cases for fizz, 
        Buzz, and FizzBuzz. This would allow  for the different cases to be easily 
        tested in isolation, and even changed to return different words for 
        different values, should you wish.
        */
        // Abstraction with FizzBuzz
    public static List<String> alternativeFizzBuzz( final int n) {
        final List<String> result = new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            final String word = toWord(3, i, "Fizz") + toWord(5, i, "Buzz");

            //if (StringUtils.isEmpty(word)) {
            if (word == "") {
                result.add(Integer.toString(i));
            } else {
                result.add(word);
            }
        }
        return result;
    }

    private static String toWord( final int divisor,
                                    final int value,
                                    final String word) {
        return value % divisor  == 0  ? word : "";
    }
    
    public static void printFizzBuzz(int n) {
        for (int i=1 ; i< n; i++) {
            if (i%3 ==0 && i%5 ==0 ) {
                System.out.println("FizzBuzz");
            } else if ( i%3 == 0) {
                System.out.println("Fizz");
            } else if (i%5 ==0 ) {
                System.out.println("Buzz");
            }  else {
                System.out.println(i);
            }
        }

    }
 
}
