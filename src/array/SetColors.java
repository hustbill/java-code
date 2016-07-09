/*
 * 75. Sort Colors  QuestionEditorial Solution  My Submissions
Total Accepted: 105565
Total Submissions: 299612
Difficulty: Medium
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Hide Company Tags Pocket Gems Microsoft Facebook
Hide Tags Array Two Pointers Sort
Show Similar Problems

 */
package array;

public class SetColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public void sortColorsMine(int[] nums) {
	        if(nums == null || nums.length == 0) return;
	        
	        int n = nums.length;
	        int left = 0, right = 1;
	         
	         for (int i = 0; i < n -1 ; i++) {
	            if (nums[i + 1] < nums[i])
	                swap(nums, i, i + 1);
	        }
	        while (left < n && right < n ) {
	            if (nums[left] == nums[right]) {
	                left++;
	                right++;
	            }
	            
	            while (right < n && nums[left] != nums[right] ) {
	                right++;
	            }  
	            if ( left + 1 < n && right < n) {
	        
	                swap(nums, left + 1, right);
	                left = left + 2;
	                right = left + 1;
	            }
	        }
	      
	        
	    }
	    
	    public void swap(int[] nums, int left, int right) {
	        int temp = nums[right];
	        nums[right] = nums[left];
	        nums[left] = temp;
	    }

}
