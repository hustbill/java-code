/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (34.01%)
 * Total Accepted:    526.1K
 * Total Submissions: 1.5M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    // 总共4种解法， 我掌握了 horizontal scan 和 vertical scan 两种，divide and conquer一知半解
    // Divide and Conquer, Time: O(s), S is the number of all characters in the array
    // Space complexity: O(m.logn)
    // https://leetcode.com/problems/longest-common-prefix/solution/
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
            return longestCommonPrefix(strs, 0, strs.length - 1);
    }
    
    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r ) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) 
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }


    // 1. vertical scanning
    public String longestCommonPrefix_vertical_scan(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) 
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }


    
    // 2. horizontal scanning, Time complexity: O(S), where S is the sum of all characters in all strings.
    public String longestCommonPrefix_horizontal_scan(String[] strs) {
      if (strs.length == 0) return ""; 
      String ret = strs[0];
      for (int i = 1; i < strs.length; i++) {
          while (strs[i].indexOf(ret) != 0) {
              ret = ret.substring(0, ret.length() - 1);
         }
      }
       return ret.length() == 0 ? "" : ret;
    }
}
