/*
 *
 * private 
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 *
 * algorithms
 * Medium (42.08%)
 * Total Accepted:    188.4K
 * Total Submissions: 447.6K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Example:
 * 
 * 
 * Given the sorted linked list: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following
 * height balanced BST:
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // convert list to array
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        System.out.println("len:" + len);
        int[] nums = new int[len];
        int i = 0;
        while ( head != null &&  i < nums.length) {
            nums[i] = head.val;
            System.out.printf(" nums[%d]=%d ", i, nums[i]);
            len--;
            i++;
            head = head.next;
        }
        
        int begin = 0;
        int end = nums.length - 1;
      return sortedArrayToBST(nums, begin, end);      
    }

    private TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if (begin > end) return null; 
        int mid = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, begin, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }
}
