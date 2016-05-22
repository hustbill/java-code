package v201605;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//level order printing
		public void levelOrderPrint(TreeNode root){
		    Queue<TreeNode> que = new LinkedList<TreeNode>();
		    TreeNode mark = new TreeNode(0);
		    if(root != null){
		        que.add(root);
		        que.add(mark);
		    }
		    while(!que.isEmpty()){
		    	TreeNode temp = que.poll();
		        if(temp != mark)
		        System.out.print(temp.val + " ");
		        if(temp == mark){
		            if(que.peek() == mark || que.isEmpty()){
		                return;
		            }
		            que.add(mark);
		            System.out.println();
		        }
		        if(temp.left != null){
		            que.add(temp.left);
		        }
		        if(temp.right != null){
		            que.add(temp.right);
		        }
		    }
		}

}
