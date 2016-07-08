package stack;

import java.util.*;

public class MyQueue {
	
	    Stack<Integer> input = new Stack<>();
	    Stack<Integer> output = new Stack<>();
	    
	    
	    // Push element x to the back of queue.
	    public void push(int x) {
	        input.push(x);    
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        peek();
	        output.pop();
	    }

	    // Get the front element.
	    public int peek() {
	        if (output.empty()) 
	            while(!input.empty()) 
	                output.push(input.pop());
	        return output.peek();
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return input.empty()  && output.empty();   
	    }
	    
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		System.out.println(queue.empty());// true
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.empty()); // false;
		
		System.out.println(queue.peek()); // 1	
		
		queue.pop();
		System.out.println(queue.peek());  // 2
		

	}

}
