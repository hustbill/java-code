/* Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an
algorithm to find the maximum profit.*/

/* It looks similar to find the minimum and maximum value in the array, the difference is the minimum value should
appear before the maxinum value.*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(null==prices || prices.length<2)
            return 0;
        int min=prices[0],profit=0;
        for(int i:prices){
            if(i<min)
                min=i;
            else{
                int diff=i-min;
                profit=Math.max(profit,diff);
            }
        }
        return profit;
    }
}

/* Follow up:
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell
one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you 
must sell the stock before you buy again).*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(null==prices || prices.length<2)
            return 0;
        int profit=0;
        for(int i=0;i<prices.length-1;++i){
            int diff=prices[i+1]-prices[i];
            if(diff>0)
                profit+=diff;
        }
        return profit;
    }
}

/*Follow up:
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.*/

/* The idea is to divide the array into two parts, 0 to i, and i to n, and calculate the max profits of the two parts.
we can use DP to store the previous result, and just compare previous result with current price and min/max prices.*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(null==prices || prices.length<2)
            return 0;
        int len=prices.length;
        int[] forward=new int[len];
        int[] backward=new int[len];
        int min=prices[0];
        forward[0]=0;
        for(int i=1;i<len;++i){
            forward[i]=Math.max(forward[i-1],prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        backward[len-1]=0;
        int profit=forward[len-1]+backward[len-1];
        int max=prices[len-1];
        for(int i=len-2;i>=0;--i){
            backward[i]=Math.max(backward[i+1],max-prices[i]);
            max=Math.max(max,prices[i]);
            profit=Math.max(profit,forward[i]+backward[i]);
        }
        return profit;
    }
}
