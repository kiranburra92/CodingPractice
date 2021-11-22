package com.burra.practice.crackingCodingInterview.bitManipulation;

// Return next largest and smallest for a given integer with same number of 1 in binary form
public class GetNextNumber {
  // To get next largest number, we should flip 0 to 1, ie., flip right most non trailing 0 to 1 and move all 1's
  // with one less to right most

  int getNextLargest(int n) {
    int temp = n;
    int c0 = 0;
    int c1 = 0;
    // count number of trailing zeros
    while ((temp & 1) == 0 || temp != 0) {
      c0++;
      temp >>= 1;
    }

    // count number of 1 after trailing zeros
    while ((temp & 1) == 1) {
      c1++;
      temp >>= 1;
    }
    int p = c0 + c1;

    if (p == 31 || p == 0) {
      return -1;
    }

    // change 0 to 1 at (c0 + c1)th  position
    n = n | (1 << p);

    // clear all bits before pth position
    n = n & (~0 << (p - 1));

    // add c1 - 1 to right most
    n = n | ((1 << (c1 - 1)) - 1);
    return n;
  }

  // To get next smallest number, we should flip 1 to 0, ie., flip right most non trailing 1 to 0 and move all 1's
  // with one extra next to the flipped bit

  public int getNextSmaller(int n) {
    int temp = n;
    int c0 = 0, c1 = 0;

    // count number of trailing 1's
    while ((temp & 1) == 1) {
      c1++;
      temp >>= 1;
    }

    // count number of 0's after trailing 1
    while ((temp & 1) == 0 && (temp != 0)) {
      c0++;
      temp >>= 1;
    }
    int p = c0 + c1;

    // clear all bits from p to rightmost
    n = n & (~0 << (p + 1));

    // add c1+1 once after pth bit
    int mask = (1 << (c1 + 1) - 1);
    mask = mask << (c0 - 1);
    n = n | mask;
    return n;
  }
}
