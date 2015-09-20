/*
Date: 2015.0.3.19

https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/

Remove Duplicates from Sorted Array 
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].

*/

import java.util.*;


public class RemoveDuplicates {
	// Ref: http://blog.csdn.net/fightforyourdream/article/details/12719683
	    public int removeDuplicates(int[] A) {
	      int len = A.length;  
	        if(len < 2){  
	            return len;  
	        }  
          
	        // i遍历数组，j指向待检验是否与i相同的下一个数  
	        int i = 0, j = 1;  
	        while(i<len && j<len){  
	            if(A[i] == A[j]){       // 如果出现相同  
	                j++;        // 则j继续往前找，直到找到不同于A[i]数  
	            }else{  
	                i++;        // i跳动要被覆盖的重复那个数  
	                A[i] = A[j];        // 用非重复的j覆盖重复的i  
	                j++;        // 更新待检验的j  
	            }  
	        }  
          
	        // 返回长度是下标加1  
	        return i+1;  
        
	    }
	
    public static int removeDuplicates1(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if(A.length ==0 && A== null) return 0;
		if(A.length ==1)  return A.length;
		if(A.length > 1) {
			for (int i=0; i< A.length; i++) {
				if(!map.containsKey(A[i])) {
				System.out.println("A["+i +"] = " + A[i]);
				
				map.put( A[i],A[i]);
				System.out.println(map);
				}
			}
			System.out.println("keys= "+map.keySet());
			System.out.println(map.keySet().size());
			System.out.println(map.values());
		}
		return map.keySet().size();
    }
	
	public static void main(String[] args) {
		//int[] A = { 1 , 1, 2, 2, 3, 4, 0, 9,8, 6, 8, 7,6, 10};
		int[] A = { 1 , 1, 2};
		System.out.println("size = " + removeDuplicates(A));
	}
	
}