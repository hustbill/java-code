package old;
/*
18. 4 Sum
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/
import java.util.*;

public class FourSum {
   
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // Clean accepted java O(n^3) solution based on 3sum
       // https://leetcode.com/discuss/32594/clean-accepted-java-o-n-3-solution-based-on-3sum
       // test case 1:  [0, 0, 0, 0]   0 
       // test case 2:  [-3,-2,-1,0,0,1,2,3] 0
       List<List<Integer>> lists = new ArrayList<List<Integer>>();
       if (nums == null || nums.length < 4) return lists;
       Arrays.sort(nums);

       for(int i=0; i < nums.length - 3; i++) {
           if (i > 0 && nums[i] == nums[i-1]) continue;
           for(int j= i+1; j < nums.length-2; j++) {
               if (j > i+1 && nums[j] == nums[j-1]) continue;
               int lo = j+1, hi = nums.length - 1;
               while(lo < hi) {
                   int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                   if (sum == target) {
                       lists.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi])));
                       while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                       while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                       lo++;
                       hi--;
                   }
                   else if (sum < target)  lo++;
                   else hi--;
               }
           }
       }
       return lists;
    }
    
    public static void main(String[] args) {
       int[] nums = { 1, 1, 3, 11, 7, 2, 2, 6};
       List<List<Integer>> ans = fourSum(nums, 13);
      //List<List<Integer>> ans = fourSum(null, 13);
        for( List<Integer> list : ans) {
            for (int i: list) {
                System.out.printf (" %d ", i);
            }
            System.out.println();
        }
    }
}