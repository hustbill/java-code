/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (43.38%)
 * Total Accepted:    219.4K
 * Total Submissions: 505K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all startsible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<List<Integer>> ans = new ArrayList<List<Integer>>();
       List<Integer> cur = new ArrayList<Integer>();
       Arrays.sort(nums); // don't forget this 
       dfs(nums, 0, cur, ans);
       return ans;
    }

    public void dfs(int[] nums, int start, List<Integer> cur, List<List<Integer>> ans) {
        ans.add(new ArrayList<Integer>(cur));
        
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            cur.add(nums[i]);
            dfs(nums, i + 1, new ArrayList<Integer>(cur), ans);
            cur.remove(cur.size() - 1);
        }
    }
}
