package oj.ots;
import java.util.*;

public class RemoveCharNoMoreThanTwo {
	/*
	

	 */

	public String removeChar(String s) {
		StringBuilder ret = new StringBuilder();
		if (s == null || s.length() == 0) return s;
		int n = s.length();
		char[] arr = s.toCharArray();
		for (int idx = 0; idx < n; idx++) {
			if (idx >= 2 && arr[idx - 1] == arr[idx] 
					&& arr[idx - 2] == arr[idx]) {
				continue;
			}
			ret.append(arr[idx]);
		}
		return ret.toString();		
	}

	public static  void main(String[] args) {
		String[] strs = {"bbaaabbbcccdd", "bbb", "bbbaa", "aabbb", "abcabcabc"};
		RemoveCharNoMoreThanTwo ts  = new RemoveCharNoMoreThanTwo();
		for (String str : strs) {
			String ret = ts.removeChar(str);
			System.out.println("ret: " + ret);
		}
	}

}
