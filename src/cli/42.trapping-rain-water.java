/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (44.28%)
 * Total Accepted:    355K
 * Total Submissions: 789.2K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 */
class Solution {
    // Appoarch 1: dp
    // for index i,  compare its left_max, with its right_max, 
    // ans += min(left_max, right_max) - height[i];

    // Appoarch 2: two pointers,  O(N) Time, O(1) Space
    // Traverse one pass with two pointers, from two sides to the middle
    // https://leetcode.com/problems/trapping-rain-water/discuss/17386/Sharing-my-Java-code%3A-O(n)-time-O(1)-space
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        
        int ans = 0;
        int len = height.length;
        int left = 0, right = len - 1;
        
        // find the left and right edge which can hold water
        while (left < right && height[left] <= height[left + 1]) left++;
        while (left < right && height[right] <= height[right - 1]) right--;

        while (left < right) {
            int maxLeft = height[left];
            int maxRight = height[right];
            if (maxLeft <= maxRight) {
                // add volum until an edge larger than the left edge
                while (left < right && maxLeft >= height[++left]) {
                    ans += maxLeft - height[left];
                }
            } else {
                // add volum until an edge larger then the right volum
                while (left < right && height[--right] <= maxRight) {
                    ans += maxRight - height[right];
                }
            }
        }
        return ans;
    }
}
