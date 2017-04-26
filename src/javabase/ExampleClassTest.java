package javabase;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExampleClassTest {
	@Test
	public void staticVariableAccess() {
		assertEquals(ExampleClass.EXAMPLE_VALUE, 6);
		
		ExampleClass c1 = new ExampleClass();
		ExampleClass c2 = new ExampleClass();
		c1.EXAMPLE_VALUE = 22; // permitted, but not recommended
		assertEquals(ExampleClass.EXAMPLE_VALUE, 22);
		assertEquals(c2.EXAMPLE_VALUE, 22);
	}

}
