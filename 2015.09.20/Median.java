// Median of Two sorted Arrays
//Date:  Jan 30, 2015
// Author: hua zhang 
// reference:  leetcode 题解

/* 
 There are two sorted arrays A and B of size m and n respectively. 
Find the median of the two sorted arrays. The overall runtime complexity should be O(log(m+n))

the solution use the find Kth element in the sorted two arrays. We compare the ith element in A and jth element in B, where i+j = k-1.
A[i]> A[j], both right part of A and left part of B should be discarded.
A[i]< A[j], both left part of A and right part of B should be discarded. 

*/

public class Median {
	public static double findMedian(int[] A, int[] B){
		int m = A.length;
		int n = B.length;
		if((m+n)%2 ==1) 
			return (double)findKth(A, B, (m+n)/2, 0, m-1, 0, n-1 );
		else 
			return (findKth(A, B, (m+n)/2, 0, m-1, 0, n-1) + findKth(A, B, (m+n)/2 -1, 0, m-1, 0,n-1))*0.5;
	}
	public static int findKth(int A[], int B[], int k,  int startA, int endA, int startB,  int endB) {
		int lenA = endA - startA+1 ;
		int lenB = endB - startB+1;
		if(0 == lenA)
			return B[startB+k];
		if(0 == lenB)
			return A[startA+k];
		if(0 == k) 
			return Math.min( A[startA], B[startB]);
		int midA = lenA*k /(lenA + lenB);
		int midB = k -midA - 1;
		midA +=startA;
		midB +=startB;
		if(A[midA] > B[midB]) {
			k -= (midB -startB +1);
			endA = midA;
			startB = midB+1;
		}
		else {
			k-= (midA-startA +1);
			startA = midA +1;
			endB = midB;
		}
		return findKth(A, B, k, startA, endA, startB, endB);
	
	}
	public static void main(String args[]) {
		int A[] = { 1, 2, 3, 4, 5, 6, 7};
		int B[] = { 2, 4, 6, 8, 10, 12};
		double c = findMedian(A, B);
		System.out.print(String.format("c=%.2f", c));
		
	}
}