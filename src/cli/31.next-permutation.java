/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (30.93%)
 * Total Accepted:    269.3K
 * Total Submissions: 867.7K
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
class Solution {
    // https://leetcode.com/problems/next-permutation/discuss/13872/Easiest-JAVA-Solution
    public void nextPermutation(int[] nums) {
      if(nums == null || nums.length <= 1) return;
      int i = nums.length - 2; 

      while (i >= 0 && nums[i] >= nums[i+ 1]) i--; // find the first idx that breaks descending order

      if (i >= 0) {                                  // If not entirely descending 
          int j = nums.length - 1;                  // start from the end
          while (j >= 0 && nums[j] <= nums[i]) {    // Find rightmost first larger id j
              j--;
          }
          swap(nums, i, j);                         // Switch i and j
      }
      reverse(nums, i + 1, nums.length - 1);         // Reverse the descending sequence
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public  void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }
}
