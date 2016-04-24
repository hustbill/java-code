/*43. Multiply Strings My Submissions Question
Total Accepted: 52614 Total Submissions: 233543 Difficulty: Medium
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

Hide Company Tags Facebook
Hide Tags Math String
Hide Similar Problems (M) Add Two Numbers (E) Plus One (E) Add Binary
*/
import java.util.*;

public class Multiply {
    
    public static void main(String[] args) {
        String num1= "12";
        String num2 = "3";
        /*  "126789000"
            "129887765544"
            Expected answer :
            "16468339905558216000"
            */
        
        int output = String2Int(num1);
        System.out.printf("output = %d\n", output);
        
        String res = multiply(num1, num2);
        System.out.printf("res = %s" , res);
    }
    
    public static String multiply(String num1, String num2) {
        // https://leetcode.com/discuss/71593/easiest-java-solution-with-graph-explanation
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        
        for (int i= m-1; i >=0; i--) {
            for (int j= n-1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
                
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int p : pos) if (!(sb.length() == 0 && p == 0 )) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
    private static int String2Int( String num) {
        int len = num.length();
        char[]  chars = num.toCharArray();
        
        int[] bits = new int[num.length()];
        int res = 0;
        
        int i = 0;
        for (char c : num.toCharArray()) {
            bits[i] = (int) (c - '0');
            res += bits[i]* Math.pow(10, len-i-1);
            i++;            
        }
        return res;
    }
}