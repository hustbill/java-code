package old;
/*93. Restore IP Addresses
Total Accepted: 50015 Total Submissions: 220919 Difficulty: Medium
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

Hide Tags Backtracking String*/

import java.util.*;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = restoreIpAddresses(s);
        System.out.print(res);
    }
    
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        String temp = "";
        int len = s.length();
        int[] bits = { 1, 2, 3};
        
        for (int i=0; i < bits.length; i++) {
            temp = s.substring(0, bits[i]);
            res.add(temp + ".");
            backtrack(res, s.substring(bits[i]));
        }
        return res;
    }
    
    public static void backtrack(List<String> res, String s) {
        int[] bits = {1, 2, 3}; 
        if (s.length() == 0) {
            return ;
        } 
        for (int i=0; i < bits.length; i++) {
            String temp = s.substring(0, bits[i]);
            res.add(temp + ".");
            backtrack(res, s.substring(bits[i]));
        }
    }
}
