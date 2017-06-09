/**
 * 
 */
package bfs;

import tree.TreeNode;
import java.util.*;

/**
 * @author hzhang
 *
 *102. level order traversal
 *
 *103. zigzag traversal
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
		List<List<Integer>> zigzagRes = lr.zigzagLevelOrder(root);
		
		
		System.out.println(res);
		System.out.println(zigzagRes);
	}
	
	/*
	 *  102 level order
	 */
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
	  
	  /*
	   *  103. zigzag level order 
	   */
	  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		  List<List<Integer>> res = new ArrayList<>();
		  travel(root, res, 0);
		  return res;
	  }
	  
	  // dfs
	  private void travel(TreeNode curr, List<List<Integer>> res, int level) {
		  if (curr == null)  return;
		  
		  if (res.size() <= level) {
			  List<Integer> newLevel = new LinkedList<>();
			  res.add(newLevel);
		  }
		  
		  List<Integer> collection = res.get(level);
		  if (level % 2 == 0) collection.add(curr.val);
		  else collection.add(0, curr.val);
		  
		  travel(curr.left, res, level + 1);
		  travel(curr.right, res, level + 1);
	  }
	  
	  

}
