package oj.ots;
import java.util.*;

public class ReplaceQuestionMark {
	/*
		2. 给定一个string，变量名riddle，只有小写字母以及question mark组成，要求用'a'~'z'替换掉所有'?'，保证任意相邻的字符不相同
		比如riddle = ab?ac?，如果我们返回的是abcacd就是正确的。
		比如riddle = ?????????, 如果我们返回abcdefghi就是正确的t。
		Codility的test case应该是包括了 (1)新的返回的string是否长度和原先string相‍‌‌‍‌‌‍‌‌‌‌‌‍‍‌‍‌等  (2) 原先问号位置的两边是否和replaced character相等
		
		 def replaceQMark(self,s):
		        low = "abc"
		        def getCh(a, b):
		            for i in low:
		                if i==a or i==b:
		                    continue
		                return i
		        res=[]
		        for i, char in enumerate(s):
		            if char=='?':
		                res.append(getCh(res[-1], s[i+1]))
		            else:
		                res.append(char)
		        return "".join(res)
	 */

	// Time complexity: O(N)
	public char getChar(char prev, char next) {
		char[] candidates = {'a', 'b', 'c'};
		char ret = 'a';	
		for (char ch : candidates) {
			if (ch == prev || ch == next) continue;
			ret = ch;
		}
		return ret;
	}
	public String replaceQuestionMark(String riddle) {
		if (riddle == null || riddle.length() == 0) return riddle;
		if (	riddle.length() == 1) return riddle == "?" ? "a" : riddle;
		
		char replacement = 'a';
		StringBuilder ret = new StringBuilder();
		char[] arr = riddle.toCharArray();
		
		if (arr[0] == '?') {
			arr[0] = replacement;
		}
		ret.append(arr[0]);
		
		for (int i = 1; i < arr.length - 1; i++) {			
			if (arr[i] == '?') {
				arr[i] = getChar(arr[i - 1], arr[i + 1]);
				ret.append(arr[i]);				
			} else {
				ret.append(arr[i]);
			}
		}
		if (arr[arr.length - 1] == '?') {
			arr[arr.length - 1] = getChar(arr[arr.length - 2], replacement);
		} 
		ret.append(arr[arr.length - 1]);
		return ret.toString();		
	}
	

	public static  void main(String[] args) {
		String[] strs = {"a?bx?eX?", "ab?cd", "????abc?d?", "abcda???", "a?", "?"};
		ReplaceQuestionMark cdt  = new ReplaceQuestionMark();
		for (String str : strs) {
			System.out.println("\nstr: " + str);
			String ret = cdt.replaceQuestionMark(str);
			System.out.println("ret: " + ret);
		}
	}

}
