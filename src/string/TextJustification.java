/*
 * 68. Text Justification  QuestionEditorial Solution  My Submissions
Total Accepted: 36777
Total Submissions: 220301
Difficulty: Hard
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
Hide Company Tags LinkedIn Airbnb
Hide Tags String

 */
package string;

import java.util.*;

public class TextJustification {

	public static void main(String[] args) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int L = 16;
		
		TextJustification tj = new TextJustification();
		ArrayList<String> result = tj.fullJustify(words, L);
		for (String line : result)
			System.out.println(line);
	}
	
	// T(len(words)*L), S(len(words)*L)
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> res = new ArrayList<String>();
		
		int len=0; 		// count current line char length
		int start=0; 	// count the start index of the word in current line
		
		for(int i=0; i<words.length; i++) {
			len +=words[i].length();
			if(len+i-start>L){ //i-start means the least spaces we need between words
				res.add(justify(words, start, i-1, len-words[i].length(), L));
				len=words[i].length(); // reset len
				start=i;
			}
		}
		// last line
		if(len>0) res.add(justify(words, start, words.length-1, len, L));
		if(res.size()==0) res.add(stuffSpaces(L));
		return res;
	}
	// generate a string of Length L, containing words[start...end] inclusively
	// T(L), S(L)
	private String justify(String[] words, int start, int end, int total, int L){
		StringBuilder sb = new StringBuilder();
		if(end==start || end==words.length-1){ // single word or last line
			while(start<end) sb.append(words[start++]).append(" ");
			sb.append(words[end]).append(stuffSpaces(L-sb.length()));
		} else {
			int space=(L-total)/(end-start);
			int extra=(L-total)%(end-start);
			while(start<end){
				sb.append(words[start++]);
				sb.append(stuffSpaces(space));
				if(extra>0)	{
					sb.append(" ");
					extra--;
				}
			}
			sb.append(words[end]);
		}
		return sb.toString();
	}
	
	private String stuffSpaces(int n){
		if(n==0) return "";
		StringBuilder sb = new StringBuilder();
		while(n-->0) sb.append(" ");
		return sb.toString();
	}

}
