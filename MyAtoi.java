import java.util.*;

public class MyAtoi {
    public static int myAtoi(String str) {
	  if(str == null && str.length() ==0 ) return 0;
	  
	  StringBuilder sb = new StringBuilder();
	  
	  for (char c : str.toCharArray()) {
		if( !Character.isWhitespace(c)) {
		  sb.append(c);
		}
	  }
	  if ( !sb.toString().equals("")) {
		int res = Integer.parseInt(sb.toString());
		 return res ;
	  } 
	  return 0 ;   
    }
	
	public static void main(String[] args) {
		String[] testcases = {"", "-2321", "30000001","-2198563"};
		
		int i=0; 
		for(String str : testcases) {
			System.out.println( i + " : " + myAtoi(str));
			i++;
		}
	}
	
	
}