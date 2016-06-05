package tree.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tree.VerifyPreOrderBST;

public class VerifyPreOrderBSTTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int[] preorderFailed = { 4, 2, 1, 3, 6, 7, 3};
		VerifyPreOrderBST verify = new VerifyPreOrderBST();
		assertEquals(false, verify.verifyPreorder(preorderFailed));
		
		int[] preorder = { 4, 2, 1, 3, 6, 7, 9};
		assertEquals(true, verify.verifyPreorder(preorder));
	}

}
