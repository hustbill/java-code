package old;
// write a method to replace all whites spaces in a string with 20%
// new York --> new%20York20%20%
// Date: March 15, 2016
// Desc:  Interview for Sony technical interview

import java.util.*;

public class SonyReplaceWhiteSpace {
    public static void main(String[] args) {
        String input = "new York";
        System.out.printf("result = %s", replaceWhiteSpace(input));
    }
    
    public static String replaceWhiteSpace( String str) {
        String result = "";
        
        if (str == null || str.length() == 0)  return result;
        
        int n = str.length();
        HashMap<Integer, String> map = new HashMap<>();

        char[] arr = str.toCharArray();

         for (int i = n -1 ; i >= 0 ; i-- ) {
           if (arr[i] == ' ')  {
              String temp = "%20";
                 map.put(i, temp);
            }  else {
                map.put(i, String.valueOf(arr[i]));
            }

        }

        for ( String val : map.values()) {
            result += val;
        }
        //result = str.replaceAll(" ", "%20");
        return result;
    }
}