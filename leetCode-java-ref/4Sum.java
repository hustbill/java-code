/* Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all 
unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)*/
    
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(num.length<4)
            return result;
        Arrays.sort(num);
        for(int i=0;i<num.length-3;++i){
            if(0==i || num[i]>num[i-1]){
                for(int j=i+1;j<num.length-2;++j){
                    if(j==i+1 || num[j]>num[j-1]){
                        int start=j+1,end=num.length-1;
                        while(start<end){
                            int sum=num[i]+num[j]+num[start]+num[end];
                            if(sum==target){
                                ArrayList<Integer> tmp=new ArrayList<Integer>();
                                tmp.add(num[i]);
                                tmp.add(num[j]);
                                tmp.add(num[start]);
                                tmp.add(num[end]);
                                result.add(tmp);
                                start++;
                                end--;
                                while(start<end && num[start]==num[start-1]){start++;}
                                while(start<end && num[end]==num[end+1]){end--;}
                            }
                            else if(sum<target)
                                start++;
                            else
                                end--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
