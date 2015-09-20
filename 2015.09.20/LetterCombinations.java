/*
Letter Combinations of a Phone Number 
https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
Total Accepted: 28876 Total Submissions: 108679 My Submissions Question Solution 

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.


*/

import java.util.*;

public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
		List<String> ret = new ArrayList<String>();
        String[] dic = { " ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		StringBuilder temp = new StringBuilder();
		dfs(digits, dic, 0, temp, ret);
		return ret;
	}
	
	public static void dfs( String digits, String[] dic, int deep, StringBuilder temp,
	List<String> ret) {
		if( deep == digits.length()) {
			ret.add(temp.toString());
			return;
		}
		else {
			for(int i=0; i< dic[digits.charAt(deep) -'0'].length(); i++ ) {
				temp.append(dic[digits.charAt(deep) -'0'].charAt(i));
				dfs(digits, dic, deep+1, temp, ret);
				temp.deleteCharAt(temp.length()-1);
			}
		}
	}
	public static void main(String[] args) {
		String digits = "23";
		List<String> ret = new ArrayList<String>();
		ret = letterCombinations(digits);
		System.out.println("ret.size() = " + ret.size());
			System.out.println();
	}
	
}