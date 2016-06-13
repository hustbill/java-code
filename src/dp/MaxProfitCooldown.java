package dp;
/*
 * 309. Best Time to Buy and Sell Stock with Cooldown 
Total Accepted: 17241 Total Submissions: 46340 Difficulty: Medium
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Dynamic Programming
Hide Similar Problems (E) Best Time to Buy and Sell Stock (M) Best Time to Buy and Sell Stock II

 */

public class MaxProfitCooldown {

	public static void main(String[] args) {
		MaxProfitCooldown mpc = new MaxProfitCooldown();
		 int[] prices1 = {99, 98, 97, 102, 101, 103, 105, 101};
		 int[] prices2 = { 1, 2, 3, 0, 2 }; 
		System.out.println(mpc.maxProfit(prices1));  // 8
		System.out.println(mpc.maxProfit(prices2));  // 3
	}

	public int maxProfit(int[] prices) {
		/*
		 * https://leetcode.com/discuss/71391/easiest-java-solution-with-
		 * explanations because of cooldown, after sell, we need cooldown one
		 * day buy[i] = Math.max(buy[i - 1] , sell[i - 2] - prices[i]);
		 * 两种情况：在第i天不买不卖cooldown,维持第i-1的profit；或者是i-2那天卖掉，然后在i天买入。 取两种情况的profit
		 * 
		 * sell[i] = Math.max(sell[i - 1], buy [i - 1] + prices[i]);
		 * 也是两种情况：不买不卖； 或者卖掉prices[i], profit 为buy [i - 1] + prices[i]。 取两种情况最大值
		 */

		if (prices == null || prices.length <= 1) {
			return 0;
		}

		int[] buy = new int[prices.length]; // profit after buy price[i] or cooldown
		int[] sell = new int[prices.length];

		buy[0] = -prices[0];
		sell[0] = 0; 
		buy[1] = Math.max(buy[0], -prices[1]);
	    sell[1] = Math.max(sell[0], buy[0] + prices[1]);
		
				
		for (int i = 2; i < prices.length; i++) {
			buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]); 
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
		}
	
		return sell[prices.length - 1];
	}

}
