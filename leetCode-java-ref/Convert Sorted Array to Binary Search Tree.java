/* Given an array where elements are sorted in ascending order, convert it to a height balanced BST.*/

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
    public TreeNode sortedArrayToBST(int[] num) {
        if(0==num.length)
            return null;
        if(1==num.length)
            return new TreeNode(num[0]);
        int mid=num.length/2;
        TreeNode root=new TreeNode(num[mid]);
        root.left=sortedArrayToBST(Arrays.copyOfRange(num,0,mid));
        root.right=sortedArrayToBST(Arrays.copyOfRange(num,mid+1,num.length));
        return root;
    }
}
