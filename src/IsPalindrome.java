/*
125. Valid Palindrome My Submissions Question
Total Accepted: 94559 Total Submissions: 401331 Difficulty: Easy
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Hide Company Tags Microsoft Uber Facebook Zenefits
Hide Tags Two Pointers String
Hide Similar Problems (E) Palindrome Linked List

*/



public class IsPalindrome {
	public static boolean isPalindrome(String s) {
		/* O (n) time, O(1) space
			The idead is simple, have two pointers - one at the head while teh other one at tail.
			Move them towards each other until they meet while skippig non-aplphanumeric 
			characters.

			Consider the case where given string contains only non-alphanumberic characters. This is
			a valid palindrome because the empty string is also a valid palindrome.
		*/
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && ! Character.isLetterOrDigit(s.charAt(j))) j--;
			if (Character.toLowerCase(s.charAt(i))
				!= Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			i++; j--; 
		}
		return true;

	}

    public static boolean isPalindrome_int(int x) {
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
		String str = "A man, a plan, a canal:Panama";

		int x = 121;
		int y = 1221;
		int z = 12321;
		int[] arr = {x, y,z};

		System.out.printf("%s is Palindrome string: %b\n", str, isPalindrome(str));
		
		for( int i : arr) { 
			System.out.println(isPalindrome_int(i));
		}

	}
}