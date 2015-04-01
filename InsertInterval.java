/*

Insert Interval
https://leetcode.com/problems/insert-interval/

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


*/


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

import java.util.ArrayList;
import java.util.List;

import java.util.Collections;
import java.util.Comparator;
import java.util.*;

public class InsertInterval {
 
    /**
     * In place solution
     * Find start and end point of the interval to be merged
     */
	    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
			List<Interval> res = new ArrayList<Interval>();
	        if (intervals == null||intervals.size() == 0){
	            res.add(newInterval);
	            return res;
	        }
			int start=0, end = 0;  
			// find the insert position for newInterval , to be insert or merged
			for( Interval interval : intervals) {
				if(newInterval.start > interval.end) start++;
				if(newInterval.end >= interval.start)  end++;
			    else break;
			}
			
			if(start== end) {  // no need merge, just copy all intervals into res
				res.addAll(intervals);
				res.add(start, newInterval) ;    // insert the new one
				return res;
			}
			for(int i=0; i< start; i++)  res.add(intervals.get(i));
			// intervl and newInterval are a closer range
			Interval interval = new Interval( Math.min( intervals.get(start).start, newInterval.start),
												Math.max( intervals.get(end-1).end,  newInterval.end));  // note that, it's end-1
			res.add(interval);
			for(int j=end; j< intervals.size(); j++) {
				res.add(intervals.get(j));   // after the newInterval insert, copy the remains into res
			}
			return res;
		}
	
	
	public static void testCase1() {
		// Case 1:
		System.out.println("Case 1");
		Interval interval0 = new Interval(1,2);
		// Interval interval0 = new Interval(0,1);
		Interval interval1 = new Interval(3,5);
		Interval interval2 = new Interval(6, 7);
		Interval interval3 = new Interval(8, 10);
		Interval interval4 = new Interval(12, 16);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(interval0);
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		printIntervals(intervals);	
		Interval newInterval_1 = new Interval(4,9);
		// Interval newInterval_1 = new Interval(4,11);
		System.out.println("\nstart Insert newInterval_1 : " + newInterval_1.start + " , " + newInterval_1.end);
		intervals = insert(intervals, newInterval_1);
		printIntervals(intervals);		
	}
	
	public static void testCase2() {
		// Case 2
		System.out.println("\n\nCase 2");
		Interval interval5 = new Interval(0, 1);
		Interval interval6 = new Interval(4, 9);
		List<Interval> intervals2 = new ArrayList<Interval>();
		intervals2.add(interval5);
		intervals2.add(interval6);
		printIntervals(intervals2);
		Interval newInterval_2 = new Interval(2,5); 

		System.out.println("start Insert newInterval2 : " + newInterval_2.start + " , " + newInterval_2.end);
		intervals2 = insert(intervals2, newInterval_2);
		printIntervals(intervals2);
	}
	
	public static void testCase3() {
		// Case 3
		System.out.println("\n\nCase 3");
		Interval interval5 = new Interval(1, 5);
		List<Interval> intervals2 = new ArrayList<Interval>();
		intervals2.add(interval5);
		printIntervals(intervals2);
		Interval newInterval_2 = new Interval(2,3); 

		System.out.println("start Insert newInterval2 : " + newInterval_2.start + " , " + newInterval_2.end);
		intervals2 = insert(intervals2, newInterval_2);
		//printIntervals(intervals2);
	}
	
	public static void main(String[] args){
		testCase1();
		 testCase2();
		 testCase3();
	}
	
	public static void printIntervals(List<Interval> intervals) {
		//System.out.println(intervals);
		for (int i = 0; i < intervals.size(); i++) {
           System.out.println("Index: " + i + " - Item: " 
			   + intervals.get(i).start + " "+ intervals.get(i).end);
		}
	}
	
	
    public static List<Interval> insert0(List<Interval> intervals, Interval newInterval) {
		// List<Interval> res = new ArrayList<Interval>();
// 		int size = intervals.size();
// 		if (size == 0 )  res.add(newInterval);
// 		// if (size == 1)  res.add(new Interval ( Math.min( intervals.get(0).start, newInterval.start),
// 	// 		   Math.max( intervals.get(0).end, newInterval.end)));
// 	//
// 		// my firs solution is use two point,  i and j ,  i from 0 to size() , j from size() to 0.
// 		//  this idea make the problem more complicated.
//
// 		//Second solution.
// 		// pick up one interval from list, compare with the new Interval.  three cases.
// 		// 用图来表示各种情况比较清楚  参考
// 		// http://www.programcreek.com/2012/12/leetcode-insert-interval/
//
// 		for (Interval interval : intervals) {
// 			//case 1 : newInterval is in front of interval
// 			if(  newInterval.end < interval.start) {
// 				res.add(newInterval);
// 				newInterval  = interval;  //move to right
// 			}
// 			// case 2 : middle, cross
// 			else if( newInterval.start <= interval.end || newInterval.end >= interval.start) {
// 				newInterval = new Interval(Math.min(newInterval.start, interval.start),
// 					 Math.max(newInterval.end, interval.end));
// 			}
// 			// case 3:  newInterval is after of intervel
// 			else if (  newInterval.start > interval.end) {
// 				res.add(interval);
// 			}
// 			res.add(newInterval);
// 		}
// 		return res;
// ArrayList<Interval> result = new ArrayList<Interval>();
//
//       for(Interval interval: intervals){
//           if(interval.end < newInterval.start){
//               result.add(interval);
//           }else if(interval.start > newInterval.end){
//               result.add(newInterval);
//               newInterval = interval;
//           }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
//               newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
//           }
//       }
//
//       result.add(newInterval);
//
//       return result;
return intervals;

    }
}


/**
 * Definition for an interval. */
  class Interval {
     int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
	   
  }

