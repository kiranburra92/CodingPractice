package com.burra.practice.leetcode;

/**
 * Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a
 * and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.
 * <p>
 * You need to count and return the number of maximum integers in the matrix after performing all the operations.
 * <p>
 * Example 1: Input: m = 3, n = 3 operations = [[2,2],[3,3]] Output: 4 Explanation: Initially, M = [[0, 0, 0], [0, 0,
 * 0], [0, 0, 0]]
 * <p>
 * After performing [2,2], M = [[1, 1, 0], [1, 1, 0], [0, 0, 0]]
 * <p>
 * After performing [3,3], M = [[2, 2, 1], [2, 2, 1], [1, 1, 1]]
 * <p>
 * So the maximum integer in M is 2, and there are four of it in M. So return 4.
 */
public class RangeAddition2 {

  public static int maxCount(int m, int n, int[][] ops) {
    /**
     * maximum elements will lay in from (0,0) to min(ops[0],ops[1])
     */
    for (int[] op : ops) {
      m = Math.min(m, op[0]);
      n = Math.min(n, op[1]);
    }
    return m * n;
  }
}
