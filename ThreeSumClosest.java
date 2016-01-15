/*
16. 3Sum Closest

https://leetcode.com/problems/3sum-closest/
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Hide Company Tags Bloomberg
Hide Tags Array Two Pointers
Hide Similar Problems (M) 3Sum (M) 3Sum Smaller


*/
import java.util.*;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        /* https://leetcode.com/discuss/16335/java-solution-with-o-n2-for-reference
            Similar to 3 Sum problem, use 3 pointers to point current element, next element
             and the last element. 
            If the sum is less than target, it means we have to add a larger element
             so next element move to the next. 
            If the sum is greater, it means we have to add a smaller element 
            so last element move to the second last element. Keep doing this until the end.
             Each time compare the difference between sum and target, 
            if it is less than minimum difference so far, then replace result with it, 
            otherwise keep iterating.
            
            */
        int result = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);
            
        for(int i = 0; i < nums.length - 2; i++) {
            int lo = i+1, hi = nums.length - 1;
            int sum = nums[i] + nums[lo] + nums[hi];
            
            while (lo < hi) {
                if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
            }
        }
        
        return result;
        
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        
        int sum = threeSumClosest(nums, target);
        
        System.out.printf("sum = %d", sum);
    }
}