package bit;

import java.util.*;

public class FindRepeatedDNASequence {
	/*
	 * Solution 1: bit
	 * https://discuss.leetcode.com/topic/8894/clean-java-solution-hashmap-bits-
	 * manipulation/3 The key point is that it is not doing hash, it is doing
	 * the exact coding of a 10-letter sequence into a 4-bytes number, which is
	 * simply not possible for any generic string, but is possible for strings
	 * in this problem because they can have only 4 differfent characters.
	 * 
	 * So we have only 4 possible letters, and we can use as little bits as
	 * possible to store each character of our 10-letter string. We really need
	 * only 2 bits (bits, not bytes) for this. Specifically the solution uses
	 * the following coding:
	 * 
	 * 0 = 00 (bits in binary number system) = 'A'
	 * 
	 * 1 = 01 (bits in binary number system) = 'C'
	 * 
	 * 2 = 10 (bits in binary number system) = 'G'
	 * 
	 * 3 = 11 (bits in binary number system) = 'T'
	 * 
	 * Note that since there 10 letters and each letter requires only 2 bits, we
	 * will need only 10 * 2= 20 bits to code the string (which is less then
	 * size of integer in java (as well as in all othere popular languages),
	 * which is 4 bytes = 32 bits).
	 * 
	 * 
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		Set<Integer> words = new HashSet<>();
		Set<Integer> doubleWords = new HashSet<>();
		List<String> rv = new ArrayList<>();
		char[] map = new char[26];
		// map['A' - 'A'] = 0;
		map['C' - 'A'] = 1;
		map['G' - 'A'] = 2;
		map['T' - 'A'] = 3;

		for (int i = 0; i < s.length() - 9; i++) {
			int v = 0;
			for (int j = i; j < i + 10; j++) {
				v <<= 2;
				v |= map[s.charAt(j) - 'A'];
			}
			if (!words.add(v) && doubleWords.add(v)) {
				rv.add(s.substring(i, i + 10));
			}
		}
		return rv;
	}

	// use two hashsets, beat 90%
	/*
	 * my idea is to get all the possible 10 letter long sequences and put them
	 * into set, it the operation failed, it means there are duplicates. so put
	 * the sequence into another set("AAAAAAAAAAAA" could have three
	 * "AAAAAAAAAA" sequences, so this set will remove the duplicates) 
	 */

	public List<String> findRepeatedDnaSequencesSet(String s) {
		Set seen = new HashSet(), repeated = new HashSet();
		for (int i = 0; i + 9 < s.length(); i++) {
			String ten = s.substring(i, i + 10);
			if (!seen.add(ten))
				repeated.add(ten);
		}
		return new ArrayList(repeated);
	}

	public static void main(String[] args) {
		String s = "AAAAAAAAAAA";

		FindRepeatedDNASequence frds = new FindRepeatedDNASequence();
		List<String> result = frds.findRepeatedDnaSequences(s);
		System.out.println(result);
	}

}
