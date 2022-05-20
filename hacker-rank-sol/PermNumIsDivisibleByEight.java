import java.util.*;

public class PermNumIsDivisibleByEight {

    /*
     * s= "1280" = 1*1000 + 280 
     * s="1092010203" s= "12742679334532367432466"
     * last 3 digits: ar =[000,008, 016, ... 992]
     * 
     * freq_table = { {0:3} {0:2, 8:1} {0:1, 6:1, 1:1} }
     * 
     * s = 6100 => 1600, 6010, ... => 160, 601, 016 => freq { 1:1, 6:1, 0:1}
     */
    public static boolean solve(String s) {
        // create freq table for last three digits
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        freqMap = getFreqMap(s); // 28 => {2:1 , 8: 1}

        if (freqMap.getOrDefault(0, 0) >= 3)
            return true; // "000"
        if (s.length() < 3) {
            int num = Integer.parseInt(s);
            if (num % 8 == 0)
                return true;
            // reverse num 27 -> 72
            s = (new StringBuilder()).append(s).reverse().toString();
            num = Integer.parseInt(s);
            if (num % 8 == 0)
                return true;
            return false;
        }

        // {000, 008, 016, ..., 104, 112, ... 992}
        for (int i = 0; i < 1000; i += 8) {
            String num = String.valueOf(i);
            if (i < 10) {
                num = "00" + num;
            } else if (i < 100) {
                num = "0" + num;
            }
            HashMap<Integer, Integer> permMap = getFreqMap(num); // { 1:1, 0:1, 4:1}
            boolean isSubMap = checkSubMap(permMap, freqMap);
            if (isSubMap)
                return true;
        }
        return false;
    }

    private static boolean checkSubMap(HashMap<Integer, Integer> permMap, HashMap<Integer, Integer> freqMap) {
        for (int key : permMap.keySet()) { 
            if (!freqMap.containsKey(key)) {
                return false;
            }
            if (freqMap.get(key) < permMap.get(key)) { // f=126, {1:1, 2:1, 6:1} perm {112} {1:2, 2:1}
                return false;
            }
        }
        return true;
    }

    private static HashMap<Integer, Integer> getFreqMap(String n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            int key = c - '0';
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        String[] strs = { "26", "192", "1024", "127924857" };
        for (String num : strs) {
            boolean result = PermNumIsDivisibleByEight.solve(num);
            String res = result ? "YES" : "NO";
            System.out.println(num + " is divisible by 8 ? " + res);
        }
    }
}
