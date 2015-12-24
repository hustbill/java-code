import java.util.*;

public class Solution {
	public static void main(String[] args) {
		String s1 = "small", s2 = "smart", s3 = "smartsite", s4= "smab", s5="smac";
		String[] strs = new String[] { s1, s2, s3, s4, s5};
		System.out.printf("prefix =%s", findCommonPrefix(s1, s2));
		System.out.printf("\tres = %s", longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		String prefix="";
		if (strs == null || strs.length == 0 ) return prefix;
		if (strs.length == 1) return strs[0];
	    int len  = strs.length;
		prefix = findCommonPrefix(strs[0], strs[1]);
		int i=2;
		while (i < len) {
		   prefix = findCommonPrefix(prefix, strs[i]);
		   i++;
		}
		return prefix;
    }
    
    public static String findCommonPrefix(String s1, String s2) {
        int end = 0;
		int len = Math.min(s1.length(), s2.length());
        for(int i=0; i< len; i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                end++;
            } else {
				break;
			}
        }
        return s1.substring(0, end);
    }
}