/*320. Generalized Abbreviation My Submissions Question
Total Accepted: 2676 Total Submissions: 6744 Difficulty: Medium
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Hide Company Tags Google
Hide Tags Backtracking Bit Manipulation
Hide Similar Problems (M) Subsets (E) Unique Word Abbreviation
*/
import java.util.*;

public class GenerateAbbreviations {
    public static void main(String[] args) {
        String word = "word";
        
         List<String> res = generateAbbreviations(word);
         
         System.out.print(res);
    }
    
    public static List<String> generateAbbreviations(String word) {
        // ref : https://leetcode.com/discuss/75754/java-backtracking-solution
        /*The idea is: for every character, we can keep it or abbreviate it. To keep it, we add it to the current solution and carry on backtracking. To abbreviate it, we omit it in the current solution, but increment the count, which indicates how many characters have we abbreviated. When we reach the end or need to put a character in the current solution, and count is bigger than zero, we add the number into the solution.*/
        List<String> res = new ArrayList<String>();
        
        backtrack(res, word, 0, "" , 0);
        
        return res;
    }
    
    private static void backtrack(List<String> res, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) cur += count;
            res.add(cur);
        }  else {
            backtrack(res, word, pos+1, cur, count+1);  
            System.out.printf(" %s \t %d \t %s \t %d\n", word, pos+1, cur, count+1);
            System.out.println();
            backtrack(res, word, pos+1, cur + (count > 0? count: "") + word.charAt(pos), 0);
            System.out.printf(" %s \t %d \t %s \t %d\n", word, pos+1, cur+(count > 0? count: "") + word.charAt(pos), count+1);
        }
    }
}