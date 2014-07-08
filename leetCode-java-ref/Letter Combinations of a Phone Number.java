/* Given a digit string, return all possible letter combinations that the number could represent.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].*/

/* The problem is similar to the combination sum and combinations problem, using DFS to solve it. */

public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result=new ArrayList<String>();
        if(null==digits)
            return result;
        String[] keyboard={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        letterCombinationsDFS(digits,0,keyboard,result,new StringBuffer());
        return result;
    }
    public void letterCombinationsDFS(String digits, int index, String[] keyboard, ArrayList<String> result, StringBuffer cur){
        if(index==digits.length()){
            StringBuffer tmp=new StringBuffer(cur);
            result.add(tmp.toString());
            return ;
        }
        int num=(int)(digits.charAt(index)-'0');
        String curStr=keyboard[num];
        for(int i=0;i<curStr.length();++i){
            cur.append(curStr.charAt(i));
            letterCombinationsDFS(digits,index+1,keyboard,result,cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
