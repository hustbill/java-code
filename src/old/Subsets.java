package old;
/*78. Subsets
Total Accepted: 82205 Total Submissions: 271622 Difficulty: Medium
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Hide Company Tags Amazon Uber Facebook
Hide Tags Array Backtracking Bit Manipulation
Hide Similar Problems (M) Generalized Abbreviation*/

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
      int[] nums = {1, 2, 3};
      List<List<Integer>> lists = new ArrayList<List<Integer>>();
      lists = subsets(nums);
      
      for (int i=0; i < lists.size(); i++) {
          System.out.println(lists.get(i));
      }    
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        return  solution1_improve(nums);
    }
    
    public static List<List<Integer>> solution1(int[] nums) {    
        // Ref: https://leetcode.com/discuss/25696/simple-java-solution-with-for-each-loops
        /*Intuitively, we are still generating all 2^n possible subsets (where n = |S| ) so the complexity will be at least 2^n.

As for the code, initially in the outer for loop iterating over S, "res" only contains 1 subset, the empty set, []. We iterate over it in the inner loop and add a new subset, the subset containing the first element, [s0] (without loss of generality).

In the next iteration of the outer loop, there are now 2 subsets in "res": [] and [s0]. We iterate over both of these, appending the 2nd element of S to each and add two additional subsets, [s1] and [s0, s1]. Thus res now has 4 subsets, [], [s0], [s1], [s0, s1].

You can now see that for each iteration of the outer loop, the number of subsets we iterate over in the inner loop doubles, giving us the exponential complexity.*/
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        Arrays.sort(nums);
        for(int i : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
    
    public static List<List<Integer>> solution1_improve(int[] nums) {
        /* The idea is:
起始subset集为：[]
添加S0后为：[], [S0]
添加S1后为：[], [S0], [S1], [S0, S1]
添加S2后为：[], [S0], [S1], [S0, S1], [S2], [S0, S2], [S1, S2], [S0, S1, S2]
红色subset为每次新增的。显然规律为添加Si后，新增的subset为克隆现有的所有subset，并在它们后面都加上Si*/
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        result.add(tmp);   // add empty set
        Arrays.sort(nums);
        
        for (int i=0 ; i<nums.length; i++) {
            int n = result.size();
            for (int j=0; j<n;  j++) {
                // NOTE : must create a new tmp object,  and add templte into it
                tmp = new ArrayList<Integer>(result.get(j));
                tmp.add(nums[i]);
                result.add(new ArrayList<Integer>(tmp));
            }
        }
        return result;
    }
}