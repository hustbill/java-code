public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 1. bfs - using queue https://leetcode.com/discuss/22533/java-solution-with-a-queue-used
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
    
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
            // 2. dfs -https://leetcode.com/discuss/21778/java-solution-using-dfs
            List<List<Integer>> res = new ArrayList<List<Integer>>();
        
            levelHelper(res, root, 0);
        
            return res;
        }
    
        public void levelHelper( List<List<Integer>> res,  TreeNode root, int height) {
            if (root == null)  return ;
        
            if (height >= res.size())  {
                res.add(new LinkedList<Integer>());
            }
            res.get(height).add(root.val);
        
            if(root.left != null)  levelHelper(res, root.left, height+1);
            if(root.right != null) levelHelper(res, root.right, height+1);
        }
}