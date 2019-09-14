/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (41.77%)
 * Total Accepted:    271.3K
 * Total Submissions: 644.4K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
class Solution {
    // backtracking 
    // traversal each num, add the permutation to the arraylist
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0)  return ret;

       List<Integer> curr = new ArrayList<>();
       boolean[] used = new boolean[nums.length];

       Arrays.sort(nums);  // if it includes duplicates, sort it at first
       helper(nums, used, curr, ret);

       return ret;
    }

    private void helper(int[] nums, boolean[] used,  List<Integer> curr, List<List<Integer>> ret) {
        if (curr.size() == nums.length) {
            ret.add(new ArrayList<Integer>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
           if (used[i]) continue;
           if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
           used[i] = true;
           curr.add(nums[i]);
           helper(nums, used, curr, ret);
           used[i] = false;
           curr.remove(curr.size() - 1);
        }
    }    
}
