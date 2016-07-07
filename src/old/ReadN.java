package old;

public class ReadN extends Reader4 {
    /**
 *      * @param buf Destination buffer
 *           * @param n   Maximum number of characters to read
 *                * @return    The number of characters read
 *                     */
    public static int read(char[] buf, int n) {
        
        char[] buffer = new char[4];
        boolean eof = false;
        int pos = 0;
        while(!eof &&  pos < n) {
            int res = read4(buffer);
            if (res < 4) eof = true;  
            int step = Math.min( n- pos, res);
            System.arraycopy( buffer, 0, buf, pos, step);
            pos += step;
        }
        return pos;
    }
    
    public static void main(String[] args) {
        String str = "Hello world! Java";
        char[] buf =  str.toCharArray();
        System.out.println("buf.length=" + buf.length);
        // for (char c : buf) {
        //     System.out.println(c);
        // }
        System.out.println(read(buf, 8));
        
        
        int arr1[] = { 0, 1, 2, 3, 4, 5 };
          int arr2[] = { 0, 10, 20, 30, 40, 50 };
    
          // copies an array from the specified source array
          System.arraycopy(arr1, 2, arr2, 0, 3);
          System.out.print("array2 = ");
          System.out.print(arr2[0] + " ");
          System.out.print(arr2[1] + " ");
          System.out.print(arr2[2] + " ");
          System.out.print(arr2[3] + " ");
          System.out.print(arr2[4] + " ");
          
    }
}
