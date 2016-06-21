/*
 * 350. Intersection of Two Arrays II My Submissions QuestionEditorial Solution
Total Accepted: 14286 Total Submissions: 34522 Difficulty: Easy
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
package array;

import java.util.*;

public class IntersectionTwoArraysDuplicate {
	/*
	 * 要点在于三个follow up questions 
	 * 	//  总共有三种解法， 1. two hashsets O(n) 时间复杂度 2. two pointers O(nlogn) 3. binary search O(nlogn)
    // Use two hash sets, Time complexity: O(n),  Space complexity O(m) 
    // m is the size of small length in nums1 or nums2
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
        // https://leetcode.com/discuss/103969/solution-to-3rd-follow-up-question
        if( nums1 == null || nums2.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];
            
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int p1 = 0;  //pointer to nums1
        int p2 = 0;
        
        List<Integer> list = new ArrayList<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                list.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
            
        }
     
        
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            array[i] = list.get(i);
        
        return array;
    }
}
