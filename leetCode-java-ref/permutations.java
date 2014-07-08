/* Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].*/

/* The solution is adding number in the array one by one. */

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(null==num || 0==num.length)
            return result;
        result.add(new ArrayList<Integer>());
        for(int i=0;i<num.length;++i){
            ArrayList<ArrayList<Integer>> cur=new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> index:result){
                for(int j=0;j<=index.size();++j){
                    index.add(j,num[i]);
                    ArrayList<Integer> tmp=new ArrayList<Integer>(index);
                    cur.add(tmp);
                    index.remove(j);
                }
            }
            result=new ArrayList<ArrayList<Integer>>(cur);
        }
        return result;
    }
}

/* Another solution, swap each element with element after it.*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(null==num || 0==num.length)
            return result;
        permute(num,0,result);
        return result;
    }
    public void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result){
        if(start>=num.length)
            result.add(array2list(num));
        for(int i=start;i<num.length;++i){
            swap(num,start,i);
            permute(num,start+1,result);
            swap(num,start,i);
        }
    }
    public ArrayList<Integer> array2list(int[] num){
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<num.length;++i){
            res.add(num[i]);
        }
        return res;
    }
    public void swap(int[] num, int i, int j){
        int tmp=num[i];
        num[i]=num[j];
        num[j]=tmp;
    }
}


/*Follow up:
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].*/

/* use the swap method, only to check whether there are duplicated. */

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(null==num || 0==num.length)
            return result;
        permute(num,0,result);
        return result;
    }
    public void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result){
        if(start>=num.length)
            result.add(array2list(num));
        for(int i=start;i<num.length;++i){
            if(containsDuplicate(num,start,i)){
                swap(num,start,i);
                permute(num,start+1,result);
                swap(num,start,i);
            }
        }
    }
    public boolean containsDuplicate(int[] num,int start,int end){
        for(int i=start;i<end;++i){
            if(num[i]==num[end])
                return false;
        }
        return true;
    }
    public ArrayList<Integer> array2list(int[] num){
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<num.length;++i){
            res.add(num[i]);
        }
        return res;
    }
    public void swap(int[] num, int i, int j){
        int tmp=num[i];
        num[i]=num[j];
        num[j]=tmp;
    }
}
