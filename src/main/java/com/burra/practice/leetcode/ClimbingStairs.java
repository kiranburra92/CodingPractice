package com.burra.practice.leetcode;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
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
