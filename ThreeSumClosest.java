/*
3Sum Closest 

Total Accepted: 39555 Total Submissions: 147087 My Submissions Question Solution 
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Show Tags
*/
import java.util.*;

public class ThreeSumClosest {
	
	// This solution will be timeout  O(n^2)
    public static int threeSumClosest(int[] nums, int target) {
       	if( nums == null ) return 0;
		// find all sum of any three items , and then get the gap between target, 
		Arrays.sort(nums);
		
		int result = nums[0] + nums[1] + nums[2] - target;
		int len = nums.length;
		int diffMin = 0;
		for(int i=0; i< len-2; i++) {
			int l = i+1;
			int r = len -1;
			while( l < r){
				int sum = nums[i]+ nums[l] + nums[r];
				int diff = sum - target;
				if (diff == 0 ) return target;
				if( Math.abs(diff) <  Math.abs(result)) {
					result = diff;
				}
				if( diff < 0 ) {
					l++;   // l pointer move right
				} else {
					r--;  //  r pointer move left
				}
			}
		}
		return result + target;
		// Ref 1: 解答：
		/*与3Sum类似，但是更简单。因为我们不必跳过重复的元素，因为不需要输出嘛。
			然后同样也是三个指针来移动，复杂度跟前一题是一样. 
			注意的点：
		1. 当三个值等于target时，直接退出，不需要再算了。
		2. 考虑正负的问题，算差值时，取一个ABS(绝对值），这样比较容易控制差距。
		 */
		//http://blog.sina.com.cn/s/blog_eb52001d0102v2de.html
		// 提供的解法在oj 中超时，需要添加 Arrays.sort(nums);
		
		// Ref 2:  simple solution in comments 
		//  http://gongxuns.blogspot.com/2012/12/leetcode3sum-closest.html  
    }
	
	public static void main(String[] agrs){
		// test case 1 
		// int[] array = { -1, 2, 1, -4};
// 		int target = 1;
		int[] array = { 1, 1, 1, 0};
		int target = 100;
		int result = threeSumClosest(array, target);
		
		System.out.println("result="+ result);
	}
}