package v201604;
/*
 * 
 * 
 * 326. Power of Three   My Submissions QuestionEditorial Solution
Total Accepted: 37366 Total Submissions: 102354 Difficulty: Easy
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Math
Hide Similar Problems (E) Power of Two (E) Power of Four

 * 
 */

public class IsPowerOfTwo_231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 128;

		System.out.println(isPowerOfTwo(n));

		n = 256 * 8 * 3;
		System.out.println(isPowerOfTwo(n));

		n = 1;
		System.out.println(isPowerOfTwo(n));

		n = -16;
		System.out.println(isPowerOfTwo(n));

	}

	public static boolean isPowerOfTwo(int n) {
		/*
		 * https://leetcode.com/discuss/43875/using-n%26-n-1-trick Ref: Power of
		 * 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to
		 * judge whether that is the case
		 */
		return (n > 0 && (n & (n - 1)) == 0);

	}

	public static boolean isPowerOfTwo_optimize(int n) {
		if (n > 1) {
			while (n % 2 == 0) {
				n = n / 2;
			}
		}
		return n == 1;
	}

	public boolean isPowerOfTwo_mine(int n) {
		if (n <= 0)
			return false;

		if (n == 1)
			return true;

		while (n > 2 && n % 2 == 0) {
			n = n / 2;
		}

		return n % 2 == 0;

	}

	// Recursive Solution
	public boolean isPowerOfThree_recursive(int n) {
		return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree(n / 3)));
	}

	// Iterative Solution
	public boolean isPowerOfThree_itetration(int n) {
		if (n > 1)
			while (n % 3 == 0)
				n /= 3;
		return n == 1;
	}

	// Ref :
	// https://leetcode.com/discuss/78532/summary-all-solutions-new-method-included-at-15-30pm-jan-8th
	public boolean isPowerOfThree_mine(int n) {
		if (n <= 0)
			return false;
		if (n == 1)
			return true;

		while (n > 3 && n % 3 == 0) {
			n = n / 3;
		}
		return n % 3 == 0;
	}

}
