/*
ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

https://leetcode.com/problems/zigzag-conversion/
*/

public class ZigzagConversion {
	
	//Ref: http://www.lifeincode.net/programming/leetcode-zigzag-conversion-java/
	// Ref: http://www.cnblogs.com/springfor/p/3889414.html
	 //Reference:http://blog.unieagle.net/2012/11/08/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Azigzag-conversion/

	    public  String convert(String s, int nRows) {
		 if(nRows <=1 ) return s;
		 if(s.length() ==0) return " ";
	 
		 StringBuilder result = new StringBuilder();
		 int size = 2*nRows -2;
		 for(int i=0; i< nRows; i++) { // i is index of rows
			// use the index for the location in s
			//  j is column 
			for (int j=i; j< s.length(); j+=size) {
				result.append(s.charAt(j));   // long element
					if(i!=0 && i != nRows -1) { //except the first row and the last row
					int temp = j+ size -2*i;
					if(temp < s.length())
						result.append(s.charAt(temp));
				}
			}
		}
		return result.toString();

	   }
}