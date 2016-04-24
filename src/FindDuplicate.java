/*
287. Find the Duplicate Number
https://leetcode.com/problems/find-the-duplicate-number/
hua.zhang20150913 
Difficulty: Hard

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 prove that at least one duplicate number must exist. 
Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Bloomberg Hedvig
Hide Tags Array Two Pointers Binary Search
Hide Similar Problems (H) First Missing Positive (M) Single Number (M) Linked List Cycle II (M) Missing Number*/

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        // Ref: https://leetcode.com/discuss/60830/solutions-explanation-space-without-changing-input-array
        int n = nums.length - 1;
        int left = 0, right = n;
        while(left < right) {
            int mid = left + (right- left)/2;
            int count = numBelow(nums, mid);
            if(count > mid)  right = mid;
            else left = mid + 1;
        }
        return left;
    }
 
    public static int numBelow(int[] nums, int target) {
        int result = 0;
        for(int i=0; i < nums.length; i++)
            if(nums[i] <= target) result++;
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums= {1, 2, 2, 4,5, 6};
        System.out.printf("duplicate one is %d", findDuplicate(nums));  
    }
}