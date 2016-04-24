package v201604;

public class IsPowerOfTwo_231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 128;
		
		System.out.println(isPowerOfTwo(n));
		
		n = 256 *8 * 3;
		System.out.println(isPowerOfTwo(n));
		
		n = 1;
		System.out.println(isPowerOfTwo(n));
		
		n = -16;
		System.out.println(isPowerOfTwo(n));
		
		
		
	}
	
    public static boolean isPowerOfTwo(int n) {
        /* https://leetcode.com/discuss/43875/using-n%26-n-1-trick
          Ref: Power of 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to judge whether that is the case
        */
        return (n > 0 && (n & (n-1)) == 0 );
    
    }
    public static boolean isPowerOfTwo_mine(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
      
        
       	while ( n > 2 &&  n % 2 == 0)  {
 			n = n / 2;
 		}
 		return n % 2 == 0; 
    }

}
