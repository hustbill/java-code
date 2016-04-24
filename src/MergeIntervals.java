/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
<<<<<<< HEAD
 import java.util.*;
 
public class MergeIntervals {
	private static Comparator<Interval> comparator = new Comparator<Interval>() {
		@Override public int compare(Interval x, Interval y) {
			return x.start - y.start;
		}
	};
		
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
	}
=======
 
 
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        
    }
>>>>>>> dev-win
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end =0;}
<<<<<<< HEAD
	Interval(int s, int e) { start = s ; end = e; }
=======
	Interval(int s, int e) { star = s ; end = e; }
>>>>>>> dev-win
}