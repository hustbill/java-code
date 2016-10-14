/*
415. Add Strings
Total Accepted: 4917
Total Submissions: 11391
Difficulty: Easy
Contributors: Admin
Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
Show Company Tags
Hide Tags Math

*/
import java.util.*;

public class AddStrings {
	public static void main(String[] args) {
		AddStrings as = new AddStrings();
		String num1 = "124";
		String num2 = "86";
		String res = as.addStrings(num1, num2);
		
		System.out.println("res = " + res);
	}
	
	// https://discuss.leetcode.com/topic/62310/straight-forward-java-10-main-lines-25ms
    public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int len1 = num1.length();
		int len2 = num2.length();
        for (int i = len1 - 1 , j = len2 - 1; i >=0 || j >= 0; i--, j--)  {
        	int x = i < 0 ? 0 : num1.charAt(i) - '0';
			int y = j < 0 ? 0 : num2.charAt(j) - '0';
			sb.append((x + y + carry) % 10);
			carry = (x + y + carry) / 10;
        }
		if (carry != 0) {
			sb.append(carry);
		}
		return  sb.reverse().toString(); // 421 + 68 -> 0 1 2 - > 2 1 0 
	}
}