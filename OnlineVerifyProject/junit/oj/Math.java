package oj;

public class Math {
	
	public int mySqrt_nok(int x) {
        if (x == 1) return 1;
        int low = 1;
        int hi = x - 1;
        while (low < hi) {
            int mid = low + (hi - low) / 2;
            int square = mid * mid; 
            if (square  == x) {
                return mid;
            } else if (square > x) {
                hi = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;        
    }
	
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int low = 1;
        int hi = x;
        while (low + 1 < hi) {
            int mid = low + (hi - low) / 2;
            if (mid  > x / mid ) {  // use divide to avoid overflow
                hi =  mid;
            } else {
                low = mid;
            }
            if (hi <= x / hi) {
                return hi;
            }
        }
        return low; 
    }	
	
	public static void main(String[] args) {
		Math mt = new Math();
		int[] input = {1, 2, 4, 8, 9, 10, 12, 16}; 
		for (int x : input) {
			int ret = 	mt.mySqrt(x);
			System.out.printf("the sqrt of %d is %d\n", x, ret);
		}
	
		
	}
}
