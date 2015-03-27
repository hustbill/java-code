/*
Min Stack

https://oj.leetcode.com/problems/min-stack/
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

*/

import java.util.ArrayList;
import java.util.Collections;

class MinStack {
	ArrayList<Integer> list = new ArrayList<Integer>();
	
    public void push(int x) {
    	list.add(x);
    }

    public void pop() {
        int size = list.size() - 1;
		list.remove(size);
    }

    public int top() {
        return list.get(list.size() -1 );
    }

    public int getMin() {
		System.out.println(list);
		/* Sort statement*/
	    Collections.sort(list);
		System.out.println(list);
        return list.get(0);
    }
	
	public static void main(String[] args) {
		MinStack mstack = new MinStack();
		for(int i=21; i>10; i--)
			mstack.push(i);
		
		mstack.pop();
		int top_elem = mstack.top();
		int min_elem = mstack.getMin();
		
		System.out.print(String.format("top=%d, \t min=%d ", top_elem, min_elem));
		
	}
}