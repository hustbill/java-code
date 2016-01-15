/* 22.
Date: 2016.01.14

https://leetcode.com/problems/generate-parentheses/
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"


*/

import java.util.*;

public class GenerateParenthesis {
    public static  List<String> generateParenthesis(int n) {
        /*
            The idea here is to only add '(' and ')' that we know will guarantee us a solution 
            (instead of adding 1 too many close). 
            Once we add a '(' we will then discard it and try a ')'
             which can only close a valid '('. Each of these steps are recursively called.
            https://leetcode.com/discuss/25063/easy-to-understand-java-backtracking-solution
        */
        List<String> res = new ArrayList<String>();
        backtrack(res, "", 0, 0, n);
        return res;
        
    }
    
    public static void backtrack(List<String> res , String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            res.add(str);
            return;
        }
        if (open < max) {
            backtrack(res, str+"(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(res, str+ ")", open, close + 1, max);
        }
    }
    
    public static void main(String[] args) {
        int n = 3;
        List<String> res = generateParenthesis(3);
        System.out.println(Arrays.toString(res.toArray()));
    }
}