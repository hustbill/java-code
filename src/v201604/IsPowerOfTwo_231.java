package v201604;
/*
 * Power of 231 Two, 326.Three, 342.Four
 * 
 * 342. Power of Four   My Submissions QuestionEditorial Solution
Total Accepted: 6545 Total Submissions: 19526 Difficulty: Easy
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

Credits:
Special thanks to @yukuairoy for adding this problem and creating all test cases.

Hide Company Tags Two Sigma
Hide Tags Bit Manipulation
Hide Similar Problems (E) Power of Two (E) Power of Three

 * 
 * 231. Power of Two   My Submissions QuestionEditorial Solution
Total Accepted: 69865 Total Submissions: 191640 Difficulty: Easy
Given an integer, write a function to determine if it is a power of two.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Math Bit Manipulation
Hide Similar Problems (E) Number of 1 Bits (E) Power of Three (E) Power of Four


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
		
		n = 9;
		System.out.println(isPowerOfThree(n));

		n = 4;
		System.out.println(isPowerOfFour(n));

		n = 2048;
		System.out.println(isPowerOfFour(n));

	}

	
	/*
    Using regular expression 
    n = 3, Integer.toString(n,3)  = 10 
    n = 9, Integer.toString(n,3)  = 100
    n = 27, Integer.toString(n,3) = 1000
  */
  public static boolean isPowerOfThree(int n) {
      return Integer.toString(n, 3).matches("10*");
  }   
  
	// using regx
	// since power of four is like, 100, 10000, 1000000
	/* https://leetcode.com/discuss/97967/java-1-line-of-code-and-can-be-extended-to-any-radix-solution?show=97967#q97967
	 * The idea is that numbers in quaternary system that is power of 4 will be like 10, 100, 1000 and such. 
	 * Similar to binary case. And this can be extended to any radix.
	 * num = 4 is power of 4 : Integer.toString(num, 4) = 10 => true
	 * 
	 * num = 1024 is power of 4 : Integer.toString(num, 4) = 100000 => true
	 * 
	 * num = 2048 is not power of 4: Integer.toString(num, 4) = 200000 = > false
	 * 
	 */
	public static boolean isPowerOfFour(int num) {
		return Integer.toString(num, 4).matches("10*");
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
		return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree_recursive(n / 3)));
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
