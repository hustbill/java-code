package tree;

/*173. Binary Search Tree Iterator
Total Accepted: 38767 Total Submissions: 118060 Difficulty: Medium
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
Hide Company Tags LinkedIn Google Facebook Microsoft
Hide Tags Tree Stack Design
Hide Similar Problems (M) Binary Tree Inorder Traversal (M) Flatten 2D Vector (M) Zigzag Iterator (M) Peeking Iterator (M) Inorder Successor in BST */

import java.util.Stack;

///** Definition for binary tree */
//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
// 

public class BSTIterator {
    // use stack to store directed left children from root.
    // When next() be called, just pop one element and
    // process its right child as new root. 
    // this satisfy  O(h) memory, hasNext() in O(1) TIME,  but next() is O(h) time.
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */