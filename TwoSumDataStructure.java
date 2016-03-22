/*
Date: March 21, 2016
Question:
 Design and impelment a TwoSum class. It should support the following operations: add and find.
 	add(input) --  Add the number input to an internal data structure.
 	find(value) -- Find if there exists any pair of numbers which sum is equal to value.
 For example:
 	add(1); add(3); add(5);  find(4) -> true; find(7) -> false
*/

import java.util.*;

public class TwoSumDataStructure {
	// add  O(1) time,    find(value) O(n) time,  space O(n)
	public static void main(String args[]) {
		TwoSumDataStructure twoSum = new TwoSumDataStructure();
		twoSum.add(1); twoSum.add(3); twoSum.add(5);
		System.out.printf(" find(4) = %b\n", twoSum.find(4));
		System.out.printf(" find(7) = %b\n", twoSum.find(7));
	}
	
	private static HashMap<Integer, Integer> map = new HashMap<>();

	public static void add(int input) {
		int count = map.containsKey(input) ? map.get(input) : 0;
		map.put(input, count + 1);
	}


	public static boolean find(int val) {
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int num = entry.getKey();
			int y = val - num;
			if (y == num) {
				// For dumplicates, ensure there are at least  two individual numbers.
				if (entry.getValue() >= 2)  return true;
			} else if (map.containsKey(y)) {
				return true;
			}
		}
		return false;
	} 

}