/* Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].*/

/* use two pointers to record current length and original positon. */

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length<2)
            return A.length;
        int index=0,i=1;
        while(i<A.length){
            if(A[i]==A[index])
                i++;
            else
                A[++index]=A[i++];
        }
        return index+1;
    }
}

/* Follow up: What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].*/

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length<3)
            return A.length;
        int index=0,num=1;
        for(int j=1;j<A.length;++j){
            if(A[j]!=A[index]){
                A[++index]=A[j];
                num=1;
            }
            else{
                if(1==num){
                    A[++index]=A[j];
                }
                num++;
            }
        }
        return index+1;
    }
}
