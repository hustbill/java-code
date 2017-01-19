```java
/*
22. Generate Parentheses
Total Accepted: 125110
Total Submissions: 298164
Difficulty: Medium
Contributors: Admin
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
Hide Company Tags Google Uber Zenefits
Hide Tags Backtracking String
Hide Similar Problems (M) Letter Combinations of a Phone Number (E) Valid Parentheses

*/
// Use backtracking
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
        
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max*2) {
            list.add(str);
            return;
        }
        
        if (open < max) {
            backtrack(list, str+"(", open+1, close, max);
        }
        if (close < open) {
            backtrack(list, str+")", open, close + 1, max);
        }
    }
}
```
