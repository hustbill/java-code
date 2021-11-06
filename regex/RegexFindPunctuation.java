import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFindPunctuation {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\p{Punct}");

        Matcher m = p.matcher("One day! when I was walking. I found your pants? just kidding...");
        int count = 0;
        while (m.find()) {
            count++;
            System.out.println("\nMatch number: " + count);
            System.out.println("start() : " + m.start());
            System.out.println("end()   : " + m.end());
            System.out.println("group() : " + m.group());
        }
    }
}