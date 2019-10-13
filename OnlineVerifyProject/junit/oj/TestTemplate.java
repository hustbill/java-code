package oj;
import java.util.*;

public class TestTemplate {
	/*
	

	 */

	public List<String> letterCombinations(String digits) {
		String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		LinkedList<String> ret = new LinkedList<String>();
		ret.add("");

		for(int i = 0; i < digits.length(); i++) {
			int idx = Integer.parseInt(digits.charAt(i)+"");
			System.out.printf("idx=%d\n", idx);

			while (ret.peek().length() == i) {
				String t = ret.remove();
				System.out.println("t: " + t + " , ret: " + ret);
				for (char s : dict[idx].toCharArray()) {
					ret.add(t + s);
				}
			}

		}
		return ret;
	}


	public int balancedStringSplit(String s) {
        // using stack
        if (s.length() < 2) return 0;
        
        Stack<Character> stack = new Stack<Character>();        
        char[] arr = s.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() ) {
                if (arr[i] != arr[i + 1]) {
                    count++;
                    i = i + 1;
                } else {
                    stack.push(arr[i]);                    
                }
            } else {
                if (stack.peek() == arr[i] )  {
                    stack.push(arr[i]);
                }  else {
                    stack.pop();
                    if (stack.isEmpty()) count++;
                }
            }
        }
        return count;        
    }
	
	// 5223. 
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		List<List<Integer>> ret  = new ArrayList<List<Integer>>();
		int row = king[0];
		int col = king[1];
		int m = queens.length;
		
		// row
		// if r == row,  c1 < col < c2,  two queens can attack king,  if  col < c1 < c2 or  col > c1 > c2 , only c1 can attack king
		
		
		// col
		// if c== col,  r1 < row < r2,  two queens can attack king,  if  row < r1 < r2 or  row > r1 > r2 , only r1 can attack king
		
		// diag
		
		// antidiag
		
		return ret;
	}
	

	public static  void main(String[] args) {
		String digits = "23";
		TestTemplate cdt  = new TestTemplate();
		// List<String> ret = cdt.letterCombinations(digits);
		// System.out.println("ret: " + ret);

		String[] inputStrArr = { "RLRRLLRLRL", "RLLLLRRRLR", "LLLLRRRR" }; //,
		for (String str : inputStrArr) {
			int result = cdt.balancedStringSplit(str);
			System.out.println("result: " + result);
		}
	}

}
