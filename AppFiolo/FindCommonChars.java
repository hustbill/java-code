/*
Name: FindCommonChars.java
AppFiolo Interview questions
Implement a method that takes 2 strings as input and returns a string with the common characters

*/
import java.util.*;

public class FindCommonChars {

	public static void main(String args[]) {
		String str1 = "hello world";
		String str2 = "This is a whole new world!";
		
		String str = findCommonChars(str1, str2);
		System.out.printf("str = %s", str);

	}
	
	public static String findCommonChars(String str1, String str2) {
		String res = "";

		int m = str1.length();
		int n = str2.length();
		int p1 = 0, p2 = 0;
		Set<character> set = new HashSet<>();

		for (int i=0; i < m ; i++) {
			for (int j=0; j < n; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					p1 = i;
					set.add()
				}
			}
		}
	｝
	
	public static String findCommonChars2(String str1, String str2) {
		String res = "";
		Set<String> set  = new HashSet<>();
		int m = str1.length();
		int n = str2.length();

		int p1 = 0, p2 = 0;
		while (p1 < m && p2 < m) {
			System.out.printf("c1 = %c, c2= %c", str1.charAt(p2) , str2.charAt(p2));
			if(str1.charAt(p2) == str2.charAt(p2)) {
				p2++;
				System.out.printf(" temp = %s \n", str1.substring(p1, p2));
			}  else {
				p1= p2;
				p2++;
				System.out.printf(" second = %s \n", str1.substring(p1, p2));
			}



		}
		res = str1.substring(p1, p2);
		set.add(res);
		System.out.print(set);

		return res;
	}
}