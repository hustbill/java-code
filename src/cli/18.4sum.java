/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (31.30%)
 * Total Accepted:    267K
 * Total Submissions: 844.3K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        // two pointers
        // val = nums[i] + nums[j] + nums[hi] + nums[lo] 
        // if val == target, ret.add(i, j, hi, lo)
        // else if val < target, lo++;
        // else if val > target, hi--;
        
        if (nums == null || nums.length < 4) return ret;
        int len = nums.length;

        for (int i = 0; i < len - 3; i++) {
            // first candidate too large, search finished
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) 
                continue;  // first candidate too small
            if (i > 0 && nums[i] == nums[i - 1]) 
                continue; // avoids duplicate result int list
            for (int j = i + 1; j < len - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[len -1] + nums[len -2] < target)
                    continue; // second canddiate too small
                if (j > i + 1 && nums[j] == nums[j - 1]) 
                    continue; // avoids duplicate result in list
                int hi = len - 1;
                int lo = j + 1;
                while (lo < hi) {
                    int val = nums[i] + nums[j] + nums[hi] + nums[lo];
                    if (val == target) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        // skipping over duplicate on low
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        // skipping over duplicate on hi 
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (val > target) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
        }
        return ret;
    }
}
