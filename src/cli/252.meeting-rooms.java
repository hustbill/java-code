/*
 * @lc app=leetcode id=252 lang=java
 *
 * [252] Meeting Rooms
 *
 * https://leetcode.com/problems/meeting-rooms/description/
 *
 * algorithms
 * Easy (52.60%)
 * Total Accepted:    96.6K
 * Total Submissions: 182.8K
 * Testcase Example:  '[[0,30],[5,10],[15,20]]'
 *
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 * 
 * Example 1:
 * 
 * 
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[7,10],[2,4]]
 * Output: true
 * 
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
       if (intervals.length <= 1) 
           return true;
        
       // Sort the intervals by start time
       Arrays.sort(intervals, (il1, il2) -> Integer.compare(il1[0], il2[0])); 
       for (int i = 0; i < intervals.length - 1; i++) {
           if (intervals[i][1] > intervals[i + 1][0]) {
               return false;
            }
       }
      return true; 
    }

      public boolean canAttendMeetings_253(int[][] intervals) {
       if (intervals.length <= 1) 
           return true;

       Arrays.sort(intervals, (il1, il2) -> Integer.compare(il1[0], il2[0])); // sort by start time
       List<int[]> list = new ArrayList<>();
       int[] newInterval = intervals[0];
       list.add(newInterval); // add the first meeting

       for (int i = 1; i < intervals.length; i++) {
           if (intervals[i][0] < newInterval[1]) {
               newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
               return false;
            } else {
                newInterval = intervals[i];
                list.add(newInterval);
            }
       }
      return list.size() != 1; 
    }
}
