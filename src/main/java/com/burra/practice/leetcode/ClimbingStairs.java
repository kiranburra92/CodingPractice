package com.burra.practice.leetcode;

// number of ways to climb n steps, by 1, 2 steps at a time.
public class ClimbingStairs {

  public static int climbStairs(int n) {
    int[] memory = new int[n + 1];
    return myClimb(0, n, memory);
  }

  public static int myClimb(int i, int n, int[] m) {
    if (n < i) {
      return 0;
    }
    if (n == i) {
      return 1;
    }
    if (m[i] > 0) {
      return m[i];
    } else {
      m[i] = myClimb(i + 1, n, m) + myClimb(i + 2, n, m);
    }
    return m[i];
  }

  public static void main(String... args) {
    System.out.println("2 : " + climbStairs(2));
    System.out.println("3 : " + climbStairs(3));
  }
}
