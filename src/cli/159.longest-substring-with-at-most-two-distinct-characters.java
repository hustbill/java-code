/*
 * @lc app=leetcode id=159 lang=java
 *
 * [159] Longest Substring with At Most Two Distinct Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
 *
 * algorithms
 * Hard (47.63%)
 * Total Accepted:    78.6K
 * Total Submissions: 164.6K
 * Testcase Example:  '"eceba"'
 *
 * Given a string s , find the length of the longest substring t  that contains
 * at most 2 distinct characters.
 * 
 * Example 1:
 * 
 * 
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 * 
 */
class Solution {
    // use slide window method
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() < 3) return s.length();
        int n = s.length();
        int i = 0, j = 0;
        int ans = 2;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while (j < n) {
            if (map.size() < 3) {
                map.put(s.charAt(j), j++); // move right pointer
            } 
            if (map.size() == 3) {
                // delete the leftmost character
                int del_idx = Collections.min(map.values());
                map.remove(s.charAt(del_idx));
                // move the left pointer of the slide window
                i = del_idx + 1;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }

}
