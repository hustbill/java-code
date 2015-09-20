/*
Minimum Window Substring 


https://oj.leetcode.com/problems/minimum-window-substring/

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

*/

import java.util.*;

public class MinWindow {
    public static String minWindow(String S, String T) {
		String res = "";
          if( S.length()== 1 && S.length() ==0)  return "";
          if(T.length() ==1 && T.length()==0) return T;
          Hashtable htStr = new Hashtable();
          Hashtable win = new Hashtable();
		  // get all substring of S which length =T.length() +1
	
			  for(int i =0; i< S.length()-T.length(); i++ ) {
				   System.out.println("i= "+ i);
				  	  System.out.println("S.length() =" + S.length());
					  	  System.out.println("T.length() =" + T.length());

							  String substr =  S.substring(i, i+T.length()+1);
							  System.out.println("substr =" + substr);
							  htStr.put( substr, i);
				
			}
		 
      
          // Show all chars in hash table. 
          Enumeration names = htStr.keys(); 
		  while(names.hasMoreElements()) { 
		  	String str = (String) names.nextElement(); 
          	for(int j=0; j< T.length(); j++) {
				char c = T.charAt(j);
            	 if( str.contains( Character.valueOf(c).toString()))
				   res= str;
         	}
		 }
		  
		 return res;
      }
	
	public static void main(String args[]) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		String output = minWindow(S, T);
		System.out.print(String.format("output= %s \n", output));
		
	}
}