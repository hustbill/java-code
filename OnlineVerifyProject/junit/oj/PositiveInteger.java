package oj;

import java.util.Arrays;

/*
 * This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */

public class PositiveInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrs = {{1, 3, 6, 4, 1, 2}, {-1, -3}, {2, 3, 4}, {0, 1, 2}, {-1, 0, 0}, {-1, -3, 0} , {-1, 2, 3}, {-1, 3, 4}};
		
		PositiveInteger pint = new PositiveInteger();
		for (int[] A : arrs) { 
			int result = pint.getPositiveInteger(A);
			System.out.printf("\nresult: %d", result);
		}

	}
	
	public int getPositiveInteger(int[] arr) {
		Arrays.sort(arr);
		// A' = { 1, 1, 2, 3, 4, 6}
		int n = arr.length - 1;
		if (arr[n] <= 0) return 1;
		if (arr[0] > 1)  return arr[0] - 1;
		
		for (int i = 1; i <= n; i++) {	
//			System.out.printf("A[%d]= %d \t", i, arr[i]);
			if (arr[i] < 0) arr[i] = 1;
			if (arr[i] <= i ) continue;
		
			if (arr[i] > i ) return arr[i] - 1;
		}
		return arr[n] + 1;
	}

}
