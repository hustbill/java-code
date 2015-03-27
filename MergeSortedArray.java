/*
Merge Sorted Array 
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

*/

public class MergeSortedArray {
	
	//reference: http://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
    public static void merge(int A[], int m, int B[], int n) {
 
           while(m > 0 && n > 0){
               if(A[m-1] > B[n-1]){
                   A[m+n-1] = A[m-1];
                   m--;
               }else{
                   A[m+n-1] = B[n-1];
                   n--;
               }
           }
 
           while(n > 0){
               A[m+n-1] = B[n-1];
               n--;
           }
       }
	   
	public  static void merge0(int A[], int m, int B[], int n) { 
		if(A == null || B == null) 
			return;
		
        int aidx = m-1;
		int bidx = n-1;
		int len = m+ n -1;
		while( len >=0) {
			if(bidx <0 || (aidx >=0 && A[aidx] > B[bidx])) {
				A[len--] = A[aidx--];
			}
			else {
				A[len--] = B[bidx--];
			}
			
		}
	}
	
	
	public static void main(String args[]) {
		System.out.println("Merge Sorted Array");
		
		int A[] = {1, 3 , 7, 8, 9 , 11, 19 , 23, 46, 0, 0, 0, 0,0,0,0,0,0,0,0};
		int B[] = { 4, 6, 8, 10, 12, 16};
		int C[] = { 4, 6, 8, 10, 12, 16,37, 39 ,70, 78, 90};
		  merge(A, 9, B, 6);
		for( int i=0; i< A.length; i++)
			System.out.print(String.format(" %d, ", A[i]));
	}
}