/* Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]*/

/* This problem is similar to the combination sum problem. Both problems could be solve by DFS solution. We just make sure
the next number is always bigger than current one, one the size reaches k, we can add it to the result array. */

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur=new ArrayList<Integer>();
        if(n<k)
            return result;
        combineHelper(n,k,1,result,cur);
        return result;
    }
    public void combineHelper(int n,int k, int start, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cur){
        if(k==cur.size()){
            result.add(new ArrayList<Integer>(cur));
            return ;
        }
        for(int i=start;i<=n;++i){
            cur.add(i);
            combineHelper(n,k,i+1,result,cur);
            cur.remove(cur.size()-1);
        }
    }
}
