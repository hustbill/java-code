package old;
public class RomanToInt {  
  // Test case : "DCXXI"
  // Refer to :  clearclean code v1.03 pdf
  //https://en.wikipedia.org/wiki/Roman_numerals
    private static Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('I', 1);  put('V', 5);   put('X', 10);
        put('L', 50); put('C', 100);  put('D', 500); put('M', 1000);
    }};
    
    public int romanToInt(String s) {
         int prev=0, total=0 , curr=0;
         
         for(char c : s.toCharArray()) {
             if (map.containsKey(c)) {
                 curr = map.get(c);
                 total += (curr > prev)? (curr - 2*prev) : curr; 
                 prev = curr;
             }
         }
         
         return total;
    }
}