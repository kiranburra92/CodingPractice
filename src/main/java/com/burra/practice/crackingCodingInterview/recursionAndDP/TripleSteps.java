package com.burra.practice.crackingCodingInterview.recursionAndDP;

import java.util.Arrays;

// find number of ways steps can be climbed provided we can use 1, 2, 3 steps at a time.
public class TripleSteps {

  // Unoptimized and not using memory
  int countWays(int stairs) {
    if (stairs == 0) {
      return 1;
    }
    if (stairs < 0) {
      return 0;
    }
    return countWays(stairs - 1) + countWays(stairs - 2) + countWays(stairs - 3);
  }

  // Optimized because memory
  int countWaysUsingMemory(int stairs) {
    int[] memo = new int[stairs + 1];
    Arrays.fill(memo, -1);
    return countWaysUsingMemoryHelper(stairs, memo);
  }

  private int countWaysUsingMemoryHelper(int stairs, int[] memo) {
    if (stairs < 0) {
      return 0;
    }
    if (stairs == 0) {
      return 1;
    }
    if (memo[stairs] != -1) {
      return memo[stairs];
    }
    memo[stairs] = countWaysUsingMemoryHelper(stairs - 1, memo) +
        countWaysUsingMemoryHelper(stairs - 2, memo) +
        countWaysUsingMemoryHelper(stairs - 3, memo);
    return memo[stairs];
  }
}
