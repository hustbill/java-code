import java.util.*;

public class ReverseWordsInString{
	public static String reverseWordsInString(String s) {
		if (s == null || s.length() <=1) return s;
		StringBuilder sbr = new StringBuilder(); 
		int i = s.length()-1;
		int j= s.length()-1;
		
			
		while(i <=j && i>=0 ) {
			//System.out.println("i: " + s.charAt(i));
			if (Character.isWhitespace(s.charAt(i)) || i==0 ) {
				sbr.append(s.substring( i, j));
				j=i+1;
			}
			i--;
			// System.out.println(sbr.toString());
		}
		
		return sbr.toString();
	}
	
	public static void main(String[] args) {
		String s = "The sky is blue";
		System.out.println(reverseWordsInString(s));
		
		s=" ";
		System.out.println(reverseWordsInString(s));
		
	}
}