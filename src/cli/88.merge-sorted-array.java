/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (36.58%)
 * Total Accepted:    406.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to
 * m + n) to hold additional elements from nums2.
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;
        // while there are still elements to compare
        while (p1 >= 0 && p2 >=0 ) {
            // compare two elements from nums1 and nums2 
            // and add the largest one in nums1 
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }
        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2  + 1);
    }
      

    public void merge_nok(int[] nums1, int m, int[] nums2, int n) {
       int i = 0, j = 0;
       while (i < m + n && j < n) {
           if (i < m + n && nums1[i] < nums2[j]) {
               i++;
               if (nums1[i] == 0) {
                   nums1[i] = nums2[j];
                   j++;
               }

           } else if (i < m + n && nums1[i] == nums2[j]) {
               int temp = nums1[i + 1];
               nums1[i + 1]  = nums2[j];
               nums1[i + 2] = temp;
               i = i+2;
               j++;
               System.out.printf("i=%d,j=%d,nums1[%d]=%d, nums2[%d]=%d\n", i,j,i,nums1[i], j,nums2[j]);
          } else {
              int temp = nums1[i];
              nums1[i] = nums2[j];
              nums1[i + 1] = temp;
              i = i + 1;
              j++;
        }
       }
    }
}
