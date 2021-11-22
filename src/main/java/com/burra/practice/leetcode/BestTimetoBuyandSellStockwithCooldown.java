package com.burra.practice.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
 * sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day) Example:
 * <p>
 * Input: [1,2,3,0,2] Output: 3 Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimetoBuyandSellStockwithCooldown {

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }
    final int N = prices.length;
    int[] buy = new int[N];
    int[] hold = new int[N]; // hold stock after buying
    int[] sell = new int[N];
    int[] wait = new int[N]; // wait (cooldown) after selling
    buy[0] = hold[0] = -prices[0];
    for (int i = 1; i < N; i++) {
      buy[i] = wait[i - 1] - prices[i];
      hold[i] = Math.max(hold[i - 1], buy[i - 1]);
      sell[i] = Math.max(hold[i - 1], buy[i - 1]) + prices[i];
      wait[i] = Math.max(wait[i - 1], sell[i - 1]);
    }
    return Math.max(sell[N - 1], wait[N - 1]);
  }
}
