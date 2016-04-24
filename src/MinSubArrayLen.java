/*209. Minimum Size Subarray Sum
https://leetcode.com/problems/minimum-size-subarray-sum/

Total Accepted: 28224 Total Submissions: 110067 Difficulty: Medium
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).*/

public class MinSubArrayLen {
    public static int minSubArrayLen(int s, int[] nums) {
        return solveN(s, nums);
    }
    
    public static int solveN(int s, int[] nums) {
          // Ref: https://leetcode.com/discuss/45449/accepted-clean-java-o-n-solution-two-pointers
          // Two pointers
          // Ref 2: https://leetcode.com/discuss/35378/solutions-java-with-time-complexity-nlogn-with-explanation
          // i don't understand this solution.
          int start = 0, end = 0, sum =0, minLen = Integer.MAX_VALUE;
          if (nums == null || nums.length == 0) return 0;
        
          while (end < nums.length) {
              sum += nums[end++];
            
              while(sum >= s) {
                  minLen = Math.min(minLen, end - start);
                  sum -= nums[start++];
              }
          }
          return minLen == Integer.MAX_VALUE ? 0 : minLen;
      }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        int len = minSubArrayLen(s, nums);
        System.out.printf("len = %d", len);
    }
}