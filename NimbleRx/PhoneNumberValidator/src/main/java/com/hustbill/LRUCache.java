/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 *  When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
package com.hustbill;

import java.util.*;

public class LRUCache {

	private class Node {
		public Node prev;
		public Node next;
		public long key;
		public int val;

		public Node(long k, int v) {
			key = k;
			val = v;
		}
	}

	private int cap;
	private HashMap<Long, Node> map = new HashMap<>();
	private Node head = new Node(-1, -1), tail = new Node(-1, -1);

	public LRUCache(int capacity) {
		cap = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(long key) {
		if (!map.containsKey(key))
			return -1;

		Node n = map.get(key);
		n.prev.next = n.next;
		n.next.prev = n.prev;

		insertTail(n);
		return n.val;
	}

	private void insertTail(Node n) {
		n.prev = tail.prev;
		n.prev.next = n;
		n.next = tail;
		n.next.prev = n;
	}

	public void set(long key, int value) {
		if (map.containsKey(key)) { // if key exists
			Node n = map.get(key);
			n.val = value;
			n.prev.next = n.next;
			n.next.prev = n.prev;
			insertTail(n);
			return;
		}
		if (cap == map.size()) { // no space
			Node n = head.next;
			n.prev.next = n.next;
			n.next.prev = n.prev;
			map.remove(n.key);
		}
		// exists, and have the space
		Node n = new Node(key, value);
		map.put(key, n);
		insertTail(n);
	}
}