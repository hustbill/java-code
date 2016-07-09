/*
 * 244. Shortest Word Distance II  QuestionEditorial Solution  My Submissions
Total Accepted: 8916
Total Submissions: 25026
Difficulty: Medium
This is a follow up of Shortest Word Distance. 
The only difference is now you are given the list of words and your method will be called repeatedly many times
 with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a
 method that takes two words word1 and word2 and return the shortest
  distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Hide Company Tags LinkedIn
Hide Tags Hash Table Design
Hide Similar Problems (E) Merge Two Sorted Lists (E) Shortest Word Distance (M) Shortest Word Distance III


245. Shortest Word Distance III  QuestionEditorial Solution  My Submissions
Total Accepted: 8612
Total Submissions: 18423
Difficulty: Medium
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.

 */
package array;

import java.util.*;

public class WordDistance {

	HashMap<String, List<Integer>> map;

	// 244. Shortest Word Distance II 
	public WordDistance(String[] words) { // beat 94.69% java
		map = new HashMap<String, List<Integer>>();
		for (int i = 0; i < words.length; i++) {
			String w = words[i];
			if (map.containsKey(w)) {
				map.get(w).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(w, list);
			}
		}
	}
	
	// 245 word distance III
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index = -1;
        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && (word1.equals(word2) || !words[index].equals(words[i]))) {
                    min = Math.min(i - index, min);
                }
                index = i;
            }
        }
        return min;
}
    

	public int shortest(String word1, String word2) {
		int min = Integer.MAX_VALUE;
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);

		if (list1 != null && list2 != null) {
			for (int i = 0, j = 0; i < list1.size() && j < list2.size();) {
				int index1 = list1.get(i);
				int index2 = list2.get(j);
				if (index1 < index2) {
					min = Math.min(min, index2 - index1);
					i++;
				} else {
					min = Math.min(min, index1 - index2);
					j++;
				}
			}
		}

		return min;
	}

	public static void main(String[] args) {
		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		WordDistance wordDistance = new WordDistance(words);
		int d1 = wordDistance.shortest("coding", "makes");
		int d2 = wordDistance.shortest("anotherWord1", "anotherWord2");

		System.out.printf("d1 = %d, d2 = %d", d1, d2);

	}

}
