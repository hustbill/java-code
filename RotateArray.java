/*

Roatate Array

https://leetcode.com/problems/rotate-array/

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.
*/

import java.util.*;
public class RotateArray {
	
	// solution2: 
    public static void rotate(int[] nums, int k) {
		HashMap<Integer, Integer> map  = new HashMap<Integer, Integer>();
	
		int len = nums.length;
		if( len > k) {
			for(int i= len-k; i< len; i++) {
				map.put(i - (len-k), nums[i]);
			}
        	for (int i =0; i< len -k ; i++) {
        		map.put( i + k , nums[i]);
        	}
	
			for(int j =0; j< map.size();j++)
				nums[j]= map.get(j);
		}
		if (len < k) {
			k = k%len;
			rotate(nums, k);
		}
    }
	
	// solution 1: 
    public static void rotate1(int[] nums, int k) {
	
	    int len = nums.length;
			int[] temp = new int[len];
			if (len > k) {
				// Refer :  http://stackoverflow.com/questions/26610309/java-rotating-array
				System.arraycopy(nums, 0, temp, k, len-k);
				System.arraycopy(nums, len-k, temp, 0, k);
			
				System.arraycopy(temp, 0, nums, 0, len); // nums[i] = temp[i], i= 0... len

			}
		
			if( len <k) {  // this part is wroten by myself -hua
				k = k%len;
				System.out.println("k=" + k);
				rotate(nums, k);
			}
			
	
		
    }
	
	public static void main(String[] args) {
		//int[]  nums = { 1, 2, 3, 4, 5, 6 ,7};
		int[]  nums = { 1, 2};
		// int[] nums ={-1};
		int k =3;
		rotate(nums, k);
		for(int i=0; i< nums.length; i++)
		System.out.print(nums[i] + " ");
		System.out.println();
		
	}
}