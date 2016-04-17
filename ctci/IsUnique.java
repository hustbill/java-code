/* ctci page 99 
Implement an algorithm to determinate if a string has all unique characters. 
What if you cannot use additional data structure?

*/

import java.util.*;

public class IsUnique {
    public static void main(String[] args) {
        String str = "hello";
        System.out.printf("Test case %s \n", isUnique(str) == false ? "success" : "failed");
            System.out.printf("Test case %s ", isUniqueChars(str) == false ? "success" : "failed");
    }
    
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) return false; //ASCII string
        boolean[] char_set = new boolean[128];
        
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) { // Already found this char in string
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
    
    public static boolean isUnique(String str) {
        Hashtable<Character, Integer> ht = new Hashtable<>();
        
        for (char c: str.toCharArray()) {
            if (ht.containsKey(c)) {
                int count =  ht.get(c) + 1;
                ht.put(c, count);
            } else {
                ht.put(c, 1);
            }
        }
        
        for (int i : ht.values()) {
            if (i > 1) {
                return false;
            }
        }
        
        return true;
        
    }
    
    
}