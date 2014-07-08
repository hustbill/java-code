/* Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".*/

/* traverse the string from end to start, save each word(needs reverse) to the result. be carefull with multiple spaces.*/

public class Solution {
    public String reverseWords(String s) {
        int start=0;
        int end=s.length()-1;
        while(start<=end && s.charAt(start)==' '){
            start++;
        }
        while(end>=0 && s.charAt(end)==' '){
            end--;
        }
        if(start>end)
            return "";
        StringBuffer result=new StringBuffer();
        while(start<=end){
            StringBuffer word=new StringBuffer();
            while(start<=end && s.charAt(end)!=' '){
                word.append(s.charAt(end));
                end--;
            }
            word.reverse();
            if(!word.equals(""))
                result.append(word+" ");
            while(start<=end && s.charAt(end)==' '){
                end--;
            }
        }
        return result.substring(0,result.length()-1).toString();
    }
}
