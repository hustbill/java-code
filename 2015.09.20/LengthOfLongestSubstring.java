
/*
Longest Substring Without Repeating Characters 

https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

*/


import java.util.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class LengthOfLongestSubstring {
     public static int lengthOfLongestSubstring(String s) {
		if(s == null || s.length()==0 || s.length()== 1) return s.length(); 
		if (s.length()==2) {
			if (s.charAt(0) == s.charAt(1)) return 1;
			else return s.length();
		}
		if (s.length()==3) {
			if (s.charAt(0) == s.charAt(1) && s.charAt(1)== s.charAt(2)) return 1;
			if (s.charAt(0) != s.charAt(1) && s.charAt(1)!= s.charAt(2)) return 3;
			else return 2;
		}
		int len = s.length();
		char start = s.charAt(0); 
		for(int i=0; i< len; i++ ) {
			if (start ==  s.charAt(0+i)) {
				start = s.charAt[i+1];
			}
		}
		
		
    }
	
	public static String findTarget( String left,  String right) {
		String target = null;
		String s = left;
		int len  = left.length();
		if (len % 2==0 ) {
			
			le = findTarget( s.substring(0, len/2),  s.substring(len/2 +1, len));
		}
	}
	
	// check the target string 
	public static boolean isTarget(String s) {
		for(int i=0; i< s.length(); i++) {
			for(int j=i+1; j< s.length(); j++) {
				if(s.charAt(i) == s.charAt(j)) {
					return false;
				} 
			}
		}
		return true;
	}

	
	public static void main(String[] args) {
		//String s = "lmnabcdefghijklmnopqrstabcdefgabcdefglove";
		// String s1 = "abcklmabcklmopqrstuopqrstummabcclmabcklmopqrstuopqrstummabcclmabcklmopqrstuopqrstumm";
		// String s2 = "abcklmabcklmopqrstvopqrstumm";
				String s3 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
			+"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!"
				+"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!"
					+"$abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!"
						+"$%abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!"
							+"$abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!"
								+"$abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!"
									+"$abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!"
										+"$abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!";
											
		//String s4 = "aa";
	    String s5 = "abcb";
	    String s6 = "c";
		 String s7 = "cdd";
		// System.out.println(lengthOfLongestSubstring(s1));
		// System.out.println(lengthOfLongestSubstring(s2));
		System.out.println(lengthOfLongestSubstring(s3));
		System.out.println(lengthOfLongestSubstring(s5));
		System.out.println(lengthOfLongestSubstring(s6));
	    System.out.println(lengthOfLongestSubstring(s7));
	}
	
	
	/*
		http://www.importnew.com/501.html
		*/
    public static String reverse(String str) {
              if ((null == str) || (str.length() <= 1)) {
                  return str;
              }
              return new StringBuffer(str).reverse().toString();
          }
		  
	public static String reverse2(String str) {
	           if ((null == str) || (str.length()  <= 1)) {
	               return str;
	           }
			   System.out.println("str=" + str + " " + str.charAt(0)) ;
	           return reverse(str.substring(1)) + str.charAt(0);
	       }
	
	// reverse the string s , it is s' ,  and add it with s , Then we get s'' 
	// then we will scan each bit in s'', find those same ones.
	// we will get the target location. 
	

	
	// find all possible data sets from  26 letters 
	public static ArrayList<String> getAllDataSet() {
		ArrayList<String> retList = new ArrayList<String>();
		String[] letters= {"a", "b", "c", "d", "e",
	                 "f", "g", "h", "i", "j", "k",
	                  "l", "m", "n", "o", "p",
					  "q", "r", "s", "t", "u", 
				   	  "v",	"w", "x", "y", "z"};
		for(int i=0; i< letters.length; i++) {
			for(int j=1; j< letters.length; j++) {
			  
			}
			
		}
		
		System.out.println(retList);
		return retList;
		
	}

	
	// locate the target substring in string
	public static int locateTargetSubstr(String s) {
		int ret =0;
		ArrayList <String> list = new ArrayList <String>();
		for(int j=1; j< 26; j++) {
			String target = s.substring(0,j);
				System.out.println("target=" + target);
			for(int i=1; i< s.length() - target.length()+1; i++) {
			
				if( (s.substring(i, i+ target.length()).equals(target))) {
				
					System.out.println(s.substring(i, i+ target.length()));
					list.add(target);
			}
		 }	
		}
		return ret ;
	}
	
    public static int lengthOfLongestSubstring2(String s) {
	if(s == null || s.length()==0 || s.length()== 1) return s.length(); 
	if (s.length()==2) {
		if (s.charAt(0) == s.charAt(1)) return 1;
		else return s.length();
	}
	if (s.length()==3) {
		if (s.charAt(0) == s.charAt(1) && s.charAt(1)== s.charAt(2)) return 1;
		if (s.charAt(0) != s.charAt(1) && s.charAt(1)!= s.charAt(2)) return 3;
		else return 2;
	}
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	String target = null;
	int scan_len= 26;
	if (s.length() < scan_len) 	scan_len = (int)s.length()/2 ;
 		
			for(int k=1; k< scan_len; k++) {
				for(int j=0; j< s.length() -scan_len; j++) {
				System.out.println(" j+k= " +  j+k);
		    	System.out.println("s.length() =" + s.length());
				target = s.substring(j, j+k);
				if (isTarget(target) == true) {
					
					for(int i=1; i< s.length() - target.length()+1; i++) {
						if( (s.substring(i, i+ target.length()).equals(target))) {
							System.out.println("target=" + target);
							System.out.println(s.substring(i, i+ target.length()));
							map.put(target, i);
						}
					}	
				}   	 
			}
  		 }
	 int len =0;
	
	 if (map.size() > 1 ) {
		 List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());  
         	 Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
              public int compare(Map.Entry<String, Integer> o1,  
                      Map.Entry<String, Integer> o2) {  
                  return o2.getKey().toString().length() -o1.getKey().toString().length();  
              }  
          });  
	   System.out.println(list.get(0).getKey().toString());
	   len = list.get(0).getKey().toString().length();
   } else {
	    System.out.println(map);
		len = 1;
   }
	return len;
	
   }
	
	
}