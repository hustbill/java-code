/* Given a string, find the length of the longest substring without repeating characters. For example, the longest 
substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is 
"b", with the length of 1.*/

/*This problem is similar to the minimum substring window problem. We need two pointers to record the current max window,
then update the window to find the maximum. You can use a table to record all the appreared characters, or you can use a 
hashset, like the code below. The reason to use hashset is we do not know whether the string is ASIC or unicode. */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> record=new HashSet<Character>();
        int start=0,maxLen=0;
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(record.contains(c)){
                maxLen=Math.max(maxLen,i-start);
                for(int j=start;j<i;++j){
                    if(s.charAt(j)==c){
                        start=j+1;
                        break;
                    }
                    record.remove(s.charAt(j));
                }
            }
            else{
                record.add(c);
            }
        }
        return Math.max(maxLen,s.length()-start);
    }
}
