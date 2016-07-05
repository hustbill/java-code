/*
 * 364. Nested List Weight Sum II  QuestionEditorial Solution  My Submissions
Total Accepted: 955
Total Submissions: 2104
Difficulty: Medium
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:
Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

Example 2:
Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)

Hide Company Tags LinkedIn
Hide Tags Depth-first Search
Hide Similar Problems (E) Nested List Weight Sum

 */

/* public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

package dfs;

import java.util.*;

public class NestedListWeightSumII {
	 // from yazhen
	    int total=0;
	    int maxLevel=1;
	    public int depthSumInverse(List<NestedInteger> nestedList) {
	        if(nestedList==null || nestedList.isEmpty()) return 0; 
	        List<Integer> levelSum=new ArrayList<>();
	        int depthSum=helper(nestedList, 1);
	        return (maxLevel+1)*total-depthSum;
	    }
	    public int helper(List<NestedInteger> list, int level){
	        int sum=0; 
	        for(NestedInteger ni : list){
	            if(ni.isInteger()) {
	                sum+=ni.getInteger()*level;
	                total+=ni.getInteger();
	            }
	            else {
	                sum+=helper(ni.getList(), level+1);
	                maxLevel=Math.max(maxLevel, level+1);
	            }
	        }
	        return sum;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
