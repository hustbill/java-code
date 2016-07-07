package old;
public class Reader4 {
    public static int read4(char[] buf) {
        // int len = buf.length;
        // if (len < 4)
        //     return buf.length;
        // else
        //     return buf.length%4;
        //System.out.println("len=" + buf.length);
        return buf.length % 4;
    }
    
    public static void main(String[] args) {
        String str = "Hello world! Java";
        char[] buf =  str.toCharArray();
        // for (char c : buf) {
        //     System.out.println(c);
        // }
        //System.out.println(read4(buf));
    }
}