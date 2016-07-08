package stack;

import java.util.*;
public class MyStack {

	Queue<Integer> queue = new LinkedList<Integer>();
	// https://discuss.leetcode.com/topic/15945/concise-1-queue-java-c-python/2

	// Push element x onto stack.
	public void push(int x) {
		queue.add(x);
		for (int i = 1; i < queue.size(); i++) {
			queue.add(queue.remove()); // queue a b -> queue b a
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		queue.remove(); // Retrieves and removes the head of this queue
	}

	// Get the top element.
	public int top() {
		return queue.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		System.out.println(stack.empty());// true
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.empty()); // false;
		
		System.out.println(stack.top()); // 3
		
		stack.pop();
		System.out.println(stack.top());  // 2
		

	}

}
