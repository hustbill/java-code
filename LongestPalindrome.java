/*
2015/10/09 
LongestPalindrome

*/
public class LongestPalindrome {
    
    public static String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        
        String longest = s.substring(0,1);
        
        for(int i=0; i< s.length(); i++) {
            String tmp = findPalindrom(s, i, i);   // get longest palindrome with center of i,  such as "abcba"
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
            
            tmp = findPalindrom(s, i, i+1); // get longest palindrome with center of i, i+1, ex, "abba"
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;
        
    }
    
    public static String findPalindrom(String s, int begin, int end) {
        while(begin >=0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--; // expand palindrom string to left
            end++;
        }
        return s.substring(begin+1, end);
        
    }
    //reference1: http://codeganker.blogspot.com/2014/02/longest-palindromic-substring-leetcode.html
    //reference2:  http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
    public static String longestPalindrome2(String s) {
    //https://leetcode.com/discuss/52814/ac-relatively-short-and-very-clear-java-solution
    /*
        S= "yxabcdcbamn"
        currLength = 1, res= y
        currLength = 3, res= cdc
        currLength = 5, res= bcdcb
        currLength = 7, res= abcdcba
        s = abcdcba
        currLength = 1, res= m
        currLength = 3, res= cdc
        currLength = 5, res= bcdcb
        s = bcdcb
        currLength = 1, res= m
        currLength = 2, res= dd
        currLength = 4, res= cddc
        currLength = 6, res= bcddcb
        currLength = 8, res= abcddcba
        s = abcddcba
        */
       String res = "";
       int currLength = 0;
       for(int i=0;i<s.length();i++){
           if(isPalindrome(s,i-currLength-1,i)){
               res = s.substring(i-currLength-1,i+1);
               currLength = currLength+2;
               System.out.println("i=" + i + ", currLength = " + currLength + ", res= " + res);
           }
           else if(isPalindrome(s,i-currLength,i)){
               res = s.substring(i-currLength,i+1);
               currLength = currLength+1;
               System.out.println("i=" + i + ", currLength = " + currLength + ", res= " + res);
           }
       }
       return res;
   }
   
   

   public static boolean isPalindrome(String s, int begin, int end){
       if(begin<0) return false;
       while(begin<end){
           if(s.charAt(begin++)!=s.charAt(end--)) return false;
       }
       return true;
   }
    
    public static void main(String[] args) {
        String[] strArr = {"yxabcdcbamn", "mlabcdcbdklm", 
        "mlabcddcbaklm" };
        
        for (int i=0; i< strArr.length; i++) {
            String s = longestPalindrome(strArr[i]);
            System.out.println("s = " + s);
        }
    }
}