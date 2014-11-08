/*
Valid Number
Total Accepted: 15259 Total Submissions: 140068 My Submissions Question Solution 
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

*/

public class ValidNumber {
    public static boolean isNumber(String s) {
        // 0
		char charArr[]=  s.toCharArray();
		for(int i=0; i < charArr.length; i++ )
		  System.out.println( String.format(" charArr[%d] = %c" , i, charArr[i]));
		return checkCharArray(charArr);
    }
	
	public static boolean checkCharArray( char charArr[]) {
		   int i=0;
			if (charArr[i] == '0')
				return true;
			if (charArr[i] == 'a')
				return false;
			else  return false;
	}
	
	public static void main( String args[]) {
		String inputArr[] = new String[10];
		inputArr[0] = "0";
		inputArr[1] = " 0.1";
		for( int i=0; i< inputArr.length; i++) 
			System.out.println( String.format("isNumber(%s) = %s" , inputArr[i], isNumber(inputArr[i])));
	}
}
