/*
File:  IsPalindrome
Date: Feb 1, 2015
Determine whether an integer is a palindrome. Do this without extra space.

*/

public class IsPalindrome {
	// my first version 
    public static boolean isPalindrome0(int x) {
    
        String s = Integer.toString(x);
    	if(s.length()==1 && s.length()==0 ) return true;
    	if(s.length() > 1) {
        	System.out.print(String.format("s= %s \t", s));
			for(int i=0; i< s.length()-1; i++) {
				if(s.charAt(i) != s.charAt(s.length()-1 -i)) {
					return false;
				}
			}
		}
		return true;
    }
    
    // my second version

        public static boolean isPalindrome1(int x) {
        String s = Integer.toString(x);
    	if(s.length()==1 && s.length()==0 ) return true;
    	if(s.length() > 1) {
        	//System.out.print(String.format("s= %s \t", s));  //delete this line , save 700m       s
			for(int i=0; i< s.length()-1; i++) {
				if(s.charAt(i) != s.charAt(s.length()-1 -i)) {
					return false;
				}
			}
		}
		return true;
    }
	
	/*  LeetCode book: 
		The idea is simple, have two pointers – one at the head while the other one at the tail.
		Move them towards each other until they meet while skipping non-alphanumeric
		characters
		*/
	
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			if (Character.toLowerCase(s.charAt(i))
				!= Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			i++; 
			j--;
		}
		return true;
	}
	
    public static void main(String args[]) {

    	int[] input = {1, 121, 12321, 2244, 22445544, 13731, 808};
		boolean flag = false;
    	for(int i=0; i< input.length; i++ ) {
			flag = isPalindrome(input[i]);
    		System.out.print(String.format("input[%d] is %b \n", i, flag));
    	}
	
    }
	
}