/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 import java.util.*;
 
public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        return intervals;
    }
	
	public static void main(String[] args) {
		/* 
		  Given [1,3],[2,6],[8,10],[15,18],
		  return [1,6],[8,10],[15,18].
		*/
		Interval x = new Interval( 1,3);
		Interval y = new Interval( 2,6);
		Interval z = new Interval( 8,10);
		Interval r = new Interval( 15,18);
		
		List<Interval> lst = new ArrayList<Interval>();
		lst.add(x);
		lst.add(y);
		lst.add(z);
		lst.add(r);
		
		List<Interval> res = merge(lst);
		
		for( Interval i : res) 
			System.out.println( "[" +  i.start + ", " + i.end + "]"\);
	}
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end =0;}
	Interval(int s, int e) { start = s ; end = e; }
}