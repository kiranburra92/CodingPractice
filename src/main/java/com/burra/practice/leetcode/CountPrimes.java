package com.burra.practice.leetcode;

public class CountPrimes {

  public int countPrimes(int n) {
    if (n <= 2) {
      return 0;
    }
    boolean[] isPrime = new boolean[n];

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (!isPrime[i]) {
        for (int j = i * i; j < n; j += i) {
          isPrime[j] = true;
        }
      }
    }

    int numberOfPrimes = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime[i] == false) {
        ++numberOfPrimes;
      }
    }

    return numberOfPrimes;
  }
}
