/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (44.31%)
 * Total Accepted:    610.5K
 * Total Submissions: 1.4M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */
class Solution {
    /*
     * The problem to find maximum (or minimum) element (or sum) with a single array as the input is a good candidate to be solved by the greedy approach in linear time. One can find the examples of linear time greedy solutions in  our articles of Super Washing Machines, and Gas Problem.
*/
    // Greedy approach 
    /* The algorithm is general and straightforward: 
     * iterate over the array and update at each step the standard set for such problems:
       (1) current element
       (2) current local maximum sum (at this given point)
       (3) global maximum sum seen so far.
    */
    // Time complexity: O(N), Space complexity: O(1)
    public int maxSubArray_greedy(int[] nums) {
       int n = nums.length;
       int currSum = nums[0];
       int maxSum = nums[0];
       for (int i = 1; i < n; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
       return maxSum;
    }

    // DP Dynamic Programming (Kadane's algorithm)
    // Time Complexity: O(N), Space complexity: O(1)
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}
