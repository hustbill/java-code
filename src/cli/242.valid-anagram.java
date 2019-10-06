/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (53.21%)
 * Total Accepted:    402.4K
 * Total Submissions: 749.6K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 * 
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[] buckets = new int[26];
        for (char i :  sArr) buckets[i - 'a']++;
        for (char j :  tArr) buckets[j - 'a']--;

        for (int i : buckets) {
            if (i != 0 ) return false;
        }

        return true;
    }
}
