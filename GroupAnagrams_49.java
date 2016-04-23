import java.util.*;

public class GroupAnagrams_49 {
    
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        System.out.print(groupAnagrams(strs));
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result  = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) return result;
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>(); 
        //Arrays.sort(strs);
        
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(s);
        }
        
        // sort map save 10 ms than sort whole array
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        return new ArrayList<List<String>>(map.values());
    }
    
    public boolean isAnagrams(String a, String b) {
        if (a == b) return true;
        int n = a.length();
        int[] bits = new int[n];
        
        for (char c : a.toCharArray()) {
            bits[c] = 1;
        }
        
        for (char c : b.toCharArray()) {
            bits[c] += 1;
        }
        
        for (int i : bits) {
            if (i != 2) return false;
        }
        
        return true;
    }
}