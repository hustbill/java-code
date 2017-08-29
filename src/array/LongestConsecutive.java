/*
 * 128. Longest Consecutive Sequence  QuestionEditorial Solution  My Submissions
Total Accepted: 69624
Total Submissions: 211039
Difficulty: Hard
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

Hide Company Tags Google Facebook
Hide Tags Array Union Find
Hide Similar Problems (M) Binary Tree Longest Consecutive Sequence

 */
package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

	public int longestConsecutive(int[] nums) {
		/*
		 * Using a set to collect all elements that hasn't been visited. search
		 * element will be O(1) and eliminates visiting element again.
		 * https://discuss.leetcode.com/topic/25493/simple-fast-java-solution-
		 * using-set
		 */
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;

		for (int i : nums) {
			set.add(i);
		}
		for (int num : nums) {
			if (set.remove(num)) {

				int val = num;
				int sum = 1;
				while (set.remove(val - 1)) {
					val--;
				}
				sum += num - val;

				val = num;
				while (set.remove(val + 1)) {
					val++;
				}
				sum += val - num;
				max = Math.max(max, sum);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestConsecutive lc = new LongestConsecutive();
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		System.out.println(lc.longestConsecutive(nums)); // 4

	}

}
