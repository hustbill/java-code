package divideConquer;

/*
 * 169. Majority Element
	Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 */
public class MajorityElement {

	/*
	 * A Linear Time Majority Vote Algorithm
	 * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
	 * https://discuss.leetcode.com/topic/28601/java-solutions-sorting-hashmap-
	 * moore-voting-bit-manipulation
	 */
	public int majorityElement(int[] nums) {
		int majority = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				majority = nums[i];
			}
			if (majority != nums[i]) {
				count--;
			} else {
				count++;
			}
		}
		return majority;
	}

	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		int[] nums = { 1, 2,2,2,2,1};
		System.out.println(me.majorityElement(nums));

	}

}
