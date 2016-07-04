/*
 * 170. Two Sum III - Data structure design My Submissions QuestionEditorial Solution
Total Accepted: 13104 Total Submissions: 55431 Difficulty: Easy
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Hide Company Tags LinkedIn
Hide Tags Hash Table Design
Show Similar Problems

 */
package ood;

import java.util.*;

public class TwoSumDesign{

	HashMap<Integer, Integer> map = new HashMap<>(); //记录数字和它出现的次数
	List<Integer> nums = new ArrayList<>();  // 记录添加的元素
	// https://discuss.leetcode.com/topic/32786/beats-100-java-code

	// Add the number to an internal data structure.
	public void add(int number) {
		if (map.containsKey(number)) {
			map.put(number, map.get(number) + 1);
		} else {
			map.put(number, 1);
			nums.add(number);
		}
	}

	// Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {

		for (int i = 0; i < nums.size(); i++) {
			int num1 = nums.get(i), num2 = value - num1;

			if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// Your TwoSum object will be instantiated and called as such:
		TwoSumDesign twoSum = new TwoSumDesign();

		twoSum.testcase1();
		twoSum.testcase2();
		twoSum.testcase3();

	}

	public void testcase1() {
		TwoSumDesign twoSum = new TwoSumDesign();
		for (int number : new int[] { 1, 3, 5, 8 }) {
			twoSum.add(number);
		}

		int value = 4;
		System.out.println(" find(" + value + ") = " + twoSum.find(value));

		value = 7;
		System.out.println(" find(" + value + ") = " + twoSum.find(value));
	}

	public void testcase2() {
		TwoSumDesign twoSum = new TwoSumDesign();
		int number = 0;
		twoSum.add(number);

		int value = 0;
		System.out.println(" find(" + value + ") = " + twoSum.find(value));
	}

	// [add(3),add(2),add(1),find(2),find(3),find(4),find(5),find(6)]

	public void testcase3() {
		TwoSumDesign twoSum = new TwoSumDesign();

		twoSum.add(3);
		twoSum.add(2);
		twoSum.add(1);

		int value = 2;
		System.out.println(" find(" + value + ") = " + twoSum.find(value)); // false

		value = 3;
		System.out.println(" find(" + value + ") = " + twoSum.find(value)); // true

		value = 4;
		System.out.println(" find(" + value + ") = " + twoSum.find(value)); // true

		value = 5;
		System.out.println(" find(" + value + ") = " + twoSum.find(value)); // true

		value = 6;
		System.out.println(" find(" + value + ") = " + twoSum.find(value)); // false
	}

}
