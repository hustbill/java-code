// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.*;

class PeekingIterator implements Iterator<Integer> {
    private boolean hasPeeked=false;
    private Iterator<Integer> itr;
    private Integer peekElement;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.itr = iterator;
	}

	@Override
	public void remove() {
		if (!hasPeeked)  // can't remove after you've peeked at next
			itr.remove();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (!hasPeeked) {
            peekElement = itr.next();
            hasPeeked = true;
        }
        return peekElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (!hasPeeked) {
	        return itr.next();
	    }
	    Integer result = peekElement;
	    hasPeeked = false;
	    peekElement = null;
	    return result;
	}

	@Override
	public boolean hasNext() {
	    return hasPeeked || itr.hasNext();
	}
}