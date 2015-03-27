/*
Longest Common Prefix 
https://oj.leetcode.com/problems/longest-common-prefix/
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class LongestCommonPrefix {
	// Reference: http://rleetcode.blogspot.com/2014/02/longest-common-prefix-java.html
    public  static String longestCommonPrefix(String[] strs) {
        int n = strs.length; 
        if (n==0) return "";
		if( n==1 ) return strs[0];
		String res = strs[0];
		for(int i=0; i< res.length(); i++) {
			char p = res.charAt(i);
			System.out.println("p=" +p);
			for( int j=1; j < n; j++) {  // search in strs
				System.out.print(String.format("strs[%d]=%s \n", j, strs[j]));
				if( strs[j].length()==i || strs[j].charAt(i) != p) {
					System.out.print(String.format("res.substring(0, %d) = %s \n" , i, res.substring(0, i)));
					return res.substring(0, i);
				}
			}
          }
     
		return res ;
    }
	
	public static void main(String args[]) {
		String[] strs = {"hello", "hez", "hel", "helro"};
		String prefix = longestCommonPrefix(strs);
		System.out.print(String.format("prefix = %s \n", prefix)); 
	}
}