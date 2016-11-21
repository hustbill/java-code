package array;

import java.util.Arrays;

public class MergeSortedArray {
	/* 
	Test case:
	[1, 4, 7, 0, 0, 0]
	3
	[2, 5]
	2
	result : [1, 2, 4, 5, 7, 0]
	*/

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// https://discuss.leetcode.com/topic/10257/3-line-java-solution
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i > -1 && j > -1) {
			nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
		}

		while (j > -1) {
			nums1[k--] = nums2[j--]; // this loop deal with  nums2 remains.
		}
	}

	public static void main(String[] args) {
		MergeSortedArray msa = new MergeSortedArray();
		int[] nums1 = { 1, 4, 5, 9, -1, -1, -1, -1 };
		int[] nums2 = { 2, 3, 7 };
		int m = 4, n = 3;
		msa.merge(nums1, m, nums2, n); // [1, 2, 3, 4, 5, 7, 9, -1]
		System.out.print(Arrays.toString(nums1));
	}
}
