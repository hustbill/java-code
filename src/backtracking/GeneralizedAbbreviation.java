/*
 * 320. Generalized Abbreviation
 * Difficulty: Medium
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Hide Company Tags Google
Hide Tags Backtracking Bit Manipulation
Hide Similar Problems (M) Subsets (E) Unique Word Abbreviation

 */
package backtracking;

import java.util.*;

public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
		/*
		 * https://discuss.leetcode.com/topic/32270/java-backtracking-solution
		 * https://discuss.leetcode.com/topic/32765/java-14ms-beats-100
		 * 
		 * 
		 * idea: for each character, we can keep it or abbreviate it. 
		 * 
		 * 1) To keep it, we add it to the current position and carry on backtracking.
		 * 
		 * 2) To abbreviate it, we omit it in the current solution, but
		 * increment the count, which indiciates how many chars have we
		 * abbreviated.
		 * 
		 * 3) When we reach the end or need to put a character in the current
		 * solution, and count is bigger than zero, we add the number into the
		 * solution.
		 * 
		 * 
		 */
		List<String> res = new ArrayList<>();

		backtrack(word, 0, 0, "", res);
		return res;
	}

	public void backtrack(String word, int pos, int count, String cur, List<String> res) {

		if (pos == word.length()) {
			if (count > 0) {
				cur += count;
			}
			res.add(cur);
		} else {
			// abbr word.charAt(pos)
			backtrack(word, pos + 1, count + 1, cur, res);
			backtrack(word, pos + 1, 0, cur + (count > 0 ? count : "") + word.charAt(pos), res);

		}

	}

	public static void main(String[] args) {
		GeneralizedAbbreviation gav = new GeneralizedAbbreviation();
		String word = "word";
		System.out.print(gav.generateAbbreviations(word));

	}

}
