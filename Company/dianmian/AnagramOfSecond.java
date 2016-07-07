package dianmian;

import java.util.*;

public class AnagramOfSecond {
	/*
	 * # 2. anagramsOf(word) # # anagramsOf("post") --> ["pots", "spot", "stop",
	 * "tops"] # anagramsOf("dictionary") --> ["indicatory"] #
	 * anagramsOf("anagram") --> [] # # Given a text file of English language
	 * words, and preprocessing time, how would you solve this?
	 */

	private static final Set<String> DICTIONARY=new HashSet<String>(){{add("post");add("pots");add("spot");add("stop");add("tops");add("indicatory");add("dictionary");add("anagram");}};

	public void preprocess() {
		Set<String> result = new HashSet<>();
		HashMap<Integer, ArrayList<String>> map = new HashMap<>();

		for (String str : DICTIONARY) {
			int[] count = new int[26];
			for (int i = 0; i < str.length(); i++) {
				count[str.charAt(i) - 'a']++;

			}
			int hash = getHash(count);
			if (!map.containsKey(hash)) {
				map.put(hash, new ArrayList<>());
			}
			map.get(hash).add(str);
		}
		System.out.println(map);
	}

	// public Set<String> anagramsOf(String word) {
	// for
	//
	// }

	private int getHash(int[] count) {
		int hash = 0;
		int a = 378551;
		int b = 63689;
		for (int num : count) {
			hash = hash * a + num;
			a = a * b;
		}
		return hash;
	}

	public static void main(String[] args) {
		AnagramOfSecond af = new AnagramOfSecond();
		af.preprocess();
		// System.out.println(af.anagramsOf("post"));
		// System.out.println(af.anagramsOf("dictionary"));
		// System.out.println(af.anagramsOf("anagram"));

	}
	
	private String getKey(String input) {
		char[] ca = input.toCharArray();
		Arrays.sort(ca);
		return new String(ca);
	}

}
