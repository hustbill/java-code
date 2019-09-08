/*
 * @lc app=leetcode id=340 lang=java
 *
 * [340] Longest Substring with At Most K Distinct Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
 *
 * algorithms
 * Hard (40.68%)
 * Total Accepted:    85.5K
 * Total Submissions: 209.3K
 * Testcase Example:  '"eceba"\n2'
 *
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() <= k) return s.length();
        int n = s.length();
        // use two pointers, slide window
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int ans = k;

        while (j < n) {
            if (map.size() < k + 1) {
                map.put(s.charAt(j), j++);
            }
            if (map.size() == k + 1) {
                // delete the leftmost character
                int del_idx = Collections.min(map.values());
                map.remove(s.charAt(del_idx));
                i = del_idx + 1;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
