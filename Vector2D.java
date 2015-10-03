import java.util.*;

public class Vector2D {
 // Refer 1:  http://www.meetqun.com/thread-10681-1-1.html
    // Refer 2: http://www.cnblogs.com/jcliBlogger/p/4704781.html
   	private ArrayList<Integer> al = new ArrayList<Integer>();

	private int size, index=0;
    public Vector2D(List<List<Integer>> vec2d) {
		int vsize = vec2d.size();
        for(int i=0; i< vsize; i++) {
        	List<Integer> rowList  = vec2d.get(i);
			int colSize = rowList.size();
        	for(int j=0; j< colSize; j++) {
        	 	al.add(rowList.get(j));
        	 }
        }
        size = al.size();
    }

    public int next() {
       return al.get(index-1); 
    }

    public boolean hasNext() {
        return index++ < size ? true : false;

    }
    
}

/**
 *  * Your Vector2D object will be instantiated and called as such:
 *   * Vector2D i = new Vector2D(vec2d);
 *    * while (i.hasNext()) v[f()] = i.next();
 *     */
