package tree.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tree.IsBalanced;
import tree.TreeNode;

public class IsBalancedTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		IsBalanced ibtr = new IsBalanced();
		assertEquals(true, ibtr.isBalanced(root));
		
		TreeNode left = new TreeNode(2);
		root.left = left;
		left.left = new TreeNode(3);
		assertEquals(false, ibtr.isBalanced(root));
		
	}
	


}
