import java.util.*;

public class LetterCombinations {
	public static List<String> letterCombinations(String digits) {
	// ref1: https://leetcode.com/discuss/29404/easy-understand-java-solution
	// ref2: FIFO Queue : https://leetcode.com/discuss/24431/my-java-solution-with-fifo-queue  i don't try this method.
		String mappings[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            List<String> res = new ArrayList<String>();
		    if (digits.length()==0) return res;
			
			res.add("");

			for(int i=0; i < digits.length(); i++) {
				int key = digits.charAt(i) - '0';
				res = combine(res, mappings[key]);
			}
			return res;
	}
	
	public static List<String> combine(List<String> list, String toBeCombine) {
		List<String> res = new ArrayList<>();
		for(int i=0; i< toBeCombine.length(); i++) {
			for(String x : list) {
				res.add(x + toBeCombine.charAt(i));
			}
		}
		
		return res;
	}
	
   /* public static List<String> letterCombinations1(String digits) {
        Map<Integer, String> map = new HashMap<>();
        
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        List<String>  values = new ArrayList<>(); 
        List<String> res = new ArrayList<>();
        
        for (char c: digits.toCharArray()) {
            int key = (int) (c - '0');
            String str = map.get(key);
            values.add(str);
        }
		//List<Integer, 
		
         char[]  combain = new char[values.size()];
			for(int i=0;  i < values.size(); i++ ) {
				for(int j=0; j < values[i].size(); j++ ) {
					combain[i] = values[i].charAt(j);
					list.add(j, combain[i]);
				}
			}
		
		 
               // for (int i=0; i < values.size(); i++ ) {
					// StringBuilder sb = new StringBuilder(); 
					// for(int j=0; j< values.get(i).length(); j++) {
						 // sb.append(values.get(i).charAt(j));
							// System.out.println("sb = " + sb);					     
					// }
					 // System.out.println("sb = " + sb);
					
			   // }
			   
            
           
        res.add(new String(combain));
        return res;
    }
	*/
	public static void main(String[] args) {
		String str = "23";
		
		System.out.println("letterCombinations(str)) =  " + letterCombinations(str)); 
		
	}
}