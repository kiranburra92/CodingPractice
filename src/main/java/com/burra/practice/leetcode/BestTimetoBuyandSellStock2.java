package com.burra.practice.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and
 * sell one share of the stock multiple times).
 */
public class BestTimetoBuyandSellStock2 {

  public int maxProfit(int[] prices) {
    /**
     * Directly keep on adding the difference between the consecutive numbers of the array if the second
     * number is larger than the first one, and at the total sum we obtain will be the maximum profit.
     */
    int maxProfit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) {
        maxProfit += prices[i + 1] - prices[i];
      }
    }
    return maxProfit;
  }
}
