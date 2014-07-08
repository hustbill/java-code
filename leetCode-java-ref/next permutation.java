/* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1*/

/* The solution is traverse from back to front, find the first element that conflicts the increasing order, then find the
first one that is bigger than it, then swap the two elements, the last step is to reverse the elememts behind it.
if no element found, reverse the whole array. */

public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length<2)
            return ;
        for(int i=num.length-2;i>=0;--i){
            if(num[i]<num[i+1]){
                int j=num.length-1;
                while(j>i && num[j]<=num[i] ){--j;}
                swap(num,i,j);
                reverse(num,i+1,num.length);
                return ;
            }
        }
        reverse(num,0,num.length);
        return ;
    }
    public void reverse(int[] num, int start, int end){
        int mid=start+(end-start)/2;
        for(int i=start;i<mid;++i){
            swap(num,i,end-1-i+start);
        }
    }
    public void swap(int[] num, int i, int j){
        int tmp=num[i];
        num[i]=num[j];
        num[j]=tmp;
    }
}
