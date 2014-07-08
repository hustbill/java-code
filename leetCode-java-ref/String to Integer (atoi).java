/* mplement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what 
are the possible input cases.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as 
possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no 
effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists 
because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of 
representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.*/

public class Solution {
    public int atoi(String str) {
        if(null==str || 0==str.length())
            return 0;
        int start=0,end=str.length(),result=0;
        while(start<end && str.charAt(start)==' '){
            start++;
        }
        int neg_pos_sign=1;
        if('-' == str.charAt(start) || '+'==str.charAt(start)){
            char sign=str.charAt(start);
            neg_pos_sign= sign=='-'?-1:1;
            start++;
        }
      
        while(start<end && str.charAt(start)>='0' && str.charAt(start)<='9'){
            int num=(int)(str.charAt(start)-'0');
            if(Integer.MAX_VALUE/10<result || (Integer.MAX_VALUE/10==result && Integer.MAX_VALUE%10 <num)){
                return neg_pos_sign==1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            result=result*10+num;
            start++;
        }
        
        return result*neg_pos_sign;
    }
}
