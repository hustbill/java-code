/*
  3Sum
  https://leetcode.com/problems/3sum/
  
   Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

   Note:
   Elements in a triplet (a,b,c) must be in non-descending order. (ie, a<= b <=c)
   The solution set must not contain duplicate triplets.
   

   For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

*/



import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] num) {
	/*
	 Ref: http://gongxuns.blogspot.com/2012/12/leetcode3sum.html
	 Idea:  o(n^2) solution exists. First sort the array, and then from left to right,
	 for each num[i], search the pair that sums up to -num[i] using Two Sum algorithm.
	*/
	    List<List<Integer>> retList = new ArrayList<List<Integer>>();
		int len = num.length;
		// sort the num in non-descending order
		Arrays.sort(num); // don't use the quick sort to sort the array. Use the method which provided by JDK
		for(int i=0; i< len -2 ; i++) {
			if(i==0 || num[i] > num[i-1]) {
				int j = i+1, k= len-1;
				while(j< k) {
					if(num[j] + num[k] == -num[i]) {
						List<Integer> numList = new ArrayList<Integer>();
						numList.add(num[i]);
						numList.add(num[j]);
						numList.add(num[k]); 
						retList.add(numList);
						k--;
						j++;
						while(k >j && num[k] == num[k+1])
							k--;  // avoid duplicate solutions
						while(j< k && num[j] == num[j-1])
							j++;  // avoid duplicate solutions
					} else if (num[j] + num[k] > - num[i]) {
						k--;
					} else {
						j++;
					}
				}	
			}
		}
	   	return retList;
 
	}
	

	
	public static void main(String[] args) {
		int[] num = { -1, 0, 1, -1, -4 ,2 };
		// for (int i = 0; i< num.length; i++ ) {
			// System.out.print(" num[" + i + "]= " + num[i] );
		// }
		// System.out.println();
		
		List<List<Integer>> retList = threeSum(num);
		List<Integer> numList= new ArrayList<Integer>();
		System.out.println("retList.size() = " + retList.size());
		for(int i=0; i< retList.size(); i++) {
			numList = retList.get(i);
		}
		System.out.println(" numList.size() =" +  numList.size());
		for(int j=0; j< numList.size(); j++) 
			System.out.print( numList.get(j) + " ");
		System.out.println("," ); 
		
		
	}
	
	

	
}