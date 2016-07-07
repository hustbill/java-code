/*
 * Micorsoft Azure July 15 OTS
 */
package microsoftOTS;

import java.util.*;

class Pair implements Comparable {

	public char c;
	public int count;

	public Pair(char c, int count) {
		this.c = c;
		this.count = count;
	}

	@Override
	public int compareTo(Object arg0) {
		int res = count - ((Pair) arg0).count;
		if (res != 0) {
			return res;
		}
		return ((Pair) arg0).c - c;
	}

}

public class ReArrangeChars {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReArrangeChars reg = new ReArrangeChars();
		 String[] inputs = { "aaabc",  "aadfggggg",  "aabbbccddee",  "$$aaa&&&bbcc", "$$aaa&&bbcc", "aa", "aacccccccccdf",
		 "aaaaaabbcc" };
		//String[] inputs = { "aa" };

		for (String input : inputs)
			System.out.println(reg.reArrange(input));
	}

	public static String reArrange(String s) {

		char[] arr = s.toCharArray();
		HashMap<Character, Pair> map = new HashMap<Character, Pair>();
		TreeSet<Pair> set = new TreeSet<Pair>();
		for (char c : arr) {
			Pair item = map.get(c);
			if (item == null) {
				item = new Pair(c, 0);
				map.put(c, item);
			}
			set.remove(item);
			item.count++;
			set.add(item);

		}

		Pair prev = null;
		for (int i = 0; i < arr.length; ++i) {
			if (set.size() == 0) {
				return "invalid input";
			}
			Pair curr = set.last();
			set.remove(curr);
			curr.count--;
			arr[i] = curr.c;
			if (prev != null && prev.count > 0) {
				set.add(prev);
			}
			prev = curr;
		}
		return String.valueOf(arr);
	}
}
