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
    //throw new RuntimeException("Test not implemented");
	  IsPowerOfTwo_231 obj = new IsPowerOfTwo_231();
	  boolean result = obj.isPowerOfTwo(128);
	  Assert.assertEquals(result, true);
  }
}
