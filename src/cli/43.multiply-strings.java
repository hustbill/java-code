/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (31.37%)
 * Total Accepted:    222.3K
 * Total Submissions: 706.5K
 * Testcase Example:  '"2"\n"3"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Example 1:
 * 
 * 
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 
 * Example 2:
 * 
 * 
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 
 * 
 * Note:
 * 
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
 /*
  * two references:
  *
  * 1. https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
  *用图来说明， index i * index j ==> indices[i+ j, i + j + 1], 即 index 1 * index 0 ==>  indices[1, 2] 
  * 
  * 2. https://leetcode.com/problems/multiply-strings/discuss/17608/AC-solution-in-Java-with-explanation
  *思路也很清晰：
  * If we break it into steps, it will have the following steps. 1. compute products from each pair of digits from num1 and num2. 2. carry each element over. 3. output the solution.

Things to note:
(1) The product of two numbers cannot exceed the sum of the two lengths. (e.g. 99 * 99 cannot be five digit)
(2) 
    int d1 = num1.charAt(i) - '0';
    int d2 = num2.charAt(j) - '0';
    products[i + j + 1] += d1 * d2;
*/

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + pos[p2]; 
               
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }
        
        StringBuilder ret = new StringBuilder();
        for (int p : pos) {
            if (!(ret.length() == 0 && p == 0)) {
                ret.append(p);
            }
        }
        return ret.length() == 0 ? "0" :  ret.toString();
    }
}
