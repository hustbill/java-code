package oj;



	// Given a list of jobs with their dependencies, is it possible to schedule all the jobs? If so then determine and print the order in which all the jobs could be scheduled.

	// Example:

	// A: [B,C]
	// B: []
	// C: [D]
	// D: []

	// Output:
	// B D C A
	// or
	// D C B A


	import java.io.*;
	import java.util.*; 
	
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	

	public class UberCodingSol {
	    public static void main(String args[] ) throws Exception {
	        System.out.println("Hello World");
	        Map<String, List<String>> map = new HashMap<String, List<String>>();
	        List<String> listA = new ArrayList<>();
	        listA.add("B");
	        listA.add("C");
	        List<String> listB = new ArrayList<>();
	        List<String> listD = new ArrayList<>();
	        
	        List<String> listC = new ArrayList<>();
	        listC.add("D");
	        map.put("A", listA);
//	        map.put("B", listB);
	        map.put("C", listC);
//	        map.put("D", listD);
	        UberCodingSol sl = new UberCodingSol();
	        List<String> ret = sl.scheduleJobs(map);
	        System.out.println(ret);
	    }
	    
	    // if only two depencies for one node , binary tree travesal
	    /*
	    A: B C E
	    E: []
	    
	    => E D C B A
	    */
	    
	    // brute-force first
	    /*
	    
	    Map<String, List<String>> map
	   step1: traversal the each key, and get the pairs
	   
	    A ->B  A->C
	    B -> null
	    c -> D
	    D -> null
	    
	   step 2: link the result of step 1 
	   A->C ->D
	   A->B->D
	   
	   Final:
	   A->C-> D -> B  => B - D - C -A
	    */
	    public List<String> scheduleJobs(Map<String, List<String>> map) {
	        List<String> result = new ArrayList<>();
	        
	        // s1: traversal the map
	        List<List<String>> lists = new ArrayList<>();
	        for (String key : map.keySet()) {
	             List<String> vals = map.get(key);
	             List<String> pairs = new ArrayList<>();
	             for (String val : vals) {
	                 pairs.add(key);
	                 pairs.add(val);
	             }
	             lists.add(pairs);
	        }
	        
	        // s2 : merge the pairs 
	        // For each pair:  [A, B], [A, C], [C, D]
	        // merge  [A, C] [C, D]  to  ArrayList A - > C - > D
	        
	        List<List<String>> mergedLists  = new ArrayList<>();
	          List<String> tempList  = new ArrayList();
	        for (int i = 0; i < lists.size(); i++) {
	            for (int j = 1; j < lists.size(); j++) {
	              tempList =   mergeTwoPairs(lists.get(i), lists.get(j));
	            }
	            mergedLists.add(tempList); // A - > C - > D
	        }
	        
	        // s3: add the remaining job  B  
	        // Suppose  ArrayList<String> list : A -> C -> D
	        
	        // check the elements in list, and map.keys,  find the no-depency node B
	        for (List<String> list : mergedLists) {
	            String node = getNoDependcyNode(list, map.keySet());
	            list.add(node); // A- c - d - b
	            result = list;
	        }
	        
	        // reverse the list 
	        // result = reverse(list);
	        return result;
	    }
	    
	    public String getNoDependcyNode(List<String> list, Set<String> keys) {
	        String ret = "";
	        for (String key : keys) {
	            if (!list.contains(key)) {
	                ret = key;
	            }
	        }
	        return ret;
	    }
	    
	    
	    public List<String> mergeTwoPairs(List<String> p1, List<String> p2) {
	        List<String> ret = new ArrayList<String>();
	        ret.add(p1.get(0));
	        if (p1.get(1) == p2.get(0)) {
	            ret.add(p1.get(1));
	            ret.add(p2.get(1));
	        }
	        return ret; // A -> C -> D
	    }
	    
	}
