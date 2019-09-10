package oj.ots;
import java.util.*;

public class FindLargestUpperLower {
	/*
	1. 只有大写和小写字母组成，要求返回一个大写字母，which is the largest alphabetically order and occurs both in lower and upper cases in the string。
比如"aAbxeEX"，A，E， X都符合题意，但X的字母序比较大，所以返回X。
def findLargest(self, s):
        st = set(s)
        for each in sorted(s, reverse=True):
            if str(each).isupper():
                if str(each).lower() in st:
                    return each
	 */

	// Time complexity: O(N)
	public char findLargestUpperLower(String s) {
		char[] arr = s.toCharArray();
		char max = 'A';
		for (char ch : arr) {
			if (Character.isUpperCase(ch)) {
				String substr = Character.toString(Character.toLowerCase(ch));
				if (s.contains(substr)) {
					max = (char) Math.max(max, ch);  // get the largest alphabetically order one: X
				}
			}
		}		
		return max;
	}

	public static  void main(String[] args) {
		String[] strs = {"aAbxeEX", "ABCD", "abcd", "abcdD"};
		FindLargestUpperLower cdt  = new FindLargestUpperLower();
		for (String str : strs) {
			char ret = cdt.findLargestUpperLower(str);
			System.out.println("ret: " + ret);
		}
	}

}
