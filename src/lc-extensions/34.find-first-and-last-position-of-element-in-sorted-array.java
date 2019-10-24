/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (34.37%)
 * Likes:    2125
 * Dislikes: 99
 * Total Accepted:    366.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */

// @lc code=start
class Solution {
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/14699/Clean-iterative-solution-with-two-binary-searches-(with-explanation)
    public int[] searchRange(int[] nums, int target) {        
        int len = nums.length;
        int lo = 0, hi = len - 1;
        int[] ret = new int[2];
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }        
        }
        if (target == nums[lo]) {
            ret[0] = lo;
        } else {
            ret[0] = -1;
        }

        // right side 
        hi = len - 1;
         while (lo < hi) {
            int mid = (lo + (hi - lo) / 2) + 1;
            if ( target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid;
            }        
        }
        if (target == nums[hi]) {
            ret[1] = hi;
        } else {
            ret[1] = -1;
        }
       
        return ret;
    }
}
// @lc code=end

