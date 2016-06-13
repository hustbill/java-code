package v201604;
/*
243. Shortest Word Distance   
Total Accepted: 10375 Total Submissions: 22370 Difficulty: Easy
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

import java.util.*;

public class ShortestDistance_243 {
    public static void main(String[] args) {
        String[] words  = {"hello", "is", "word", "what", "is", "a ", "word" };
        String word1 = "hello";
        String word2 = "word";
        
        System.out.printf("Test case %s ", shortestDistance(words, word1, word2) == 2 ? "Success" : "Failed");
    }
    
    public static int shortestDistance(String[] words, String word1, String word2) {
        // https://leetcode.com/discuss/50234/ac-java-clean-solution
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) 
                p1 = i;

            if (words[i].equals(word2)) 
                p2 = i;

            if (p1 != -1 && p2 != -1)
                min = Math.min(min, Math.abs(p1 - p2));
        }

        return min;
    }
    
    public static int shortestDistance_mine(String[] words, String word1, String word2) {
        // ["hello", "is", "word", "what", "is", "a ", "word"]
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        
        for (int i = 0; i < words.length; i++) {
            
            if (words[i].equals(word1)) {
                list1.add(i);
            }
            
            if (words[i].equals(word2)) {
                list2.add(i);
            }
        }
        
        int curDistance = words.length - 1, distance = words.length - 1;
        
        for (int i : list1) {
            for (int j : list2) {
                curDistance = Math.abs(i - j);
                distance = Math.min(curDistance, distance);
            }
        }
        
        return distance;
        
    }
}