/*
 * 324. Wiggle Sort II My Submissions QuestionEditorial Solution
Total Accepted: 12578 Total Submissions: 54249 Difficulty: Medium
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Sort
Hide Similar Problems (M) Sort Colors (M) Kth Largest Element in an Array (M) Wiggle Sort

 */
package array;

public class WiggleSortII {

	public void wiggleSort(int[] nums) {
		// https://discuss.leetcode.com/topic/23871/java-o-n-solution
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 1) {
				if (nums[i - 1] > nums[i]) {
					swap(nums, i, i - 1);
				}
			} else if (i != 0 && nums[i - 1] < nums[i]) {
				swap(nums, i, i - 1);
			}
		}
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WiggleSort ws = new WiggleSort();
		//int[] nums = { 1, 5, 1, 1, 6, 4};
		int[] nums = {1, 3, 2, 2, 3, 1};
		ws.wiggleSort(nums);
		for (int num : nums)
			System.out.print(num + " ");  // 1 5 1 6 1 4 

	}

}
