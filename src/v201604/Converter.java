package v201604;

import java.util.Stack;
import java.util.StringTokenizer;

public class Converter {

	public static void main(String[] args) {
		String s1 = " 3 + 4 * 5 - 2 ";
		String s2 = " 3 4 5 * + 2 -";
		System.out.printf("Infix   : %s \nPostfix : %s \n", s1, convertToPostfix(s1));
		System.out.printf("Test case %s", convertToPostfix(s1).equals(s2) ? "Success" : "Failed");
		/*
		 *  Infix   : 3 + 4 * 5 - 2 
		 * Postfix : 3 4 5 * + 2 - 
		 * Test case Success
		 */
	}

	/*
	 * Method: convertToPostfix Usage: to convert infix to postfix: Input : 3 +
	 * 4 * 5 - 2 Output : 3 4 5 * + 2 -
	 * http://www.mathblog.dk/tools/infix-postfix-converter/
	 * https://people.cs.clemson.edu/~turner/courses/cs102/spring98/section2/assignments/asg4/InfixToPostfix.java
	 */
	public static String convertToPostfix(String infix) {

		Stack optrStack = new Stack(); // the stack of operators
		StringTokenizer parser = new StringTokenizer(infix, "+-*/^() ", true);
		StringBuffer postfix = new StringBuffer(infix.length());

		char c;

		while (parser.hasMoreTokens()) {
			String token = parser.nextToken();
			c = token.charAt(0);

			if ((token.length() == 1) && isOperator(c)) {
				while (!optrStack.empty() && !lowerPrecedence(((String) optrStack.peek()).charAt(0), c)) {
					postfix.append(" ").append((String) optrStack.pop());
				}

				if (c == ')') {
					// Output the remaining operators in the parenthesized part.
					String operator = (String) optrStack.pop();
					while (operator.charAt(0) != '(') {
						postfix.append(" ").append(operator);
						operator = (String) optrStack.pop();
					}
				} else {
					optrStack.push(token);// Push this operator onto the stack.
				}

			} else if ((token.length() == 1) && Character.isWhitespace(c)) {
				continue; // If token was a space, ignore it
			} else {
				postfix.append(" ").append(token); // Output the operand
			}
		}

		// Output the remaining operators on the stack.
		while (!optrStack.empty()) {
			postfix.append(" ").append((String) optrStack.pop());
		}

		return postfix.toString();
	}

	/* Check whether c is an operator. */
	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
	}

	/*
	 * Method: lowerPrecedence Input: op1 and op2 are assumed to be operator
	 * characters (+,-,*,/,^). Usage: Tell whether op1 has lower precedence than
	 * op2, where op1 is an operator on the left and op2 is an operator on the
	 * right
	 */
	private static boolean lowerPrecedence(char op1, char op2) {
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

		default:
			return false;
		}
	}

}

/*
 * Reference:
 * http://scriptasylum.com/tutorials/infix_postfix/algorithms/infix-postfix/
 * Infix to Postfix Conversion :
 * 
 * In normal algebra we use the infix notation like a+b*c. The corresponding
 * postfix notation is abc*+. The algorithm for the conversion is as follows :
 * Scan the Infix string from left to right. Initialise an empty stack. If the
 * scannned character is an operand, add it to the Postfix string. If the
 * scanned character is an operator and if the stack is empty Push the character
 * to stack. If the scanned character is an Operand and the stack is not empty,
 * compare the precedence of the character with the element on top of the stack
 * (topStack). If topStack has higher precedence over the scanned character Pop
 * the stack else Push the scanned character to stack. Repeat this step as long
 * as stack is not empty and topStack has precedence over the character. Repeat
 * this step till all the characters are scanned. (After all characters are
 * scanned, we have to add any character that the stack may have to the Postfix
 * string.) If stack is not empty add topStack to Postfix string and Pop the
 * stack. Repeat this step as long as stack is not empty. Return the Postfix
 * string.
 */
