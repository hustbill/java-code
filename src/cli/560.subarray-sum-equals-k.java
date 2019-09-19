/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (42.73%)
 * Total Accepted:    134.6K
 * Total Submissions: 314.3K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * 
 * 
 * 
 * Note:
 * 
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the
 * integer k is [-1e7, 1e7].
 * 
 * 
 * 
 */
class Solution {
    // Approach #2 Using Cummulative sum, Time: O(N^2) , Space O(N); 
    public int subarraySum_extra_space(int[] nums, int k) {
       int[] sum = new int[nums.length + 1];

       sum[0] = 0;
       for (int i = 1; i <= nums.length; i++) {
           sum[i] = sum[i - 1] + nums[i - 1];
       }

       int count = 0;
       for (int start = 0; start < nums.length; start++) {
           for (int end = start + 1; end <= nums.length; end++) {
               if (sum[end] - sum[start] == k) {
                   count++;
                }
           }
       }
       return count;
    }
    
    // Approach #3 Time: O(N^2) , Space O(1); 
    public int subarraySum(int[] nums, int k) {
       int count = 0;
       for (int start = 0; start < nums.length; start++) {
           int sum = 0;
           for (int end = start; end < nums.length; end++) {
               sum += nums[end];
               if (sum == k) {
                   count++;
                }
           }
       }
       return count;
    }
}