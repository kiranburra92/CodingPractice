package com.burra.practice.educative;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorial {

  public static List<Integer> primeFact(int x) {
    // Print the number of 2s that divide n
    List<Integer> factors = new ArrayList<>();
    while (x % 2 == 0) {
      factors.add(2);
      x = x / 2;
    }

    // n must be odd at this point.  So we can
    // skip one element (Note i = i +2)
    for (int i = 3; i <= Math.sqrt(x); i = i + 2) {
      while (x % i == 0) {
        factors.add(i);
        x = x / i;
      }
    }

    // This condition is to handle the case when
    // n is a prime number greater than 2
    if (x > 2) {
      factors.add(x);
    }

    return factors;
  }

  public static void main(String args[]) {
    System.out.println(primeFact(169));
  }
}
