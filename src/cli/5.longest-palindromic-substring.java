/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.77%)
 * Total Accepted:    637.8K
 * Total Submissions: 2.3M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
      // expand around center
      // O(n^2) time using only constant space.
        if (s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) return s;

        String ret = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i, i,  abcba
            String tmp = helper(s, i, i);
            if (tmp.length() > ret.length()) {
                ret = tmp;
            }
            // get longest palindrome with center of i, i+1, abba
            tmp = helper(s, i, i+1);
            if (tmp.length() > ret.length()) {
                ret = tmp;
            }
        }
        return ret;
    }

    // Given a center, either one letter or two letter,
    // Find longest palindrome
    private String helper(String s, int start, int end) {
        while (start>= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
    
    public String longestPalindrome_9ok_255cases_(String s) {
        String ans = "";
        String substr = "";
        int len = s.length();
       for (int i = 0; i < len - 1; i++) {
           for (int j = 1; j < len - 1; j++) {
               System.out.printf("i=%d, j=%d", i, j);
               if (i< j && i < len - 1 && j <len - 1)  substr = s.substring(i, j);
                if (isPalindrome(substr)) {
                    ans = ans.length() > substr.length() ? ans : substr;
                }
           }
        }
      return ans;
    }

     public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()  - 1;
        while ( i < j) {
            while ( i < j && !Character.isLetterOrDigit(s.charAt(i)))  i++;
            while ( i < j && !Character.isLetterOrDigit(s.charAt(j)))  j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
