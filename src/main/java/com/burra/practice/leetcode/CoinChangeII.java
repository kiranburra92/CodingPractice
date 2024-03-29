package com.burra.practice.leetcode;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing
 * a total amount of money.
 * <p>
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return 0.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * The answer is guaranteed to fit into a signed 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: amount = 5, coins = [1,2,5] Output: 4 Explanation: there are four ways to make up the amount: 5=5 5=2+2+1
 * 5=2+1+1+1 5=1+1+1+1+1
 * <p>
 * Example 2:
 * <p>
 * Input: amount = 3, coins = [2] Output: 0 Explanation: the amount of 3 cannot be made up just with coins of 2.
 * <p>
 * Example 3:
 * <p>
 * Input: amount = 10, coins = [10] Output: 1
 */
public class CoinChangeII {

  public int change(int amount, int[] coins) {
    int[] results = new int[amount + 1];
    results[0] = 1;
    for (int den : coins) {
      for (int i = den; i <= amount; i++) {
        results[i] += results[i - den];
      }
    }
    return results[amount];
  }
}
