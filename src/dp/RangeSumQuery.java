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
	private int[] sums;
	// private int[] array;

	public RangeSumQuery(int[] nums) {
		// array = Arrays.copyOf(nums, nums.length); // 不需要了
		for (int i = 1; i < nums.length; i++) {
			 nums[i]  += nums[i - 1];
			// System.out.printf("nums[%d] = %d \n", i, nums[i]);
		}
		sums = nums;
	}

	public int sumRange(int i, int j) {
		if (i == 0) {
			return sums[j];
		}
		return sums[j] - sums[i - 1];
		
		// return dp[j] - dp[i] + array[i];  ==>  dp[j] - dp[i - 1]  避免了增加array数组
	}

	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		
		RangeSumQuery rsq = new RangeSumQuery(nums);

		System.out.println(rsq.sumRange(0, 2) == 1);
		System.out.println(rsq.sumRange(0, 2));

		System.out.println(rsq.sumRange(2, 5) == -1);
		System.out.println(rsq.sumRange(2, 5));

		System.out.println(rsq.sumRange(0, 5) == -3);
		System.out.println(rsq.sumRange(0, 5));
	}

}
