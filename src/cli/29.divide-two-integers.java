/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (16.15%)
 * Total Accepted:    212.9K
 * Total Submissions: 1.3M
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * 
 * Note:
 * 
 * 
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
 * this problem, assume that your function returns 231 − 1 when the division
 * result overflows.
 * 
 * 
 */
class Solution {
    // Use long to avoid integer overflow case
    public int divide(int dividend, int divisor) {
        int qt = 0;
        int flag = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) 
            flag = -1;
        
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        // Take care the edge case
       if (ldivisor == 0) return Integer.MAX_VALUE;
       if ((ldividend == 0) || (ldividend < ldivisor)) return 0;

       // Time Limit Exceeded
      /* long lans = 0;
       while (ldividend >= ldivisor) {
           ldividend -= ldivisor;
           lans++;
        }
        */ 
       long lans = ldivide(ldividend, ldivisor);

       int ans;

       if (lans > Integer.MAX_VALUE) { // Handle overflow
           ans = (flag == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
       } else {
           ans = (int) (flag * lans);
       }
       return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        // Find the larget multiple so that (divisor * multiple <= dividend),
        // whereas we are moving with stride 1, 2, 4, 8, 16 ... 2^n for performance reason
        // Think this as a binary search
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }

        // Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
