/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 *
 * https://leetcode.com/problems/excel-sheet-column-title/description/
 *
 * algorithms
 * Easy (29.41%)
 * Total Accepted:    186.4K
 * Total Submissions: 628.8K
 * Testcase Example:  '1'
 *
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 
 * ⁠   1 -> A
 * ⁠   2 -> B
 * ⁠   3 -> C
 * ⁠   ...
 * ⁠   26 -> Z
 * ⁠   27 -> AA
 * ⁠   28 -> AB 
 * ⁠   ...
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: "A"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 28
 * Output: "AB"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 701
 * Output: "ZY"
 * 
 */
class Solution {
    // https://leetcode.com/problems/excel-sheet-column-title/discuss/51399/Accepted-Java-solution
    public String convertToTitle(int n) {
        StringBuilder ret = new StringBuilder();
        
        while (n > 0) {
            n--;
            ret.insert(0, (char)('A'+ n % 26)); // 28 -> "AB",  insert B first, and then A
            n = n / 26;
            
        }
        
        return ret.toString();   
    }
}
