package com.burra.practice.crackingCodingInterview.bitManipulation;

// insert binary int M in binary int N from bit position i to j
public class InsertMinsideN {

  public int insert(int n, int m, int i, int j) {
    int mask = ~0 << (j + 1) | (1 << (i) - 1);
    n = n & mask;
    return n | m << i;
  }
}
