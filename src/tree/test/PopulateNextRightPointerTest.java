package tree.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tree.PopulateNextRightPointer;
import tree.TreeLinkNode;

public class PopulateNextRightPointerTest {

	private TreeLinkNode root = new TreeLinkNode(1);

	@Before
	public void setUp() throws Exception {

		TreeLinkNode left = new TreeLinkNode(2);
		TreeLinkNode right = new TreeLinkNode(3);
		root.left = left;
		root.right = right;

		TreeLinkNode four = new TreeLinkNode(4);
		TreeLinkNode five = new TreeLinkNode(5);
		left.left = four;
		left.right = five;

		four.right = new TreeLinkNode(8);
		five.left = new TreeLinkNode(9);

		TreeLinkNode six = new TreeLinkNode(6);
		TreeLinkNode seven = new TreeLinkNode(7);

		TreeLinkNode ten = new TreeLinkNode(10);
		TreeLinkNode eleven = new TreeLinkNode(11);

		right.left = six;
		right.right = seven;

		five.right = ten;
		six.left = eleven;
	}

	@Test
	public void testArray() {
		// int[] nums = {-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13};
		// ConvertArrayToBST_108 cbst = new ConvertArrayToBST_108();
		// TreeNode root = cbst.sortedArrayToBST(nums);
		
	}

	@Test
	public void test() {

		PopulateNextRightPointer rnp = new PopulateNextRightPointer();
		rnp.connect(root);

		assertEquals(5, root.left.left.next.val); // 5
		assertEquals(9, root.left.left.right.next.val); // 9

		assertEquals(6, root.left.right.next.val); // 6
		assertEquals(10, root.left.right.left.next.val); // 10

		assertEquals(11, root.left.right.right.next.val); // 11

	}

}
