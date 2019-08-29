/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (54.53%)
 * Total Accepted:    405.2K
 * Total Submissions: 741.5K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> ans = new ArrayList<List<Integer>>();
       List<Integer> cur = new ArrayList<Integer>();
       Arrays.sort(nums);

       dfs(nums, 0, cur, ans);
       return ans;
    }

    private void dfs(int[] nums, int start, List<Integer> cur, List<List<Integer>> ans) {
        ans.add(new ArrayList<Integer>(cur));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])  continue; // skip nums[i] == nums[i - 1]
            cur.add(nums[i]);
            dfs(nums, i + 1, new ArrayList<Integer>(cur), ans);
            cur.remove(cur.size() - 1);
       }
    }
}
