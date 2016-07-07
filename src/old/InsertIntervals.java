package old;
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
 
public class InsertIntervals {
	private static Comparator<Interval> comparator = new Comparator<Interval>() {
		@Override public int compare(Interval x, Interval y) {
			return x.start - y.start;
		}
	};
	
// Solution1: https://leetcode.com/discuss/22929/short-and-straight-forward-java-solution
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<Interval>();
        int i=0;
        
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( //we could mutate newInterval here also
                Math.min(intervals.get(i).start, newInterval.start),
                Math.max(intervals.get(i).end, newInterval.end));
                i++;
        }
        result.add(newInterval); // all the union of intervals we got
        
        // add all the rest
        while (i < intervals.size())  result.add(intervals.get(i++));
        return result;
    }
    
    // Solution2:  use merge internals method
    public static List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        List<Interval> res = new LinkedList<Interval>();
        res = merge(intervals);
        return res;
    }
    

    public static List<Interval> merge(List<Interval> intervals) {
	   /*  https://leetcode.com/discuss/13953/a-simple-java-solution
        The idea is to sort the intervals by their starting points. Then, we take the first interval and compare its end with the next intervals starts. As long as they overlap, we update the end to be the max end of the overlapping intervals. Once we find a non overlapping interval, we can add the previous "extended" interval and start over.
Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).
I used an anonymous comparator and a for-each loop to try to keep the code clean and simple.  */
        
		// Sort by ascending starting point using an anonymous Comparator
		if (intervals.size() <=1)
			return intervals;
			
		Collections.sort(intervals, comparator);
		List<Interval> res = new LinkedList<Interval>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		
		for(Interval i : intervals) {
			if (i.start <= end  ) {  // Overlapping intervals, move the end if needed
				end = Math.max( end, i.end);
			} else { // Disjoint intervals, add the previous one and reset bounds
				res.add( new Interval(start, end));
				start = i.start;
				end = i. end;
			}
		}
		res.add(new Interval(start, end));
		return res;
    }
	

	
	public static void main(String[] args) {
		/* 
		  Given [1,3],[2,6],[8,10],[15,18],
		  return [1,6],[8,10],[15,18].
		*/
		Interval x = new Interval( 1,3);
		Interval y = new Interval( 3,6);
		Interval z = new Interval( 8,10);
		Interval r = new Interval( 15,18);
		
		
		List<Interval> lst = new ArrayList<Interval>();
		lst.add(r);
		lst.add(x);
		lst.add(y);
		lst.add(z);
		
		
		List<Interval> res = merge(lst);
		
		for( Interval i : res) 
			System.out.println( "[" +  i.start + ", " + i.end + "]");
			
		Interval m = new Interval(1,2);
		Interval l = new Interval(6,9);
		Interval n = new Interval(3,7);
		
		List<Interval> list2 = new LinkedList<Interval>();
		list2.add(m);
		list2.add(l);
		res = insert(list2, n);
		for( Interval j : res) 
			System.out.println( "[" +  j.start + ", " + j.end + "]");
		
	}
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end =0;}
	Interval(int s, int e) { start = s ; end = e; }
}