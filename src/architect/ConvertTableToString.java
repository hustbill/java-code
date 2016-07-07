package architect;

import java.util.*;

public class ConvertTableToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		
		ArrayList<Integer> list  =  new ArrayList<Integer>();
		list.add(1);
		list.add(0);
		list.add(0);
		map.put("A",list);
		
		ArrayList<Integer> list2  =  new ArrayList<Integer>();
		list2.add(1);
		list2.add(0);
		list2.add(0);
		map.put("B", list2);
		
		ArrayList<Integer> list3  =  new ArrayList<Integer>();
		list3.add(0);
		list3.add(0);
		list3.add(1);
		map.put("C", list3);
		
		
		String result = convertTableToString(map);
		System.out.println(result);
	}
	
	// Convert table to String
	public static String convertTableToString(HashMap<String, List<Integer>> map) {
		String result = "";
		String[] operators = {"And", "Or", "Not"};
		Set<String> set = map.keySet();
		for (String key : set) {
			result += "\n" + key + " " + map.get(key);
			List<Integer> list = map.get(key);
			for(int i : list ) {
				
			}
			
		}
		return result;
	}
	


}
