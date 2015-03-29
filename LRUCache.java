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
    
	public static HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
	private static DoubleLinkedListNode head;
	private static DoubleLinkedListNode end;
	private static int capacity;
	private static int len;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		len = 0;
    }
    
    public static int get(int key) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode latest = map.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.val;
		
		} else 
			return -1;
        
    }
	
	public static void removeNode(DoubleLinkedListNode node){
		DoubleLinkedListNode cur = node;
		DoubleLinkedListNode pre = cur.pre;
		DoubleLinkedListNode post = cur.next;
		if ( pre != null) {
			pre.next = post;
		}else {
			head = post;
		}
		if (post != null) {
			post.pre = pre;
		} else {
			end = pre;
		}
	}
    
	public static void setHead(DoubleLinkedListNode node ) {
		node.next = head;
		node.pre = null;
		if (head != null) {
			head.pre = node;
		}
		head = node;
		if(end == null) {
			end = node;
		}
	}
	
    public static void set(int key, int value) {
		if( map.containsKey(key)) {
			if(map.size() < capacity) {
				DoubleLinkedListNode oldNode = map.get(key);
				oldNode.val = value;
				removeNode(oldNode);
				setHead(oldNode);
			} else {
				DoubleLinkedListNode newNode = 
					new DoubleLinkedListNode(key, value);
				if( len < capacity) {
					setHead(newNode);
					map.put(key, newNode);
					len++;
				} else {
					// remove least used element
					map.remove(end.key);
					end = end.pre;
					if( end != null) {
						end.next = null;
					}
					
					setHead(newNode);
					map.put(key, newNode);
				}
				
			 }
		}
    }
	
	
	public static void main(String[] args){
		//int capacity = 6;
		LRUCache cache = new LRUCache(2);
		cache.set(2,1);
		cache.set(1,1);
		cache.set(2,3);
		cache.set(4,1);

		System.out.println("cache.get(1)=" + cache.get(1));
		System.out.println("cache.get(2)=" + cache.get(2));
	}
	
}

 class DoubleLinkedListNode {
    public int val;
    public int key;
    public DoubleLinkedListNode pre;
    public DoubleLinkedListNode next;
 
    public DoubleLinkedListNode(int key, int value) {
        val = value;
        this.key = key;
    }
}

