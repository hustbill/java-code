import java.util.*;

public class ReverseString {

    public static String revStr1(String inputStr) {
        int length = inputStr.length();
		System.out.println("length =" + length);
        String str = "";
        char[] charArr = new char[length];
        char[] outputArr = new char[length];
        for(int i=length-1; i>= 0; i--) {
            charArr[i] = inputStr.charAt(i);
			str += charArr[i];
			System.out.print(String.format("%c ", charArr[i]));
            
        }
		
		System.out.print(String.format("%s", str));
        return str;
        
    }
	//reference :  http://www.importnew.com/501.html
	public static String reverse2(String str) {
		if((null == str) || (str.length() <=1)) {
			return str;
		}
		StringBuffer result = new StringBuffer(str);
		for(int i=0; i< (str.length() /2); i++) {
			int swapIndex = str.length() -1 -i;
			char swap = result.charAt(swapIndex);
			result.setCharAt(swapIndex, result.charAt(i));
			result.setCharAt(i, swap);
		}
		return result.toString(); 
	}
	//reference:  http://www.importnew.com/501.html
	public static String reverse(String str){
		if((null == str) || (str.length() <=1)) {
			return str;
		}
		StringBuffer reverse=  new StringBuffer(str.length());
		for( int i= str.length() -1; i >=0 ; i--) {
			reverse.append(str.charAt(i));			
		}
		return  reverse.toString();
	}
	
	public static void main(String args[]) {
		String input = "Hello World!";
		String output = reverse(input);
		System.out.println("\noutput=" + output);
		
	}

} 