/*
*   ReverseDigits.java
*/
import java.util.ArrayList;

public class ReverseDigits {
    public static int reverse(int x) {
       int ret =0; // reverse digits
	    boolean flag = true;
        ArrayList<Integer> bitList  = new ArrayList<Integer>();
        if(x < 10 && x >=0)
            ret = x;
        if( x< 0) {
            x = -x;
			flag = false;
		 }
         if (isValidReverse(x) && x >=10 ) {
         // System.out.println(" the last digit of x is not 0");
              bitList = parse(x);
			      for( int i=0 ; i< bitList.size(); i++) {
					ret = ret *10 + bitList.get(i) ;
					//System.out.println(String.format(" ret=%d", ret));
			}
		
         }
       
		   if (flag == false)  ret = - ret;
         return ret;
    }
    
    public static int getRemains( int x) {
		int remains = 0;
		if (x/10 > 10 ) {
			remains = x%10;
            x = x/10;   
            //System.out.println(String.format(" x=%d, remains=%d", x, remains));
        }
		return remains;
    }

	public static ArrayList parse(int x) {
	 int shang=0, remains=0;
	 	ArrayList<Integer> retList = new ArrayList<Integer>();
		while( x >0 ) {
			remains= x % 10;
			retList.add(remains);
			// System.out.println(String.format(" x =%d, remains=%d", x, remains));
			x = x/10;
	  }
	return retList;
	}
   
    public static boolean isValidReverse(int x) {
        if( x < 1* 1024 * 1024 * 1024 ) 
      			return true;
		else 
			return false;
    }
	
	public static void main(String args[]) {
		Integer x[] = { 0, 1, -123, 123, 10, 1000003, 901000 };
		//parse(x);
		for (int i=0; i< x.length; i++ ) {
			System.out.println(String.format("reverse(%d) = %d", x[i], reverse(x[i])));
		}
	}
    
}