package com.burra.practice.leetcode;

public class PowerOfFour {

  public boolean isPowerOfFour(int n) {
    return (n != 0) && ((n & (n - 1)) == 0) && (n & 0xAAAAAAAA) == 0;
  }
}
