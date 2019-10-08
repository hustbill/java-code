/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (54.95%)
 * Total Accepted:    532.2K
 * Total Submissions: 963.6K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */
class Solution {
    public void moveZeroes(int[] nums) {
        
    }

    // my solution, Okay
    public void moveZeroesi_ok(int[] nums) {
        if (nums == null || nums.length == 0) return;
        // two pointers
        int i = 0, j = 1;
        while (i < j && j < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
                j = i + 1;
            }
            if (j < nums.length && nums[i] == 0 && nums[j] != 0) {
                swap(nums, i, j);
                i++;
                j = i + 1;
            }
            if ( j < nums.length && nums[i] == 0 && nums[j] == 0) {
                j++;
            }
        }
}
