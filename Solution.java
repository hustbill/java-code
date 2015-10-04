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
      	vec2d.add(a1);
      	vec2d.add(a2);         
    	vec2d.add(a3);
        int j=0;
      
        Vector2D i = new Vector2D(vec2d);
        int[] v = new int[vec2d.size()];
        System.out.println("size = " + vec2d.size());
 			
 		while (i.hasNext()) {
 			System.out.println("next = " +i.next());
 			
 		}
		System.out.println("PeekingIterator");
		Iterator<Integer> iterator = a2.iterator();
		PeekingIterator k = new PeekingIterator(iterator);
     	while (k.hasNext()) {
 			System.out.println("next = " +k.next());
 		}
     }
     
     /**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
     

}

//https://www.hackerrank.com/

