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
	public void testPreOrderTraversal() {
		//preorderTraversal
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(5);
		root.left = left;
		root.right = right;
		
		left.left = new TreeNode(3);
		left.right = new TreeNode(4);
		
		right.left = new TreeNode(6);
		right.right = new TreeNode(7);
		
		
		PreOrderTraversal preOrder = new PreOrderTraversal();
		List<Integer> result = Arrays.asList(1, 2, 3, 4, 5, 6, 7); 
		
		assertEquals(result, preOrder.preorderTraversal(root));
		
	}
	
	@Test 
	public void testPreOrderTraversal_recursive() {
		//preorderTraversal
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		
		left.left = new TreeNode(4);
		
		PreOrderTraversal preOrder = new PreOrderTraversal();
		List<Integer> result = Arrays.asList(1, 2, 4, 3); 
		
		assertEquals(result, preOrder.preorderTraversal_recursive(root));
		
	}
}
