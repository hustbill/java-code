/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 *
 * https://leetcode.com/problems/ransom-note/description/
 *
 * algorithms
 * Easy (50.57%)
 * Total Accepted:    123K
 * Total Submissions: 242.9K
 * Testcase Example:  '"a"\n"b"'
 *
 * 
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the
 * ransom 
 * note can be constructed from the magazines ; otherwise, it will return
 * false. 
 * 
 * 
 * Each letter in the magazine string can only be used once in your ransom
 * note.
 * 
 * 
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * 
 * 
 * 
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * 
 */
class Solution {
    // Time complexity: O(N), where N is magazine length
    public boolean canConstruct(String ransomNote, String magazine) {
       if (ransomNote.length() > magazine.length()) return false;

        // using bucket
       int[] table = new int[26];
       for (int i = 0; i < ransomNote.length(); i++) {
           char c = ransomNote.charAt(i);
           table[c - 'a']++;
       }

       for (int j = 0; j < magazine.length(); j++) {
           char c = magazine.charAt(j);
           table[c - 'a']--;
       }

       for (int k : table) {
           if (k > 0) return false;
       }
       return true;
    }
}
