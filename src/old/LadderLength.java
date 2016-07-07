package old;
/*127. Word Ladder
Total Accepted: 64765 Total Submissions: 331415 Difficulty: Medium
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
import java.util.*;

public class LadderLength {
    public static void main(String[] args) {
        String[] strs = {"hot","dot","dog","lot","log"};
        Set<String> wordList = new HashSet<String>();
        for (String str : strs) {
            wordList.add(str);
        }
        String beginWord = "hit";
        String endWord = "cog";
        int len = ladderLength(beginWord, endWord, wordList);
        System.out.printf("len = %d", len);
    }
    
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // using two sets  to record transformation steps
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordList.add(endWord);
        
        int distance = 1;
        while(!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for(int i=0; i < each.length(); i++) {
                    char[] chars =  each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordList.contains(word)) {
                            toAdd.add(word);
                            wordList.remove(word);   
                        }
                    } 
                }
            }
          distance++;
          if (toAdd.size() == 0) return 0;
          reached = toAdd;   
        }
        return distance;
    }
}