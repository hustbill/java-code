package v201604;

/*
 * 249. Group Shifted Strings   My Submissions QuestionEditorial Solution
Total Accepted: 8782 Total Submissions: 28048 Difficulty: Easy
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic order.

Hide Company Tags Google Uber
Hide Tags Hash Table String
Hide Similar Problems (M) Group Anagrams

 */

import java.util.*;

public class GroupStrings_249 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
		List<List<String>> result = groupStrings(strings);
		System.out.print(result);

	}

	public static List<List<String>> groupStrings(String[] strings) {
		// https://leetcode.com/discuss/81897/12-lines-java-solution-with-explanation
		// Create a hashmap. key is a number (the offset compared to its first
		// char),
		/*
		 * abc => 192021 bcd => 192021 acef => 19212324 xyz => 192021 az => 1918
		 * ba => 1918 a => 19 z => 19
		 */
		// value is a list of strings which have the same offset.
		// For each string, convert it to char array

		HashMap<String, List<String>> map = new HashMap<>();

		for (String s : strings) {
			// String key = getTag(s);
			String key = "";
			int offset = s.charAt(0) - 'a';
			for (int i = 0; i < s.length(); i++) {
				// a  is 97 (Dec)   (97 + 26) %26 = 19
				key += (s.charAt(i) + 26 - offset) % 26;
			}
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

	String getTag(String s) {
		int diff = (int) s.charAt(0) - (int) 'a';
		

		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray())
			sb.append((c + 26 - diff) % 26);

		return sb.toString();
	}
}