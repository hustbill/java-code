package tree.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tree.NumTree;

public class NumTreeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		NumTree nt = new NumTree();
		int n = 3;
		assertEquals(4, nt.numTrees(n) );
	}

}
