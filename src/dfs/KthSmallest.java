package dfs;

import java.util.*;

/*
 * *.Find the kth smallest number in at row and column sorted matrix.
 */
public class KthSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
		                  {1 ,5 ,7},
		                  {3 ,7 ,8},
		                  {4 ,8 ,9},
					};
		KthSmallest ks = new KthSmallest();
		
		int k = 4;
		int res = ks.kthSmallest(matrix, k);
		System.out.println("res: " + res);
	}
	
	/*
	 * Java 1ms nlog(max -min) solution
		Main loop is binary search of max - min.
		Swap from left-bottom to right-top can get count <= mid in O(n) time instead of O(nlogn), 

		total complexity will be O(nlogm) while m = max - min.
		ref: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/#/solutions
	 */
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int lo = matrix[0][0], hi = matrix[n-1][n-1];
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cout = getLessEqual(matrix, mid);
			
			if (cout < k) lo = mid + 1;
			else 
				hi = mid - 1;
		}
		return lo;
			
	}
	
	public int getLessEqual(int[][] matrix, int val) {
		int res = 0;
		int n = matrix.length;
		int i = n - 1, j = 0;
        while (i >= 0 && j < n) {
        	if (matrix[i][j] > val) i--;
        	else {
        		res += i + 1;
        		j++;
        	}
        }
        return res;
	}
	
	// 2017.05.06 first try.  jiuzhang, lintcode, leetcode
	 public int kthSmallest_failed(int[][] matrix, int k) {
	        // write your code here
	        List<Integer> list = new ArrayList<>();
	        for (int i = 0; i < matrix.length - 1; i++) {
	            for (int j = 0; j < matrix[i].length - 1; j++) {
	                if (matrix[i+1][j] > matrix[i][j+1]) {
	                    list.add(matrix[i][j+1]);
	                } else {
	                    list.add(matrix[i+1][j]);
	                }
	            }
	        }
	        System.out.println(list);
	        
	        return list.get(k-1);
	    }

}
