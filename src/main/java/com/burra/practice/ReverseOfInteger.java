package com.burra.practice;

public class ReverseOfInteger {

  /**
   * Reverse number for both +ve and -ve. If overflows return 0
   */
  public static int reverseNum(int n) {
    int rev = 0;
    int prev_rem = 0;
    int bit = 1;
    if (n < 0) {
      bit = -1;
      n *= bit;
    }
    while (n != 0) {
      int curr = n % 10;
      rev = rev * 10 + curr;
        if ((rev - curr) / 10 != prev_rem) {
            return 0;
        }
      n = n / 10;
      prev_rem = rev;
    }
    return rev * bit;
  }

  public static void main(String args[]) {
    int n = 1234567899;
    System.out.println(reverseNum(n));
    n = 12345;
    System.out.println(reverseNum(n));
    n = -12345;
    System.out.println(reverseNum(n));
    n = -1234567899;
    System.out.println(reverseNum(n));
  }
}
