package v201604;

import java.util.*;

// reference:
// 1. http://scriptasylum.com/tutorials/infix_postfix/algorithms/infix-postfix/
// 2. 
public class InfixToPostfix {

	// Constructor: (default)

	// Private methods:

	private boolean isOperator(char c) { // Tell whether c is an operator.

		return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';

	}// end isOperator

	private boolean isSpace(char c) { // Tell whether c is a space.

		return (c == ' ');

	}// end isSpace

	private boolean lowerPrecedence(char op1, char op2) {
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

	// Method to convert infix to postfix:

	public String convertToPostfix(String infix) {
		// Return a postfix representation of the expression in infix.

		Stack operatorStack = new Stack(); // the stack of operators

		char c; // the first character of a token

		StringTokenizer parser = new StringTokenizer(infix, "+-*/^() ", true);
		// StringTokenizer for the input string

		StringBuffer postfix = new StringBuffer(infix.length()); // result

		// Process the tokens.
		while (parser.hasMoreTokens()) {

			String token = parser.nextToken(); // get the next token
												// and let c be
			c = token.charAt(0); // the first character of this token

			if ((token.length() == 1) && isOperator(c)) { // if token is
															// an operator

				while (!operatorStack.empty() && !lowerPrecedence(((String) operatorStack.peek()).charAt(0), c))
					// (Operator on the stack does not have lower precedence, so
					// it goes before this one.)

					postfix.append(" ").append((String) operatorStack.pop());

				if (c == ')') {
					// Output the remaining operators in the parenthesized part.
					String operator = (String) operatorStack.pop();
					while (operator.charAt(0) != '(') {
						postfix.append(" ").append(operator);
						operator = (String) operatorStack.pop();
					}
				} else
					operatorStack.push(token);// Push this operator onto the
												// stack.

			} else if ((token.length() == 1) && isSpace(c)) { // else if
				// token was a space
				; // ignore it
			} else { // (it is an operand)
				postfix.append(" ").append(token); // output the operand
			} // end if

		} // end while for tokens

		// Output the remaining operators on the stack.
		while (!operatorStack.empty())
			postfix.append(" ").append((String) operatorStack.pop());

		// Return the result.

		return postfix.toString();

	}// end convertToPostfix

	public static void main(String[] args) { // Test method for the class.

		String[] testString = { "2 + 3 * 4 / 5", "2*3 - 4 + 5 / 6", " 35 - 42* 17 /2 + 10", " 33.2 - 17.5 * 2.0 ^ 3.2",
				"3 * (4 + 5)", "3 * ( 4 - (5+2))/(2+3)" };

		InfixToPostfix converter = new InfixToPostfix();

		System.out.println("\nTest for convertToPostfix:\n");

		for (int i = 0; i < testString.length; i++) {
			System.out.println("infix: " + testString[i]);
			System.out.println("postfix: " + converter.convertToPostfix(testString[i]));
			System.out.println();
		}
	} // end main

}// end class InfixToPostfix
