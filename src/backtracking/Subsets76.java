package backtracking;

import java.util.*;

public class Subsets76 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets76 subset = new Subsets76();
		int[] nums = { 1, 2, 3 };

		System.out.println(subset.subsets(nums));
	}

	public List<List<Integer>> subsets(int[] nums) {
		/*
		 * The idea is: 起始subset集为：[] 添加S0后为：[], [S0] 添加S1后为：[], [S0], [S1],
		 * [S0, S1] 添加S2后为：[], [S0], [S1], [S0, S1], [S2], [S0, S2], [S1, S2],
		 * [S0, S1, S2]
		 * 红色subset为每次新增的。显然规律为添加Si后，新增的subset为克隆现有的所有subset，并在它们后面都加上Si
		 */
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		result.add(tmp); // add empty set
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			int n = result.size();
			for (int j = 0; j < n; j++) {
				// NOTE : must create a new tmp object, and add templte into it
				tmp = new ArrayList<Integer>(result.get(j));
				tmp.add(nums[i]);
				result.add(new ArrayList<Integer>(tmp));
			}
		}
		return result;
	}

	public List<List<Integer>> subsets_my_failed(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int pos = 0;
		List<Integer> cur = new ArrayList<>();
		backtrack(nums, pos, cur, res);
		return res;
	}

	// backtracking
	private void backtrack(int[] nums, int pos, List<Integer> cur, List<List<Integer>> res) {
		if (pos == nums.length) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		System.out.println(pos);
		for (int i = pos; i < nums.length; i++) {

			cur.add(nums[i]);
			backtrack(nums, pos + 1, new ArrayList<Integer>(cur), res);
			// cur.remove(nums[i]);
			System.out.print(cur);
			cur.remove(cur.size());

		}

	}

}
