/*
238. Product of Array Except Self 
2016.01.24

Total Accepted: 31395 Total Selfubmissions: 77007 Difficulty: Medium
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

Hide Company Tags LinkedIn Facebook
Hide Tags Array
Hide Similar Problems (H) Trapping Rain Water (M) Maximum Product Subarray (H) Paint House II

*/
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2 , 3, 4 , 5};
        int[] res = productExceptSelf(nums);
        for (int i : res) 
            System.out.printf(" %d ", i);
    }
    
    public static int[] productExceptSelf(int[] nums) {
        /*  https://leetcode.com/discuss/46104/simple-java-solution-in-o-n-without-extra-space
            https://leetcode.com/discuss/53781/my-solution-beats-100%25-java-solutions
            The product basically is calculated using the numbers before the current number 
            and the numbers after the current number. Thus, we can scan the array twice. 
            First, we calcuate the running product of the part before the current number.
             Second, we calculate the running product of the part 
            after the current number through scanning from the end of the array.
            */
        int n = nums.length;
        
        int[] res = new int[n];
        res[0] = 1;
        
        for (int i=1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        
        int right = 1;
        for (int i=n-1 ; i >= 0 ; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        
        return res;
    }
}