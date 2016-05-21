package v201605;

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
	public static void main(String[] args) {
		String s = "leetcode";
		System.out.printf(" %s -> %s\n", s, new ReverseVowels_345().reverseVowels_stack(s));
		System.out.printf(" %s -> %s", s, new ReverseVowels_345().reverseVowels(s));
	}
	
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
    	if (s == null || s.length() == 0) return s;
    	
        String vowels = "aeiouAEIOU";
        
        int start = 0, end = s.length() - 1;
        char[] arr = s.toCharArray();
        
        while (start < end) {
            while (start < end && !vowels.contains(arr[start] + "")) {
                start++;
            }
            while(start < end && !vowels.contains(arr[end] +"")) {
                end--;
            }
    
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
    }
}
