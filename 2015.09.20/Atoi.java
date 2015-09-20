
/* 
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

*/

public class Atoi {
	
	// 这道题，我还不会做。 没有自己调试过。 看别人解法算作弊。鄙视自己。 3/31/2015
    // reference: http://blog.csdn.net/lilong_dream/article/details/19677643
       public int atoi(String str) {
   		String s = str.trim();

   		if (s.length() == 0) {
   			return 0;
   		}

   		int INT_MAX = Integer.MAX_VALUE;
   		int INT_MIN = Integer.MIN_VALUE;
		
   		int sign = 1;
   		int res = 0;
		
   		int i = 0;
   		if (s.charAt(0) == '-') {
   			sign = -1;
   			++i;
   		} else if (s.charAt(0) == '+') {
   			++i;
   		}

   		for (; i < s.length(); ++i) {
   			char digit = s.charAt(i);
   			if (digit >= '0' && digit <= '9') {
   				if (res > INT_MAX / 10 || digit - '0' > INT_MAX - res * 10) {
   					return sign == -1 ? INT_MIN : INT_MAX;
   				}

   				res = res * 10 + (digit - '0');
   			} else {
   				break;
   			}
   		}

   		return sign * res;
       }
}