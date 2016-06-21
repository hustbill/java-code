/*
 * 349. Intersection of Two Arrays

Total Accepted: 20966 Total Submissions: 47020 Difficulty: Easy
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
Hide Tags Binary Search Hash Table Two Pointers Sort
Hide Similar Problems (E) Intersection of Two Arrays II

 */
package array;

import java.util.*;

public class IntersectionTwoArrays {
	//  总共有三种解法， 1. two hashsets O(n) 时间复杂度 2. two pointers O(nlogn) 3. binary search O(nlogn)
    // Use two hash sets, Time complexity: O(n),  Space complexity O(m) 
    // m is the size of small length in nums1 or nums2
    // beat 56.57%
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0)
            return nums1;
        if (nums2 == null || nums2.length == 0)
            return nums2;
            
        Set<Integer> set = new HashSet<>();
        Set<Integer> interset = new HashSet<>();
        
        // the size of nums1 is very small, Space complexity O(m) is acceptable
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                interset.add(nums2[j]);
            } 
        }
        
         int[] result = new int[interset.size()];
        int k = 0;
        for (Integer num : interset) {  
            result[k++] = num;
        }
        return result;
    }
    
    // Sort both arrays, use two pointers  Time complexity: O(nlogn)
    public int[] intersectionTwoPointers(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0)
            return nums1;
        if (nums2 == null || nums2.length == 0)
            return nums2;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int p1 = 0; // pointer to nums1
        int p2 = 0;
        
        HashSet<Integer> set = new HashSet<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                set.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        
        int[] array = new int[set.size()];
        int k = 0;
        for (Integer num : set) {  // beat 56%
            array[k++] = num;
        }
        
        // Iterator<Integer> it = set.iterator();
        // int k = 0;
        // while ( it != null && it.hasNext()) {  // beat 32%
        //     array[k] = it.next();
        //     k++;
        // }
        return array;
    }
    
        public int[] intersectionBinarySearch(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0)
            return nums1;
        if (nums2 == null || nums2.length == 0)
            return nums2;
            
        Arrays.sort(nums2); // if nums2.length << nums1.length;
        Set<Integer> interset = new HashSet<>();
        
        for(int i = 0; i < nums1.length; i++) {
            if (binarySearch(nums2, nums1[i])) {
                interset.add(nums1[i]);
            }
        }
        
        int[] result = new int[interset.size()];
        int k = 0;
        for (Integer num : interset) {  
            result[k++] = num;
        }
        return result;
     }
     
     public boolean binarySearch(int[] nums, int target) {
         int start = 0; 
         int end = nums.length - 1;
         
         while ( start <= end) {
             int mid = start + (end - start) / 2;
             if (nums[mid] == target) {
                 return true;
             } else if (nums[mid] < target) {
                start = mid + 1;
             } else {
                 end = mid - 1;
             }
         }
         return false;
     }
    
}