package com.burra.practice.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * <p>
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int val = 0;
        boolean flag = true;
        int buy = 0;
        for(int i = 0 ; i < prices.length ; i++){
            if(!flag && prices[i-1] < prices[i]) {
                val += prices[i-1];
                i++;
            }
        }
        return val;
    }
}
