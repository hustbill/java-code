package old;
/*
 * 171. Excel Sheet Column Number   My Submissions QuestionEditorial Solution
Total Accepted: 76218 Total Submissions: 183560 Difficulty: Easy
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Company Tags Microsoft Uber
Hide Tags Math
Hide Similar Problems (E) Excel Sheet Column Title

https://leetcode.com/problems/excel-sheet-column-number/
 */
public class Title2Number_171 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "CBABBBB";

		System.out.printf("Test case %s", titleToNumber(s) == 951003614 ? "success" : "failed");

	}

	public static int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = result * 26 + (s.charAt(i) - 'A' + 1);
		}
		
		return result;
	}

	public static int titleToNumber_mine(String s) {
		int result = 0, bit = 0;

		int n = s.length();
		for (int i = 0; i < n; i++) {
			bit = (s.charAt(i) - 'A') + 1;
			result += bit * Math.pow(26, n - 1 - i);

		}

		return result;
	}

}
