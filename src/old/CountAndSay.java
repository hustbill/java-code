package old;
/*
38. Count and Say 
https://leetcode.com/problems/count-and-say/

Total Accepted: 67385 Total Submissions: 246172 Difficulty: Easy
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Hide Company Tags Facebook
Hide Tags String
Hide Similar Problems (M) Encode and Decode Strings

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221 
 6.     312211
 7.     13112221
 8.     1113213211
 9.     31131211131221
 10.   13211311123113112211
From the examples you can see, the (i+1)th sequence is the "count and say" of the ith sequence!


*/
public class CountAndSay {
    public static String countAndSay(int n) {
          
        StringBuilder  curr = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        
        for(int i=1; i < n; i++) {
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);  // say ='1'
            
            for (int j=1, len = prev.length(); j< len; j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                }
                else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }
    
    public static void main(String[] args) {
        int n = 8; // 8.     1113213211
        
        System.out.printf("n sequence is %s",countAndSay(n));
    }
}