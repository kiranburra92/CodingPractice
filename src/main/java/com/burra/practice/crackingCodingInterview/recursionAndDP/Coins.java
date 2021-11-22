package com.burra.practice.crackingCodingInterview.recursionAndDP;

// Find number of ways to represent n cents from unlimited supply of quarters, dime, nickles and pennies
public class Coins {

  // Not optimal
  int makeChange(int amount) {
    int[] denoms = {25, 10, 5, 1};
    return makeChangeHelper(amount, denoms, 0);
  }

  private int makeChangeHelper(int amount, int[] denoms, int index) {
    if (index >= denoms.length - 1) {
      return 1;
    }
    int denomAmount = denoms[index];
    int ways = 0;
    for (int i = 0; i * denomAmount < amount; i++) {
      ways += makeChangeHelper(amount - i * denomAmount, denoms, index + 1);
    }
    return ways;
  }

  // Optimal solution using memory
  int makeChangeWithMemory(int amount) {
    int[] denoms = {25, 10, 5, 1};
    int[][] memo = new int[amount + 1][denoms.length];
    return makeChangeWithMemoryHelper(amount, 0, denoms, memo);
  }

  private int makeChangeWithMemoryHelper(int amount, int index, int[] denoms, int[][] memo) {
    if (memo[amount][index] > 0) {
      return memo[amount][index];
    }
    if (index >= denoms.length - 1) {
      return -1;
    }

    int denomAmount = denoms[index];
    int ways = 0;
    for (int i = 0; i * denomAmount < amount; i++) {
      ways += makeChangeWithMemoryHelper(amount - i * denomAmount, index + 1, denoms, memo);
    }
    memo[amount][index] = ways;
    return ways;
  }
}
