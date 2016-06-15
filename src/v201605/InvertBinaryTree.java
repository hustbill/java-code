package v201605;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.LevelOrderPrint;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        
        root.left = two;
        root.right = seven;
        
        
        two.left = new TreeNode(1);
        two.right = new TreeNode(3);
        
        seven.left = new TreeNode(6);
        seven.right = new TreeNode(9);
        
        System.out.println("Input: ");
        LevelOrderPrint  printer = new LevelOrderPrint();
        printer.levelOrderPrint(root);
        
       TreeNode newTree = invertTree(root);
       System.out.println("\nOutput: ");
       printer.levelOrderPrint(newTree);
    
    }

    // using Deque<TreeNode> stack, do iterative
    /*
     * https://leetcode.com/discuss/40001/straightforward-dfs-recursive-iterative-bfs-solutions
     * use stack data structure 比recursive 更健壮
     */
    public static TreeNode invertTree_iterative(TreeNode root) {
    	if (root == null)  {
    		return root;
    	}
    	
    	Deque<TreeNode> stack = new LinkedList<TreeNode>();
    	//  The name deque is short for "double ended queue" and is usually pronounced "deck". 
    	// https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
    	stack.push(root);
    	
    	while( !stack.isEmpty()) {
    		TreeNode node = stack.pop();
    		TreeNode left = node.left;
    		node.left = node.right;
    		node.right = left;
    		
    		if (node.left != null) {
    			stack.push(node.left);
    		}
    		
    		if (node.right != null) {
    			stack.push(node.right);
    		}
    	}
    	return root;
 
    }
    
    // Finally we can easly convert the above solution to BFS - or so called level order traversal.
    public static TreeNode invertTree(TreeNode root) {
    	if (root == null) {
    		return root;
    	}
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	
    	while( !queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		TreeNode left = node.left;
    		node.left = node.right;
    		node.right = left;
    		
    		if (node.left != null) {
    			queue.offer(node.left);
    		}
    		if (node.right != null) {
    			queue.offer(node.right);
    		}
    	}
    	return root;
    }
    
    
    /*
     * it's no so much scalable - (you can find the problem size
     *  that will overflow the stack and crash your application),
     *   so more robust solution would be to use stack data structure.
     */
    public static TreeNode invertTree_recursive(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        TreeNode newTree = new TreeNode(root.val);
        
        newTree.left  = invertTree_recursive(root.right);
        newTree.right = invertTree_recursive(root.left);
        
        return newTree;
    }
}

