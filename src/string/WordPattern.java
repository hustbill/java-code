package string;

import java.util.*;

public class WordPattern {

	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");

		if (words.length != pattern.length()) {
			return false;
		}

		Hashtable<Character, String> table = new Hashtable<>();
		for (int i = 0; i < words.length; i++) {
			char c = pattern.charAt(i);
			if (table.containsKey(c)) {
				if (!table.get(c).equals(words[i])) {
					return false;
				}
			} else {
				if (table.containsValue(words[i])) {
					return false;
				}
				table.put(c, words[i]);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPattern wp = new WordPattern();
		String pattern = "abba";
		String[] strs = {"dog cat cat dog", "dog cat cat fish", "dog dog dog dog"};
		for (String str : strs)
			System.out.println(wp.wordPattern(pattern, str));

	}

}
