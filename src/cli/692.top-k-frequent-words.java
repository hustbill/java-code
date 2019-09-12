/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 *
 * https://leetcode.com/problems/top-k-frequent-words/description/
 *
 * algorithms
 * Medium (46.72%)
 * Total Accepted:    81.8K
 * Total Submissions: 174K
 * Testcase Example:  '["i", "love", "leetcode", "i", "love", "coding"]\n2'
 *
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two
 * words have the same frequency, then the word with the lower alphabetical
 * order comes first.
 * 
 * Example 1:
 * 
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * ⁠   Note that "i" comes before "love" due to a lower alphabetical order.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is",
 * "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent
 * words,
 * ⁠   with the number of occurrence being 4, 3, 2 and 1 respectively.
 * 
 * 
 * 
 * Note:
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * 
 * 
 * 
 * Follow up:
 * 
 * Try to solve it in O(n log k) time and O(n) extra space.
 * 
 * 
 */
// import java.util.*;

class Solution {
    // approach 2: using heap, Time complexity: O(Nlogk) , Space: O(N)
    // https://leetcode.com/problems/top-k-frequent-words/solution/
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ret = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<String>(
            (w1, w2) -> map.get(w1).equals(map.get(w2)) ? 
                    w2.compareTo(w1) : map.get(w1) - map.get(w2));
        
        for (String word : map.keySet()) {
            heap.offer(word);
            if (heap.size() > k) 
                heap.poll();
        }

        while (!heap.isEmpty()) {
            ret.add(heap.poll());
        }
        Collections.reverse(ret);
        return ret;
    }
}

