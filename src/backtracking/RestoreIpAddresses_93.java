/*
 * 93. Restore IP Addresses
Total Accepted: 58123 Total Submissions: 243738 Difficulty: Medium
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

Hide Tags Backtracking String

 */
package backtracking;

import java.util.*;

public class RestoreIpAddresses_93 {
	public static void main(String[] args) {
		String s = "25525511135";
		RestoreIpAddresses_93 rp = new RestoreIpAddresses_93();
		List<String> res = rp.restoreIpAddresses(s);
		System.out.print(res);
	}

	public List<String> restoreIpAddresses(String s) {
		List<String> solutions = new ArrayList<>();
		backtrack(s, solutions, 0, "", 0);
		// restoreIp(s, solutions, 0, "", 0);
		return solutions;
	}


	public void backtrack(String ip, List<String> solutions, int idx, String restored, int count) {
		if (count > 4)
			return;
		if (count == 4 && idx == ip.length())
			solutions.add(restored);

		for (int i = 1; i < 4; i++) {
			if (idx + i > ip.length())
				break;
			String s = ip.substring(idx, idx + i);

			if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256)) {
				continue;
			}

			backtrack(ip, solutions, idx + i, restored + s + (count == 3 ? "" : "."), count + 1);
	
		}

	}

}
