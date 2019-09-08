/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (56.88%)
 * Total Accepted:    429.5K
 * Total Submissions: 750.7K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;
        
        List<Integer> curr = new ArrayList<>();
        helper(nums, 0, curr, ret);
        return ret;
    }

    private void helper(int[] nums, int pos, List<Integer> curr, List<List<Integer>> ret) {
        if (pos == nums.length) {
            ret.add(new ArrayList<Integer>(curr));
            return;        
        }
        ArrayList<Integer> newPerm = new ArrayList<Integer>(curr);
        for (int i = 0; i <= pos; i++) {
            newPerm.add(i, nums[pos]);
            helper(nums, pos + 1, newPerm, ret);
            newPerm.remove(i);
       }
    }

}
