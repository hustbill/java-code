package v201604;

import java.util.Stack;
import java.util.StringTokenizer;


public class ExpediaPhoneInterview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "3 + 4 * 5 - 2 ";
		String s2 = "3 4 5 * + 2 - ";
		System.out.println(convertToPostfix(s1));
		//System.out.printf("Test case %s", convertToPostfix(s1) == s2 ? "Success" : "Failed");
	}
	
	
	/*
	 *  input 			output
	 *  3 + 4 * 5 - 2    	3 4 5 * + 2 - 
	 *  http://www.mathblog.dk/tools/infix-postfix-converter/
	*/
	public static String convertToPostfix(String str) {
	
        Stack opStack = new Stack(); // the stack of operators
        StringTokenizer parser = new StringTokenizer(str, "+-*/^()", true);
        StringBuffer postfix = new StringBuffer(str.length());
        
        char c;  
        while(parser.hasMoreTokens()) {
            String token = parser.nextToken();
            c = token.charAt(0);
            
            if ((token.length() == 1) && isOperator(c)) {
              while (!opStack.empty() && !lowerPrecedence(((String) opStack.peek()).charAt(0), c)) {
                  postfix.append((String) opStack.pop());
              }
              
              if ( c== ')') {
					// Output the remaining operators in the parenthesized part.
				 	String operator = (String) opStack.pop();
					while (operator.charAt(0) != '(') {
						postfix.append(operator);
						operator = (String) opStack.pop();
					}
				} else
					opStack.push(token);// Push this operator onto the
												// stack.

			} else if ((token.length() == 1) && Character.isWhitespace(c)) { // else if
				
				 postfix.append(""); 
			} else { // (it is an operand)
				postfix.append(token); // output the operand
			}

		}

		// Output the remaining operators on the stack.
		while (!opStack.empty())
			postfix.append((String) opStack.pop());

		// Return the result.

		return postfix.toString();

	}// end convertToPostfix

        
    
    private static boolean isOperator(char c) { // Tell whether c is an operator.

    		return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';

    	}// end isOperator

    
    	private static boolean lowerPrecedence(char op1, char op2) {
    		// Tell whether op1 has lower precedence than op2, where op1 is an
    		// operator on the left and op2 is an operator on the right.
    		// op1 and op2 are assumed to be operator characters (+,-,*,/,^).

    		switch (op1) {

    		case '+':
    		case '-':
    			return !(op2 == '+' || op2 == '-');

    		case '*':
    		case '/':
    			return op2 == '^' || op2 == '(';

    		case '^':
    			return op2 == '(';

    		case '(':
    			return true;

    		default: // (shouldn't happen)
    			return false;
    		}

    	} // end lowerPrecedence
    
}
