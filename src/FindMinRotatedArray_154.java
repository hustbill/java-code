/*
154. Find Minimum in Rotated Sorted Array II   My Submissions QuestionEditorial Solution
Total Accepted: 51167 Total Submissions: 148534 Difficulty: Hard
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

Hide Tags Array Binary Search
Hide Similar Problems (M) Find Minimum in Rotated Sorted Array


*/
5
2 4 26
abcde
public class FindMinRotatedArray_154 {
    public int findMin(int[] nums) {
        // https://leetcode.com/discuss/19746/my-pretty-simple-code-to-solve-it
        // When num[mid] == num[hi], we couldn't sure the position of minimum in mid's left or right, so just let upper bound reduce one.
     int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;

        while(lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            }
            else if (nums[mid] < nums[hi]) {
                hi = mid;
            }
            else { // when num[mid] and num[hi] are same
                hi--;
            }
        }
        return nums[lo];
    }
    
}