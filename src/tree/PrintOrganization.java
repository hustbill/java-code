package tree;

import java.util.*;



public class PrintOrganization {
	class Pair {
		int first;
		int second;
		public Pair (int a, int b) {
			first = a;
			second = b;
		}
	}
	/*
	 * input  List<Pair>  list 
	 * 
	 * print the organization such as 
	 * 1
	 * 	- 2
	 * 		-4
	 * 		-6
	 * 			-7
	 * 	-3
	 * 		-5
	 * 			-8
	 * 			-9
	 * 	-10
	 * 		-11
	 * 		-12
	 * 		-13
	 */	
	
//	 public void printOrg(List<Pair> list) {
//			
//	 }
	 public static void printOrg(List<List<Integer>> pairs) {
		int level = 0;
		helper(pairs, level);
	 }
	 
	 public static void helper(List<List<Integer>> pairs, int level) {
		 HashMap<Integer, Integer> map = new HashMap<>();
		System.out.println(pairs);
		 
	 }

	public static void main(String[] args) {
	
//		List<Pair> list = new ArrayList<Pair>();
//		Pair one = new Pair(1, 0);
		
		List<List<Integer>> pairs = new ArrayList<List<Integer>>();
		List<Integer> pairOne = new ArrayList<Integer>();
		
		pairOne.add(1);
		pairOne.add(0);
		pairs.add(pairOne);
		
		List<Integer> pair2 = new ArrayList<Integer>();
		
		pair2.add(2);
		pair2.add(1);
		pairs.add(pair2);
		
		List<Integer> pair3 = new ArrayList<Integer>();
		
		pair3.add(3);
		pair3.add(1);
		pairs.add(pair3);
		
		List<Integer> pair10 = new ArrayList<Integer>();
		
		pair10.add(10);
		pair10.add(1);
		pairs.add(pair10);
		
		List<Integer> pair11 = new ArrayList<Integer>();
		
		pair11.add(11);
		pair11.add(10);
		pairs.add(pair11);
		
		List<Integer> pair12 = new ArrayList<Integer>();
		pair12.add(12);
		pair12.add(10);
		pairs.add(pair12);
		
		List<Integer> pair13 = new ArrayList<Integer>();
		pair13.add(13);
		pair13.add(10);
		pairs.add(pair13);
		
		printOrg(pairs);
	}

}
