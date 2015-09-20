/*
Sort Colors
https://leetcode.com/problems/sort-colors/
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Solution:
  divide - conquer 
*/

import java.util.*;

public class SortColors {
	public static void sortColors(int[] A) {
 		print("before" , A);
 		System.out.println();
	     ArrayList list= sortColorsArr(A); 
	     System.out.println(list);
	    //print("after" , A);
	 
	}
	
	public static void print(String desc, int[] A) {
		int j=0;
		  System.out.print( "\n" + desc + "\t");
	    while(j< A.length) {
	    	System.out.print( " " + A[j]);
	    	j++;
	    }
	  
	}
	
	public static ArrayList<Integer>  sortColorsArr(int[] A) {
		//if (A.length == 1 || A.length ==0)  return A;
		int len = A.length;  System.out.println("len="+ len);
		int middle = len/2;  System.out.println("middle=" + middle);
		
		if(len %2 == 0) {
			int[] left = new int[middle];
			int[] right = new int[middle];
			int i=0;
			 while (i < middle) {
				left[i] = A[i];
				i++;
			 }
		
			int j= 0;
			while (j < middle) {
				right[j] = A[j+middle];
				j++;
			}
			ArrayList<Integer>  left1 = sortColorsArr(left);
		
			ArrayList<Integer>  right1 = sortColorsArr(right);
			
			ArrayList<Integer> list = mergeSubColors(left1, right1);
			
		} else {   // odd 
			int[] left2 = new  int[A.length-1];
			
			int k=0;
			while( k < A.length-1) {
				left2[k] = A[k];
				k++;
			}
			int[] right2 =new int[1];
			right2[0] =  A[A.length-1];
		
			ArrayList<Integer>  left3 = sortColorsArr(left);
		
			ArrayList<Integer>  right3= sortColorsArr(right);
		
			ArrayList<Integer> list = mergeSubColors(left3, right3);
		}
		return list;
		
	}
	
	public static ArrayList<Integer> mergeSubColors(ArrayList<Integer>left, ArrayList<Integer> right) {
		int l_len = left.length;
		int r_len = right.length;

	   int i=0;
	   int j=0;
	   int k=0;
	   ArrayList<Integer> pnew = new ArrayList<Integer>();
	   while((i< l_len || j < r_len) && k < left.length *2 -2){
			if(j == r_len){
				pnew.add(left[i]);
				i++;
			
				k++;
			} else if( i ==l_len) {
			
					pnew.add(right[j]);
				j++;
			
				k++;
			} else {
				if(left[i] < right[j]) {
				
				    pnew.add(left[i]);
					i++;
				
					k++;
				} else if( left[i] == right[j]) {
					pnew.add(left[i]);
					pnew.add(left[i]);
					i++;
					j++;
					
				} else {
					// pnew[k] = right[j];
					pnew.add(right[j]);
			
					j++;
				}
			}	 
	   }	
		return pnew;
	}
	
	
	public static void main(String[] args){
		int[] A= { 0, 1, 2, 0, 0, 1, 1, 2, 2 , 0, 1, 2, 0, 1,2};
		sortColors(A);
	}
}