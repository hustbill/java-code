package hashtable;

import java.util.*;

public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
        // https://leetcode.com/discuss/81897/12-lines-java-solution-with-explanation
        //Create a hashmap. key is a number (the offset compared to its first char), 
        /*
         abc => 192021
         bcd => 192021
         acef => 19212324
         xyz => 192021
         az => 1918
         ba => 1918
         a => 19   			// a  is 97 (Dec)   (97 ) %26 = 19
         z => 19
        */
        //value is a list of strings which have the same offset.
        //For each string, convert it to char array 
        
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s : strings) {
            String key = getTag(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        
        // sort map
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
        }
    
        return new ArrayList<List<String>>(map.values());
    }
    
    String getTag(String s){
        int diff = (int)s.charAt(0) - (int)'a';
    
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray())
            sb.append((c+26-diff)%26);  // a  is 97 (Dec)   (97 + 26) %26 = 19
        	// getTag(az) = 1918
    
        return sb.toString();
    }

	public static void main(String[] args) {
		String[] strs = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		
		GroupShiftedStrings gss = new GroupShiftedStrings();
		System.out.println(gss.groupStrings(strs));
	}

}
