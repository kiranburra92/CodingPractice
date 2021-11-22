package com.burra.practice.crackingCodingInterview.bitManipulation;

// Find the longest sequence of 1's in binary form on int n, you can flip atmost 1 bit
public class FlipBitToWin {

  public int longestLengthAfterFlip(int n) {
    if (~n == 0) {
      return Integer.BYTES * 8;
    }
    int max = 1, curr_length = 0, prev_length = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        curr_length++;
      } else {
        // store prev_length only if next bit is 1, else assign 0 to prev_length
        prev_length = ((n & 2) == 0) ? 0 : curr_length;
        curr_length = 0;
      }
      max = Math.max(curr_length + prev_length + 1, max);
      n >>>= n;
    }
    return max;
  }
}
