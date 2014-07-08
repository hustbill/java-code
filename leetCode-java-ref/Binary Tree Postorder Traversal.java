/*Given a binary tree, return the postorder traversal of its nodes' values.*/

/*The first method space complexity is O(h), where h is the height of the tree. 
The second methof sapce complexity is O(n), where n is the number of nodes.*/
/* This is the first intenative version using just one stack. In this method, there are two pointers, pre and current;
when up  to bottom, the pre is the parent of current; when bottom to up, pre is the child of current.*/

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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(null==root)
            return result;
        Stack<TreeNode> nodes= new Stack<TreeNode>();
        TreeNode current=root;
        TreeNode pre=null;
        nodes.push(current);
        while(false==nodes.empty()){
            current=nodes.peek();
            if(null==pre || current==pre.left || current==pre.right){
                if(null!=current.left)
                    nodes.push(current.left);
                else if(null!=current.right)
                    nodes.push(current.right);
            }
            else if(pre==current.left){
                if(null!=current.right)
                    nodes.push(current.right);
            }
            else{
                result.add(current.val);
                nodes.pop();
            }
            pre=current;
        }
        return result;
    }
}


/* This is the second verion of intenative. There are two stacks. It is doing a reversed pre-order traversal. That is,
the orider of traversal is a node, then the right child follewd by its left child. This yields the post-order in reversd
order. Using a second stack, we could reverse it back.*/
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(null==root)
            return result;
        Stack<TreeNode> nodes= new Stack<TreeNode>();
        Stack<TreeNode> output=new Stack<TreeNode>();
        nodes.push(root);
        while(false==nodes.empty()){
            TreeNode current=nodes.peek();
            nodes.pop();
            output.push(current);
            if(null!=current.left)
                nodes.push(current.left);
            if(null!=current.right)
                nodes.push(current.right);
        }
        while(false==output.empty()){
            result.add(output.pop().val);
        }
        return result;
    }
}
