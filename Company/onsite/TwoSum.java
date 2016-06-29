package onsite;
/*
 * RealtyShares 
 */

import java.util.*;

public class TwoSum {
	public boolean isSum(int[] nums, int k)  {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(k - nums[i])) {
				map.put(k - nums[i], nums[i]);
			} else {
				System.out.printf("nums[%d] = %d", i, nums[i]);
			}
		}
		System.out.println(map);
		
		Set<Integer> set = map.keySet();
		System.out.println(set);
		
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				System.out.printf("nums[%d] = %d\n", i, nums[i]);
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 5, 7};
		int k = 7;
		TwoSum tw = new TwoSum();
		System.out.println(tw.isSum(nums, k));
		
	}
}
