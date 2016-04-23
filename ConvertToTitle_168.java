/*
168. Excel Sheet Column Title   My Submissions QuestionEditorial Solution
Total Accepted: 58964 Total Submissions: 272369 Difficulty: Easy
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases.

Hide Company Tags Microsoft Facebook Zenefits
Hide Tags Math
Hide Similar Problems (E) Excel Sheet Column Number

*/

public class ConvertToTitle_168 {
    public String convertToTitle(int n) {
        // ref : https://leetcode.com/discuss/19150/accepted-java-solution
        StringBuilder result = new StringBuilder();
        
        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        
        return result.toString();
    }
}