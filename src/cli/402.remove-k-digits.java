/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 *
 * https://leetcode.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (26.96%)
 * Total Accepted:    71.6K
 * Total Submissions: 265.4K
 * Testcase Example:  '"1432219"\n3'
 *
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * 
 * Note:
 * 
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
 * which is the smallest.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the
 * output must not contain leading zeroes.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with
 * nothing which is 0.
 * 
 * 
 */
class Solution {
    public String removeKdigits(String num, int k) {
       // using stack
       // corner case
       if (num.length() == k) return "0";

       Stack<Character> stack = new Stack<Character>();

       int i = 0; 
       while (i < num.length()) {
          //whenever meet a digit which is less than the previous digit, discard the previous one:wq
           while (k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()) {
               stack.pop();
               k--;
            }
            stack.push(num.charAt(i));
            i++;
       }

       // corner case like "1111"
       while (k > 0) {
           stack.pop();
           k--;
        }

       // construct the number from the stack
       StringBuilder ret = new StringBuilder();
       while (!stack.isEmpty()) {
           ret.append(stack.pop());
        }

       // remove all the 0 at the end
       while (ret.length() > 1 && ret.charAt(ret.length() - 1) == '0') 
           ret.deleteCharAt(ret.length() - 1);
       
        return ret.reverse().toString();
    }
}
