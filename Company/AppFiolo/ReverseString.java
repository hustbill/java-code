import java.util.*;

public class ReverseString{

    public static void main(String[] args) {

        String str = "Today     is Monday March 21st";
        System.out.println(str);
        System.out.print("=> " + reverseStr(str));
    }

    public static String reverseStr(String str) {
        // split string to multiple words
        LinkedList<String> list = new LinkedList<>();
        
        // check the whitespace , split string by whitespace
        int n = str.length();
        int left = 0, right = 0; 
        int index = 0;

        for (int i=0; i < n; i++){
            right++;
            if(str.charAt(i) == ' ') {
                String temp = str.substring(left, right);
                list.add(index, temp); 
                left = right;
                index++;
            }
        }

        // add the last word int the string
        list.add(index, str.substring(left, right));
   
        StringBuilder sb = new StringBuilder();
        for (int j=list.size() -1; j >= 0; j--) {
           sb.append(list.get(j) + " " );
         }
        return sb.toString();
    }
}