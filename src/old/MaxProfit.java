package old;
import java.util.Arrays;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0) return 0;
        
        int maxCur=0, maxSofar=0;
        
        for(int i=1; i< prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSofar = Math.max(maxCur, maxSofar);
        }
        return maxSofar;
    }
    
    
    public static void main(String[] args) {
        int[] prices = { 7, 9, 11, 15, 4, 10};
        
        System.out.println(maxProfit(prices));
    }
}