package tree;
/*
259. 3Sum Smaller

https://leetcode.com/problems/3sum-smaller/
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?

Hide Company Tags Google
Hide Tags Array Two Pointers
Hide Similar Problems (M) 3Sum (M) 3Sum Closest
*/
import java.util.*;

public class ThreeSumSmaller {
    public static int threeSumSmaller(int[] nums, int target) {
        /* https://leetcode.com/discuss/56164/simple-and-easy-understanding-o-n-2-java-solution */
        int count = 0;
        Arrays.sort(nums);
            
        for(int i = 0; i < nums.length - 2; i++) {
            int lo = i+1, hi = nums.length - 1;
            
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum < target) {
                    count += hi - lo; 
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        
        int sum = threeSumSmaller(nums, target);
        
        System.out.printf("sum = %d", sum);
        
        int[] nums2 = {0,2,1,-3};
        
        System.out.printf("\nsum2 = %d",  threeSumSmaller(nums2, target));
    }
}