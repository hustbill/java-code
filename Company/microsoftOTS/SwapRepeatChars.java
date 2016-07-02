/*
 * 1. change string so that no character repeats twice
     example 1
     input: aaabc
     output: abaca
     example 2
           input: aa
          output: invalid input
 */
package microsoftOTS;

public class SwapRepeatChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapRepeatChars swrc = new SwapRepeatChars();
		String[] inputs = { "ccddee", "aaabc", "aa" ,  "aaa", "aadfggggg", "aadfgggg" , "aabbbccddee"};
		for (String input : inputs)
			System.out.println(swrc.swapChars(input));

	}

	public String swapChars(String s) {
		int len = s.length();
		if (s == null || s.length() < 2)
			return s;
		char[] arr = s.toCharArray();

		for (int i = 1; i < len; i++) {
			if (arr[i] != arr[i - 1])
				continue;
			int cur = i, next = i + 1;

			while (next < len && arr[cur] == arr[next])
				next++; // find a different char
			if (next == len)
				return "invalid string"; // no chars can be swapped.
			swap(arr, cur, next);
		}
		return new String(arr);
	}

	public void swap(char[] arr, int i, int j) {
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}

}
