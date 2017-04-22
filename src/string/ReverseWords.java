//package string;

/*
 * 186. Reverse Words in a String II  QuestionEditorial Solution  My Submissions
Total Accepted: 14384
Total Submissions: 49577
Difficulty: Medium
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?

Related problem: Rotate Array

Hide Company Tags Amazon Microsoft Uber
Hide Tags String
Hide Similar Problems (M) Reverse Words in a String (E) Rotate Array

 */
public class ReverseWords {

	public static void main(String[] args) {
		ReverseWords rw = new ReverseWords();
		String str = "the sky is blue";
		char[] s = str.toCharArray();
		System.out.println(str);
		rw.reverseWords(s);
		// System.out.println(String.valueOf(s));
	}

	// https://discuss.leetcode.com/topic/8366/my-java-solution-with-explanation
	public void reverseWords(char[] s) {
		// Two step to reverse
		// 1, reverse the whole sentence
		reverse(s, 0, s.length - 1);
		System.out.println(String.valueOf(s));

		// 2, reverse each word
		int start = 0;
		for (int i = 0; i <= s.length; i++) {
			if (i == s.length || s[i] == ' ') {
				System.out.println(i);
				reverse(s, start, i - 1);
				System.out.println(String.valueOf(s));
				start = i + 1;
			}
		}

	}

	public void reverse(char[] s, int start, int end) {
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}

}
