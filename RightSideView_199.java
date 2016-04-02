/*
199. Binary Tree Right Side View My Submissions QuestionEditorial Solution
Total Accepted: 38607 Total Submissions: 113726 Difficulty: Medium
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

Credits:
Special thanks to @amrsaqr for adding this problem and creating all test cases.

Hide Company Tags Amazon
Hide Tags Tree Depth-first Search Breadth-first Search
Hide Similar Problems (M) Populating Next Right Pointers in Each Node
Have you met this question in a real interview? Yes  No
Discuss

*/


/**
 * Definition for a binary tree node.
 */
 
import java.util.*;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
 public class RightSideView_199 {
     public static void main(String[] args) {
         TreeNode root = new TreeNode(1);
         TreeNode two = new TreeNode(2);
         TreeNode three = new TreeNode(3);
         root.left = two;
         root.right = three;
         
         TreeNode four = new TreeNode(4);
         TreeNode five = new TreeNode(5);
         
         two.right = five;
        // three.right = four;
         
         System.out.print(rightSideView(root));
     }
     
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)  return list;
        
        list.add(root.val);
        helper(list, root.left, root.right);
        return list;
    }
    
    public static void helper(List<Integer> list, TreeNode left, TreeNode right) {
        if (right == null ) {
            if (left != null) {
                list.add(left.val);
                helper(list, left.left, left.right);
            }
        } else {
            list.add(right.val);
            helper(list, right.left, right.right);       
        }
    }
}