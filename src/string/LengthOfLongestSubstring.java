package string;

/*
 * 3. Longest Substring Without Repeating Characters Add to List
DescriptionHintsSubmissionsSolutions
Total Accepted: 283937
Total Submissions: 1178327
Difficulty: Medium
Contributor: LeetCode
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Hide Company Tags Amazon Adobe Bloomberg Yelp
Hide Tags Hash Table Two Pointers String
Hide Similar Problems (H) Longest Substring with At Most Two Distinct Characters

 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String[] tests = {"ctnlk", "z", "aaaa", "aab", "", "an++--viaj"};
      int[] res = {5, 1, 1, 2, 0, 5};
      for (int i = 0; i < tests.length; i++) {
    	  int ans = lengthOfLongestSubstring(tests[i]); 
    	  System.out.println(ans == res[i]);
      }
	}
	
	public static int lengthOfLongestSubstring(String s) {
	  int[] map = new int[256]; // map from character's ASCII to its last occured index
	  int j = 0;
	  int len = 0;
	  for (int i = 0; i < s.length(); i++) {
		  while (j < s.length() && map[s.charAt(j)] == 0) {
			  map[s.charAt(j)] = 1;					  
			  len = Math.max(len,  j - i + 1);
			  j++;
		  }
		  map[s.charAt(i)] = 0;
	  }
	  return len;
	}
	
	
    public static int lengthOfLongestSubstring_failed(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s.length();
        int len = 0;
        char[] arr = s.toCharArray();
        
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
        	    while (j < s.length()) {
	              if(j < s.length() && arr[i] != arr[j]) {
	            	// System.out.printf("arr[%d] = %c \t", j, arr[j]);
	                len = Math.max(len, j - i + 1);
	                j++;
	              } 
	              if (j < s.length() && arr[i] == arr[j]) {
	                len = Math.max(len, j - i );
	                i = j;
	                j++;
	              }              
	            }
        	}
        
        return len;
    }
}

