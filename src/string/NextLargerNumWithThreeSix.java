package string;
import java.util.*;

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

// 123 -> 333, 666  calc the gap between 

// step 1:  how many digitis in the num .  123 , 3
// step 2:  3 digits, the output should in the range ( 333, 336, 366, 633, 636, 663, 666),  
// step 3:  if in the range, get the minmum gap one,    333
public class NextLargerNumWithThreeSix {
	public static String getNextLargerInteger(String input) {
		char[] arr = input.toCharArray();
		
	   // 1. get the digitial size 
	    int size = arr.length;
	    
	  
        int[] nums = new int[input.length()];
        for(int i = 0; i < input.length(); i++){
            nums[i] = Integer.parseInt(""+input.charAt(i));
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
        	if (nums[i] <=3 )  {
        		nums[i] = 3;
        	} else if ( nums[i] >= 3 && nums[i] <6) {
        		nums[i] = 6;
        	} else if ( nums[i] >= 6) {
        		nums[i] = 3;
        	}
        }
        String res = Arrays.toString(nums);
        return res;
        
//	    
//	    // 2. get the permutation range using 3 and 6  
//	    
//	    // 3. get the min one from range if it exist, or add a new digit
//	    int min = 0;
//	    for (String s : range) {
//	       // to be implement. 
//	    	System.out.println(s);
//	    }
//	    return input;
	}

  public static void main(String[] args) {
	  String input = "6753";
	  String result = getNextLargerInteger(input);
	  System.out.print(result);
  }	
}

