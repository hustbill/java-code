package array;

public class FindMedianTwoArrays {
/*
 * 6/22/16  yazhen, 刷题记录
 * 比较A 和B 两个array ，找合并以后的数组  第k大的数。k= (m+n + 1) /2 ， 分奇数和偶数两个情况
 * 
 */
	    public double findMedianSortedArrays(int[] A, int[] B) {
	        if(A==null || B==null || A.length+B.length==0) return -1; 
	        int m=A.length, n=B.length, size=m+n;
	        
	        if((size&1)==1){
	            return helper(A, 0, m, B, 0, n, size/2+1);
	        }
	        else{
	            return (helper(A, 0, m, B, 0, n, size/2)+helper(A, 0, m, B, 0, n, size/2+1))/2.0;
	        }
	    }
	    public double helper(int[] A, int astart, int m, int[] B, int bstart, int n, int k){
	        if(m>n) return helper(B, bstart, n, A, astart, m, k);
	        if(m==0) return B[bstart+k-1];
	        if(k==1) return Math.min(A[astart], B[bstart]);
	        
	        int aMid=Math.min(k/2, m), bMid=k-aMid;
	        
	        if(A[astart+aMid-1]<B[bstart+bMid-1]){
	            return helper(A, astart+aMid, m-aMid, B, bstart, n, k-aMid);
	        }
	        else if(A[astart+aMid-1]>B[bstart+bMid-1]){
	            return helper(A, astart, m, B, bstart+bMid, n-bMid, k-bMid);
	        }
	        else return A[astart+aMid-1];
	    }
	}
