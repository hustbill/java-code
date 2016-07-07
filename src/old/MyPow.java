package old;
public class MyPow {
    public static double myPow(double x, int n) {
		// divide and conquer 
		if (n ==0) return 1;
        if ( n< 0) {
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
        
        // reference: https://leetcode.com/discuss/17005/short-and-easy-to-understand-solution
    
    }
	 
	 public static int mySqrt(int x) {
		 // use binary search idea 
        // if mid*mid > x ,  let high = mid;  else let low=mid;
      
        int low = 1, high = x;
        if(x == 0) return x;
        
        while ( low + 1 < high) {
            int mid = low + (high - low)/2;
             if (mid > x/mid )  {
                 high = mid;
             } else {
                 low = mid;
             }
        }
        
        return low;
          // Refer: https://leetcode.com/discuss/24942/a-binary-search-solution
          // left/ right are the min and max values of an interval. each loop divide the interval by half and pick the left half or right half and continue. this is really the same idea as binary search.
    }
	
	
	public static void main(String[] args) {
	
	
		//double[] xArr = { 2, 4,  10, 64};
		int[] xArr = { 2, 4,  10, 64};
		int[] nArr = { 2, -2, 10, -10};
		for (int x : xArr) {
			/* for ( int n : nArr) {
				System.out.println(myPow(x, n));
			} */
			System.out.println(mySqrt(x));
		}
		
	}
}