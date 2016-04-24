/*
8. String to Integer (atoi) My Submissions Question
Total Accepted: 93777 Total Submissions: 698810 Difficulty: Easy
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

Hide Company Tags Amazon Microsoft Bloomberg Uber
Hide Tags Math String
Hide Similar Problems (E) Reverse Integer (H) Valid Number
Have you met this question in a real interview? Yes  No
Discuss
Date : 2016.03.22
*/
import java.util.*;

public class MyAtoi {

	public static int myAtoi(String s) {

		int sign = 1, i = 0, num = 0;
		int n = s.length();
		int maxDiv10 = Integer.MAX_VALUE/10;
		if (s == null || n == 0) return 0;

		// deal with multi whitespace
		while ( i < n && Character.isWhitespace(s.charAt(i)))  i++;
		if (i < n && s.charAt(i) == '+') {
			sign = 1;
			i++;
		}
		if (i < n && s.charAt(i) == '-') {
			sign = -1;
			i++;
		}

		while (i < n  && Character.isDigit(s.charAt(i))) {
			int digit = Character.getNumericValue(s.charAt(i));
				if (num > maxDiv10 || 
					(num < maxDiv10 && digit > 8))
					return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			
			num = num * 10 + digit;
			i++;
		}

		return sign * num;

	}

    public static int myAtoi_overflow(String str) {
	  if(str == null && str.length() ==0 ) return 0;
	  
	  StringBuilder sb = new StringBuilder();
	  
	  for (char c : str.toCharArray()) {
		if( !Character.isWhitespace(c)) {
		  sb.append(c);
		}
	  }
	  if ( !sb.toString().equals("")) {
		int res = Integer.parseInt(sb.toString());
		 return res ;
	  } 
	  return 0 ;   
    }
	
	public static void main(String[] args) {
		String[] testcases = {"", "-2321", "30000001","-2198563", "2147484647", "-2147484648", "2147484649"};
		
		int i=0; 
		for(String str : testcases) {
			System.out.println( i + " : " + myAtoi(str));
			i++;
		}
	}
	
	
}