/* Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] */

/*DFS solution.*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(0==candidates.length || target<0)
            return result;
        int start=0;
        ArrayList<Integer> cur=new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates,target,start,result,cur);
        return result;
    }
    public void helper(int[] candidates, int target, int start, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cur){
        if(target<0)
            return;
        if(0==target){
            ArrayList<Integer> tmp=new ArrayList<Integer>(cur);
            result.add(tmp);
            return;
        }
        for(int i=start;i<candidates.length;++i){
            if(target<candidates[i])
                return;
            cur.add(candidates[i]);
            helper(candidates,target-candidates[i],i,result,cur);
            cur.remove(cur.size()-1);
        }
    }
}

/*DP solution.*/

/* Follow up: Each number in C may only be used once in the combination.
The difference is since each number could only be used once, start should be i+1, not i, and check the duplicated num*/
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(0==num.length || target<0)
            return result;
        Arrays.sort(num);
        int start=0;
        ArrayList<Integer> cur=new ArrayList<Integer>();
        helper(num,target,start,result,cur);
        return result;
    }
    public void helper(int[] num, int target,int start, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cur){
        if(target<0)
            return;
        if(0==target){
            ArrayList<Integer> tmp=new ArrayList<Integer>(cur);
            result.add(tmp);
            return ;
        }
        for(int i=start;i<num.length;++i){
            if(target<num[i])
                return;
            cur.add(num[i]);
            helper(num,target-num[i],i+1,result,cur);
            cur.remove(cur.size()-1);
            while(i<num.length-1 && num[i]==num[i+1]){i++;}
        }
    }
}

