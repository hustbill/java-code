/*345. Reverse Vowels of a String   My Submissions QuestionEditorial Solution
Total Accepted: 10539 Total Submissions: 29840 Difficulty: Easy
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Hide Company Tags Google
Hide Tags Two Pointers String
Hide Similar Problems (E) Reverse String
*/
import java.util.*;

public class ReverseVowels_345 {
    public String reverseVowels_stack(String s) {
      /* 
        https://leetcode.com/discuss/98987/java-standard-two-pointer-solution
        update! May use a HashSet to reduce the look up time to O(1)
      */
       HashSet<Character> vowels = new HashSet<Character>() {{
          add('A'); add('E'); add('I'); add('O'); add('U'); 
          add('a'); add('e'); add('i'); add('o'); add('u'); 
       }};
       
       Stack<Character> stack = new Stack<Character>();
       for (char c : s.toCharArray()) {
           if (vowels.contains(c)) {
               stack.push(c);
           }
       }
       
       StringBuilder sb = new StringBuilder();
       for(char c : s.toCharArray()) {
           if (vowels.contains(c)) {
               sb.append(stack.pop());
           } else {
               sb.append(c);
           }
       }
        return sb.toString();
        
    }
    
    public String reverseVowels(String s) {
        /* using two pointer
            https://leetcode.com/discuss/98987/java-standard-two-pointer-solution
           statically declared String as the dictionary and use the indexOf function to avoid String comparison. 
           This code run in 6ms.
        */
        String vowels = "aeiouAEIOU";
        
        int start = 0, end = s.length() - 1;
        char[] arr = s.toCharArray();
        
        while (start < end) {
            while (start < end && vowels.indexOf(arr[start]) != -1) {
                start++;
            }
            while(start < end && vowels.indexOf(arr[end]) != -1) {
                end--;
            }
    
            char temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }
}
