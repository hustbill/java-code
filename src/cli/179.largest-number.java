/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 *
 * https://leetcode.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (26.35%)
 * Total Accepted:    142.9K
 * Total Submissions: 537.6K
 * Testcase Example:  '[10,2]'
 *
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * Example 1:
 * 
 * 
 * Input: [10,2]
 * Output: "210"
 * 
 * Example 2:
 * 
 * 
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * 
 * 
 * Note: The result may be very large, so you need to return a string instead
 * of an integer.
 * 
 */
class Solution {
    /*
     * https://leetcode.com/problems/largest-number/discuss/53158/My-Java-Solution-to-share
     *
     * mplement a String comparator to decide which String should come first during concatenation. Because when you have 2 numbers (let's convert them into String), you'll face only 2 cases:
For example:

String s1 = "9";
String s2 = "31";

String case1 =  s1 + s2; // 931
String case2 = s2 + s1; // 319

     *
     * Let's assume:
the length of input array is n,
average length of Strings in s_num is k,
Then, compare 2 strings will take O(k).
Sorting will take O(nlgn)
Appending to StringBuilder takes O(n).
So total will be O(nklgnk) + O(n) = O(nklgnk).

Space is pretty straight forward: O(n).
     */
    public String largestNumber(int[] nums) {
       if (nums == null || nums.length == 0)
           return "";
       // Convert int array to String array, so we can sort later on
       String[] sArr = new String[nums.length];
       for (int i = 0; i < nums.length; i++) {
            sArr[i] = String.valueOf(nums[i]);
       }

        // Comparator to decide which string should come first in concatenation
       Comparator<String> comp = new Comparator<String>() {
           @Override 
           public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);  // reverse order here, so that we can do append() later
         }
       };

       Arrays.sort(sArr, comp);
       // An extreme edge case by lc, say you have only a bunch of 0 in nums 
       if (sArr[0].charAt(0) == '0') {
            return "0";
       }
       
       StringBuilder ret = new StringBuilder();
       for (String str : sArr) {    
           ret.append(str);
       }
       return ret.toString();
    }
}
