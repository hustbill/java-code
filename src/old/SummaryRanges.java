package old;
/*228. Summary Ranges My Submissions Question
Total Accepted: 34545 Total Submissions: 152843 Difficulty: Easy
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Array
Hide Similar Problems (M) Missing Ranges*/

import java.util.*;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 4, 5, 7};
        
        List<String> list = summaryRanges(nums);
        
        System.out.println(list);
        
    }
    
    public static List<String> summaryRanges(int[] nums) {
        // Ref : https://leetcode.com/discuss/42290/accepted-java-solution-easy-to-understand
        List<String> list = new ArrayList<String>();
        
       for (int i=0; i < nums.length; i++) {
           int num = nums[i];
           while (i +1 < nums.length && (nums[i+1] - nums[i]) == 1) {
             i++;
           }
           if (num != nums[i]) {
               list.add(num + "->" + nums[i]);
           } else {
               list.add(num + "");
           }
       }
       return list;
    }
}
