package com.burra.practice.crackingCodingInterview.recursionAndDP;

// Multiply two integers without using * operator.
public class MultiplicationUsingRecursion {

  int multiplication(int x, int y) {
    int smaller = x < y ? x : y;
    int bigger = x < y ? y : x;
    return multiplicationHelper(smaller, bigger);
  }

  // O(log(smaller))
  private int multiplicationHelper(int smaller, int bigger) {
    if (smaller == 1) {
      return bigger;
    }
    if (smaller == 0) {
      return 0;
    }
    int half = multiplication(smaller / 2, bigger);
    if (smaller % 2 == 0) {
      return half + half;
    }
    return half + half + bigger;
  }
}
