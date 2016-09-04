public class BalancedString {
	public boolean isValid(String s) {
		int count = 0; // the number of "("
		int superMatch = 0; // the number of ":"

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ':')
				superMatch++;
			else if (c == '(')
				count++;
			else if (c == ')') {
				if (count == 0 && superMatch == 0)
					return false;
				if (count > 0)
					count--;
				else if (superMatch > 0)
					superMatch--;
			} else
				return false;
		}
		return count == 0 || count == superMatch;
	}

	public static void main(String[] args) {
		String[] testcases = { "(:)", "((:))", "(:))", "((::)))))(:)" };
		BalancedString bs = new BalancedString();
		for (String s : testcases) {
			boolean result = bs.isValid(s);
			System.out.println(result);
		}
	}
}
/* 
true
true
true
false
*/