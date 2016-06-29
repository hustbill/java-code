package dianmian;
//	1. 第一题
//	You're working with an intern that keeps coming to you with JavaScript code that won't run because the braces, brackets, and parentheses are off. To save you both some time, you decide to write a braces/brackets/parentheses validator.
//	Let's say:
//	
//	'(', '{', '[' are called "openers."
//	')', '}', ']' are called "closers."
//	
//	Write an efficient function that tells us whether or not an input string's openers and closers are properly nested.
//	
//	Examples:
//	
//	"{ [ ] ( ) }" should return True
//	"{ [ ( ] ) }" should return False
//	"{ [ }" should return False
//	"{a''**bc}" should return True

import java.util.*;


public class CollectiveHealth {
	public boolean checkValid(String s) {
	    static final Map<Character, Character> map  = 
	        new HashMap<Character, Character>() {
	            {
	                put('(', ')');
	                put('[', ']');
	                put('{', '}');
	            }
	        };
	        
	      // pre-operate 
	    // remove abc from {abc}
	    for (char c : s.toCharArray()) {
	        if ( Character.isLetterOrDigit(c)) {
	          //
	        }
	        
	    }    
	    // s from  orig to {} 
	    // s.subString(... )
	    // regular express
	    // only remain six:  () {} and []
	    Stack<Character> st = new Stack<>();
	    
	    for (char c : s.toCharArray()) {
	        if (map.containsKey(c)) {
	            st.push(c); // push "openers"
	        } else if (st.isEmpty() || map.get(st.pop()) != c) {
	            return false;
	        }
	    }
	    return st.isEmpty();
	}

}


