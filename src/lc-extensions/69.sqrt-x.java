/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (32.26%)
 * Likes:    917
 * Dislikes: 1545
 * Total Accepted:    428.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '4'
 *
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 * 
 * Example 1:
 * 
 * 
 * Input: 4
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since 
 * the decimal part is truncated, 2 is returned.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int low = 1;
        int hi = x;
        while (low + 1 < hi) {
            int mid = low + (hi - low) / 2;
            if (mid > x / mid) { // use divide to avoid overflow
                hi = mid;
            } else {
                low = mid;
            }
            if (hi <= x / hi) {
                return hi;
            }
        }
        return low;
    }
}
// @lc code=end

