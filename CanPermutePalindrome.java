public class CanPermutePalindrome {
    public static boolean canPermutePalindrome(String s) {
        char[] arr = s.toCharArray();
		Map<Char, Integer> map = new Map<Char, Integer>();
		
		
    }
	
	public static void main(String[] args) {
		String[] strArr = {"abc", "abcd", "aab", "carerac"};
		for (String s : strArr) {
			System.out.println(s + " canPermutePalindrome ? " + canPermutePalindrome(s));
		}
	}
}