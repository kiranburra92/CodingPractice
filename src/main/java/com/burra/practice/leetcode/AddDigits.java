package com.burra.practice.leetcode;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 */
public class AddDigits {

  public int addDigits(int num) {
    while (num / 10 != 0) {
      num = sum(num);
    }
    return num;
  }

  public int sum(int n) {
    int sum = 0;
    while (n > 0) {
      sum += n % 10;
      n = n / 10;
    }
    return sum;
  }

  // or
  public int addDigits2(int num) {
    if (num <= 9) {
      return num;
    }
    return num % 9 == 0 ? 9 : num % 9;
  }
}
