package v201604;
/*
 * 
 * 139. Word Break   My Submissions QuestionEditorial Solution
Total Accepted: 84727 Total Submissions: 335739 Difficulty: Medium
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

Hide Company Tags Google Uber Facebook Amazon Yahoo Bloomberg Pocket Gems
https://leetcode.com/problems/word-break/
*/
import java.util.*;

public class WordBreak_139 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordDict = new HashSet<String>();

		//wordDict.addAll(Arrays.asList("lee", "le", "co", "de"));
		wordDict.add("leet");
		wordDict.add("code");
		
		
		String s = "leetcode";
		System.out.printf("Test case %s", wordBreak(s, wordDict) ? "success" : "failed");

	}

	public static boolean wordBreak(String s, Set<String> wordDict) {
		/* https://leetcode.com/discuss/24572/accepted-java-solution
		 * https://leetcode.com/discuss/18904/java-implementation-using-dp-in-two-ways
		 * 
		 * It is a DP solution, the array breakable[i] stores whether the substring 
		 * s.substring(0,i) is breakable or not. 
		 * The DP equation is as follows: 
		 * breakable[i+1] |= breakable[j] && dict.contains(s.substring(j,i+1)), j>=0 && j<i+1
		 */
		
		int n = s.length();
		boolean[] breakable = new boolean[n + 1];
		breakable[0] = true;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (breakable[j] && wordDict.contains(s.substring(j, i))) {
					System.out.printf("j = %d, i = %d\n", j, i);
					breakable[i] = true;
					break;
				}
			}
		}
		
		return breakable[s.length()];
	}
	
    public static boolean wordBreak_mine(String s, Set<String> wordDict) {
        boolean result = false;
        int start = 0, end = 1;
        int n = s.length();
        while ( start < end && end < n) {
        	String word = s.substring(start,  end);
        	if (wordDict.contains(word)) {
        		start = end;
        		end++;
        	} else {
        		end++;
        	}
        }
        System.out.printf("start = %d, end = %d\n", start, end);
        if (end == n) return true;
        
        return result;
    }
}
