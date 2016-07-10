/*
 * 260. Single Number III 
Total Accepted: 39779
Total Submissions: 87540
Difficulty: Medium
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Tags Bit Manipulation
Hide Similar Problems (M) Single Number (M) Single Number II

 */
package bit;

import java.util.Arrays;

public class SingleNumberIII {
	/*
	 * we need to use XOR to solve this problem. But this time, we need to do it
	 * in two passes:
	 * 
	 * In the first pass, we XOR all elements in the array, and get the XOR of
	 * the two numbers we need to find. Note that since the two numbers are
	 * distinct, so there must be a set bit (that is, the bit with value '1') in
	 * the XOR result. Find out an arbitrary set bit (for example, the rightmost
	 * set bit).
	 * 
	 * In the second pass, we divide all numbers into two groups, one with the
	 * aforementioned bit set, another with the aforementinoed bit unset. Two
	 * different numbers we need to find must fall into the two distrinct
	 * groups. XOR numbers in each group, we can find a number in either group.
	 * 
	 * Complexity:
	 * 
	 * Time: O (n)
	 * 
	 * Space: O (1)
	 * 
	 * A Corner Case:
	 * 
	 * When diff == numeric_limits<int>::min(), -diff is also
	 * numeric_limits<int>::min(). Therefore, the value of diff after executing
	 * diff &= -diff is still numeric_limits<int>::min(). The answer is still
	 * correct.
	 * https://discuss.leetcode.com/topic/21605/accepted-c-java-o-n-time-o-1-space-easy-solution-with-detail-explanations
	 */
	public int[] singleNumber(int[] nums) {
		// Pass 1 :
		// Get the XOR of the two numbers we need to find
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		System.out.println(diff);  // ( diff = 8 ^ 4 = 12,  1100)
		// Get its last set bit
		diff &= -diff;     // -diff  是diff的二补数    0011 + 1 = 0100 = 4;   12 &=4  -> 4
		// https://en.wikipedia.org/wiki/Two%27s_complement
		System.out.println(diff);

		// Pass 2 :
		int[] rets = { 0, 0 }; // this array stores the two numbers we will
								// return
		for (int num : nums) {
			if ((num & diff) == 0) // the bit is not set
			{
				rets[0] ^= num;
			} else // the bit is set
			{
				rets[1] ^= num;
			}
		}
		return rets;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 7, 3, 7, 3, 4, 6, 8, 6 };
		SingleNumberIII sn = new SingleNumberIII();
		System.out.println(Arrays.toString(sn.singleNumber(nums)));

	}

}
