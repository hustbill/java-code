package v201604;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class IsPowerOfTwo_231Test {
	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@Test
	public void isPowerOfTwo() {
		// throw new RuntimeException("Test not implemented");
		IsPowerOfTwo_231 obj = new IsPowerOfTwo_231();
		int[] nums = { 128, 1 };
		for (int n : nums) {
			boolean result = obj.isPowerOfTwo(n);
			Assert.assertEquals(result, true);
		}

		int[] failedNums = { 1280, -16 };

		for (int n : failedNums) {
			boolean result = obj.isPowerOfTwo(n);
			Assert.assertEquals(result, false);
		}
	}

	@Test
	public void isPowerOfThree() {
		IsPowerOfTwo_231 obj = new IsPowerOfTwo_231();
		int[] nums = { 9, 27 };
		for (int n : nums) {
			boolean result = obj.isPowerOfThree(n);
			Assert.assertEquals(result, true);
		}

		int[] failedNums = { 53, -16 };

		for (int n : failedNums) {
			boolean result = obj.isPowerOfThree(n);
			Assert.assertEquals(result, false);
		}
	}
	
	@Test
	public void isPowerOfFour() {
		IsPowerOfTwo_231 obj = new IsPowerOfTwo_231();
		int[] nums = { 16, 1024 };
		for (int n : nums) {
			boolean result = obj.isPowerOfFour(n);
			Assert.assertEquals(result, true);
		}

		int[] failedNums = { 2048, 97, -16};

		for (int n : failedNums) {
			boolean result = obj.isPowerOfFour(n);
			Assert.assertEquals(result, false);
		}
	}
}