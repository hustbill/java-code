package old;
import java.util.Arrays;

public class MaxProfit3 {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0) return 0;
        int[] history = new int[prices.length];
        int[] future = new int[prices.length];
        
        Arrays.fill(history, 0);
        Arrays.fill(future, 0);
        
        int low =0, high=0, profit=0;
        for(int i=1; i< prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }
            history[i] = prices[i] - low;
        }
        
        for(int i=1; i< prices.length; i++) {
            if (high < prices[i] ) {
                high = prices[i];
            }
            future[i] = high - prices[i];
            profit = Math.max(future[i] + history[i], profit);
        }
        return profit;
    }
    
    
    public static void main(String[] args) {
        int[] prices = { 7, 9, 11, 15, 4, 10};
        
        System.out.println(maxProfit(prices));
    }
}