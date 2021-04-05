package com.burra.practice.leetcode;
/**
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
    int max = 0;
    int min  = Integer.MAX_VALUE;
    int total_max = 0;
        for(int j : prices){
            if(j < min){
                min = j;
            }
            else if(j - min > max){
                max = j - min;
                total_max = max;
            }
        }
        return total_max;
    }
}
