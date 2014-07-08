/* Implement int sqrt(int x).

Compute and return the square root of x.*/

/* The first way using Newton's Method.*/

public class Solution {
    public int sqrt(int x) {
        if(x<0)
            return -1;
        double res=(double)(x)/2.0;
        while(Math.abs(res*res-x)>0.1){
            res=0.5*(res+x/res);
        }
        return (int)res;
    }
}

/* The second way using binary search. */

public class Solution {
    public int sqrt(int x) {
        if(x<0)
            return -1;
        long start=0, end=x/2+1;
        while(start<=end){
            long mid=start+(end-start)/2;
            long sq=mid*mid;
            if(sq==(long)(x))
                return (int)mid;
            else if(sq<(long)(x))
                start=mid+1;
            else
                end=mid-1;
        }
        return (int)end;
    }
}
