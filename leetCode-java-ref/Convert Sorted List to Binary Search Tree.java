/* Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int size=0;
        ListNode node=head;
        while(null!=node){
            size++;
            node=node.next;
        }
        return helper(new ListNode[]{head},0,size-1);
    }
    public TreeNode helper(ListNode[] head,int start,int end){
        if(start>end)
            return null;
        int mid=start+(end-start)/2;
        TreeNode leftNode=helper(head,start,mid-1);
        TreeNode root=new TreeNode(head[0].val);
        root.left=leftNode;
        head[0]=head[0].next;
        TreeNode rightNode=helper(head,mid+1,end);
        root.right=rightNode;
        return root;
    }
}
