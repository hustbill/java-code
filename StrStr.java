/*
28. Implement strStr() My Submissions Question
Total Accepted: 98416 Total Submissions: 400908 Difficulty: Easy
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Hide Company Tags Microsoft Facebook
Hide Tags Two Pointers String
Hide Similar Problems (H) Shortest Palindrome

KMP Algorithm
Rabin-Karp Algorithm
Boyer-Moore Algorithm

Bruce force method : we can scan the needle with hackstack from its first position and start matching all subsequent letters one by one. If one of the letters does not match, we start over again with the next position in the haystack.

Assume that n = length of haystack and m = lenght of needle, then the runtime complexity is O(nm)

Have you considered these scenarios?
1. needle or haystack is empty. If needle is empty, always return 0.
If haystack is empty, then there will be no match (return -1)unless needle is also empty which 0 is returned.
2. needle's length is greater than haystack's length. Should always return -1 
3. needle is located at the end of haystack. For example, "aaaaba" and "ba". Catch possible off-by-one errors.
4. needle occur multiple times in haystack. For example, "mississippi" and "issi". It should return index 2 as the first match of "issi"
5. Imagine two very long strings of equal lengths = n, haystack = "aaaa...aa" and needle = "aaaa....ab". You should not do more than n character comparsions, or else your code will get Time Limit Exceeded in OJ.
*/

public class StrStr {
    public static void main(String args[]) {
        String haystack = "You are a good software engineer";
        String needle = "software";
        System.out.printf("strStr(%s, %s) = %d", haystack, needle, 
            strStr(haystack, needle));
    }
    
    public static int strStr(String haystack, String needle) {
     
        for (int i = 0; ; i++ ) {
            for (int j=0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i+j)) break;
            
            }
        }
    }
}