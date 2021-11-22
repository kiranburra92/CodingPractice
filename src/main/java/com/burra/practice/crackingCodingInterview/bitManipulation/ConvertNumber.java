package com.burra.practice.crackingCodingInterview.bitManipulation;

// return number bits to flip to convert x to y
public class ConvertNumber {

  public int flip(int x, int y) {
    int count = 0;
    for (int z = x ^ y; z != 0; z >>>= 1) {
      count++;
    }
    return count;
  }
}
