/*
 * 
303. Range Sum Query - Immutable
Total Accepted: 34053 Total Submissions: 135853 Difficulty: Easy
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
Hide Company Tags Palantir
Hide Tags Dynamic Programming
Show Similar Problems

 */
package dp;

import java.util.Arrays;

public class RangeSumQuery {
	private int[] dp;
	private int[] array;

	public RangeSumQuery(int[] nums) {

		array = new int[nums.length];
		array = Arrays.copyOf(nums, nums.length);

		if (nums == null || nums.length == 0) {
			return;
		}
		dp = new int[nums.length];
		dp[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			dp[i] = dp[i - 1] + nums[i];
			// System.out.printf("dp[%d] = %d \n", i, dp[i]);
		}

	}

	public int sumRange(int i, int j) {
		if (i >= array.length || j >= array.length) return -1;
		return dp[j] - dp[i] + array[i];
	}

	public static void main(String[] args) {
		// int[] nums = {-2, 0, 3, -5, 2, -1};
		int[] nums = {};
		RangeSumQuery rsq = new RangeSumQuery(nums);

		System.out.println(rsq.sumRange(0, 2) == 1);
		System.out.println(rsq.sumRange(0, 2));

		System.out.println(rsq.sumRange(2, 5) == -1);
		System.out.println(rsq.sumRange(2, 5));

		System.out.println(rsq.sumRange(0, 5) == -3);
		System.out.println(rsq.sumRange(0, 5));
	}

}
