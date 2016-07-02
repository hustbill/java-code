package tree;

import java.util.*;

public class ConvertTree {
	
	//T(n), S(n)
	public static TreeNode convertTree(TreeNode root){
		List<Integer> list=inorderTraversal(root);
		if(list.isEmpty()) return null;
		Collections.sort(list);
		return buildBST(list);
	}
	
	//T(n), S(n)
	public static TreeNode buildBST(List<Integer> nums) {
        if(nums==null || nums.isEmpty()) return null; 
        return buildHelper(nums, 0, nums.size()-1);
    }
    public static TreeNode buildHelper(List<Integer> nums, int begin, int end){
        if(begin<=end){
            int mid=begin+(end-begin)/2;
            TreeNode root=new TreeNode(nums.get(mid));
            root.left=buildHelper(nums, begin, mid-1);
            root.right=buildHelper(nums, mid+1, end);
            return root;
        }
        return null;
    }
	
	//T(n), S(n)
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        inorderHelper(root, res);
        return res;
    }
    public static void inorderHelper(TreeNode root, List<Integer> res){
        if(root==null) return;
        
        inorderHelper(root.left, res);
        res.add(root.val);
        inorderHelper(root.right, res);
    }
}
//class TreeNode{
//	int val; 
//	TreeNode left, right; 
//	public TreeNode(int val){
//		this.val=val;
//	}
//}