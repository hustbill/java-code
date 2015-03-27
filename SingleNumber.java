/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

public class SingleNumber {
    public static int singleNumber0(int[] A) {
		if(A.length >3) {
        for (int i=0; i< A.length-2; i++) {
             if(A[i] != A[i+1] ) {
				 if(A[i+1] != A[i+2]) {
             		 System.out.println("index=" + (i+1));
				
			
             	return A[i+1];
			}
           }
        }
	  }
	  if(A.length ==1 ) return A[0];
	  if(A.length ==3) {
		  if (A[0]==A[1]) return A[2];
		  if (A[0] == A[2]) return A[1];
		  if(A[1]== A[2]) return A[0];
	  }
	
        return 0;
    }
	
	
	//reference: http://www.programcreek.com/2012/12/leetcode-solution-of-single-number-in-java/
	/*
		Thoughts
		The key to solve this problem is bit manipulation. XOR will return 1 only on two different bits.
		So if two numbers are the same, XOR will return 0. Finally only one number left.	
	*/
		 
	//reference: http://rleetcode.blogspot.com/2014/01/blog-post_1.html	 
	public static int singleNumber(int[] A) {
		if(A == null || A.length==0) 
			return -1; // throw exception
		int result = A[0];
		for(int i =1; i< A.length; i++) {
			result ^= A[i];
		}
		return result;
	}
	
	
	public static void main(String args[]) {
		//int A[] = { 1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6};
		// int A[] = {1};
		//int A[] = {2 , 2, 1};
		int A[] =	{1,3,1,-1,3};
		int result = singleNumber(A);
		System.out.println("result=" + result);
	}
}