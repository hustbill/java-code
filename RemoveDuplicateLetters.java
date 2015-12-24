import java.util.*;

public class RemoveDuplicateLetters {
	public static void main(String[] args) {
		   //bacdb => acd 
		// bcabc => abc
		// cbacdcbc => acdb 
		String s = "cbacdcbc";
		String res = removeDuplicateLetters(s);
		
		System.out.printf("removeDuplicateLetters(%s)  =  %s" , s, res);
	}
	
	  public static String removeDuplicateLetters(String s) {
		System.out.println("s=" + s);
		int[] cnt = new int[26];
		int pos = 0;  // the position for the smallest s[i]
		for (int i =0; i< s.length(); i++)  cnt[s.charAt(i) - 'a']++;
		for (int i =0; i < s.length(); i++) {
			if (s.charAt(i) < s.charAt(pos)) pos = i;
			if (--cnt[s.charAt(i) - 'a'] == 0 ) break;
		}
		if (s.length() !=0 ) 
		System.out.printf ("\ts.pos = %c\n", s.charAt(pos));
		return s.length() ==0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replaceAll("" + s.charAt(pos), ""));
	  }
	

    public static String removeDuplicateLetters2(String s) {
		if (s == null || s.length() <=1 ) return s;
		
		Map<Character, Integer> lastPosMap = new HashMap<>();
		
		for (int i = 0 ; i<s.length(); i++) {
			lastPosMap.put(s.charAt(i), i);
		}
		
		char[] result = new char[lastPosMap.size()];
		int begin = 0;
		int end = findMinLastPos(lastPosMap);
		
		for (int i=0; i< result.length; i++) {
			char minChar = 'z' + 1;
			for (int k= begin; k <= end; k++) {
				if (lastPosMap.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
					minChar = s.charAt(k);
					begin = k + 1;
				}
			}
			result[i] = minChar;
			if(i == result.length-1) break;
			lastPosMap.remove(minChar);
			if (s.charAt(end) == minChar) end = findMinLastPos(lastPosMap);
		}
		return new String(result);
	}
	
	private static int findMinLastPos(Map<Character, Integer> lastPosMap) {
		if (lastPosMap == null || lastPosMap.isEmpty()) return -1;
		
		int minLastPos = Integer.MAX_VALUE;
		for (int lastPos: lastPosMap.values()) {
			minLastPos = Math.min(minLastPos, lastPos);
		}
		return minLastPos;
	}
	
}