/*
 * 280. Wiggle Sort My Submissions QuestionEditorial Solution
Total Accepted: 12147 Total Submissions: 24005 Difficulty: Medium
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

Hide Company Tags Google
Hide Tags Array Sort
Hide Similar Problems (M) Sort Colors (M) Wiggle Sort II

 */
package array;

public class WiggleSort {
	

	    public void wiggleSort(int[] nums) {
	    // https://discuss.leetcode.com/topic/23871/java-o-n-solution
	      for (int i = 0; i < nums.length; i++) {
	          if (i % 2 == 1) {
	              if (nums[i - 1] > nums[i]) {
	                  swap(nums, i, i - 1);
	              }
	          } else if ( i != 0 && nums[i - 1] < nums[i]) {
	              swap(nums, i, i -1);
	          }
	      } 
	    }
	    
	    public void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WiggleSort ws = new WiggleSort();
		int[] nums = { 3, 5, 2, 1, 6, 4};
		ws.wiggleSort(nums);
		for (int num : nums) 
			System.out.print(num + " "); // 3 5 1 6 2 4 
		
	}

}
