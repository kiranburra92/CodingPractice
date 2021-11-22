package com.burra.practice.leetcode;

/**
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 */
public class UglyNumber {

  public static boolean isUgly(int num) {
    if (num <= 0) {
      return false;
    }

    int factor = 2;
    while (factor <= 5) {
      if (num == 1) {
        return true;
      }
      if (num % factor == 0) {
        num = num / factor;
      } else {
        factor++;
      }
    }
    return false;
  }

  public static void main(String args[]) {
    System.out.println(isUgly(6));
  }
}
