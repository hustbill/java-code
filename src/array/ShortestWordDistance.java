/*
 * 243. Shortest Word Distance  QuestionEditorial Solution  My Submissions
Total Accepted: 12928
Total Submissions: 27206
Difficulty: Easy
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Hide Company Tags LinkedIn
Hide Tags Array
Hide Similar Problems (M) Shortest Word Distance II (M) Shortest Word Distance III

 */
package array;

public class ShortestWordDistance {
	
    public int shortestDistance(String[] words, String word1, String word2) {
    	// https://discuss.leetcode.com/topic/29963/short-java-solution-10-lines-o-n-modified-from-shortest-word-distance-i
        int index = -1;
        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && !words[index].equals(words[i])) {
                    min = Math.min(i - index, min);
                }
                index = i;
            }
        }
        return min;
    }
    
    public int shortestDistanceTwopointer(String[] words, String word1, String word2) {
        // https://discuss.leetcode.com/topic/20668/ac-java-clean-solution
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
            }
            if (words[i].equals(word2)) {
                p2 = i;
            }
            if (p1 != -1 && p2 != -1 ) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        return min;
    }
    
	public int shortestDistanceMine(String[] words, String word1, String word2) {
		if (words == null || words.length == 0) return -1;
		int start = 0, end = words.length - 1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				start = i;
			} 
			if (words[i].equals(word2)) {
				end = i;
			}
			
		}
		return (int)Math.abs(start -end);
	}

	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		// Given word1 = “coding”, word2 = “practice”, return 3.
		//	Given word1 = "makes", word2 = "coding", return 1.
		ShortestWordDistance swd = new ShortestWordDistance();
		String word1 = "coding";
		String word2 = "practice";
		System.out.println(swd.shortestDistance(words, word1, word2));
		

	}

}
