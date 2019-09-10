package oj.ots;


import java.util.*;

public class CodeTemplate {
	/*
	2.find longest substring so no continuous letter appear more than 2 times. like aaab, the longest will be 3(aab)

def longestSub(self, text):
   idx, cnt, res, max = 0 ,{}, "", -1

   for i in range(len(text)):
       c = text[i]
       cnt[c] = cnt.get(c, 0)+1
       while cnt[c]>2:
           d = text[idx]
           idx+=1
           cnt[d]-=1
       if max< i-idx:
           max = i-idx
           res = text[idx:i+1]
   return res
	 */
	
	public String longestSubstr(String s) {
		if (s == null || s.length() == 0) return s;
		
		int[] counts = new int[26]; // count of each char
		int n = s.length();
		
		int idx = 0, end = 0; // use two pointers (begin, end) to slide window
		int maxLength = 0;
		String ret = "";
		
		for (end = 0; end < n; end++) {
			char c = s.charAt(end);
			counts[c - 'a']++;
			while (counts[c - 'a'] > 2) {
				char d = s.charAt(idx);
				idx++; // move the left pointer
				counts[d - 'a']--;
			}
			if (maxLength < end - idx + 1) {
				maxLength = end - idx + 1;
				ret = s.substring(idx, idx + maxLength);
			}
		}
		return ret;
	}
	
	public static  void main(String[] args) {
		String[] strs = {"abcdefghabcdefghlmnlmnlmn", "aaab", "aab", "ab", "abcdeffaggabc", "lmnalmnabclmn","a", ""};

		CodeTemplate ts  = new CodeTemplate();
		for (String str : strs) {
			String ret = ts.longestSubstr(str);
			System.out.println("ret: " + ret);	
		}
	}

}
