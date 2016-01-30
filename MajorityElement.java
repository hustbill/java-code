/* 169. Majority Element
Total Accepted: 89785 Total Submissions: 227570 Difficulty: Easy
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Company Tags Zenefits
Hide Tags Divide and Conquer Array Bit Manipulation
Hide Similar Problems (M) Majority Element II
Have you met this question in a real interview? Yes  No*/


public class MajorityElement {
    public static int majorityElement(int[] nums) {
        // ref: https://leetcode.com/discuss/24971/o-n-time-o-1-space-fastest-solution
        int len = nums.length;
        int major = nums[0], count = 1;
           
        for (int i=1; i < len; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else count--;
        }
        return major;
    }
    
    public static void main(String[] args) {
        int[] nums = { 1, 3, 7, 3, 3, 3, 3};
        System.out.printf("major = %d", majorityElement(nums));
    }
}