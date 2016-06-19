/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Subscribe to see which companies asked this question

Hide Tags Array Backtracking
Hide Similar Problems (M) Combination Sum

 */
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		//https://leetcode.com/discuss/48350/java-solution-using-dfs-easy-understand
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();

		backtrack(candidates, target, 0, cur, res);
		return res;
	}

	 public void backtrack(int[] candid, int target, int pos, List<Integer> cur, List<List<Integer>> res) {
		 if (target < 0)  return;
		 if (target == 0) {
			 res.add(new ArrayList<Integer>(cur));
			 return;
		 }
		 
		 for (int i = pos; i < candid.length; i++) {
			 if (i > pos && candid[i] == candid[i - 1]) {
				 continue;
			 }
			 cur.add(cur.size(), candid[i]);
			 backtrack(candid, target - candid[i], i + 1, cur, res);
			 cur.remove(cur.size() - 1);
		 }
		 
	 }
	 
	public static void main(String[] args) {
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		
		int target = 8;
		CombinationSum2 cmbs = new CombinationSum2();
		List<List<Integer>> result = cmbs.combinationSum2(candidates, target);
		System.out.println(result);

	}
}
