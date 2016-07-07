package old;
import java.util.*;

public class ZigzagIterator {

    private Iterator<Integer> itr1, itr2, tmp;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	    itr1 = v1.iterator();
	    itr2 = v2.iterator();
    }

    public int next() {
        if (itr1.hasNext())  { 
            tmp=itr2;
            itr2=itr1;
            itr1=tmp;
        }
        return itr2.next();
    }

    public boolean hasNext() {
        return itr1.hasNext() || itr2.hasNext();
    }


}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */