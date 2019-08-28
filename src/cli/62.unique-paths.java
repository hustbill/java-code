/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 *
 * https://leetcode.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (48.78%)
 * Total Accepted:    321.9K
 * Total Submissions: 659K
 * Testcase Example:  '3\n2'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * 
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the
 * bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: m = 7, n = 3
 * Output: 28
 * 
 */
class Solution {
    public int uniquePaths(int m, int n) {
       // dp solution
       /*
        * The assumptions are
            (1) When (n==0||m==0) the function always returns 1 since the robot can't go left or up.
            (2)  For all other cells. The result = uniquePaths(m-1,n)+uniquePaths(m,n-1)
        Therefore I populated the edges with 1 first and use DP to get the full 2-D array.
      */

      int[][] map = new int[m][n];

       for (int i = 0; i < m; i++) {
           map[i][0] = 1;
       }
       for (int j = 0; j < n; j++) {
           map[0][j] = 1;
       }
       for (int i = 1; i < m; i++) {
           for (int j = 1; j < n; j++) {
               map[i][j] = map[i - 1][j] + map[i][j - 1];
           }
       }
       return map[m-1][n-1];
    }
}
