/* Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6*/

/* The solution is traverse from left to right,
if operand, push to the stack,
if operator, pop the stack twice the get the two operands, then do the operation, push the result back.
The result is left in the stack as the only number.*/

public class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        if(tokens.length == 0) return res;
         
        // build a stack for this kind of problem
        String operators = "+-*/";
        Stack<string> stack = new Stack<string>();
         
        for(String s : tokens) {
            // if s is not an valid operator, then s is a num, push in stack
            if(!operators.contains(s)) {
                stack.push(s);
            } 
            // if s is an valid operator, pop two nums, calculate, push back
            else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                 
                // caculate
                switch(s) {
                    case "+" : stack.push(String.valueOf(a + b)); break;
                    case "-" : stack.push(String.valueOf(b - a)); break;
                    case "*" : stack.push(String.valueOf(a * b)); break;
                    case "/" : stack.push(String.valueOf(b / a)); break;
                }
            }
        }
         
        // after loop, pop the last num as res
        res = Integer.valueOf(stack.pop());
         
        return res;
    }
}
