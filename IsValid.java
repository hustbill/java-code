/*
Valid Parentheses
https://leetcode.com/problems/valid-parentheses/

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

import java.util.*;

public class IsValid {
    public static boolean isValid1(String s) {
        int len = s.length();
		System.out.println("\n" + s + ", len=" + len);
		boolean res = false;
		
		if (len ==2 ) {
			//System.out.println(" when len =2 , go ...");
			if( (s.charAt(0) == '(' && s.charAt(1) == ')' ) 
				|| (s.charAt(0) == '[' && s.charAt(1) == ']') 
				|| (s.charAt(0) == '{' && s.charAt(1) == '}')) {
			//		System.out.println("Done!");
			//		System.out.println("s= " + s + "len= " + s.length());
					res= true;
			}
			else {
			//	System.out.println("Is invalid");
					res = false;
			 } 
			 //System.out.println("s= " + s + "len= " + s.length());
		} 
		if (len ==1 ||len ==3) {
			//	System.out.println("len = " + len);
			res = false;
		} 
		if (len >2) {		
				for(int i=0; i< len; i++) {
					for(int k=1; i+k< len-1 	; k++) {
							
						if ((s.charAt(i) == '(' && s.charAt(i+k) == ')')
							|| (s.charAt(i) == '[' && s.charAt(i+k) == ']' )
							||(s.charAt(i) == '{' && s.charAt(i+k) == '}' ) ) {
								System.out.println(String.format(" c%d=%c, c%d=%c, s=%s", i, s.charAt(i),i+k, s.charAt(i+k),s));
								String s1 = s.substring(i, i+k+1);
								String s2 = s.substring(i+k+1);
								System.out.println(String.format("after s1=%s, s2=%s",  s1, s2));
								boolean b1 = isValid(s1);
								if (s2.length() >1 ) {
									boolean b2 = isValid(s2);
									System.out.println("b1=" + b1 + " b2=" + b2);
									res = b1 && b2;
								} else {
									res = b1;
								}
								 
						} 
					}
				}
				
		}
		return res;
        
    }
	
	public static boolean isValid(String s) {
		// use stack 
		// Ref : http://www.cnblogs.com/springfor/p/3869420.html
		/*
			一道训练栈的基础题。

			解题方法是：
			一个个检查给的characters，如果是左括号都入栈；如果是右括号，检查栈如果为空，证明不能匹配，如果栈不空，弹出top，与当前扫描的括号检查是否匹配。
			全部字符都检查完了以后，判断栈是否为空，空则正确都匹配，不空则证明有没匹配的。
			注意：
			检查字符是用==，检查String是用.isEqual()，因为String是引用类型，值相等但是地址可能不等。
			*/
		int len = s.length(); 
		if(len ==0 || len ==1) return false;
		
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i< s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i)== '[' || s.charAt(i)== '{') {
				stack.push(s.charAt(i));
			} else {
				if(stack.empty()) {
					return false;   // if no elment be push into stack.
				} else {
					char top = stack.pop();
					if(s.charAt(i) ==')' && top != '(')   return false;
					if(s.charAt(i) == '[' && top != ']')  return false;
					if(s.charAt(i) == '{' && top != '}')  return false;
				}
			}
		}
		return stack.empty();
	}
	
		
	public static void main(String[] args) {
		String s = "[]{}(){}()[]{}";
		String s1 = "{[]}{[]}{()}";
		String s2 = "))(())";
		String s3 = "([)]";
		String s4 = "(]";
		String s5 = "{()}";
		String s6 = "(()])}[}[}[]][}}[}{})][[(]({])])}}(])){)((){";
		
		//System.out.println("******** s = " + isValid(s));   	// true
		System.out.println("******** s1 = " + isValid(s1));       // true
		// System.out.println("******** s2 = " + isValid(s2)); 	// true
		System.out.println("******** s3 = " + isValid(s3));	// false
		System.out.println("******** s4 = " + isValid(s4));	// false
		System.out.println("******** s5 = " + isValid(s5));  // true;
		
		System.out.println("******** s6 = " + isValid(s6));  // true;
	}
    
}