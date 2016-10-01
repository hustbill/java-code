import java.util.*;

public class MedianFinder {

	PriorityQueue<Integer> minHeap = new PriorityQueue(); // heap is a minimal heap by default
	PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder()); // change to a maximum heap
	
	/* 演算过程
		maxHeap    minHeap
		2			
					2
		2
		3, 2		
		2			3
		4, 2		3
		2			3,4
		2, 3		4
		====================>  return maxHeap.peek()  =3 
		*/
	
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
        	return  (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
        	return maxHeap.peek();
        }
    }
	
	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(2);
		mf.addNum(3);
		mf.addNum(4);
		System.out.println(mf.findMedian());
	}
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();