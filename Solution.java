import java.util.*;

public class Solution {

     
     public static void main(String[] args) {
         
         System.out.println("hello world");
         List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
         
         
            ArrayList<Integer> a1 = new ArrayList<Integer>();
      	// add elements to the array list
      	a1.add(1);
      	a1.add(2);
		
		ArrayList<Integer> a2 = new ArrayList<Integer>();
      	a2.add(3);
      
      	ArrayList<Integer> a3 = new ArrayList<Integer>();
      	a3.add(4);
      	a3.add(5);
      	a3.add(6);
		a3.add(7);
		a3.add(8);
      	vec2d.add(a1);
      	vec2d.add(a2);         
    	vec2d.add(a3);
        boolean flagTestZigzag = true;
      
	   if( flagTestZigzag) {
		/**
		 * Your ZigzagIterator object will be instantiated and called as such:
		 * ZigzagIterator i = new ZigzagIterator(v1, v2);
		 * while (i.hasNext()) v[f()] = i.next();
		 */
		ZigzagIterator j = new ZigzagIterator(a1, a3);
		while (k.hasNext()) 
			System.out.println("ZigzagIterator : " + j.next());
	  } else {
		 /**
		 * Your Vector2D object will be instantiated and called as such:
		 * Vector2D i = new Vector2D(vec2d);
		 * while (i.hasNext()) v[f()] = i.next();
		 */
		Vector2D i = new Vector2D(vec2d);
        int[] v = new int[vec2d.size()];
        System.out.println("size = " + vec2d.size());
 			
 		while (i.hasNext()) {
 			System.out.println("next = " +i.next());
 			
 		}
		System.out.println("PeekingIterator");
		Iterator<Integer> iterator = a3.iterator();
		PeekingIterator k = new PeekingIterator(iterator);
     	while (k.hasNext()) {
			System.out.println("\n next = " +k.next());
			System.out.println("peek = " +k.peek());
			} 
		}
	 }
     
    
     

}

//https://www.hackerrank.com/

