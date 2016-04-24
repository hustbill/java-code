import java.util.*;

public class Vector2D {
 // Refer 1:  http://www.meetqun.com/thread-10681-1-1.html
    // Refer 2: http://www.cnblogs.com/jcliBlogger/p/4704781.html
   /* 这种解法弊端 将整个vec2d读到内存里面，而实际情况可能不能全部读入内存。
   所以该解法不是很优化
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
	
	*/
	
    // Refer 1:  http://www.meetqun.com/thread-10681-1-1.html
    // Refer 2: http://www.cnblogs.com/jcliBlogger/p/4704781.html
    Iterator<List<Integer>> rowIt;
    Iterator<Integer> colIt;
    
    public Vector2D(List<List<Integer>> vec2d) {
        rowIt=vec2d.iterator();
        colIt=null;
    }

    public int next() {
        if(!hasNext()) return -1; 
        return colIt.next();
    }

    public boolean hasNext() {
        while((colIt==null || !colIt.hasNext()) && rowIt.hasNext()) 
            colIt=rowIt.next().iterator();
        return colIt!=null && colIt.hasNext();
    }
    
}


/**
 *  * Your Vector2D object will be instantiated and called as such:
 *   * Vector2D i = new Vector2D(vec2d);
 *    * while (i.hasNext()) v[f()] = i.next();
 *     */
