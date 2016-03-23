/*
151. Reverse Words in a String My Submissions Question
Total Accepted: 95234 Total Submissions: 608927 Difficulty: Medium
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Hide Company Tags Bloomberg
Hide Tags String
Hide Similar Problems (M) Reverse Words in a String II
*/


import java.util.*;

public class ReverseWordsInString{
	public static String reverseWordsInString(String s) {
		StringBuilder res = new StringBuilder(); 
		int j = s.length();
		
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i-1) == ' ') {
                
                if (res.length() != 0) {
                    res.append(' ');
                }
                res.append(s.substring(i,j));
            }
        }
        return res.toString();
	}
	
	public static void main(String[] args) {
		String s = "The sky is blue";
		System.out.println(reverseWordsInString(s));
		
		s=" ";
		System.out.println(reverseWordsInString(s));
		
	}
}