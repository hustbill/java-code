/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 *
 * https://leetcode.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (49.07%)
 * Total Accepted:    321.4K
 * Total Submissions: 652K
 * Testcase Example:  '[3,0,1]'
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,0,1]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * 
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant extra space complexity?
 */
class Solution {
    // Approach 3 : Bit Manipulation (XOR), Time: O(N), Space: O(1) 
    /*
    index: [0, 1, 2, 3]
    input: [0, 1, 2, 4]
    missing:
        =4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
        =(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
        =0∧0∧0∧0∧2
        =2
    */
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
    
    // Approach 2 : HashSet, Time: O(NlogN), Space: O(N) 
    public int missingNumber2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int expectedNumCount = nums.length + 1;
        for (int num = 0; num < expectedNumCount; num++) {
            if (!numSet.contains(num)) {
                return num;
            }
        }
        return -1;
    }

    // Approach 1 : sort array, Time: O(NlogN), Space: O(1) (or O(N) if we can't modify nums) 
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        } else if (nums[0] != 0) {  // Ensure that 0 is at the first index
            return 0;
        }

        // The missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) {
            int ret = nums[i - 1] + 1;
            if (nums[i] != ret) {
                return ret;
            }
        }
        // Array will not miss any numbers
        return -1;
    }
}
