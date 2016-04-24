package v201604;

public class IsPowerOfTwo_231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 128;
		
		System.out.print(isPowerOfTwo(n));
	}
	
	 public static boolean isPowerOfTwo(int n) {
	        while (n > 0) {
	            n = n/2;
	        }
	        if ( n %2 != 0) {
	            return false;
	        }
	        return true;
	 }

}
