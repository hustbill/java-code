package architect;

import java.util.*;

public class String2Array {

	static List<String> wordList = new ArrayList<String>();
	static int wordIndex = -1;

	public static void main(String[] args) throws Exception {
		GetChunks("(true AND (true OR false)) OR ((true AND false) OR false)");
		// Now we know how many items we have, convert the List to an array,
		// as this is what the solution specified.

		for (String word : wordList) {
			System.out.println(word);
		}
	}

	private static void GetChunks(String text) throws Exception {
		int start;
		int end = text.indexOf(')');
		if (end > -1) {
			start = text.lastIndexOf('(', end - 1);
			if (start == -1) {
				throw new Exception("Mismatched parentheses" + text);
			}
			wordList.add(text.substring(start, end - start + 1));
			wordIndex++;
			text = text.substring(0, start) + wordIndex + text.substring(end + 1);

			GetChunks(text);
		} else {
			// no more ) in text, just add what's left to the List.
			wordList.add(text);
		}
	}
}