/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (32.46%)
 * Total Accepted:    303.9K
 * Total Submissions: 933.3K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 */
class Solution {
    // approach 4: best,  Greedy 
    // https://leetcode.com/problems/jump-game/solution/
    // Looking from the start and selecting the locally optimum in the hope of reaching global optimum 
    public boolean canJump_approach4(int[] nums) {
        int len = nums.length;
        int farest = 0;
        for (int i = 0; i < len; i++) {
            if (farest < i ) return false;
            farest = Math.max(i + nums[i], farest);
        }
        return true;
    }
    
    public boolean canJump_approach4_from_end(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i ;
            }
        }
        return lastPos == 0;

    }
    
    // Approach 2: Dynamic programming Top-Down
    // Top-down Dynamic Programming can be thought of as optimized backtracking. 
    // We can store the result and not need to recompute it every time.
    // For each position in the array, we remember whether the index is good or bad. 
    // Let's call this array memo and let its values be either one of : GOOD, BAD, UNKNOWN.
    // This technique is called memorization.
    // Steps:
    // 1. Initially, all elements of the memo table are UNKNOWN, 
    //     except for the last one, which is GOOD (it can reach itself)
    // 2. Modify the backtracking algorithm such that the recursive step 
    //     first checks if the index is known (GOOD / BAD)
    //       (a) If it is known then return True / False
    //       (b) Otherwise perform the backtracking steps as before
    // 3. Once we determine the value of the current index, we store it in the memo table
    enum Index {
        GOOD,
        BAD,
        UNKNOWN
    }
    // Time complexity: O(n^2), Space complexity: O(n)
    // ✔ 75/75 cases passed (1376 ms)
    public boolean canJump_dp_top_down(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums, memo);
    }
    
    public boolean canJumpFromPosition(int pos, int[] nums, Index[] memo) {
        if (memo[pos] != Index.UNKNOWN) {
            return memo[pos] == Index.GOOD ? true : false;
        }
        int furthestJump = Math.min(pos + nums[pos], nums.length - 1);
        for (int nextPos = pos + 1; nextPos <= furthestJump; nextPos++) {
            if (canJumpFromPosition(nextPos, nums, memo)) {
                return true;
            }
        }
        memo[pos] = Index.BAD;
        return false;
    }

    // Approach 3: Dynamic Programming - Bottom-up
    // eliminate recursion from top-down
    // The obervation to make here is that we only ever jump to the right.
    // This means that if we start from the right of the array, 
    // every time we will query a position to our right, that position 
    // has already be determined as being GOOD or BAD. 
    //
    public boolean canJump(int[] nums) {
       int len = nums.length;
       Index[] memo = new Index[len];
       for (int i = 0; i < len; i++) {
           memo[i] = Index.UNKNOWN;
       }
       memo[len - 1] = Index.GOOD;

       for (int i = len - 2; i >= 0; i--) {
           int furthestJump = Math.min(i + nums[i], len - 1);
           for (int j = i + 1; j <= furthestJump; j++) {
               if (memo[j] == Index.GOOD) {
                   memo[i] = Index.GOOD;
                   break;
                }
           }
        }
       return memo[0] == Index.GOOD;

    }


    // Time Limit Exceeded
    // approach 1: backtracking, inefficient  
    public boolean canJumpFromPosition_approach1(int pos, int[] nums) {
        if (pos == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(pos + nums[pos], nums.length - 1);

        // omo
        // for (int nextPos = pos + 1; nextPos <= furthestJump; nextPos++) {
        for (int nextPos = furthestJump; nextPos > pos; nextPos--) {
            if (canJumpFromPosition_approach1(nextPos, nums)) {
                return true;
            }
        }
        return false;
    }
    
}
