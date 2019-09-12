/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 *
 * https://leetcode.com/problems/count-binary-substrings/description/
 *
 * algorithms
 * Easy (54.07%)
 * Total Accepted:    34.5K
 * Total Submissions: 63.7K
 * Testcase Example:  '"00110"'
 *
 * Give a string s, count the number of non-empty (contiguous) substrings that
 * have the same number of 0's and 1's, and all the 0's and all the 1's in
 * these substrings are grouped consecutively. 
 * 
 * Substrings that occur multiple times are counted the number of times they
 * occur.
 * 
 * Example 1:
 * 
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive
 * 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 * Notice that some of these substrings repeat and are counted the number of
 * times they occur.
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are
 * not grouped together.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal
 * number of consecutive 1's and 0's.
 * 
 * 
 * 
 * Note:
 * s.length will be between 1 and 50,000.
 * s will only consist of "0" or "1" characters.
 * 
 */
class Solution {
    // https://leetcode.com/problems/count-binary-substrings/discuss/108600/Java-O(n)-Time-O(1)-Space
    public int countBinarySubstrings(String s) {
        // currRunLength - this keeps track of the current count of contiguous 1's or 0's that you've currently seen
        // prevRunLength - this keeps track of the previous count of contiguous 1's or 0's that you've currently seen
        // The first if/else block manipulates these variables
        int ret = 0, prevRunLength = 0, currRunLength = 1;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == s.charAt(i -1)) currRunLength++;
            else {
                prevRunLength = currRunLength;
                currRunLength = 1;
            }
            if (prevRunLength >= currRunLength) ret++;
           // The last if statement is for checking how many valid substrings you have seen so far in the iteration.
        }
        return ret;
    }
    
    public int countBinarySubstringsi_nok(String s) {
       int count = 0, c0 = 0, c1 = 0;
       char[] arr = s.toCharArray();
       int n = s.length();
       int i = 0, j = 1;
       while (i < n && j < n) {
           if (arr[i] == arr[j]) {
               if (arr[j] == 0)  c0++;
               if (arr[j] == 1)  c1++;
               i++;
               j++;
           }
           if (c0 != c1) {
               i = j + 1;
               j++;
               count++;
           } else {
               count++;
           }
           i++;
           j++;
       }
       return count;
    }
}
