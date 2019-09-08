package oj;
import java.util.*;

public class LetterCombian {
	/*
	 * idx=2
		t:  , ret: []
		idx=3
		t: a , ret: [b, c]
		t: b , ret: [c, ad, ae, af]
		t: c , ret: [ad, ae, af, bd, be, bf]
		ret: [ad, ae, af, bd, be, bf, cd, ce, cf]

	 */

	public static List<String> letterCombinations(String digits) {
		String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		LinkedList<String> ret = new LinkedList<String>();
		ret.add("");

		for(int i = 0; i < digits.length(); i++) {
			int idx = Integer.parseInt(digits.charAt(i)+"");
			System.out.printf("idx=%d\n", idx);

			while (ret.peek().length() == i) {
				String t = ret.remove();
				System.out.println("t: " + t + " , ret: " + ret);
				for (char s : dict[idx].toCharArray()) {
					ret.add(t + s);
				}
			}

		}
		return ret;
	}

	public static  void main(String[] args) {
		String digits = "23";
		List<String> ret = letterCombinations(digits);
		System.out.println("ret: " + ret);
	}

}
