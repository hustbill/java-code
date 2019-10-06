/*
 * @lc app=leetcode id=280 lang=java
 *
 * [280] Wiggle Sort
 *
 * https://leetcode.com/problems/wiggle-sort/description/
 *
 * algorithms
 * Medium (61.56%)
 * Total Accepted:    71.9K
 * Total Submissions: 116.5K
 * Testcase Example:  '[3,5,2,1,6,4]'
 *
 * Given an unsorted array nums, reorder it in-place such that nums[0] <=
 * nums[1] >= nums[2] <= nums[3]....
 * 
 * Example:
 * 
 * 
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 * 
 */
class Solution {
    // Approach 1: Two pointer approach
    // The fast pointer which is denoted by variable "cur" does the job of processing new elements
    // The slow pointer is the poistion of last found non-0 elment, is denoted by "lastNonFoundAt"
    // Time : O(N), Space: 0(1)
    public void wiggleSort(int[] nums) {
        int lastNonFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (num[i] != 0) {
                nums[lastNonFoundAt++] = nums[i];
            }
        }

        // After we have finished processing new elements,
        // all the non-zero elements are alreay at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
