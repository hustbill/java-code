/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (42.66%)
 * Total Accepted:    438.6K
 * Total Submissions: 1M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
import java.util.*;

class Solution {

    	/*
	 * idx=2
		t:  , ret: []
		idx=3
		t: a , ret: [b, c]
		t: b , ret: [c, ad, ae, af]
		t: c , ret: [ad, ae, af, bd, be, bf]
		ret: [ad, ae, af, bd, be, bf, cd, ce, cf]

	 */

	public List<String> letterCombinations(String digits) {
		String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		LinkedList<String> ret = new LinkedList<String>();
		if (digits == null || digits.length() == 0) return ret;
        ret.add("");

		for(int i = 0; i < digits.length(); i++) {
			int idx = Integer.parseInt(digits.charAt(i)+"");
			// System.out.printf("idx=%d\n", idx);

			while (ret.peek().length() == i) {
				String t = ret.remove();
				// System.out.println("t: " + t + " , ret: " + ret);
				for (char s : dict[idx].toCharArray()) {
					ret.add(t + s);
				}
			}

		}
		return ret;
	}

    public List<String> letterCombinations_nok(String digits) {
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> ret = new LinkedList<String>();
        ret.add("");
        for(int i = 0; i < digits.length(); i++) {
            int idx = Integer.parseInt(digits.charAt(i)+"");
            for (int j = 0; j < dict[idx].length(); j++) {
                if (ret.peek().length() == i) {
                    String t = ret.remove();
                    String s = Character.toString(dict[idx].charAt(j));
                    ret.add(t + s);
                }
            }
        }
        return ret;
    }

    public void main(String[] args) {
        String digits = "23";
        List<String> ret = letterCombinations(digits);
        System.out.println("ret: " + ret);
    }

}
