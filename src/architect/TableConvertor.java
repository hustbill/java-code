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

	public static void transfer() {
		String s[] = { "a", "b", "c", "d" };
		double d[][] = { { 0.50, 0.20, 0.20, 0.30 }, { 0.50, 1.10, 0.50, 0.80 }, { 0.50, 0.70, 0.40 }, { 0.50, 0.70 },
				{ 0.50 }, };
		System.out.println(Arrays.toString(s));
		System.out.println(Arrays.deepToString(d));
	}

	public static void main(String[] args) {
		// test case 1
		map = new HashMap<String, Boolean[]>();
		map.put("A", new Boolean[] { true, false, false });
		map.put("B", new Boolean[] { true, false, false });
		map.put("C", new Boolean[] { false, false, true });
		String result = convert(map);
		System.out.println(result);

		// test case 2
		map = new HashMap<String, Boolean[]>();
		map.put("A", new Boolean[] { true, false, false });
		map.put("B", new Boolean[] { true, false, false });
		map.put("C", new Boolean[] { true, false, false });
		result = convert(map);
		System.out.println(result);

		// test case 3
		map = new HashMap<String, Boolean[]>();
		map.put("A", new Boolean[] { true, false, false });
		map.put("B", new Boolean[] { true, false, false });
		map.put("C", new Boolean[] { false, false, true });
		map.put("D", new Boolean[] { false, true,  false});
		map.put("E", new Boolean[] { false, true, false });
		result = convert(map);
		System.out.println(result);

		// test case 4
		map = new HashMap<String, Boolean[]>();
		map.put("A", new Boolean[] { false, false, true });
		map.put("B", new Boolean[] { false, false, true });
		map.put("C", new Boolean[] { false, true, false });
		result = convert(map);
		System.out.println(result);

	}

	public static String convert(HashMap<String, Boolean[]> map) {
		String result = "";
		StringBuffer sb = new StringBuffer();
		boolean[][] arr = new boolean[map.keySet().size()][map.values().size()];
		int count = 0;  // count of "Not"

		for (String key : map.keySet()) {
			Boolean[] vals = map.get(key);
			int len = vals.length;

			for (int i = 0; i < len; i++) {
				if (vals[i]) {
					sb.append(operators[i] + " " + key + " ");
					if (i == 1) {
						count++;
						if (count > 1) {
							System.out.println(" Error: 'Not' has at most one");
							return "";
						}
					}
				}
			}
		}
		
		String str = sb.toString();
		result = str.substring(str.indexOf(" "));
		return result;
	}

}
