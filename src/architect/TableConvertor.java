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
	

	private static HashMap<String, Boolean[]> maps;
	final static String[] operators = {"And", "Not", "Or"};

//	public TestApp() {
//	}

	public static void main(String[] args){
		String result = convert();
		System.out.println(result);
	}
	
	public static String convert() {
		StringBuffer sb = new StringBuffer();
		
		maps = new HashMap<String, Boolean[]>();
		maps.put("A",new Boolean[] {true, false, false});
		maps.put("B",new Boolean[] {true, false, false});
		maps.put("C",new Boolean[] {false, false, true});
		
		for (String key : maps.keySet()) {
		    Boolean[] vals = maps.get(key);
		    int len = vals.length;
		    
			for (int i = 0; i < len; i++) {
				if (vals[i]) {
					sb.append(key + " " + operators[i] + " ");
				}
			}
		}
	    
	
		return sb.toString();
	}

}
