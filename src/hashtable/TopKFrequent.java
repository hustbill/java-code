/*
 * 347. Top K Frequent Elements My Submissions QuestionEditorial Solution
Total Accepted: 16347 Total Submissions: 38153 Difficulty: Medium
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
Hide Company Tags Pocket Gems Yelp
Hide Tags Hash Table Heap
Hide Similar Problems (M) Word Frequency (M) Kth Largest Element in an Array

 */
package hashtable;

import java.util.*;

public class TopKFrequent {

	
	// Bucket sort  O(n), beat 87.19% javasubmissions
	// Idea is simple. Build a array of list to be buckets with length 1 to sort.
	// https://leetcode.com/discuss/100581/java-o-n-solution-bucket-sort
	public List<Integer> topKFrequent(int[] nums, int k) {
	
		List<Integer> [] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		
		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}
		
		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		
		List<Integer> res = new ArrayList<>();
		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}
	
	// beat 12.5% java submissions using priority queue
	public List<Integer> topKFrequentPQ(int[] nums, int k) {
		/*
		 * https://leetcode.com/discuss/100704/java-straightforward-o-n-n-k-lg-k-solution
		 * Idea is very straightforward:
		 * 
		 * build a counter map that maps a num to its frequency build a
		 * heap/priority queue that keeps track of k most significant entries
		 * iterate through the final heap and get the keys
		 */
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		HashMap<Integer, Integer> counterMap = new HashMap<>();

		for (int num : nums) {
			int count = counterMap.getOrDefault(num, 0);
			counterMap.put(num, count + 1);

		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		/*
		 * (a, b) -> a.getValue()-b.getValue(), is a way of implementing the
		 * abstract method required for using the comparator interface. This is
		 * called lambda expressions introduced in Java8.
		 */

		for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
			pq.offer(entry);
			if (pq.size() > k)
				pq.poll();
		}

		while (!pq.isEmpty()) {
			res.add(0, pq.poll().getKey());
		}
		return res;
	}

	/*
	 * In the end we have to poll all the remaining elements out of the heap and
	 * the time for this process shall be considered too, so I think the time
	 * complexity should be O(N + Nlgk), or just O(Nlgk).
	 */

	
	// https://leetcode.com/discuss/102558/java8-functional-solution
//	public static List<Integer> topKFrequentJava8(int[] nums, int k) {
//	    Map<Integer, Integer> counter = new HashMap<>();
//	    for (int num : nums) {
//	        counter.putIfAbsent(num, 0);
//	        counter.computeIfPresent(num, (key, oldVal) -> oldVal + 1);
//	    }
//	    return counter.entrySet()
//	            .stream()
//	            .sorted(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed())
//	            .limit(k)
//	            .map(Map.Entry::getKey)
//	            .collect(Collectors.toList());
//	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		TopKFrequent topk = new TopKFrequent();
		System.out.println(topk.topKFrequent(nums, k));
	}

}
