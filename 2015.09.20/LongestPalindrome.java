/*
Longest Palindromic Substring 

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
import java.util.Arrays;

public class LongestPalindrome {
	
	public static String longestPalindrome(String s){
		if(s.isEmpty() ||s.length() ==0 || s == null ) return s;
		
		String longest = s.substring(0,1);
		for(int i=0; i< s.length() ;i++) {
			
			// get longest palindrome with center of i
			// for example, abcba
			String tmp = findPalindrome(s, i, i);
			if(tmp.length() > longest.length())
				longest  = tmp;
			
			// get longest palindrome with center of i, i+1
			// for example:  abba
			tmp = findPalindrome(s, i, i+1);
			if( tmp.length() > longest.length()) 
				longest = tmp;
		}
		return longest;
		
	}
	
	 
	// find longest paindrome
	// Given a center, either one letter or two letter,
	public static String findPalindrome(String s, int start, int end){
		while(start>=0  && end  < s.length()  && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return s.substring(start+1, end);
	}
	
	//Submission Result: Time Limit Exceeded
    public  static String longestPalindrome0(String s) {
		String substr = null;
		int len =s.length();
		System.out.println("Original len=" + len);
		if(s == null || len ==1) return s;
	    for(int i=0; i< len-1; i++) {
			for(int j=0; j<=i; j++) {
				substr = s.substring(j, len-1-i);
				if(isPalindrome(substr) ) {
					return substr;
				} 
			}
		}
		
		return substr;
        
    }
	
	public static boolean checkPalindrome0(String s) {
		int len = s.length();
		System.out.println("len=" + len);
		char[] arry1 = new char[len];
		char[] arry2 = new char[len];
		for(int i=0; i< len; i++) {
			arry1[i] = s.charAt(i);
			arry2[i] = s.charAt(len-1 -i);
		}
		
		if( Arrays.equals(arry1, arry2)) {
			System.out.println("arry1.to string = " + String.copyValueOf(arry1));
			return true;
		}	
		else  {
			System.out.println("arry1.to string = " + String.copyValueOf(arry1));
			System.out.println("arry2.to string = " + String.copyValueOf(arry2));
			return false;
		}
			
	}
	
	// 第一种方法就是挨个检查，维护全局最长，时间复杂度为O（n3），会TLE-  Time Limit Exceeded。
	public  static String longestPalindrome1(String s) {
 
	    int maxPalinLength = 0;
	    String longestPalindrome = null;
	    int length = s.length();
 
	    // check all possible sub strings
	    for (int i = 0; i < length; i++) {
	        for (int j = i + 1; j < length; j++) {
	            int len = j - i;
	            String curr = s.substring(i, j + 1);
	            if (isPalindrome(curr)) {
	                if (len > maxPalinLength) {
	                    longestPalindrome = curr;
	                    maxPalinLength = len;
	                }
	            }
	        }
	    }
 
	    return longestPalindrome;
	}
	
	public static boolean isPalindrome(String s) {
 
	    for (int i = 0; i < s.length() - 1; i++) {
	        if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
	            return false;
	        }
	    }
 
	    return true;
	}
	
	public static void main(String args[]) {
		String a = "hello world- gooddoog";
		String b = "1123454320";
		String c = "iammai-boy";
		String d = " ";
		String a_sub = longestPalindrome(a);
		String b_sub = longestPalindrome(b);
		String c_sub = longestPalindrome(c);
		String d_sub = longestPalindrome(d);
		System.out.print(String.format("\na_sub = %s", a_sub));
		System.out.print(String.format("\nb_sub = %s", b_sub));
		System.out.print(String.format("\nc_sub = %s", c_sub));
		System.out.print(String.format("\nd_sub = %s\n", d_sub));
	}
}

