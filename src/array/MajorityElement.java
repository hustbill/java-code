package array;

import java.util.Arrays;

public class MajorityElement {

	/*
	 * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
	 */

	public int majorityElement(int[] nums) {
		// https://discuss.leetcode.com/topic/28601/java-solutions-sorting-hashmap-moore-voting-bit-manipulation
		int majority = 0, count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				majority = nums[i];
			}
			if (majority != nums[i]) {
				count--;
			} else {
				count++;
			}
		}

		return majority;

	}

	public int majorityElement2(int[] nums) {
		// 1, 2, 2, 2, 1 -> 2
		Arrays.sort(nums);
		int mid = nums.length / 2;

		return nums[mid];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 2, 2, 1 };
		
		MajorityElement me = new MajorityElement();
		System.out.println(me.majorityElement(nums)); // 2
	}

}
