/*
Regular Expression Matching 
https://leetcode.com/problems/regular-expression-matching/

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") //false
isMatch("aa","aa") //true
isMatch("aaa","aa") //false
isMatch("aa", "a*") //true
isMatch("aa", ".*") //true
isMatch("ab", ".*") //true
isMatch("aab", "c*a*b") //true



*/

public class IsMatch{
	public static boolean isMatch(String s, String p){
		if(s.length() > p.length()) 
			return false;
		
		
	}
	
	
	pubic static void main(String[] args) {
		System.out.println(isMatch("aa","a")); //false
		System.out.println(isMatch("aa","aa")); //true
		System.out.println(isMatch("aaa","aa")); //false
		System.out.println(isMatch("aa", "a*")); //true
		System.out.println(isMatch("aa", ".*")); //true
		System.out.println(isMatch("ab", ".*")); //true
		System.out.println(isMatch("aab", "c*a*b"));  //true
	}
}