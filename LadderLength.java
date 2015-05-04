/*

Word Ladder

https://leetcode.com/problems/word-ladder/

Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.


*/
import java.util.*;

public class LadderLength {
    public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		int len = beginWord.length();
		String interWord = beginWord;
		int count =0; // the number of same letters between interWord and endWord
		Set<String> result = new HashSet<String>();
		result.add(beginWord);
		
		if ( endWord.length() != len) 
			return 0;
		
        for( int i=0; i< len; i++) {
			for( int j=0; j< len; j++) {
				//System.out.print(beginWord.charAt(i) + ", " + endWord.charAt(j) + " count=" + count +  " ");
		        interWord = beginWord.replace( beginWord.charAt(i), endWord.charAt(j));
					
					
					if( wordDict.contains(interWord)) {  // interWord is in wordDict
						System.out.println(interWord);
						result.add(interWord);
						ladderLength(interWord, endWord, wordDict);
						count++;
						
						if(count == len -1 ) {
							System.out.println(result);
							return result.size();
						}
					}
					 // else{
	 // 						System.out.println(" interWord is not in wordDict");
	 //
	 //
	 // 					}
				
				
				 // else {
	 // 					ladderLength(interWord, endWord, wordDict);
	 // 				}
        	}
        }
		
		return result.size();
    }
	
	public static void main(String[] args) {
		String start = "hit", end = "cog";
		String[] dict = {"hot","dot","dog","lot","log"};
		Set<String> wordDict = new HashSet<String>();
		for(int i=0; i< dict.length; i++) {
			wordDict.add(dict[i]);
		}
		System.out.println(ladderLength(start, end, wordDict));
		
	}
}