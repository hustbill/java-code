/*

LRU Cache
Date: 2015.03.28

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

https://leetcode.com/problems/lru-cache/

*/


/*
   my solution:   use a hashmap to store key and value pairs. use an array to track the items was visited or not. 
   if the size of hashmap() is reached the cache capacity. then remove the 
   
*/
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Map;
import java.util.Hashtable;
import java.util.Iterator;

public class LRUCache {
    
	public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
	public static int capacity =0;

    public LRUCache(int capacity) {
		// use arraylist<String, Integer> store the vistied item and count. 
		this.capacity = capacity;
    }
    
    public static int get(int key) {
		if (map.containsKey(key)) {
			table.put(key, (int) System.currentTimeMillis());
			
			return map.get(key);
		} else 
			return -1;
        
    }
    
    public static void set(int key, int value) {
		if( !map.containsKey(key)) {
			if(map.size() < capacity) {
				map.put(key, value);
				table.put(key, (int)System.currentTimeMillis());
			} else {
				System.out.println(String.format("key=%d, value=%d",key, value));
				System.out.println(table);
				// remove the least recent visited item
				 rmLeastUsedItem(table);
				 System.out.println("remove the least recent visited item");
				 map.put(key, value);
				 	table.put(key, (int)System.currentTimeMillis());
			 }
		}
    }
	
	public static void rmLeastUsedItem(Hashtable table){
		// sort map by the values 
		ArrayList<Integer> values= new ArrayList( table.values());
		 // comparing using natural ordering
		 int max = (int) Collections.max(values,null);
		  //System.out.println("Max val: " + max); 
		  
		  Iterator<Map.Entry<Integer, Integer>> iter = table.entrySet().iterator();
		  while (iter.hasNext()) {
		      Map.Entry<Integer,Integer> entry = iter.next();
		      if(max == entry.getValue()){
		          iter.remove();
				 // System.out.println("entry.getKey()" +iter.getKey());
		      }
		  }
	}
	
	public static void main(String[] args){
		//int capacity = 6;
		LRUCache cache = new LRUCache(2);
		// for(int i=0; i< capacity+1; i++) {
	// 			cache.set(i, i*i);
	// 			System.out.println(String.format("cache.get(%d) = %d", i, cache.get(i)));
	// 	}
	cache.set(2,1);
	cache.set(1,1);
	cache.set(2,3);
	cache.set(4,1);

	System.out.println("cache.get(1)=" + cache.get(1));
	System.out.println("cache.get(2)=" + cache.get(2));
	}
}