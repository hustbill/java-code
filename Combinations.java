/*77. Combinations
Total Accepted: 66314 Total Submissions: 199899 Difficulty: Medium
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[        
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Hide Tags Backtracking
Hide Similar Problems (M) Combination Sum (M) Permutations
*/
import java.util.*;

public class Combinations {
    
    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> res = solution2(n, k);
        System.out.print(res);
    }
    
    public static List<List<Integer>> combine(int n, int k) {
        /*https://leetcode.com/discuss/32955/a-short-recursive-java-solution-based-on-c-n-k-c-n-1-k-1-c-n-1-k
        C(n, k) = C(n-1, k-1) + C(n-1, k);
            */
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i=1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = combine(n-1, k-1);
        result.forEach(e -> e.add(n));
        result.addAll(combine(n-1, k));
        return result;
    }
    
    public static List<List<Integer>> solution2(int n, int k) {
        // https://leetcode.com/discuss/31250/backtracking-solution-java                     
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>();
        combine(res, comb, 1, n, k);
        return res;
    }
    
    public static void combine(List<List<Integer>> res, List<Integer>comb, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(res, comb, i+1, n, k-1);
            comb.remove(comb.size() -1);
        }
    }
}