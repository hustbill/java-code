/*
95. Unique Binary Search Trees II  QuestionEditorial Solution  My Submissions
Total Accepted: 60646
Total Submissions: 205706
Difficulty: Medium
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
Hide Tags Tree Dynamic Programming
Hide Similar Problems (M) Unique Binary Search Trees (M) Different Ways to Add Parentheses

*/
import java.util.*;

public class GenerateTrees {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
    
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) return res;
        res = helper(1, n);
        return res;
    }
    private List<TreeNode> helper(int start, int end) {
         List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int rootVal = start; rootVal <= end; rootVal++) {
            List<TreeNode> leftSubTrees = helper(start, rootVal - 1);
            List<TreeNode> rightSubTrees = helper(rootVal + 1, end);
            for (TreeNode left : leftSubTrees) {
                for (TreeNode right: rightSubTrees) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
    
    public static void main(String[] args) {
        GenerateTrees sl = new GenerateTrees();
        int n = 3;
        List<TreeNode> trees = sl.generateTrees(n);
        for(TreeNode tree : trees) 
            System.out.println(tree.val);
    }
}