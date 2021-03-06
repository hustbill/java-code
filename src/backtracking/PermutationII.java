/*
 * 47. Permutations II
 * Difficulty: Medium
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
Hide Company Tags LinkedIn Microsoft
Hide Tags Backtracking
Hide Similar Problems (M) Next Permutation (M) Permutations (M) Palindrome Permutation II

 */
package backtracking;

import java.util.*;

public class PermutationII {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		PermutationII pt = new PermutationII();
		List<List<Integer>> result = pt.permuteUnique(nums);

		System.out.println(result); // [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		// return permuteUniqueBacktrack(nums);
		// return permuteUniqueIterative(nums);
		return permuteUniqueSol2(nums);
	}

	public List<List<Integer>> permuteUniqueIterative(int[] nums) {
		/*
		 * Here's an iterative solution which doesn't use nextPermutation
		 * helper. It builds the permutations for i-1 first elements of an input
		 * array and tries to insert the ith element into all positions of each
		 * prebuilt i-1 permutation. I couldn't come up with more effective
		 * controling of uniqueness than just using a Set.
		 */
		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		res.add(new ArrayList<Integer>());

		for (int i = 0; i < nums.length; i++) {
			Set<String> cache = new HashSet<>();
			while (res.peekFirst().size() == i) {
				List<Integer> l = res.removeFirst();
				for (int j = 0; j <= l.size(); j++) {
					List<Integer> newL = new ArrayList<>(l);
					newL.add(j, nums[i]);
					if (cache.add(newL.toString())) {
						res.add(newL);
					}
				}
			}
		}

		return res;
	}

	/*
	 * Sol2 : recursive without extra set or array to escape duplicate
	 * 当操作是在一列数据的后面添加数据而不是在前面或中间,并且需要随机地访问其中的元素时,使用ArrayList会提供比较好的性能；
	 * 当你的操作是在一列数据的前面或中间添加或删除数据,并且按照顺序访问其中的元素时,就应该使用LinkedList了。
	 */
	public List<List<Integer>> permuteUniqueSol2(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		LinkedList<Integer> numList = new LinkedList<>();
		for (int num : nums)
			numList.add(num);

		permute(numList, 0, res);
		return res;
	}

	private void permute(LinkedList<Integer> numList, int start, List<List<Integer>> res) {
		if (start == numList.size() - 1) {
			res.add(new LinkedList<Integer>(numList));
			return;
		}
		for (int i = start; i < numList.size(); i++) {
			if (i > start && numList.get(i) == numList.get(i - 1))
				continue;
			numList.add(start, numList.get(i));
			numList.remove(i + 1);
			permute(numList, start + 1, res);
			numList.add(i + 1, numList.get(start));
			numList.remove(start);
		}
	}

	public List<List<Integer>> permuteUniqueBacktrack(int[] nums) {
		/*
		 * " boolean[] used" to indicate whether the value is added to list.
		 * Sort the array "int[] nums" to make sure we can skip the same value.
		 * when a number has the same value with its previous, we can use this
		 * number only if his previous is NOT used (原注释是 used 有疑问！！) *
		 * https://leetcode.com/discuss/73856/really-easy-solution-easier-than-
		 * solutions-with-very-high-vote Use an extra boolean array
		 */

		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return res;
		}

		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums); //
		backtrack(nums, visited, cur, res);
		return res;
	}

	public void backtrack(int[] nums, boolean[] visited, List<Integer> cur, List<List<Integer>> res) {
		if (cur.size() == nums.length) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
					return;
				}
				cur.add(nums[i]);
				visited[i] = true;
				backtrack(nums, visited, cur, res);
				visited[i] = false;
				cur.remove(cur.size() - 1);
			}

		}
	}

}
