package oj.ots;

import java.util.*;
import java.util.Map.Entry;

public class RemoveLeastChars {
	/*
	 * 3. remove the least number of letters so each letter's count is unique,
	 * return t‍‌‌‍‌‌‍‌‌‌‌‌‍‍‌‍‌he removed count 
	 * 
	 */
	// python solution:
	// def lestRemoval(self, text):
	// c = Counter(text)
	// l = c.values()
	// st, cnt = set(), 0
	// for i in sorted(l, reverse=True):
	// while i in st:
	// i-=1
	// cnt+=1
	// st.add(i)
	// return cnt


	public List<Integer> topKFrequentInteger(int[] nums, int k) {
		// freq map
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		for (int n : nums) {
			freq.put(n, freq.getOrDefault(n, 0) + 1);
		}
		// bucket sort on freq
		List<Integer>[] bucket = new List[nums.length + 1];
		for (int i = 0; i < bucket.length; i++)
			bucket[i] = new ArrayList();
		for (int key : freq.keySet()) {
			bucket[freq.get(key)].add(key);
		}
		// gather result
		List<Integer> res = new ArrayList();
		for (int i = bucket.length - 1; i >= 0; i--) {
			res.addAll(bucket[i]);
			if (res.size() >= k)
				break;
		}
		return res;
	}
	
	

	public List<Character> topKFrequentChars(String s, int k) {
		char[] letters = s.toCharArray();
		// freq map
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		for (char c : letters) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		// bucket sort on freq
		List<Character>[] bucket = new List[letters.length + 1];
		for (int i = 0; i < bucket.length; i++)
			bucket[i] = new ArrayList();
		for (char key : freq.keySet()) {
			bucket[freq.get(key)].add(key);
		}
		// gather result
		List<Character> res = new ArrayList();
		for (int i = bucket.length - 1; i >= 0; i--) {
			res.addAll(bucket[i]);
			if (res.size() >= k)
				break;
		}
		return res;
	}
	
	public int leastRemoval(String s) {
		 Map<Character, Integer> map = new HashMap<>();  // Frequency map
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
						
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet()); // s: "aaaabbbbccd", pq: [a=4, b=4, c=2, d=1]
        
        int leastRemoval = 0;
        
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> uniqueSet = new HashSet<Integer>();
        while (!pq.isEmpty()) {
            Entry<Character, Integer> e = pq.poll();
            int val = (int) e.getValue();            
            list.add(val); // [a=4, b=4, c=2, d=1]
        }
        
        for (Integer i : list) {
        		while (uniqueSet.contains(i)) {
        			if (i == 0) break;
        			i -= 1;			
        			leastRemoval++;        			
        		}         		
        		uniqueSet.add(i);  // [a=4, b=3, c=2, d=1]       		
        }                        
		return leastRemoval;
	}
	
	 public String frequencySort(String s) {
	        Map<Character, Integer> map = new HashMap<>();
	        for (char c : s.toCharArray())
	            map.put(c, map.getOrDefault(c, 0) + 1);
							
	        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
	        pq.addAll(map.entrySet());
	        System.out.println("pq");
	        System.out.println(pq);
					
	        StringBuilder sb = new StringBuilder();
	        int leastRemoval = 0;
	       
	        
	        Set<Integer> occuars = new HashSet<Integer>();
	        while (!pq.isEmpty()) {
	            Map.Entry e = pq.poll();
	            
	            int val = (int) e.getValue();
	            
	            if (occuars.contains(val)) {
//	            		System.out.println("key: " + (char) e.getKey());
//	            		System.out.println("value: " + val);
	            		val--;
	            		leastRemoval++;
	            		
	            } else {
	            		occuars.add(val);
	            }
	   
	           
	            for (int i = 0; i < (int)e.getValue(); i++) 
	                sb.append(e.getKey());
	        }
	        System.out.println("occuars: "+ occuars);
	        System.out.println("leastRemoval: "+ leastRemoval);
	        
	        return sb.toString();
	    }

	/*
	 * 347. Top K Frequent Elements
	 * https://leetcode.com/problems/sort-characters-by-frequency/
	 * 451. Sort Characters By Frequency
	 * 164 https://leetcode.com/problems/maximum-gap/
	 * 
	 */

	public static void main(String[] args) {
		String[] strs = { "aaaabbbbccd", "aaab", "aabbcc", "ab", "abbcccdd", "lmnalmn", "a", "" };

		RemoveLeastChars ts = new RemoveLeastChars();
		for (String str : strs) {
			System.out.println("\nstr: " + str);
			int ret = ts.leastRemoval(str);
			System.out.println("ret: " + ret);
//			String freqStr = ts.frequencySort(str);
//			System.out.println("freqstr: " + freqStr);
			//System.out.println("str: " + str + ", ret: " + ret);
		}
	}

}
