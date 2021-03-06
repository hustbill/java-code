package unionfind;

// This is a small JUnit test for the data structure.

//http://www.vogella.com/tutorials/JavaDatastructures/article.html#stack

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void testStackArray() {
    MyStackArray<Integer> stack = new MyStackArray<Integer>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(3);
    stack.push(4);
    assertTrue(4 == stack.pop());
    assertTrue(3 == stack.pop());
    assertTrue(3 == stack.pop());
    assertTrue(2 == stack.pop());
    assertTrue(1 == stack.pop());
  }

  @Test
  public void testStackList() {
	  MyStackArray<Integer> stack = new MyStackArray<Integer>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(3);
    stack.push(4);
    assertTrue(4 == stack.pop());
    assertTrue(3 == stack.pop());
    assertTrue(3 == stack.pop());
    assertTrue(2 == stack.pop());
    assertTrue(1 == stack.pop());
  }

} 