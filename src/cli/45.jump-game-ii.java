/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (28.62%)
 * Total Accepted:    191.4K
 * Total Submissions: 665.2K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * ⁠   Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 * 
 * You can assume that you can always reach the last index.
 * 
 */
class Solution {
    // Greedy
    // https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
    //  According the problem description, 'Each element in the array represents your maximum jump length at that position.'
    //  Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that 
    //  all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd,
    //  then trigger another jump, and set the new curEnd with curFarthest, 
    //  then keep the above steps, as the following:
    public int jump(int[] nums) {
        int jumps = 0;
        int curFarthest = 0;
        int curEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i > curFarthest) return - 1;

            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public int jump_nok(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;

        int jumps = 0;
        int furthest = 0;

        for (int i = 0; i < len; i++) {
            // System.out.printf("%d + nums[%d] = %d\n", i, i, i + nums[i]);
            if (i + nums[i] > furthest) {
                furthest = i + nums[i];
                jumps++;
            }
            if (furthest >= len - 1) return jumps;
        }
        return jumps;
    }
}
