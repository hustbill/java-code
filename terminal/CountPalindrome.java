/*
    "hellolle", 
    [h, e, ll, l, l, o, lol, lloll, ellolle, ll, l, l, e]
     13
    "wowpurerocks"
    [w, o, wow, w, p, u, r, e, rer, r, o, c, k, s]
     14
    "abqwerba"
    [a, b, q, w, e, r, b, a]
    8
    */
    // http://stackoverflow.com/questions/19801081/find-all-substrings-that-are-palindromes
    
import java.util.*;

public class CountPalindrome {
    
    public static List<String> palindromes(final String input) {
        final List<String> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            // expanding even length palindromes:
            expandPalindromes(result,input,i,i+1);
            // expanding odd length palindromes:
            expandPalindromes(result,input,i,i);
        } 
        return result;
     }

     public static void expandPalindromes(final List<String> result, final String s, int i, int j) {
         while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
               result.add(s.substring(i,j+1));
               i--; j++;
         }
     }

     public static void main(String[] args) {
         String[] tests = {"hellolle", "wowpurerocks", "abqwerba"};
    
        for (String test : tests) {
            List<String> result = palindromes(test);
            System.out.println(result);
            System.out.println(result.size());  
        }
   
    }
}
