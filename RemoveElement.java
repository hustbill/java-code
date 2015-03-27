//Remove Element 
// https://oj.leetcode.com/problems/remove-element/

/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

*/

import java.util.*;

public class RemoveElement {
    public static int removeElement(int[] A, int elem) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i< A.length; i++) {
			 map.put(A[i], i);
            if(A[i] == elem)
				map.values().remove(A[i]);
        }
        return map.size();
		
    }
	
	public static void main(String args[] ) {
		//int A[] = { 1, 3, 5, 9, 11, 23, 29};
		//int elem = 11;
		int A[] = {3, 3};
		int elem = 5;
		System.out.println("Before remove element, A.length is " + A.length);
		int size = removeElement(A, elem);
		System.out.println("After remove element, the size is " + size);
	}
}