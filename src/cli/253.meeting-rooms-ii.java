/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 *
 * https://leetcode.com/problems/meeting-rooms-ii/description/
 *
 * algorithms
 * Medium (43.40%)
 * Total Accepted:    183.6K
 * Total Submissions: 421.2K
 * Testcase Example:  '[[0,30],[5,10],[15,20]]'
 *
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * Example 1:
 * 
 * 
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * 
 * Example 2:
 * 
 * 
 * Input: [[7,10],[2,4]]
 * Output: 1
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
class Solution {
    // Approach 1: Priority Queues
    /* Algorithm
1. Sort the given meetings by their start time.
2. Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
3. For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
4. If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
5. If not, then we allocate a new room and add it to the heap.
6. After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.

Time Complexity: O(NlogN), Space Complexity: O(N)
*/
    public int minMeetingRooms(int[][] intervals) {
        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) 
            return 0;
        // Min heap
        PriorityQueue<Integer> allocator = 
            new PriorityQueue<Integer>(
                    intervals.length,
                    new Comparator<Integer>() {
                        public int compare(Integer a, Integer b) {
                            return a - b;
                        }
                    });
        // Sort the intervals by start time
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            
            if (intervals[i][0] >= allocator.peek())  {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
       }

       // The size of the heap tells us the minimum rooms required for all the meetings.
       return allocator.size();
    }
}
