package string;

class LongestPalindrome {
    public static void main(String[] args) {
		String s = "cmkababccbabamk";
		LongestPalindrome lp = new LongestPalindrome();
		String result = lp.longestPalindrome(s);
		System.out.println(s + "'s longest palindrome substring : " + result);
		
	}
	
	// Time O(n^2), Space O(1)
	public String longestPalindrome(String s) {
		String longest = s.substring(0,1); 

		if (s.isEmpty()) {
			return null;
		}
		if (s.length() == 1) return s;
		
		for (int i = 0; i < s.length(); i++) {
			// get longest palindomr with center of i, i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
			// get longest palindomr with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
    }
	 
	public String helper(String s, int start, int end) {
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return s.substring(start + 1, end);
	} 
}