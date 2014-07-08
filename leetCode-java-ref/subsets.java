/* Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/ 

/*This problem is similar to the combination sum problem, both could be solved by DFS.*/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur=new ArrayList<Integer>();
        Arrays.sort(S);
        subsetsDFS(S,0,result,cur);
        return result;
    }
    public void subsetsDFS(int[] S, int start, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cur){
        result.add(new ArrayList<Integer>(cur));
        for(int i=start;i<S.length;++i){
            cur.add(S[i]);
            subsetsDFS(S,i+1,result,cur);
            cur.remove(cur.size()-1);
        }
    }
}

/* Follow up: If S has duplicates, we need to add one line code to check the duplicates:
if(i!=start && S[i]==S[i-1]) continue; */

/* Another way to solve the problem is using DP. We can get current result by adding S[i] to previous results and adding
previous result.*/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        result.add(new ArrayList<Integer>());
        for(int i=0;i<S.length;++i){
            ArrayList<ArrayList<Integer>> tmpResult=new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> cur:result){
                ArrayList<Integer> tmp=new ArrayList<Integer>(cur);
                tmp.add(S[i]);
                tmpResult.add(tmp);
            }
            result.addAll(tmpResult);
        }
        return result;
    }
}
