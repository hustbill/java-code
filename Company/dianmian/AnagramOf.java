package dianmian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * # 2. anagramsOf(word)
#
#    anagramsOf("post") --> ["pots", "spot", "stop", "tops"]
#    anagramsOf("dictionary") --> ["indicatory"]
#    anagramsOf("anagram") --> []
#
# Given a text file of English language words, and preprocessing time, how would you solve this?
private final Set<String> DICTIONARY = ...;
private void preprocess() {
}
public Set<String> anagramsOf(String word) {
}
time complexity O(1), no space limit.
 */

public class AnagramOf {
	Map<String, Set<String>> map;

	private static final Set<String> DICTIONARY = new HashSet<String>() {
		{
			add("post");
			add("pots");
			add("spot");
			add("stop");
			add("tops");
			add("indicatory");
			add("dictionary");
			add("anagram");
		}
	};

	public static void main(String[] args) {
		AnagramOf af = new AnagramOf();
		af.preprocess();
		System.out.println(af.anagramsOf("post"));
		System.out.println(af.anagramsOf("dictionary"));
		System.out.println(af.anagramsOf("anagram"));
	}

	/*
	 * Open dictionary Create empty HashMap<String, Set<String>> map
	 * 
	 * For each word in dictionary: Create a key that is the word's letters
	 * sorted alphabetically, e.g. “stop” -> key “post"
	 * 
	 * Add the word to the list of words accessed by the hash key in map
	 */
	private void preprocess() {
		map = new HashMap<>();
		for (String in : DICTIONARY) {
			String key = getAnagram(in);
			if (map.containsKey(key)) {
				map.get(key).add(in);
			} else {
				Set<String> set = new HashSet<>();
				set.add(in);
				map.put(key, set);
			}
		}
		System.out.println(map);
	}

	/*
	 * O(1) look-up time complexity
	 * 
	 * Create a key that is the letters of the word, sorted. e.g
	 * “god" -> key “dog" 
	 * Look up that key in map
	 */
	public Set<String> anagramsOf(String word) {
		String key = getAnagram(word);
		Set<String> result = map.get(key);
		result.remove(word);
		return result;
	}

	private String getAnagram(String input) {
		char[] ca = input.toCharArray();
		Arrays.sort(ca);
		return new String(ca);
	}
}