package old;
import java.util.*;

public class CanPermutePalindrome {
    public static boolean canPermutePalindrome(String s) {
        char[] arr = s.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		return true;
    }
	
	public static void main(String[] args) {
		String[] strArr = {"abc", "abcd", "aab", "carerac"};
		for (String s : strArr) {
			System.out.println(s + " canPermutePalindrome ? " + canPermutePalindrome(s));
		}
	}
}