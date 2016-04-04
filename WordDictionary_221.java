/*
211. Add and Search Word - Data structure design
Total Accepted: 22556 Total Submissions: 111357 Difficulty: Medium
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

click to show hint.

Hide Company Tags Facebook
Hide Tags Backtracking Trie Design
Hide Similar Problems (M) Implement Trie (Prefix Tree)
*/

import java.util.*;

public class WordDictionary_221 {

    public static List<String> list = new ArrayList<>();
    

    
    public static void main(String[] args) {
         WordDictionary_221 wd = new WordDictionary_221();
         wd.addWord("word");
         wd.addWord("bad");
         wd.addWord("dad");
         wd.addWord("mad");
         System.out.printf("%s\n", wd.search("pad") == false ? 
             "Test case 1 success" : "Test case 1 failed");
             
        System.out.printf("%s\n", wd.search("bad") == true ?
            "Test case 2 success" : "Test case 2 failed");

        System.out.printf("%s\n", wd.search(".ad") == true ?
            "Test case 3 success" : "Test case 3 failed");

        System.out.printf("%s\n", wd.search("b..") == true ?
            "Test case 4 success" : "Test case 4 failed");
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        list.add(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public static boolean search(String word) {
        for(String e : list) {
            if (compareTwoStrs(e, word) == true)  {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean compareTwoStrs(String a, String b) {
        if (a.length() != b.length()) return false;
        
        int n = a.length();
        for (int i=0; i < n; i++) {
           return a.charAt(i) == b.charAt(i) || b.charAt(i) == '.' ;
        }
        
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
