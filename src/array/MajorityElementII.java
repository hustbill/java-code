/*
 * 229. Majority Element II  
Total Accepted: 31720
Total Submissions: 120717
Difficulty: Medium
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?
Do you have a better hint? Suggest it!
Hide Company Tags Zenefits
Hide Tags Array
Hide Similar Problems (E) Majority Element

 */
package array;

import java.util.*;

public class MajorityElementII {
	// https://discuss.leetcode.com/topic/29390/concise-java-solution-based-on-moore-s-voting-algorithm/5
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;

		int n = nums.length;
		int[] x = new int[2];
		int[] count = new int[2];

		x[0] = 0;
		x[1] = 1; // init the majority array

		for (int i = 0; i < nums.length; i++) {
			if (x[0] == nums[i]) {
				count[0]++;
			} else if (x[1] == nums[i]) {
				count[1]++;
			} else if (count[0] == 0) {
				x[0] = nums[i];
				count[0] = 1;
			} else if (count[1] == 0) {
				x[1] = nums[i];
				count[1] = 1;
			} else {
				count[0]--;
				count[1]--;
			}
		}

		Arrays.fill(count, 0);

		for (int num : nums) {// Count again for x1, x2
			if (num == x[0]) {
				count[0]++;
			} else if (num == x[1]) {
				count[1]++;
			}
		}

		for (int j = 0; j < 2; j++) {
			if (count[j] > nums.length / 3 && !res.contains(x[j]))
				res.add(x[j]);
		}
		return res;
	}

	public static void main(String[] args) {
		// int[] nums = {1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3,3 };
		int[] nums = { 1, 2 };
		MajorityElementII mj = new MajorityElementII();
		System.out.println(mj.majorityElement(nums));

	}

}
