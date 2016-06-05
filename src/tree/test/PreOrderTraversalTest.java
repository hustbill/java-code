package tree.test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;

import tree.IsBalanced;
import tree.PreOrderTraversal;
import tree.TreeNode;


public class PreOrderTraversalTest {
	
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
	@Test 
	public void testPreOrderTraversal() {
		//preorderTraversal
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		
		left.left = new TreeNode(4);
		
		PreOrderTraversal preOrder = new PreOrderTraversal();
		List<Integer> result = Arrays.asList(1, 2, 4, 3); 
		
		assertEquals(result, preOrder.preorderTraversal(root));
		
	}
}
