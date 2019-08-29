/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (33.10%)
 * Total Accepted:    466.1K
 * Total Submissions: 1.4M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */
class Solution {
    /* binary search, Time complexity: O(log(N)), Space: O(1)*/
    public int search(int[] nums, int target) {
      if (nums.length == 0) return -1;
      if (nums.length == 1) return target == nums[0] ? 0 : -1;
      
      int index = 0; // rotate index
      if (nums[index] == target) return index; // not rotated

      int j = 1;
      while (j < nums.length - 1 && nums[0] < nums[j]) {
        j++;
      } 
      index = j;
      System.out.println("index= " + index);
      // if target is the smallest element
      if (nums[index] == target) return index;
      
      int lo = 0;
      int hi = index -1;
      if (nums[hi] ==  target) {
           return hi;
      } else if (nums[hi] < target) {
          return -1;
      } 
          

      if (nums[lo] > target || nums[hi] > target) {
         lo = index + 1; // search in the right side
         hi = nums.length - 1;
      }
      return binarySearch(nums, lo, hi, target);
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
      while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
         System.out.printf("lo=%d,mid=%d,hi=%d\n", lo, mid, hi);
         if (nums[mid] == target) return mid;
         else {
            if (target > nums[mid] ) {
                 lo = mid + 1;
                System.out.println("lo = " + lo);
            } else {
                hi = mid - 1;
                System.out.println("hi = " + hi);
            }
         }
      }
      return -1;
   }
}
