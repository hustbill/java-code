/*
 * 211. Add and Search Word - Data structure design 
Total Accepted: 26724 Total Submissions: 132071 Difficulty: Medium
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

click to show hint.

Hide Company Tags Facebook
Hide Tags Backtracking Trie Design
Hide Similar Problems (M) Implement Trie (Prefix Tree)
 */
package backtracking;

import java.util.*;

public class WordDictionary {
	HashMap<Integer, List<String>> map = new HashMap<>();

	// Adds a word into the data structure.
	public void addWord(String word) {
		int index = word.length();
		if (!map.containsKey(index)) {
			List<String> list = new ArrayList<String>();
			list.add(word);
			map.put(index, list);
		} else {
			map.get(index).add(word);
		}
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		int index = word.length();
		if (!map.containsKey(index)) {
			return false;
		}

		List<String> list = map.get(index);
		for (String s : list) {
			if (isSame(s, word)) {
				return true;
			}
		}

		return false;
	}

	public boolean isSame(String s, String word) {
		if (s.length() != word.length()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (word.charAt(i) != '.' && s.charAt(i) != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("word");
		System.out.println(wordDictionary.search("pattern"));
		System.out.println(wordDictionary.search("word"));

		wordDictionary.addWord("abc");
		System.out.println(wordDictionary.search("abc"));
		System.out.println(wordDictionary.search("a.c"));
		System.out.println(wordDictionary.search("..c"));
		System.out.println(wordDictionary.search(".b."));
		System.out.println(wordDictionary.search("abcd"));

	}

}
