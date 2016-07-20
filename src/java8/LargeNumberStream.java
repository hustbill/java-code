/*
 * 179. Largest Number  QuestionEditorial Solution  My Submissions
Total Accepted: 50334
Total Submissions: 253493
Difficulty: Medium
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Tags Sort

 */
package java8;

import java.util.*;

public class LargeNumberStream {
	
    // https://discuss.leetcode.com/topic/7235/my-3-lines-code-in-java-and-python
    public String largestNumber(int[] num) {  // Thanks for Java 8, it makes code beautiful.
        String[] array = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
        // https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
        Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }

	public static void main(String[] args) {
		int[] nums = { 4, 5, 1, 9, 8, 0};
		LargeNumberStream lns = new LargeNumberStream();
		String largestNumber = lns.largestNumber(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(largestNumber);

	}

}
