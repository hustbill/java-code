/**
 * 
 */
package architect;

/**
 * @author huazhang
 *
 */

import java.util.*;

public class TableConvertor {

	/**
	 * @param args
	 */

	
	private static HashMap<String, Boolean[]> map;
	final static String[] operators = { "and", "and not", "or" };
	static TableConvertor covertor = new TableConvertor();
	
	public static void main(String[] args) {
		map = new HashMap<String, Boolean[]>();
		map.put("A", new Boolean[] { true, false, false });
		map.put("B", new Boolean[] { true, false, false });
		map.put("C", new Boolean[] { true, false, false });
		System.out.println(covertor.convertMapToExpression(map));
	}

	public String convertMapToExpression(HashMap<String, Boolean[]> map) {
		
		StringBuilder sb = new StringBuilder();
		
		int countNot = 0;  // count of "Not"

		for (String key : map.keySet()) {
			Boolean[] vals = map.get(key);
			int len = vals.length;

			for (int i = 0; i < len; i++) {
				if (vals[i]) {
					if (i == 1) {
						countNot++;
						if (countNot > 1) {
							throw new IllegalArgumentException("Error: 'Not' has at most one");
						}
					}
					if( sb.length() != 0 ) {
						sb.append(" " + operators[i] + " ");
					}
					sb.append( key );
				}
			}
		}
		
//		String str = sb.toString();
//		result = str.substring(str.indexOf(" "));  // remove first operator :  and A and B or C =>  A and B or C 
		
		// add parentheses
		//  A and B or C  = >  (A and B) or C 
		
		return  addParentheses(sb.toString());
	}
	
	public String addParentheses(String s) {
		StringBuilder sb = new StringBuilder();
		
		String[] words  = s.split(" ");
		int first = 1, index = 0, opIndex = 1;
		
		sb.append("(");
		
		
		while (opIndex < words.length - 1 && index < words.length - 1) {
			sb.append(words[index]);
			index++;
			
			if (words[opIndex]  == words[first]) {
				opIndex += 2;
			}
		}
		
		String result = "";
		
		
		// A and B or C
		int firstIndx = s.indexOf("and");
		int secondIndx = s.indexOf("and", firstIndx)  + "and B".length();
		
		result = "(" + s.substring(0,secondIndx) + ") " + s.substring(secondIndx+ 1);
		return sb.toString();
	}

}
