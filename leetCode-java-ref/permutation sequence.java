/* The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.*/

public class Solution {
    public String getPermutation(int n, int k) {
        LinkedList<Integer> nums=new LinkedList<Integer>();
        for(int i=1;i<=n;++i){
            nums.add(i);
        }
        int[] fac=getFactorial(n);
        StringBuffer res=new StringBuffer();
        k=k-1;
        for(int i=n-1;i>=0;--i){
            int div=k/fac[i];
            k=k%fac[i];
            res.append(nums.get(div));
            nums.remove(div);
        }
        return res.toString();
    }
    public int[] getFactorial(int n){
        int[] res=new int[n];
        res[0]=1;
        for(int i=1;i<n;++i){
            res[i]=res[i-1]*i;
        }
        return res;
    }
}
