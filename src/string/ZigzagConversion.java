public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        ZigzagConversion zzc = new ZigzagConversion();
        String res = zzc.convert(s, numRows);
        System.out.println("res = " + res);
    }
    
    /*n=numRows
    Δ=2n-2    1                           2n-1                         4n-3
    Δ=        2                     2n-2  2n                    4n-4   4n-2
    Δ=        3               2n-3        2n+1              4n-5       .
    Δ=        .           .               .               .            .
    Δ=        .       n+2                 .           3n               .
    Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
    Δ=2n-2    n                           3n-2                         5n-4
        https://discuss.leetcode.com/topic/22925/if-you-are-confused-with-zigzag-pattern-come-and-see/2
        https://discuss.leetcode.com/topic/3162/easy-to-understand-java-solution
        that's the zigzag pattern the question asked!
        Be careful with nR=1 && nR=2
    */
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        StringBuffer[] sb = new StringBuffer[numRows];
        int len = s.length();
        for (int i = 0; i < sb.length; i++)  
            sb[i] = new StringBuffer();
 
        int i = 0;
        while (i < len) {
            for(int idx = 0; idx < numRows && i < len; idx++) {
                sb[idx].append(c[i++]);  // vertically down
            }
            for (int idx = numRows-2; idx >= 1 && i < len; idx--) {
                sb[idx].append(c[i++]);  // obliquely up
            }
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}