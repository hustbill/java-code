public class CountAndSay {
/*
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
     https://discuss.leetcode.com/topic/2309/show-an-answer-in-java
    */
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        
        int count;
        char say;
        
        for (int i= 1; i < n; i++) {
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);
            
            for (int j = 1, len = prev.length(); j < len;j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }
   }
