/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (44.34%)
 * Total Accepted:    111.1K
 * Total Submissions: 250.1K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    // Time Complexity: `O(m + n)`, Space Complexity: O(m + n), iterative
    public String addStrings(String num1, String num2) {
       char[] arr1 = num1.toCharArray();
       char[] arr2 = num2.toCharArray();
       int i = arr1.length - 1;
       int j = arr2.length - 1;
       int carry = 0;
       StringBuilder ret = new StringBuilder();
       while(i >=0  || j >= 0 || carry == 1) {
           int sum = carry;
           if (i >= 0) {
               sum += arr1[i--] - '0';
           }
           if (j >= 0 ) {
               sum += arr2[j--] - '0';
           }
            ret.insert(0, sum % 10);
           carry = sum / 10;
       }
       return ret.toString(); 
    }
}
