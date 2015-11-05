public class IsPalindrome {
    public static boolean isPalindrome(int x) {
	    if (x < 0) return false;
        int p=x, q=0;
		
		while(p>=10) {
			q *=10;   // q=0,  q=10  q=120
			q += p%10;  // if x=1221, 1221%10 => q = 1,  122%10=2 q=12   q=120+2=122
			p /=10;	    //  p/10 => p= 122,    p/10 => p=12  p =1
		}
		return (p == x%10 && q == x/10);
		
    }
	
	public static void main(String[] args) {
		int x = 121;
		int y = 1221;
		int z = 12321;
		
		int[] arr = {x, y,z};
		for( int i : arr) { 
			System.out.println(isPalindrome(i));
		}
	}
}