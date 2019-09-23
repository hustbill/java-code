package lc;

import java.util.*;


public final class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation pm = new Permutation();
		int[] nums = {1, 1, 2};
		List<List<Integer>> ret = pm.permuteUnique(nums);
		System.out.print(ret);

	}
	
	 // backtracking
    // traversal each num, add the permutation to the ArrayList
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0)  return ret;

       List<Integer> curr = new ArrayList<>();
       boolean[] used = new boolean[nums.length];

       Arrays.sort(nums);  // if it includes duplicates, sort it at first
       helper(nums, used, curr, ret);

       return ret;
    }

    private void helper(int[] nums, boolean[] used,  List<Integer> curr, List<List<Integer>> ret) {
        if (curr.size() == nums.length) {
            ret.add(new ArrayList<Integer>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
           if (used[i]) continue;
           if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
           used[i] = true;
           curr.add(nums[i]);
           helper(nums, used, curr, ret);
           used[i] = false;
           curr.remove(curr.size() - 1);
        }
    }

}
