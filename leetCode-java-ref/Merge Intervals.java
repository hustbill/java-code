/* Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].*/

/* The crucial part of this problem is build the comparator that sort the intervals based on the start.*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.size()<2)
            return intervals;
        ArrayList<Interval> result=new ArrayList<Interval>();
        Comparator<Interval> intervalComparator=new Comparator<Interval>(){
            public int compare(Interval v1, Interval v2){
                return v1.start-v2.start;
            }
        };
        Collections.sort(intervals,intervalComparator);
        Interval pre=intervals.get(0);
        for(int i=1;i<intervals.size();++i){
            Interval cur=intervals.get(i);
            if(cur.start>pre.end){
                result.add(pre);
                pre=cur;
            }
            else{
                pre=new Interval(pre.start,Math.max(pre.end,cur.end));
            }
        }
        result.add(pre);
        return result;
    }
}
