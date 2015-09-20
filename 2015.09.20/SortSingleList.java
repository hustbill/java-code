//  SortSingleList.java
//  oj
//
//  Created by hua zhang on 2014-11-11.
//  Copyright 2014 hua zhang. All rights reserved.
//
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import java.util.ArrayList;

public class SortSingleList{
     static ListNode sortList(ListNode head) {
		 // user merge sort 
		 
	
		return head;
    }
	
	public static int[] mergeSort(int[] valueList) {
		int[] in = new int[valueList.length]; // make a new temporary array
		System.arraycopy(valueList, 0, in, 0, in.length);  // copy the input
		int[] out = new int[valueList.length];			// output array
		int[] temp;  // temp array reference used for swapping 
		int n = in.length;  
		for(int i=1; i< n; i*=2) { // each iteration sorts all lengh-2*i runs
			for(int j=0; j< n; j+= 2*i) {  // each iteration merges two length-i pairs
				merge(in,out, j, i);   // merge from in to out two length -i runs at j
				temp = in; in = out;  out = temp; // swap arrays for next iteration
			}
			// the "in" array contains the sorted array, so re-copy it
			System.arraycopy(in, 0, valueList, 0, in.length);
			
		}
		
		return valueList;
 
	}
	
	/*
		Merges two subarrays, specified by a start and increment 
    */
	protected static void merge(int[] in, int[] out, int start, int inc) {
		// merge in[ start .. start+inc-1] and in[start +inc.. start + 2*inc -1]
		int x = start; // index into run #1
		int end1 = Math.min(start+inc, in.length);  // boundary for run #1
		int end2 = Math.min(start+ 2*inc, in.length) ; // boundary for run #2
		int y = start + inc; // index into run #2 (could be beyound array boundary)
		int z = start;    // index into the out array
		
		while ((x < end1) && (y < end2)) 
			if(in[x] <= in[y]) 
				 out[z++] = in[x++];
			else
				 out[z++] = in[y++];
		 
			if( x < end1) // first run didn't finish
				System.arraycopy(in, x , out, z, end1 -x);
			else if( y < end2)  // second run didn't finish
				System.arraycopy( in, y, out, z , end2-y);
			
		
	}
	
	
	public static void mergeArrayListSort(ArrayList<Integer> in) {
		int n = in.size();
		
		if( n< 2) {
			return ; // the in list is already sorted in this case
			
		}
		// divide 
		ArrayList<Integer> in1 = new ArrayList<Integer>();
		ArrayList<Integer> in2 = new ArrayList<Integer>();
		int i =0; 
		while (i < n/2) {
			in1.add((int)in.remove(in.get(0))) ; // move the first n/2 elements to in1
			i++;
		}
		
		while(!in.isEmpty()) 
			in2.add((int)in.remove(in.get(0))) ; // move the rest to in2
		
		// recur
		mergeArrayListSort(in1) ;
		mergeArrayListSort(in2);
		
		//conquer
		merge2(in1, in2, in);
	}
	
	
	public static void merge2(ArrayList<Integer> in1, ArrayList<Integer> in2) {
		while(!in1.isEmpty() && !in2.isEmpty()) 
			if(c.compare(in1.get(0).element(), in2.get(0).element()) <=0 ) 
				in.add(in1.remove(in1.get(0)));
			else 
				in.addLast(in2.remove(in2.get(0)));
		
			while(!in1.Empty()) 
				in.addLast(in1.remove(in1.get(0)));
			while(!in2.Empty()) 
				in.addLast(in2.remove(in2.get(0)));
		
	}
	
	static int  displayList(ListNode head) {
		int count =0;
		ListNode  outPut = head;
		while(outPut != null) {
			//System.out.print(String.format("%d->", outPut.val));
			System.out.print(outPut.val + " ");
			outPut = outPut.next; 
			count++;
		}
		System.out.println();
		return count;
	}
	
	static int[]  copy2IntArray(ListNode head) {
		int length = displayList(head);
		int[] valueList = new int[length];
		int i =0;
		ListNode  outPut = head;
		while(outPut != null) {
			//System.out.print(String.format("%d->", outPut.val));
			valueList[i] = outPut.val;
			//System.out.print(outPut.val + " ");
			outPut = outPut.next; 
			i++;
		}
		System.out.println();
		return valueList;
	}

	
	static ArrayList copy2ArrayList(ListNode head) {
		int length = displayList(head);
		//int[] valueList = new int[length];
		ArrayList  list = new ArrayList();
		int i =0;
		ListNode  outPut = head;
		while(outPut != null) {
			//System.out.print(String.format("%d->", outPut.val));
			//valueList[i] = outPut.val;
			list.add(outPut.val);
			//System.out.print(outPut.val + " ");
			outPut = outPut.next; 
			i++;
		}
		System.out.println();
		return list;
	}
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static void main(String args[]) {
   		ListNode head =null,  temp = null, next = null;
   		int nodeArray[] = { 1, 3, 7 , 8 , 11, 24, 9, 61, 48 ,19, 17};
   		for(int i = 0; i< nodeArray.length -1; i++) {   			
	        ListNode obj = new ListNode(nodeArray[i]);
	               if (temp != null) {
	                   temp.next = obj;
	               } else {
	                   head = obj;
	               }
	               temp = obj;
   		}
		
		//int count = displayList(head); //	
		//System.out.println("count = " + count);
		int[] valueList = copy2IntArray(head);
		// for(int i=0; i< valueList.length; i++)
		// 	System.out.print(valueList[i] + " ");
		//
		// System.out.println();
		
		ArrayList list = copy2ArrayList(head);
		
		int[] output = mergeSort(valueList);
		for(int j=0; j < output.length; j++)
			System.out.print(output[j] + " ");
		
		System.out.println();
		
	}
}