/*Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

*/

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
		int alen = a.length() ;
		int blen = b.length();
		int count = 0;
		int carry = 0;
		if(alen == blen) {
			for(int i=alen-1; i >= 0; i--) {
				if(a.charAt(i) == '1')  {
					count++;
				}
				if( b.charAt(i) == '1') {
					count++;
				}
				if(carry == 1 ) {
					count++;
				}
				carry = (count > 1 ? 1: 0);
				str.insert(0,((count ==0 ) || count ==2)? '0': '1' );
				count = 0;
			}
			if( carry==1)  {
				str.insert(0, '1');
			}
		}
		if(alen > blen)  {
			b = "0" + b;
			System.out.println("b="+ b);
			return addBinary(a, b);
		}
		
		if(alen < blen) {
			a = "0" +a;
			return addBinary(a,b);
		}
	 	return str.toString();
    }
	
	//refrence : discussion
	// https://oj.leetcode.com/discuss/22164/213ms-java-solution-use-two-pointer-to-calculate-o-n-times
	public static String addBinary0(String a, String b) {
	        StringBuilder str = new StringBuilder();
	        int aPtr = a.length() - 1;
	        int bPtr = b.length() - 1;
	        int carry = 0;
	        int count = 0;
	        while(aPtr >= 0 || bPtr >= 0) {
	            if(aPtr >= 0) {
	                if(a.charAt(aPtr) == '1') {
	                    count ++;
	                }
	            }
	            if(bPtr >= 0) {
	                if(b.charAt(bPtr) == '1') {
	                    count ++;
	                }
	            }
	            if(carry == 1) {
	                count++;
	            }
	            carry = (count > 1 ? 1 : 0);
	            str.insert(0, ((count == 0 || count == 2)? '0' : '1'));
	            count = 0;
	            aPtr--;
	            bPtr--;
	        }
	        if(carry == 1) {
	            str.insert(0, '1');
	        }
	        return str.toString();
	    }
	
	public static void main(String args[]) {
		String a = "11";
		String b = "1";
		String c = addBinary(a, b);
		System.out.print(String.format("\n c=%s", c));
	}
}