/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (47.37%)
 * Total Accepted:    215.3K
 * Total Submissions: 454.4K
 * Testcase Example:  '3'
 *
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n?
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public int numTrees1(int n) {
        int count = 0;
       List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for (int i = 1; i <= n; i++) {
             List<Integer> cur = new ArrayList<Integer>();
            cur.add(i);
                System.out.println("cur i: " + cur);            
            // left child tree
            for (int j = 1; j < i; j++) {
                cur.add (j);
                System.out.println("cur j: " + cur);       
              
            }
               // right child tree
                for (int k = i + 1; k <= n; k++) {
                    cur.add(k);
                    System.out.println("cur k: " + cur);
                }
            
               if (cur.size() == n) {
                count++;
            }
            if (!ans.contains(cur)) 
                ans.add(new ArrayList<Integer>(cur));
            System.out.println("cur all: " + cur + ", count:" + count);
        }
        
        for (int i = 1; i <= n; i++) {
             System.out.println("round" + i);
             List<Integer> cur = new ArrayList<Integer>();
            cur.add(i);  
            
             // right child tree
                for (int k = i+ 1; k <= n; k++) {
                    cur.add(k);
                    System.out.println("cur k2: " + cur);
                  
                }
             // left child tree
                    for (int j = 1; j < i; j++) {
                        cur.add (j);
                        System.out.println("cur j2: " + cur);       
                    }
           
            if (cur.size() == n) {
                count++;
            }
            
            if (!ans.contains(cur)) 
                ans.add(new ArrayList<Integer>(cur));
            System.out.println("cur all2: " + cur + ", count2:" + count);
            
        }
        System.out.println(ans);
        return ans.size();
    }
    
    public int numTrees2(int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
         for (int i = 1; i <= n; i++) {
             dfs(n, i, new ArrayList<Integer>(), ans);
             
         }
        return ans.size();
    }
    
    private void dfs(int n, int pos, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == n) {
            System.out.println("cur: " + cur);
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        
        // left child tree
        for (int i = 1; i < pos; i++) {
            cur.add(i);
        }
        cur.add(pos);
        dfs(n, pos + 1, new ArrayList<Integer>(cur), ans);
        cur.remove(cur.size() - 1);
        
    }
}
