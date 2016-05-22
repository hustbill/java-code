package v201605;

import java.util.Iterator;

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

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        TreeNode newTree = new TreeNode(root.val);
        
        newTree.left  = invertTree(root.right);
        newTree.right = invertTree(root.left);
        
        return newTree;
    }
}

