/*
 * 39. Combination Sum 
Total Accepted: 96383 Total Submissions: 304904 Difficulty: Medium
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
Subscribe to see which companies asked this question

Hide Tags Array Backtracking
Hide Similar Problems (M) Letter Combinations of a Phone Number (M) Combination Sum II (M) Combinations (M) Combination Sum III (M) Factor Combinations

 思路： Loop + recursive 
    	＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝>  Loop
     	[2]      3    6    [7]
      /
     [2]
    /
   [3]    
   * 
   * 
 *
 */
package backtracking;

import java.util.*;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();

		backtrack(candidates, target, 0, cur, res);
		return res;
	}

	public void backtrack(int[] candid, int target, int pos, List<Integer> cur, List<List<Integer>> res) {
		if (target < 0) return;
		
		if (target == 0) {
			res.add(new ArrayList<Integer>(cur)); // 一定要 new ArrayList<Integer>
													// 不能直接加 cur
		} 
		
		for (int i = pos; i < candid.length ; i++) {
			if(candid[i] > target) continue;
				cur.add(candid[i]);
				backtrack(candid, target - candid[i], i, cur, res);
				cur.remove(cur.size() - 1); // 记得回到上一层
			}
	

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] candidates = { 2, 3, 6, 7 };
		int[] candidates = { 8, 7, 4, 3 };
		// int target = 7;
		int target = 11;
		CombinationSum cmbs = new CombinationSum();
		List<List<Integer>> result = cmbs.combinationSum(candidates, target);
		System.out.println(result);

	}

}
