/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 *
 * algorithms
 * Medium (39.23%)
 * Total Accepted:    53.9K
 * Total Submissions: 136.9K
 * Testcase Example:  '"aaabb"\n3'
 *
 * 
 * Find the length of the longest substring T of a given string (consists of
 * lowercase letters only) such that every character in T appears no less than
 * k times.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * s = "aaabb", k = 3
 * 
 * Output:
 * 3
 * 
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s = "ababbc", k = 2
 * 
 * Output:
 * 5
 * 
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is
 * repeated 3 times.
 * 
 * 
 */
class Solution {
    /*
     *  Two pointers , O(N) time complexity
     *  https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87739/Java-Strict-O(N)-Two-Pointer-Solution
     * This might help you to understand the algorithm:
For h=1:26, we are going to use sliding window (left i, right j) to find the "longest window which contains exactly h unique characters and for each character, there are at least K repeating ones".
For example, when h=3, K=5, we are going to find the longest window contains exactly 3 unique characters and each repeating 5 times.
     *
    */
    public int longestSubstring(String s, int k) {
        int d = 0;
        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
            d = Math.max(d, longestSubStringWithNUniqueChars(s, k, numUniqueTarget));
        }
        return d;                
    }

    private int longestSubStringWithNUniqueChars(String s, int k, int numUniqueTarget) {
        int[] map = new int[128];
        int numUnique = 0; // count 1
        int numNoLessThanK = 0; // count 2
        int begin = 0, end = 0;
        int d = 0;

        while (end < s.length()) {
            if (map[s.charAt(end)]++ == 0) numUnique++;  // increment map[c] after this statement;
            if (map[s.charAt(end++)] == k) numNoLessThanK++;  // inc end after this statement

            while (numUnique > numUniqueTarget) {
                if (map[s.charAt(begin)]-- == k) numNoLessThanK--;   // decrement map[c] after this statement
                if (map[s.charAt(begin++)] == 0) numUnique--;      // inc begin after this staetement
            }

            // if we found a string where the number of unique chars equals our target
            // and all those chars are repeated at least K times then update max
            if (numUnique == numUniqueTarget && numUnique == numNoLessThanK) 
                d = Math.max(end - begin, d);
        }
        return d;
    }       
}
