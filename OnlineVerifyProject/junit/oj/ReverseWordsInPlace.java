package oj;


import java.util.*;

public class ReverseWordsInPlace {

	// 151. reverse words in place
	 public String reverseWords(String s) {
	        if (s == "" || s.length() == 0) return s;

	        // split to words by space
	        String[] words = s.split(" ");

	        StringBuilder sb = new StringBuilder();

	        for (int i = words.length - 1; i >= 0; i--) {
	            if (!words[i].equals("")) {
	                sb.append(words[i]).append(" ");
	            }
	        }
	        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
	 
	 
	public static  void main(String[] args) {
		//  “how are you!" => “you! are how”
		String input = "how are you!";
		String output =  "you! are how";
		ReverseWordsInPlace ts  = new ReverseWordsInPlace();
		String ret = ts.reverseWords(input);
		System.out.println("ret: " + ret);
		System.out.println("Pass: "  + (ret.equalsIgnoreCase(output)));
	}

}
