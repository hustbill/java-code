package ood;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class ValidWordAbbr {

    HashMap<String, Set<String>> map;
    

    public ValidWordAbbr(String[] dictionary) {
    	map = new HashMap<>();
    	
        for (String word : dictionary) {
            String key = getAbbr(word);
            if (map.containsKey(key)) {
                map.get(key).add(word);
            } else {
            	Set<String> set = new HashSet<String>();
            	set.add(word);
                map.put(key, set);
            }
        }    
        System.out.print(map);
    }

    public String getAbbr(String word) {
    	StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));
        return sb.toString();
    }
    
    public boolean isUnique(String word) {
    	String key = getAbbr(word);
    	Set<String> set = map.get(key);
    	
    	if (set == null || (set.size() == 1 && set.contains(word))) {
    		return true;  // no abbreviation for word in Map  or only itself in map
    	} 
    	
    	return false;
    }
}


public class UniqueWordAbbreviation {
	public static void main(String[] args) {
	  testcase1();
	  testcase2();
	}
	
	public static void testcase1() {
		String[] dictionary = {"deer", "door", "cake", "card", "Word"};
		// Your ValidWordAbbr object will be instantiated and called as such:
		 ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
		 boolean result1 = vwa.isUnique("Word");		// true
		 boolean result2 = vwa.isUnique("anotherWord"); //true
		 boolean result3 = vwa.isUnique("door");  		// false
		 System.out.printf("%s %s %s\n", result1, result2, result3);
	}
	
	public static void testcase2() {
		String[] dictionary = {"dog"};
		ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
		
		System.out.println(vwa.isUnique("dig"));  // false
		System.out.println(vwa.isUnique("dug"));  // false
		System.out.println(vwa.isUnique("dag"));  // false
		System.out.println(vwa.isUnique("dog"));  // true
		System.out.println(vwa.isUnique("doge"));  // true
	}
	

}
