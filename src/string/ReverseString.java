import java.util.*;


class ReverseString {
	public static void main(String[] args) {
		ReverseString rr = new ReverseString();
		System.out.println(rr.reverseString("hello world"));
	}
	
	private String reverseString(String s) {
		int i = 0, j = s.length() - 1;
		
		char[] arr = s.toCharArray();
		while (i < j) {
			char temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
			i++;
			j--;
		}
		
		return String.valueOf(arr);
	}

}