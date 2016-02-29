/*112. Path Sum My Submissions Question
Total Accepted: 91216 Total Submissions: 295628 Difficulty: Easy
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Hide Company Tags Microsoft
Hide Tags Tree Depth-first Search
Hide Similar Problems (M) Path Sum II (H) Binary Tree Maximum Path Sum (M) Sum Root to Leaf Numbers
*/

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        /*The basic idea is to subtract the value of current node from sum until it reaches a leaf node and the subtraction equals 0, then we know that we got a hit. Otherwise the subtraction at the end could not be 0.
            https://leetcode.com/discuss/10456/accepted-my-recursive-solution-in-java
            */
        if (root == null) return false;
        if (root.left == null  && root.right == null && sum - root.val == 0) return true;
        return hasPathSum(root.left, sum - root.val)  || hasPathSum(root.right, sum- root.val);
    }
    
    public static void main(String[] args) {
        int sum = 22;
        
        TreeNode root = new TreeNode(5);
        TreeNode oneLeft = new TreeNode(4);
        root.left = oneLeft;
        TreeNode twoLeft = new TreeNode(11);
        oneLeft.left = twoLeft;
        twoLeft.left = new TreeNode(7);
        twoLeft.right = new TreeNode(2);
        
        TreeNode oneRight = new TreeNode(8);
        root.right = oneRight;
        oneRight.left = new TreeNode(13);
        TreeNode twoRight = new TreeNode(4);
        oneRight.right = twoRight;
        twoRight.right = new TreeNode(1);
        
        System.out.print(hasPathSum(root, sum));
    }
}
