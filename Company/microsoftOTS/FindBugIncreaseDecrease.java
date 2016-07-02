package microsoftOTS;

public class FindBugIncreaseDecrease {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 4;
		int x = 8;
		int b = 31;
		int y = (int) Math.pow(2, 31) ;
		

		FindBugIncreaseDecrease fb = new FindBugIncreaseDecrease();
		fb.makeTheNumbersMatch(a, b, x, y);
	

	}

	public static void makeTheNumbersMatch(int a, int b, int x, int y) {
		System.out.printf("a = %d, b = %d, x= %d, y = %d", a, b, x, y);
		while (a != x) {
			if (a > x) {
				a--;
			} else if (a < x) {
				a++;
			}

		}
		while (b != y) {
			if (b > y) {
				b--;
			} else if (b < y) {
				b++;
			}
		}
		System.out.printf("\n after \na = %d, b = %d, x= %d, y = %d", a, b, x, y);
		// a = 8, b = 2147483647, x= 8, y = 2147483647
	}

}
