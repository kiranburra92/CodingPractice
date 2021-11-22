package com.burra.practice.crackingCodingInterview.bitManipulation;

// swap all odd position to even position and vice versa
public class PairwiseSwap {

  public int flip(int a) {
    // a = 10
    // 5 = 01
    return ((a & 0xaaaaaaaa) >>> 1) | ((a & 0x55555555) << 1);
  }
}
