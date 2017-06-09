package javabase;

import java.util.*;

public class FizzBuzz {
	public void main(String[] args) {
		final int n = 16;
		List<String> result = alternativeFizzBuzz(n);
		System.out.printf("n = %d", n);
		System.out.printf("result = %s ", String.valueOf(result.toArray()));
	}

	public static List<String> alternativeFizzBuzz(final int n) {
		List<String> result = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			final String word = toWord(3, i, "Fizz") + toWord(5, i, "Buzz");
			if (word == "") {
				result.add(Integer.toString(i));
			} else {
				result.add(word);
			}
		}

		return result;
	}

	private static String toWord(final int divisor, final int value,
			final String word) {
		return value % divisor == 0 ? word : "";
	}
}
