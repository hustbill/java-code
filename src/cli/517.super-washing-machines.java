/*
 * @lc app=leetcode id=517 lang=java
 *
 * [517] Super Washing Machines
 *
 * https://leetcode.com/problems/super-washing-machines/description/
 *
 * algorithms
 * Hard (36.95%)
 * Total Accepted:    13.3K
 * Total Submissions: 35.9K
 * Testcase Example:  '[1,0,5]'
 *
 * You have n super washing machines on a line. Initially, each washing machine
 * has some dresses or is empty. 
 * 
 * 
 * For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass
 * one dress of each washing machine to one of its adjacent washing machines
 * at the same time .  
 * 
 * Given an integer array representing the number of dresses in each washing
 * machine from left to right on the line, you should find the minimum number
 * of moves to make all the washing machines have the same number of dresses.
 * If it is not possible to do it, return -1.
 * 
 * Example1
 * 
 * Input: [1,0,5]
 * 
 * Output: 3
 * 
 * Explanation: 
 * 1st move:    1     0     1     1     4
 * 2nd move:    1     2     1     3    
 * 3rd move:    2     1     2     2     2   
 * 
 * 
 * Example2
 * 
 * Input: [0,3,0]
 * 
 * Output: 2
 * 
 * Explanation: 
 * 1st move:    0     1     2     0    
 * 2nd move:    1     2 --> 0    =>    1     1     1     
 * 
 * 
 * Example3
 * 
 * Input: [0,2,0]
 * 
 * Output: -1
 * 
 * Explanation: 
 * It's impossible to make all the three washing machines have the same number
 * of dresses. 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The range of n is [1, 10000].
 * The range of dresses number in a super washing machine is [0, 1e5].
 * 
 * 
 */
class Solution {
   // https://leetcode.com/articles/super-washing-machines/ 
    public int findMinMoves(int[] machines) {
        // Greedy
        // Time complexity: O(N), Space complexity: O(1)
        int n = machines.length, dressTotal = 0;
        for (int m : machines) dressTotal += m;

        if (dressTotal % n != 0) return -1;

        int dressPremachine = dressTotal / n;
        // Change the number of dresses in the machines to 
        // the number of dresses to be removed from this machine
        // (cloud be negative)
        int curssSum = 0, maxSum = 0, tmpRes = 0, res = 0;
        for (int m : machines) {
            currSum += m;
            maxSum = Math.max(maxSum, Math.abs(currSum));
            tmpRes = Math.max(maxSum, m);
            res = Math.max(res, tmpRes);
        }
        return res; // 没看懂
    }
}
