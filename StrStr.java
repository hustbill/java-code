/*

Implement strStr().
Date: 	2015.03.20

https://leetcode.com/problems/implement-strstr/
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Update (2014-11-02):
The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.

Show Tags


*/

import java.util.*;
import java.lang.String;

public class StrStr {
    public static int strStr(String haystack, String needle) {
		int ret= -1 ;
		int len = haystack.length();
		if(len == needle.length() && haystack.compareTo(needle)==0 )  ret= 0;
		if(len <= needle.length() && haystack.compareTo(needle) ==1)  ret=-1;
		// System.out.println("needle is abc"+ needle.compareTo("abc"));
		
		for(int i=0; i<= len -needle.length(); i++) {
			System.out.println(haystack.substring(i, i+ needle.length()) + "\t i=" +i);
			if( haystack.substring(i, i+ needle.length()).compareTo(needle) ==0 ) {
				return i;
			}
		}
		
		return ret;
        
    }
	
	public static void main(String[] args) {
		String haystack = "abdadbabcabcbbd";
		String needle = "abc";
		
		System.out.println(strStr(haystack, needle));
		
		System.out.println(strStr("aaa", "a"));
		System.out.println(strStr("mississippi", "pi"));
	
	}
}