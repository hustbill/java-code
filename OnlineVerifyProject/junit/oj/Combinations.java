package oj;

import java.util.*;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations cmb = new Combinations();
		int n = 4, k = 2;
		List<List<Integer>> ret = cmb.combine(n, k);
		
		System.out.println(ret);
		
	}
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		
		
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int len = nums.length;
		if (nums == null || len < 4)
			return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			// first candidate too large, search finished
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
				break;
			if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target)
				continue; // first candidate too small
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			// prevents duplicate result in ans list
			for (int j = i + 1; j < nums.length - 2; j++) {
				// second candidate too large
				if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
					break;
				// second candidate too small
				if (nums[j] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target)
					continue;
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				// prevents duplicate results in ans list;
				int lo = j + 1, hi = nums.length - 1;
				while (lo < hi) {
					int val = nums[lo] + nums[hi];
					if (nums[i] + nums[j] + val == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
						// skipping over duplicate on low
						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						// skipping over duplicate on high
						while (lo < hi && nums[hi] == nums[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (nums[i] + nums[j] + val > target) {
						hi--;
					} else {
						lo++;
					}
				}
			}
		}
		return res;
	}

}
