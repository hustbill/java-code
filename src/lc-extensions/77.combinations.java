/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (n < k) return ret;
       
        helper(n, k, 1, new LinkedList<Integer>(), ret);
        return ret;
    }

    public void helper(int n, int k, int pos, LinkedList<Integer> curr, List<List<Integer>> ret) {
        // if the combination is done
        if (curr.size() == k) {           
            ret.add(new LinkedList(curr));
        }
        for (int i = pos; i <= n; i++) {
            // add i into the current combination
            curr.add(i);
            // use next integers to complete the combination
            helper(n, k, i + 1, curr, ret);
            // backtrack
            curr.removeLast();            
        }
    }
}
// @lc code=end

