package old;
/*
235. Lowest Common Ancestor of a Binary Search Tree
Total Accepted: 62505 Total Submissions: 165077 Difficulty: Easy
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Hide Company Tags Amazon Facebook
Hide Tags Tree
Hide Similar Problems (M) Lowest Common Ancestor of a Binary Tree

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class LowestCommonAncestor_235 {
    public static void main(String[] args) {
         TreeNode root = new TreeNode(6);
         TreeNode two = new TreeNode(2);
         TreeNode eight = new TreeNode(8);
         root.left = two;
         root.right = eight;
 
         TreeNode zero = new TreeNode(0);
         TreeNode four = new TreeNode(4);
         two.left = zero;
         two.right = four;
         
         TreeNode three = new TreeNode(3);
         TreeNode five = new TreeNode(5);
         four.left = three;
         four.right = five;
         
         eight.left = new TreeNode(7);
         eight.right= new TreeNode(9);
 
         System.out.print(lowestCommonAncestor(root, two, five).val);
    }
         
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // https://leetcode.com/discuss/44946/my-java-solution
         if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }    
                 
         
    public static TreeNode lowestCommonAncestor_sol2(TreeNode root, TreeNode p, TreeNode q) {
         /*Just walk down from the whole tree's root as long as both p and q are in the same subtree (meaning their values are both smaller or both larger than root's). This walks straight from the root to the LCA, not looking at the rest of the tree, so it's pretty much as fast as it gets. A few ways to do it:
         https://leetcode.com/discuss/44959/3-lines-with-o-1-space-1-liners-alternatives
             
             */
         while ((root.val - p.val) * (root.val -q.val) > 0) 
             root = p.val < root.val ?  root.left : root.right;
         return root;
    }
}