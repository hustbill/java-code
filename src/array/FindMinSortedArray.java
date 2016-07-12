/*
 * 153. Find Minimum in Rotated Sorted Array 
Total Accepted: 100021
Total Submissions: 270435
Difficulty: Medium
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

Hide Company Tags Microsoft
Hide Tags Array Binary Search
Hide Similar Problems (H) Search in Rotated Sorted Array (H) Find Minimum in Rotated Sorted Array II

 */
package array;

public class FindMinSortedArray {
	public int findMin(int[] nums) {
        /*
        https://discuss.leetcode.com/topic/5170/java-solution-with-binary-search
        The minimum element must satisfy one of two conditions: 1) If rotate, A[min] < A[min - 1]; 2) If not, A[0]. Therefore, we can use binary search: check the middle element, if it is less than previous one, then it is minimum. If not, there are 2 conditions as well: If it is greater than both left and right element, then minimum element should be on its right, otherwise on its left.
        */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1)  return nums[0];
        
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[left] <= nums[mid]  && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		FindMinSortedArray fm = new FindMinSortedArray();
		System.out.println(fm.findMin(nums));

	}

}
