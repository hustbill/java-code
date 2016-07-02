package microsoftOTS;

import java.util.*;

public class ChangeStrNotReatTwice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChangeStrNotReatTwice csr = new ChangeStrNotReatTwice();
		//String[] inputs = { "aaabc", "aa", "aadfggggg", "aacccccccccdf", "aaaaaabbcc" , "$$aaa&&&bbcc", "aabbbccddee", "$$aaa&&bbcc"};
		String[] inputs = { "ccddee"};

		for (String input : inputs)
			System.out.println(csr.reorgReaptChars(input));
	}

	public String reorgReaptChars(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] result = new char[s.length() * 2];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		int evenIndex = 0;
		int oddIndex = 1;

		for (Map.Entry<Character, Integer> entry : list) {
			if (evenIndex < oddIndex) {
				for (int index = 0; index < entry.getValue(); index++) {
					result[evenIndex] = entry.getKey();
					evenIndex += 2;
				}
			} else {
				for (int index = 0; index < entry.getValue(); index++) {
					result[oddIndex] = entry.getKey();
					oddIndex += 2;
				}
			}
		}

		String out = String.valueOf(result).trim();

		String str = out.replaceAll("\0", "");

		if (isDuplicate(str)) {
			return "invalid input";
		}

		return str;

	}

	public boolean isDuplicate(String result) {
		String s = result.trim();
		int left = 0, right = 1;
		while (left < right && right < s.length()) {
			if (s.charAt(left) == s.charAt(right)) {
				return true;
			} else {
				left++;
				right++;
			}
		}
		return false;
	}

}
