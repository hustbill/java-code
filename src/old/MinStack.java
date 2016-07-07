package old;
/*
155. Min Stack
Total Accepted: 59192 Total Submissions: 277394 Difficulty: Easy
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
import java.util.*;

class MinStack {
    public static void main(String[] args){
            
        MinStack st = new MinStack();
   
        st.push(9);
        st.push(7);
        st.push(3);
        st.push(8);
        st.push(1);

        // int top = st.top();
   //      System.out.printf("top = %d", top);
        int min = st.getMin();
        System.out.printf("\nmin = %d", min);
        
    }

    static int min = Integer.MAX_VALUE;
    static Stack<Integer> stack = new Stack<Integer>();
                    
    public static void push(int x) {
        if ( x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public static void pop() {
        int top = stack.pop();
        if (top == min) {
            min = stack.pop();
        }
        
    }

    public static int top() {
        return stack.peek();
    }

    public int getMin() {
      return min; 
    }
}
