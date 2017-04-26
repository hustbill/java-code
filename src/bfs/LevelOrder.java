/**
 * 
 */
package bfs;

import tree.TreeNode;
import java.util.*;

/**
 * @author hzhang
 *
 */
public class LevelOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		root.left = left;
		root.right = right;
		
		right.left = new TreeNode(15);
		right.right = new TreeNode(7);
		LevelOrder lr = new LevelOrder();
		List<List<Integer>> res = lr.levelOrder(root);
		
		
		System.out.println(res);
	}
	
	  public  List<List<Integer>> levelOrder(TreeNode root) {
		  List<List<Integer>> res = new ArrayList<>();
		  if (root == null) return res;
		  
		  Queue<TreeNode> que = new LinkedList<TreeNode>();
		  que.offer(root);
		  
		  while (!que.isEmpty()) {
			  int levelNum = que.size();
			  List<Integer>  subList = new LinkedList<Integer>();
			  for (int i = 0; i < levelNum; i++) {
				  if (que.peek().left != null) {
					  que.offer(que.peek().left);
				  }
				  if (que.peek().right != null) {
					  que.offer(que.peek().right);
				  }
				  subList.add(que.poll().val);
			  }
			  res.add(subList);
		  }
		  
		  return res;
	   }

}
