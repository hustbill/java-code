
import java.util.*;

public class ZigzagIterator {

	private int index=0, size;
	private ArrayList<Integer> al = new ArrayList<Integer>();
	
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	
    	if (v1.size()!=0 && v2.size() !=0)  {
			int min = Math.min(v1.size(), v2.size());
			int max = Math.max(v1.size(), v2.size());
			for (int i=0; i< min; i++) {
				al.add(v1.get(i));
				al.add(v2.get(i));
			}
			for(int j=min; j< max; j++) {
				if( v1.size() < v2.size()){
					al.add(v2.get(j)); 
				} else {
					al.add(v1.get(j));
				}
			}
    	} else {
    		if ( v1.size() == 0  && v2.size() !=0   )	
	    		al = new ArrayList<Integer>(v2);
    	    if ( v1.size() != 0 &&  v2.size() == 0 )  
    	    	al = new ArrayList<Integer>(v1);
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