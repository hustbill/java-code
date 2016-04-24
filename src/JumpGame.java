/*55. Jump Game
Total Accepted: 68926 Total Submissions: 247941 Difficulty: Medium
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Hide Company Tags Microsoft
Hide Tags Array Greedy
*/

public class JumpGame {
    
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.printf("%s\n", canJump(nums) == true ? "Test case 1 success" : "Test case 1 failed");
        System.out.printf("%s", canJump(nums2) == false ? "Test case 2 success" : "Test case 2 failed");
    }
    
    public static boolean canJump(int[] nums) {
           // refer : https://leetcode.com/discuss/22560/java-solution-easy-to-understand
           int max = 0;
           for (int i=0 ; i < nums.length; i++) {
               if (i > max) { return false; }
               max = Math.max(i + nums[i], max);
           }
           return true;
       }
  
       public boolean canJump_sol2(int[] nums) {
           // work backwards from last index, keep track of the smallest index that can "jump"
           // to the last index. Check whether the current index can jump to this smallest index.
           // https://leetcode.com/discuss/11422/simplest-o-n-solution-with-constant-space
           int n = nums.length, last = n - 1;
           for (int i= n-2; i >= 0; i--) {
               if (i + nums[i] > last) last = i;
           }
           return last <=0;
       }

  
    
       public boolean canJump_failed_mine(int[] nums) {
           // test cases: [0], [2,3,1,1,4], 
           int p = nums[0], n = nums.length;
           for (int i=1; i < n; i++) {
               if ((p-1) <= nums[i]) {
                   p = nums[i];
               } else {
                   p--;
               }
           }
        
           return p >0;
       }
}