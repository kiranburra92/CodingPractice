package com.burra.practice.blind75

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 */
class CoinChange {
    var memory = mutableMapOf<Int, Int>()
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount < 0) return -1
        if (amount == 0) return 0
        if (memory[amount] != null) return memory[amount]!!
        var currentCount = -1
        coins.forEach {
            val tempCount = coinChange(coins, amount - it)
            if (tempCount >= 0)
                currentCount =
                    if (currentCount < 0) tempCount + 1
                    else currentCount.coerceAtMost(tempCount + 1)
        }
        memory[amount] = currentCount
        return currentCount
    }
}