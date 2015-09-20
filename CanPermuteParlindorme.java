/*
Palindrome Permutation
https://leetcode.com/problems/palindrome-permutation/

Total Accepted: 1501 Total Submissions: 3385 Difficulty: Easy
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
Show Tags
Hide Similar Problems (M) Longest Palindromic Substring (E) Valid Anagram (M) Palindrome Permutation II
Have you met this question in a real interview


*/
import java.util.*;

public class CanPermuteParlindorme {
    // public static boolean canPermutePalindrome(String s) {
    //     int len = s.length();
    //     if (s == null || len ==0)
    //         return true;
    //     if (len % 2 ==0 ) {
    //         return true;
    //
    //     } else {
    //         int i =0, j = len -1;
    //         while( i< len && j > 0) {
    //             if (s.charat(i) == s.charat(j)) {
    //                 i++;
    //                 j--;
    //
    //             }
    //         }
    //
    //     }
    //
    // }
    
    public static boolean canPermutePalindrome(String s) {
        // Ref: http://stackoverflow.com/questions/31224628/check-whether-a-permutation-of-a-string-is-a-palindrome
        Map<Character, Integer> charCountMap = new HashMap<>();
        
        // Count the occurrences of each character
        for (char c : s.toCharArray()) {
            Integer count = charCountMap.get(c);
            if (count == null) {
                count = Integer.valueOf(1);
            } else {
                count = count + 1;
            }
            charCountMap.put(c, count);
        }
        
        boolean hasOdd = false;
        for (int count : charCountMap.values()) {
            if (count %2 == 1 ) {
                if (hasOdd) {
                    // Found two chars with odd counts  - return false;
                    return false;
                } else {
                    // Foun the the first char with odd count
                    hasOdd = true;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // case 1
        String s;
      
        
        s = "code";
        System.out.println(canPermutePalindrome(s));
        
        s= "aab";
        System.out.println(canPermutePalindrome(s));
        
        s= "carerac";
        System.out.println(canPermutePalindrome(s));
        
        s= "amanaplanacanalpanama";  //  "A man, a plan, a canal, Panama!"
         System.out.println(canPermutePalindrome(s));
         
         s= "amorroma";
         System.out.println(canPermutePalindrome(s)); 
    }
}