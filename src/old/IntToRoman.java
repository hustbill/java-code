package old;
/*
12. Integer to Romain

Total Accepted: 54390 Total Submissions: 146700 Difficulty: Medium
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Hide Tags Math String
Hide Similar Problems (E) Roman to Integer (M) Integer to English Words

*/

public class IntToRoman {
    public static void main(String[] args) {
        int num = 82;
        String res = intToRoman2(num);
        
        System.out.printf("res = %s", res);
    }
    
    public String intToRoman(int num) {
        // https://leetcode.com/discuss/32626/simple-solution
         String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
    
    public  static String intToRoman2(int number) {
        // ref : http://www.cnblogs.com/springfor/p/3886459.html
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                result.append(numerals[i]);
            }
        }
        return result.toString();
    }
}

