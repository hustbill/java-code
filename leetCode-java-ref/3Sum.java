/* Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)*/
    
/* The method is to ues two pointers to traverse from both sides to middle. The tricky part is to remove duplicates:
especially this line of code if(i==0 || num[i]>num[i-1]). The overall running time is O(n2).*/

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length<3)
            return result;
        Arrays.sort(num);
        for(int i=0;i<num.length-2;++i){
            int start=i+1,end=num.length-1;
            if(i==0 || num[i]>num[i-1]){
                while(start<end){
                    if(0==num[i]+num[start]+num[end]){
                        ArrayList<Integer> tmp=new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[start]);
                        tmp.add(num[end]);
                        result.add(tmp);
                        start++;
                        end--;
                        while(start<end && num[end]==num[end+1]){end--;}
                        while(start<end && num[start]==num[start-1]){start++;}
                    }
                    else if(0<num[i]+num[start]+num[end])
                        end--;
                    else
                        start++;
                }
            }
        }
        return result;
    }
}


/*Follow up: 3 sum closest: Given an array S of n integers, find three integers in S such that the sum is closest to a 
given number, target. Return the sum of the three integers. You may assume that each input would have exactly one 
solution.*/

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int result=0, min=Integer.MAX_VALUE;
        Arrays.sort(num);
        for(int i=0;i<num.length-2;++i){
            int start=i+1, end=num.length-1;
            while(start<end){
                int sum=num[i]+num[start]+num[end];
                int diff=Math.abs(sum-target);
                if(diff<min){
                    min=diff;
                    result=sum;
                }
                if(sum<target)
                    start++;
                else
                    end--;
            }
        }
        return result;
    }
}
