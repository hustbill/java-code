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
	
		
		//Set<String> result = new HashSet<String>(wordDict.size());
		ArrayList<String> result = new ArrayList<String>();
		//result.add(beginWord);
		
		if ( endWord.length() != len) 
			return 0;
		
		if( beginWord.regionMatches(0, endWord, 0, len-1) ||
	  		beginWord.regionMatches(0, endWord, 1, len-1) ||
			beginWord.regionMatches(1, endWord, 0, len-1) ||
			beginWord.regionMatches(1, endWord, 1, len-1)
	   	) {
		   result.add(beginWord);
		   result.add(endWord);
		   return result.size();
		   
	  	} else {

			System.out.println(wordDict);
			 Iterator itr = wordDict.iterator(); 
			 while(itr.hasNext()) {
	 	     		Object obj = itr.next(); 
					String element = obj.toString();
					//System.out.println(element + " " + interWord);
				
				    if(  !interWord.equals(element) && 
						( interWord.regionMatches(0, element, 0, len-1) ||
				  		interWord.regionMatches(0, element, 1, len-1) ||
						interWord.regionMatches(1, element, 0, len-1) ||
						interWord.regionMatches(1, element, 1, len-1)
				   	)) {
						//System.out.println("interWord= " +interWord);
						 interWord = element;
						  //System.out.println("element= " +element);
						 //ladderLength(interWord, endWord, wordDict);
						 
				 		if( interWord.regionMatches(0, endWord, 0, len-1) ||
				 	  		interWord.regionMatches(0, endWord, 1, len-1) ||
				 			interWord.regionMatches(1, endWord, 0, len-1) ||
				 			interWord.regionMatches(1, endWord, 1, len-1)
				 	   	) {
				 		   result.add(interWord);
				 		   result.add(endWord);
						   System.out.println("result 1 =" + result);
				 		   return result.size() +1;
		   
				 	  	}
						 
			  		} else {
						int count =0; // the number of same letters between interWord and endWord
						for(int i=0; i< len; i++) {
							for(int j=0; j< len; j++) {
								////System.out.println(interWord.charAt(i) == element.charAt(j));
								if(interWord.charAt(i) == element.charAt(j)){
								
									count++;
									//System.out.println("count=" + count);
								}
							}
						}
						if(count == len-1) {  // hit -> hot
							interWord = element;
								result.add(interWord);
							 System.out.println("interWord= " +interWord);
							ladderLength(interWord, endWord, wordDict);
							
						}
						
			  		}
				} 
				//System.out.println();
	  	  }
		  System.out.println("result =" + result);
		  int size = result.size() +1;
		  return size;
    }
	
	public static void main(String[] args) {
		String start = "hit";
		String end = "dog";
		 String[] dict = {"hot","dot","dog","lot","log"};
		
		// String end = "cog";
			//String[] dict = {"hot","hit","cog","dot","dog"};
		
		Set<String> wordDict = new HashSet<String>();
		for(int i=0; i< dict.length; i++) {
			wordDict.add(dict[i]);
		}
		System.out.println(ladderLength(start, end, wordDict));
		
	}
}