package com.burra.practice.educative;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and a value, determine if there are any two integers in the array whose sum is equal to
 * the given value. Return true if the sum exists and return false if it does not. Consider this array and the target
 * sums:
 * <p>
 * 5 7 1 2 8 4 3 Target Sum 10
 * <p>
 * 7+3=10, 2+8=10 Target Sum 19 No 2 values sum up to 19
 */
public class Determineifthesumoftwointegersisequaltothegivenvalue {

  static boolean findSumOfTwo(int[] A, int val) {
    Set<Integer> set = new HashSet<>();
    for (int i : A) {
      if (set.contains(i)) {
        return true;
      } else {
        set.add(val - i);
      }
    }
    return false;
  }
}
