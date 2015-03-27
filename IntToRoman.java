/*
Integer to Roman

https://oj.leetcode.com/problems/integer-to-roman/

My Submissions Question Solution 
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.


*/

public class IntToRoman {
    public String intToRoman(int num) {
		int[] integer = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] roman = {"M", "CM", "D","CD","C", "XC","L","XL", "X", "IX","V","IV", "I"};
		if (num<1)
			return null;

		String str="";
		for(int i = 0; i < integer.length; i ++){
			int q = num/integer[i];
			while(q>0){
				str=str+roman[i];
				q--;
			}
			num=num%integer[i];
		}

		return str;
			
    }
	
	
}