package string;

import java.util.ArrayList;

//Given an integer input, find the next larger integer with 3 and 6 as the digits
//
//example: input=123, output=333
//example: input=246, output=333
//example: input=521, output=633
//
//input = 567, output =?
//633
//
//675 . -> ?3333    
//
//1-> . 3
//4-> 6?
//-55 > 


// base on input  -> next larger one use sample digits, ex.  123 -> 132 . 

// 

// 123 -> 333, 666  calc the gap between 

// step 1:  how many digitis in the num .  123 , 3
// step 2:  3 digits, the output should in the range ( 333, 336, 366, 633, 636, 663, 666),  
// step 3:  if in the range, get the minmum gap one,    333
public class NextLargerNumWithThreeSix {
	public String getNextLargerInteger(String input) {
	   // 1. get the digitial size 
	    int size = input.toCharArray().length;
	    
	    // 2. get the permutation range using 3 and 6  
	    ArrayList<String> range = permutation(input);
	    
	    // 3. get the min one from range if it exist, or add a new digit
	    int min = 0;
	    for (String s : range) {
	       // to be implement. 
	    	System.out.println(s);
	    }
	    return input;
	}



	private ArrayList<String> permutation(String s) {
		// TODO Auto-generated method stub
		  ArrayList<String> res = new ArrayList<>();
		  if (s.length() == 1) {
		     res.add(s);
		  } else if (s.length() > 1) {
		     int lastIndex = s.length() - 1;
		     String last = s.substring(lastIndex);
		     String rest = s.substring(0, lastIndex);
		     // do permuation on the rest string and  then merge with last character 
		     res = merge(permuation(rest), last);
		     }
		     return res;
	}

	
	private ArrayList<String> merge(ArrayList<String> res, String last) {
		return res;
	}
}

